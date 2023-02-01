import os

from cs50 import SQL
from flask import Flask, flash, redirect, render_template, request, session
from flask_session import Session
from tempfile import mkdtemp
from werkzeug.security import check_password_hash, generate_password_hash

from helpers import apology, login_required, lookup, usd

# Configure application
app = Flask(__name__)

# Ensure templates are auto-reloaded
app.config["TEMPLATES_AUTO_RELOAD"] = True

# Custom filter
app.jinja_env.filters["usd"] = usd

# Configure session to use filesystem (instead of signed cookies)
app.config["SESSION_PERMANENT"] = False
app.config["SESSION_TYPE"] = "filesystem"
Session(app)

# Configure CS50 Library to use SQLite database
db = SQL("sqlite:///finance.db")

# Make sure API key is set
if not os.environ.get("API_KEY"):
    raise RuntimeError("API_KEY not set")


@app.after_request
def after_request(response):
    """Ensure responses aren't cached"""
    response.headers["Cache-Control"] = "no-cache, no-store, must-revalidate"
    response.headers["Expires"] = 0
    response.headers["Pragma"] = "no-cache"
    return response


@app.route("/", methods=["GET", "POST"])
@login_required
def index():
    """Show portfolio of stocks"""
    stocks = db.execute("SELECT * FROM stocks WHERE id = ?", session["user_id"])
    user = db.execute("SELECT * FROM users WHERE id = ?", session["user_id"])[0]
    total = user["cash"]
    for stock in stocks:
        price = float(lookup(stock["symbol"])["price"])
        db.execute("UPDATE stocks SET price = ?, total = ? WHERE id = ? AND symbol = ?", price,
                    price * stock["shares"], stock["id"], stock["symbol"])
        total += stock["total"]
    stocks = db.execute("SELECT * FROM stocks WHERE id = ?", session["user_id"])

    if request.method == "POST":
        cash = db.execute("SELECT cash FROM users WHERE id = ?", session["user_id"])[0]["cash"]
        stock = lookup(request.form.get("symbol"))
        current = db.execute("SELECT * FROM stocks WHERE id = ? AND symbol = ?", session["user_id"], stock["symbol"])[0]

        if request.form.get("submit") == "add":

            db.execute("INSERT INTO transactions (id, name, symbol, shares, price, total) VALUES (?, ?, ?, ?, ?, ?)",
                        session["user_id"], stock["name"], stock["symbol"], 1, -1 * (stock["price"]), -1 * stock["price"])
            db.execute("UPDATE users SET cash = ? WHERE id = ?", cash - stock["price"], session["user_id"])
            db.execute("UPDATE stocks SET shares = ? WHERE id = ? AND symbol = ?", current["shares"] + 1,
                        session["user_id"], current["symbol"])

            return redirect("/")
        else:
            db.execute("INSERT INTO transactions (id, name, symbol, shares, price, total) VALUES (?, ?, ?, ?, ?, ?)", current["id"],
                        current["name"], current["symbol"], 1, stock["price"], stock["price"])
            db.execute("UPDATE users SET cash = ? WHERE id = ?", cash + float(stock["price"]), session["user_id"])
            if current["shares"] > 1:
                db.execute("UPDATE stocks SET shares = ? WHERE id = ? AND symbol = ?",
                            int(current["shares"]) - 1, current["id"], current["symbol"])
                return redirect("/")
            db.execute("DELETE FROM stocks WHERE id = ? AND symbol = ?", current["id"], current["symbol"])
            return redirect("/")

    return render_template("index.html", user=user, total=total, stocks=stocks)


