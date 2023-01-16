#include <fstream>
#include <vector>
#include <sstream>
using namespace std;

// Default error code which means everything went well
const int ERROR = 200;

class Elements
{
public:
	// ----- Alert user -----
	static void alert(const string message, const int error = ERROR)
	{
		// If error is not equal to global variable error  then return message with current error number
		if (error != ERROR) printf("\n  --- %s    ERROR: %i\n", message.c_str(), error);
		else printf("\n  --- %s\n", message.c_str()); // Else return normal message with no errors
	}

	// ----- Terminate Everything -----
	static int goodbye(fstream& infile, fstream& outfile)
	{
		// Close all files opened
		infile.close();
		outfile.close();
		// End by returning 0 meaning all went well
		return 0;
	}

	// ----- Setup new file format -----
	static string root(const string root)
	{
		// Setup empty tmp string value for new url 
		string tmp = "";
		// Setup index where we find the character
		int index = root.find(".");

		// Setup all old url before reach index
		for (int i = 0; i < index; i++) tmp += root[i];

		// Add new value to current url 
		tmp.append("_new.csv");
		// Return new url for setup
		return tmp;
	}

	// ----- Setup category selection -----
	static vector<pair<pair<int, string>, bool>> category(vector<vector<string>> book)
	{
		// Container for categories options
		vector<pair<pair<int, string>, bool>> categories;
		// Is current a type string?
		bool text;
		
		// Loop through book index 0 and 1 to setup new categories
		for (int i = 0; i < book[0].size(); i++)
		{
			text = false;
			// Catch if current category can be transformed to a number, if not than setup as string
			try {stold(book[1][i]);}
			catch (invalid_argument) { text = true; }
			catch (out_of_range) {text = true;}
			// Lower case input for dynamic inputs
			for (int j = 0; j < book[0][i].size(); j++) book[0][i][j] = tolower(book[0][i][j]);

			// Add valid catergories
			categories.push_back(make_pair(make_pair(i, book[0][i]), text));
		}

		// Return Possible Options
		return categories;
	}
};