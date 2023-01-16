#include <fstream>
#include <vector>
#include <sstream>
using namespace std;

class CSVManager
{

public:

	// ----- Setup information of csv into a nested vector -----
	static void setupCSV(fstream& file, vector <vector< string >>& book)
	{
		// Data from csv
		vector<string> page;
		string line, section;

		// Get all the lines from csv
		while (getline(file, line))
		{
			// Clear old data from old row
			page.clear();
			// Setup string stream to manipulate moving data
			stringstream strm(line);
			// Get string stream different sections containing comma into the page vector
			while (getline(strm, section, ',')) page.push_back(section);
			// Setup page vectors into the nested vector book
			book.push_back(page);
		}

	}

	// ----- Merge sort algorithm method for the nested vector -----
	static void sortCSV(vector<vector<string>>& book,const int section, bool text, const int begin, const int end)
	{
		// Setup middle to separate into different sections all contents
		const auto middle = begin + ((end - begin) / 2);

		// Separate if begin and end selection or not equal position
		if (!(begin >= end))
		{
			// Setup beginning to middle sorting
			sortCSV(book, section, text, begin, middle);
			// Setup middle to end sorting
			sortCSV(book, section, text, middle + 1, end);
			// Merge contents from current end to beginning while sorting
			mergeCSV(book, section, text, begin, middle, end);
		}

	}

	// ----- Upload information from nested vector -----
	static void uploadCSV(fstream& newFile, const vector <vector< string >>& book)
	{
		// Loop through content being the pages on the nested vector book
		for (int i = 0; i < book.size(); i++)
		{
			// Loop through sections from current content being the pages and setup every section in page to the csv
			for (int j = 0; j < book[i].size() - 1; j++) newFile << book[i][j] << ",";

			// Finish setup by adding last section and add an end line 
			newFile << book[i][book[i].size() - 1] << "\n";
		}
	}

private:

	// ----- Compare strings and see which is higher -----
	static bool strCMP(string textBegin, string textEnd)
	{
		int length = textBegin.length();
		if (length > textEnd.length()) length = textEnd.length();

		for (int i = 0; i < length; i++)
		{
			if (int(tolower(textBegin[i])) < int(tolower(textEnd[i]))) return true;
			else if (int(tolower(textBegin[i])) > int(tolower(textEnd[i]))) return false;
		}

		if (textBegin.length() <= textEnd.length()) return true;

		return false;
	}

	// ----- Merge data together into the nested vector book -----
	static void mergeCSV(vector <vector< string >>& book, const int section, bool text, const int begin, const int middle, const int end)
	{
		// Setup size of beginning to middle
		const int beginSize = middle - begin + 1;
		// Setup size of middle to end
		const int endSize = end - middle;
		// Setup middle location
		const int mid = middle + 1;
			
		// Setup begin and end container to sort in two boxes and merge
		vector<vector<string>> beginContainer;
		vector<vector<string>> endContainer;

		// Setup temporary containers to separate left from right
		for (auto i = 0; i < beginSize; i++) beginContainer.push_back(book[begin + i]);
		for (auto i = 0; i < endSize; i++) endContainer.push_back(book[mid + i]);

		// Setup unknown size of items counters to keep track of current page
		auto beginCounter = 0;
		auto endCounter = 0;
		// Setup current beginning location to start counting from to up
		auto currCounter = begin;

		// Is Beginning least
		bool left;

		// Merge containers until left or right has reached their limit
		while (beginCounter < beginSize && endCounter < endSize)
		{
			// Setup path tp organize
			if (!text) { 
				if (stold(beginContainer[beginCounter][section]) <= stold(endContainer[endCounter][section])) left = true;
				else left = false;
			}
			else left = strCMP(beginContainer[beginCounter][section], endContainer[endCounter][section]);

			// finding if beginning container current page is smaller to ending container current page by section choice
			if (left)
			{
				// Setup book page new value equal to current begin container page
				book[currCounter] = beginContainer[beginCounter];
				// Increase begin counter value
				beginCounter++;
			}
			else
			{
				// Setup book page new value equal to current end container page
				book[currCounter] = endContainer[endCounter];
				// End begin counter value
				endCounter++;
			}
			// Increase current book page counter value
			currCounter++;
		}

		// Merge remaining data which was not added beforehand
		while (beginCounter < beginSize || endCounter < endSize)
		{
			// if begin container has not reached is limit then setup its remaining data
			if (beginCounter < beginSize)
			{
				// Setup book page new value equal to current begin container page
				book[currCounter] = beginContainer[beginCounter];
				// Increase begin counter value
				beginCounter++;
			}
			// if end container has not reached is limit then setup its remaining data
			else
			{
				// Setup book page new value equal to current end container page
				book[currCounter] = endContainer[endCounter];
				// End begin counter value
				endCounter++;
			}
			
			// Increase current book page counter value
			currCounter++;
		}

	}

};