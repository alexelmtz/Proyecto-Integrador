//	Alejandro Elizondo
//	alexelmtz@outlook.com
//	Linkedin: linkedin.com/in/alejandro-elizondo
//	Github: github.com/alexelmtz/Sliding-Puzzle

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class GameBoard extends JFrame {
//	private int[][] iarrGameBoard;
	private JButton[][] buttonMat;
	private Container pane;
	private int iSize;
	private int iRowCero;
	private int iColCero;

	GameBoard(int iS) {
		super("GameBoard");
		iSize = iS;
		Generate();
	}

	// Generates a puzzle with a random order
	public void Generate() {	
		buttonMat = new JButton[iSize][iSize];
		pane = getContentPane();
		pane.setLayout(new GridLayout(iSize,iSize));
		Handler handler = new Handler();
		
		Random rand = new Random();
		int iRand;
		List<Integer> lintUsed = new ArrayList<>();		// List of numbers that have been added to the game board
		for (int i = 0; i < iSize; i++)
			for (int j = 0; j < iSize; j++)
			{
				do {
					iRand = rand.nextInt(iSize*iSize - 0) + 0;
				} while (lintUsed.contains(iRand));		// The number is already in the game board
			
				if (iRand == 0)
				{
					iRowCero = i;
					iColCero = j;
				}
			
				lintUsed.add(iRand);
			
				Icon pic = new ImageIcon(getClass().getResource(Integer.toString(iRand) + ".png"));
				JButton button = new JButton(pic);
				button.addActionListener(handler);
				button.setBorder(BorderFactory.createEmptyBorder());
				buttonMat[i][j] = button;
				pane.add(button);
			}
		
	}
	
	// Switches blank space with the button the user clicked. Returns false if the switch failed.
	private boolean Switch(JButton b) {
		int iRow = 0, iCol = 0;
		
		// Finds the position of the button to be switched
		for (int i = 0; i < iSize; i++)
			for (int j = 0; j < iSize; j++)
			{
				if (buttonMat[i][j] == b)
				{
					iRow = i;
					iCol = j;
				}
			}
		
		// If the distance between the numbers is equal to 1, then that means that they are next to each other
		double dDistance = Math.sqrt(Math.pow(iRow - iRowCero, 2) + Math.pow(iCol - iColCero, 2));
		// Checks if the number is next to the blank space
		if (dDistance == 1)
		{				
			Icon aux = buttonMat[iRow][iCol].getIcon();
//			pane.remove(iRow+iCol);
//			pane.add(buttonMat[iRowCero][iColCero], iRow+iCol);
			buttonMat[iRow][iCol].setIcon(buttonMat[iRowCero][iColCero].getIcon());
//			pane.remove(iRowCero+iColCero);
//			pane.add(aux,iRowCero+iColCero);
			buttonMat[iRowCero][iColCero].setIcon(aux);
			iColCero = iCol;
			iRowCero = iRow;
			
			return true;
		}
		return false;
	}
	
	// Class that handles events
	private class Handler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();
			
			if (obj instanceof JButton)
			{
				JButton b = (JButton)obj;
				if (Switch(b))	// The switch was successful, the clicked button was next to the empty space
				{
					validate();
					repaint();
				}
			}
		}
	}

}