//	Alejandro Elizondo
//	alexelmtz@outlook.com
//	Linkedin: linkedin.com/in/alejandro-elizondo
//	Github: github.com/alexelmtz/Sliding-Puzzle

//	************************ CREAR CLASE GAMEBOARD A LA CUAL SE LE PUEDA MODIFICAR SU TAMANO DE ACUERDO AL JUEGO *****************
import java.util.*;

public class Sliding_Puzzle {

	// Displays the game board
	public static void Display(int iarrGameBoard[][]) {
		System.out.println("•---•---•---•---•---•");
		for (int i = 0; i < 4; i++)
		{
			System.out.print("| ");
			for (int j = 0; j < 4; j++)
				if (iarrGameBoard[i][j] == 0)
					System.out.print("   | ");
				else if (iarrGameBoard[i][j] < 10)
					System.out.print(" " + iarrGameBoard[i][j] + " | ");
				else
					System.out.print(iarrGameBoard[i][j] + " | ");

			System.out.println("\n" + "•---•---•---•---•---•");
		}
	}

	// Generates a puzzle with a random order
	public static void Generate(int iarrGameBoard[][]) {		
		Random rand = new Random();
		int iRand;
		List<Integer> lintUsed = new ArrayList<>();		// List of numbers that have been added to the game board

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
			{
				do {
					iRand = rand.nextInt(16 - 0) + 0;
				} while (lintUsed.contains(iRand));		// The number is already in the game board
				
				iarrGameBoard[i][j] = iRand;
				lintUsed.add(iRand);
			}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] iarrGameBoard = new int[4][4];
		int iNum;
		
		System.out.println("\n Welcome to the game\n");
		System.out.print("In order to win, order the numbers from 1 to 15, starting \nfrom the top-left corner.");
		System.out.println("The bottom-right corner of the \npuzzle should be empty in order to win.\n");

		Generate(iarrGameBoard);
		Display(iarrGameBoard);

		do {
			System.out.println("What number would you like to move?");
			iNum = input.nextInt();
		} while (iNum < 1 || iNum > 15);
	}
}