@app.route("/buy", methods=["GET", "POST"])
@login_required
def buy():
    """Buy shares of stock"""
    if request.method == "POST":
        cash = db.execute("SELECT cash FROM users WHERE id = ?", session["user_id"])[0]
        stock = lookup(request.form.get("symbol"))

        if not request.form.get("symbol"):
            return apology("Add Symbol", 400)
        elif not stock:
            return apology("Not Existent Symbol", 400)
        elif not request.form.get("shares"):
            return apology("No Shares Added", 400)
        try:
            shares = int(request.form.get("shares"))
        except:
            return apology("Invalid Share Type", 400)

        if not int(request.form.get("shares")) > 0:
            return apology("Invalid Share Amount", 400)
        elif not cash["cash"] >= stock["price"]:
            return apology("Not Enough Money", 400)

        current = db.execute("SELECT * FROM stocks WHERE id = ? AND symbol = ?", session["user_id"], stock["symbol"])

        db.execute("INSERT INTO transactions (id, name, symbol, shares, price, total) VALUES (?, ?, ?, ?, ?, ?)", session["user_id"],
                    stock["name"], stock["symbol"], int(request.form.get("shares")), -1 * (stock["price"]), -1 * (stock["price"] * int(request.form.get("shares"))))
        db.execute("UPDATE users SET cash = ? WHERE id = ?", cash["cash"] -
                    (stock["price"] * int(request.form.get("shares"))), session["user_id"])
        if not current:
            db.execute("INSERT INTO stocks (id, name, symbol, shares) VALUES (?, ?, ?, ?)", session["user_id"],
                        stock["name"], stock["symbol"], int(request.form.get("shares")))
            return redirect("/")
        db.execute("UPDATE stocks SET shares = ? WHERE id = ? AND symbol = ?", current[0]["shares"] +
                    int(request.form.get("shares")), session["user_id"], current[0]["symbol"])

        return redirect("/")

    return render_template("buy.html")


@app.route("/history")
@login_required
def history():
    """Show history of transactions"""
    transactions = db.execute("SELECT * FROM transactions WHERE id = ?", session["user_id"])
    return render_template("history.html", transactions = transactions)



@app.route("/login", methods=["GET", "POST"])
def login():
    """Log user in"""

    # Forget any user_id
    session.clear()

    # User reached route via POST (as by submitting a form via POST)
    if request.method == "POST":

        # Ensure username was submitted
        if not request.form.get("username"):
            return apology("must provide username", 403)

        # Ensure password was submitted
        elif not request.form.get("password"):
            return apology("must provide password", 403)

        # Query database for username
        rows = db.execute("SELECT * FROM users WHERE username = ?", request.form.get("username"))

        # Ensure username exists and password is correct
        if len(rows) != 1 or not check_password_hash(rows[0]["hash"], request.form.get("password")):
            return apology("invalid username and/or password", 403)

        # Remember which user has logged in
        session["user_id"] = rows[0]["id"]

        # Redirect user to home page
        return redirect("/")

    # User reached route via GET (as by clicking a link or via redirect)
    else:
        return render_template("login.html")


@app.route("/logout")
def logout():
    """Log user out"""

    # Forget any user_id
    session.clear()

    # Redirect user to login form
    return redirect("/")


@app.route("/quote", methods=["GET", "POST"])
@login_required
def quote():
    """Get stock quote."""
    if request.method == "POST":
        search = lookup(request.form.get("symbol"))
        if not search:
            return apology("Not Existent", 400)
        else:
            return render_template("quoted.html", search=search)

    return render_template("quote.html")


@app.route("/register", methods=["GET", "POST"])
def register():
    """Register user"""
    if request.method == "POST":
        if not request.form.get("username"):
            return apology("must provide username", 400)
        if not request.form.get("password"):
            return apology("must provide password", 400)
        if not request.form.get("confirmation"):
            return apology("must provide password confirmation", 400)
        elif request.form.get("password") != request.form.get("confirmation"):
            return apology("passwords do not match", 400)
        if db.execute("SELECT * FROM users WHERE username = ?", request.form.get("username")):
            return apology("username taken", 400)
        db.execute("INSERT INTO users (username, hash) VALUES (?,?)", request.form.get("username"),
                    generate_password_hash(request.form.get("password"), method="pbkdf2:sha256", salt_length=8))
        return redirect("/")
    else:
        return render_template("register.html")


