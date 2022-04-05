
----------------------------------------Notes--------------------------------------------

MD -> Markdown Documentation

Inheritance -> Is like creating a child from a class


------------Clear Terminal Code------------

ANSI escape code -> Is a sequence which can be interpeted as commands combined with bytes and characters

                 -> \033 means ESC or escape
                 -> combining \033 with [H moves the cursor to a specified position
                 -> 033[2J cleans the whole screen

                 -> Total: \033[H\033[2J

                 ->flush() flushes the content of the buffer to the output stream

------------------General------------------

Static -> In the Java programming language, the keyword static means that the particular member belongs to a type itself, rather than to 
          an instance of that type. This means we'll create only one instance of that static member that is shared across all instances of the class.

.equals() -> for comparing if equal string

Array And Array List -> A array can't add or remove. It is unchangable when set 
                        so in order to do that you need to use an array list or create a new array with the old things but removed or added whatever I want.

Casting -> In order to cast we just need to call its Parent as a variable and 
           we can set it as its childs.

        -> Upcasting: We can cast a reference along the class hierarchy in a direction from the sub classes towards the root.
        -> Downcasting: We can cast a reference along the class hierarchy in a direction from the root class towards the children or subclasses.

Switches -> They are able to run just one depending one the condition.
         -> Is like selecting one path to follow in the road where there is no comeback unless you run it inside a loop.

Setters & Getters -> They enable you to access private variables.
                  -> Setters: enables you to modify the private variable.
                  -> Getters: enables you to access the private variable and call   it.

Boolean -> If you we want to run an if or a loop with a boolean we can just use the booealan for true or false instead of specifying it
        -> Boolean - Is the same as Boolean == true;
        -> !Boolean - Is the same as Boolean == false;

Enum ->