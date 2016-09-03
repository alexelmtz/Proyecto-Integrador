//	Alejandro Elizondo
//	alexelmtz@outlook.com
//	Linkedin: http://bit.ly/1pnePO4

#include <iostream>
#include <time.h>
#include <string>

using namespace std;

void Display (int Array[4][4]){
	cout<< "•---•---•---•---•---•" <<endl;
	for (int x = 0;x < 4;x++){
		cout << "| ";
		for (int y = 0;y < 4;y++){
			if (Array[x][y] < 10)
				cout << " " << Array[x][y] << " | ";
			else 
				cout << Array[x][y] << " | ";
		}
		cout << endl << "•---•---•---•---•---•" << endl;
	}	
}
// Generates a puzzle with a random order
void Generate(int Array[4][4]){
	int iRand;
	string str = "";	// Used to keep count of used numbers

	for (int x = 0;x < 4;x++)
		for (int y = 0;y < 4;y++)
		{
				do{
					iRand = rand()%16;
				} while (str.find(iRand) != -1);
				Array[x][y] = iRand;
				str += iRand;
		}
}

void Switch (int Array[4][4]){

}

int main() {
	int Array[4][4], iNum;
	srand(time(NULL));

	cout << "\t" << "\t" << "\t" << "Welcome to the game"<< endl << endl;
    cout << "In order to win, order the numbers from 1 to 15, starting from the top-left" << endl << "corner. ";
    cout << "The bottom-right corner of the puzzle should be 0 in order to win."<< endl << endl;
	Generate(Array);
	Display(Array);
	do{
		cout << endl << "What number would you like to switch places with 0?" << endl;
		cin >> iNum;
	} while (iNum < 1 || iNum > 15);
	return 0;
}