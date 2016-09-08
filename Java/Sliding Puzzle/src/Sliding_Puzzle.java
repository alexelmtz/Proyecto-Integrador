//	Alejandro Elizondo
//	alexelmtz@outlook.com
//	Linkedin: linkedin.com/in/alejandro-elizondo
//	Github: github.com/alexelmtz/Sliding-Puzzle

import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Sliding_Puzzle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int iNum;
		boolean bPlay;
		JOptionPane.showMessageDialog(null,"Order the numbers from 1 to 15 starting from the top-left corner.\n"
				+ " The bottom-right corner of the puzzle should be empty in order to win.", 
				"Welcome to the game", JOptionPane.PLAIN_MESSAGE);
		
		String sNum = JOptionPane.showInputDialog("What game do you want to play? (3 or 4)");
		iNum = Integer.parseInt(sNum);

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