@app.route("/sell", methods=["GET", "POST"])
@login_required
def sell():
    """Sell shares of stock"""
    if request.method == "POST":
        if request.form.get("symbol") == None:
            return apology("Select Symbol", 400)
        stock = lookup(request.form.get("symbol"))
        owned = db.execute("SELECT * FROM stocks WHERE id = ? AND symbol = ?", session["user_id"], stock["symbol"])[0]
        if not stock:
            return apology("Not Existent Symbol", 400)
        try:
            share = int(request.form.get("shares"))
        except:
            return apology("Invalid Share Type", 400)
        if not request.form.get("shares"):
            return apology("No Shares Added", 400)
        elif not int(request.form.get("shares")) > 0:
            return apology("Invalid Share Amount", 400)
        elif not owned:
            return apology("Stock Not Owned", 400)
        elif not owned["shares"] >= int(request.form.get("shares")):
            return apology("Not Enough Shares", 400)

        cash = db.execute("SELECT * FROM users WHERE id = ?", session["user_id"])[0]["cash"]
        db.execute("INSERT INTO transactions (id, name, symbol, shares, price, total) VALUES (?, ?, ?, ?, ?, ?)", owned["id"], owned["name"],
                     owned["symbol"], int(request.form.get("shares")), stock["price"], stock["price"] * int(request.form.get("shares")))
        db.execute("UPDATE users SET cash = ? WHERE id = ?", cash + (float(stock["price"]) * float(request.form.get("shares"))),
                     session["user_id"])
        if owned["shares"] > int(request.form.get("shares")):
            db.execute("UPDATE stocks SET shares = ? WHERE id = ? AND symbol = ?",
                        int(owned["shares"]) - int(request.form.get("shares")), owned["id"], owned["symbol"])
            return redirect("/")
        db.execute("DELETE FROM stocks WHERE id = ? AND symbol = ?", owned["id"], owned["symbol"])
        return redirect("/")

    options = db.execute("SELECT symbol FROM stocks WHERE id = ?", session["user_id"])
    return render_template("sell.html", options=options)


@app.route("/password", methods=["GET", "POST"])
@login_required
def password():
    if request.method == "POST":
        if not request.form.get("currpassword") or not request.form.get("password") or not request.form.get("confirmation"):
            return apology("Input All Fields", 403)
        rows = db.execute("SELECT * FROM users WHERE id = ?", session["user_id"])
        if not check_password_hash(rows[0]["hash"], request.form.get("currpassword")):
            return apology("Wrong Current Password", 403)
        elif not request.form.get("password") == request.form.get("confirmation"):
            return apology("Password And Confirmation Not Match", 403)
        elif request.form.get("currpassword") == request.form.get("password"):
            return apology("Old And New Password Same", 403)

        db.execute("UPDATE users SET hash = ? WHERE id = ?", generate_password_hash(
            request.form.get("password"), method="pbkdf2:sha256", salt_length=8), session["user_id"])
        return redirect("/")

    return render_template("password.html")


@app.route("/deposit", methods=["GET", "POST"])
@login_required
def deposit():

    if request.method == "POST":
        try:
            deposit = int(request.form.get("deposit"))
        except:
            return apology("Invalid Deposit Type", 400)
        if not request.form.get("deposit"):
            return apology("No Deposit Added", 400)
        elif not int(request.form.get("deposit")) > 0:
            return apology("Invalid Deposit Amount", 400)

        cash = db.execute("SELECT cash FROM users WHERE id = ?", session["user_id"])[0]["cash"]
        db.execute("UPDATE users SET cash = ? WHERE id = ?", cash + int(request.form.get("deposit")), session["user_id"])
        db.execute("INSERT INTO transactions (id, name, symbol, shares, price, total) VALUES (?, ?, ?, ?, ?, ?)",
                    session["user_id"], "DEPOSIT", "DPST", 1, int(request.form.get("deposit")), int(request.form.get("deposit")))
        return redirect("/")

    return render_template("deposit.html")