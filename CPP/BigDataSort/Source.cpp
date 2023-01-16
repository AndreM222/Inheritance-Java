#include <iostream>
#include <fstream>
#include <sstream>
#include "CSVManager.cpp"
#include "Elements.cpp"
#include <vector>
using namespace std;

const CSVManager CSV_OBJ; // Class Elements
const Elements ELEMENTS_OBJ; //  Class Source

int main()
{
	string input; // Container of user input
	fstream file; // Container of csv in computer selected by user
	fstream newFile; // Container of new created csv with sorted data of csv selected by user

	// ----- Initializing File Setup -----
	while (input.empty() || !file) // Loop until input and file not empty
	{
		cout << "Input database location: ";
		// Type csv to sort
		cin >> input;

		// Check if input is exit to terminate everything
		if (input == "exit") return ELEMENTS_OBJ.goodbye(file, newFile);

		// Add data of csv into file container
		file.open(input, ios::in);
		// If file does not exist then return error
		if (!file) ELEMENTS_OBJ.alert("No file found", 400);
	}

	// ----- Initializing New File Setup -----
	do
	{
		cout << "\nInput new file name with location (if lazy == true; type root): ";
		// Save old url of csv into a temporary container
		string tmp = input;
		// Setup new location and name of csv file
		cin >> input;

		// If user typed root then setup old url plus modifications as new file location and name
		if (input == "root") input = ELEMENTS_OBJ.root(tmp);
		// Check if input is exit to terminate everything
		if (input == "exit") return ELEMENTS_OBJ.goodbye(file, newFile);

		// Create new csv and add it into newFile container for modifications
		newFile.open(input, ios::out);
	} while (input.empty()); // Loop until input is empty

	// ----- Data Container -----
	vector <vector< string >> book;

	// ----- Get CSV Data into nested vector book -----
	ELEMENTS_OBJ.alert("Processing - wait while we read the data . . .");
	CSV_OBJ.setupCSV(file, book);
	ELEMENTS_OBJ.alert("Processing - Completed . . .");

	// ----- Setup Category -----
	const vector <pair<pair<int, string>, bool>> category = ELEMENTS_OBJ.category(book); // Container of valid categories
	pair<int, bool> section; // Category to sort

	do
	{
		printf("\nInput the category of your choosing\n");
		// Print out all valid categories
		for (pair<pair<int, string>, bool> page : category) printf(" [%s] ", page.first.second.c_str());
		cin >> input;

		// Loop through cateogries to compare with input
		for (pair<pair<int, string>, bool> page : category)
		{	
			// Lower case input for dynamic inputs
			for (int i = 0; i < input.size(); i++) input[i] = tolower(input[i]);
			// Check if input is exit to terminate everything
			if (input == "exit") return ELEMENTS_OBJ.goodbye(file, newFile);

			// Check if current category is equal to input
			if ((page.first.second) == input)
			{
				// Setup index of categor
				section.first = page.first.first;
				section.second = page.second;
				// Clear input of user
				input.clear();
				// Terminate loop
				break;
			}
		}

		if (!input.empty()) ELEMENTS_OBJ.alert("Wrong choice", 400); // If input is invalid return error
	} while (!input.empty()); // Terminate loop if user input got cleared

	// ----- Sort all content from nested vector book -----
	ELEMENTS_OBJ.alert("Processing - wait while we allocate . . .");
	CSV_OBJ.sortCSV(book, section.first, section.second, 1, book.size() - 1);
	ELEMENTS_OBJ.alert("Processing - Completed . . .");

	// ----- Uploading into new csv -----
	ELEMENTS_OBJ.alert("Processing - wait while we upload to the new csv . . .");
	CSV_OBJ.uploadCSV(newFile, book);
	ELEMENTS_OBJ.alert("Processing - Completed . . .");

	// ----- Terminate Everything -----
	return ELEMENTS_OBJ.goodbye(file, newFile);
};