//	Alejandro Elizondo
//	alexelmtz@outlook.com
//	Linkedin: linkedin.com/in/alejandro-elizondo
//	Github: github.com/alexelmtz/Sliding-Puzzle

package Game;

import java.util.*;

public class Sliding_Puzzle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int iNum;
		boolean bPlay;
		
		System.out.println("\n Welcome to the game\n");
		System.out.print("In order to win, order the numbers from 1 to 15, starting \nfrom the top-left corner.");
		System.out.println("The bottom-right corner of the \npuzzle should be empty in order to win.\n");
		System.out.println("What game do you want to play? (type 3 or 4)");
		iNum = input.nextInt();
		GameBoard game = new GameBoard(iNum);

		game.Display();

		do {
			System.out.println("What number would you like to move?");
			iNum = input.nextInt();
			if (!game.Switch(iNum))
				System.out.println("Error that number can't be switched, please try again");
			game.Display();
			System.out.println("Do you want to keep playing? (true or false)");
			bPlay = input.nextBoolean();
		} while (bPlay);
		
		System.out.println("Thank you for playing");
		game.Display();
		input.close();
	}
}