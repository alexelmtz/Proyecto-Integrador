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
		
		GameBoard game = new GameBoard(WelcomeMessage());	//Initializes the gameboard according to the user's input
		
//		Buttons gameboard = new Buttons(iNum);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.pack();
		game.setVisible(true);
		game.setResizable(false);
		input.close();
	}
	
	// Displays Message at the beginning of the game and returns the size of the gameboard according to the user's input.
	public static int WelcomeMessage() {
		int iNum = 0;
		boolean correctInput = false;
		JOptionPane.showMessageDialog(null,"Order the numbers from 1 to 15 starting from the top-left corner.\n"
				+ " The bottom-right corner of the puzzle should be empty in order to win.", 
				"Welcome to the game", JOptionPane.PLAIN_MESSAGE);
		
		do
		{
			try
			{
				String sNum = JOptionPane.showInputDialog("What game do you want to play? (3 or 4)");
				
				if (sNum == null)		// The user closed the window or clicked on "Cancel"
					System.exit(0);
				
				iNum = Integer.parseInt(sNum);
				
				if (iNum != 3 && iNum != 4)
					JOptionPane.showMessageDialog(null, "Error: Invalid input. Please try again.");
				else
					correctInput = true;
			}
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Error: Invalid input. Please try again.");
			}
		} while(!correctInput);
		
		return iNum;
	}
}