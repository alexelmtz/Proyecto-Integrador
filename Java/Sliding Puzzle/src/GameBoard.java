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
	private JButton[][] buttonMat;
	private Container pane;
	private int iDimension;
	private int iRowCero;
	private int iColCero;
	private int iMoveCount;
	private long lStartTime;
	private long lEndTime;
	
	public int getDimension() {
		return iDimension;
	}
	
	public int getMoveCount() {
		return iMoveCount;
	}
	
	
	GameBoard(int iS) {
		super("GameBoard");
		iDimension = iS;
		iMoveCount = 0;
		lStartTime = System.nanoTime();
//		Generate();
		GenerateToWin();
	}
	
	
	public void GenerateToWin() {
		buttonMat = new JButton[iDimension][iDimension];
		pane = getContentPane();
		pane.setLayout(new GridLayout(iDimension,iDimension));
		Handler handler = new Handler();
		
		List<Integer> lintUsed = new ArrayList<>();		// List of numbers that have been added to the game board
		for (int iR = 0; iR < iDimension; iR++)
			for (int iC = 0; iC < iDimension; iC++)
			{
			
				if (iR == 3 && iC == 3)
				{
					iRowCero = iR;
					iColCero = iC;
				}
				int iNumber = iR*iDimension + iC + 1;
				if (iNumber == (iDimension*iDimension) )
					iNumber = 0;
			
				lintUsed.add(iNumber);
			
				ImageIcon pic = new ImageIcon(getClass().getResource(Integer.toString(iNumber) + ".png"));
				pic.setDescription(Integer.toString(iNumber));
				JButton button = new JButton(pic);
				button.addActionListener(handler);
				button.setBorder(BorderFactory.createEmptyBorder());
				buttonMat[iR][iC] = button;
				pane.add(button);
			}
	}

	// Generates a puzzle with a random order
	public void Generate() {	
		buttonMat = new JButton[iDimension][iDimension];
		pane = getContentPane();
		pane.setLayout(new GridLayout(iDimension,iDimension));
		Handler handler = new Handler();
		
		Random rand = new Random();
		int iRand;
		List<Integer> lintUsed = new ArrayList<>();		// List of numbers that have been added to the game board
		for (int iR = 0; iR < iDimension; iR++)
			for (int iC = 0; iC < iDimension; iC++)
			{
				do {
					iRand = rand.nextInt(iDimension*iDimension - 0) + 0;
				} while (lintUsed.contains(iRand));		// The number is already in the game board
			
				if (iRand == 0)
				{
					iRowCero = iR;
					iColCero = iC;
				}
			
				lintUsed.add(iRand);
			
				ImageIcon pic = new ImageIcon(getClass().getResource(Integer.toString(iRand) + ".png"));
				pic.setDescription(Integer.toString(iRand));
				JButton button = new JButton(pic);
				button.addActionListener(handler);
				button.setBorder(BorderFactory.createEmptyBorder());
				buttonMat[iR][iC] = button;
				pane.add(button);
			}
		
	}
	
	// Switches blank space with the button the user clicked. Returns false if the switch failed.
	private boolean Switch(JButton b) {
		int iRow = 0, iCol = 0;
		
		// Finds the position of the button to be switched
		for (int iR = 0; iR < iDimension; iR++)
			for (int iC = 0; iC < iDimension; iC++)
			{
				if (buttonMat[iR][iC] == b)
				{
					iRow = iR;
					iCol = iC;
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
	
	// Checks if the gameboard is in order
	private boolean Win() {
		for (int iR = 0; iR < iDimension; iR++)
			for (int iC = 0; iC < iDimension; iC++)
			{
				ImageIcon icon = (ImageIcon)buttonMat[iR][iC].getIcon();
				if ( (iR*iDimension + iC) == (iDimension*iDimension - 1) )		//It's the last position of the gameboard
				{
					if (!(Integer.parseInt(icon.getDescription()) == 0))
						return false;
				}
				else if (!(Integer.parseInt(icon.getDescription()) == (iR*iDimension + iC + 1) ))
					return false;
			}
		return true;
	}
	
	// Class that handles events
	private class Handler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object obj = event.getSource();
			
			if (obj instanceof JButton)
			{
				JButton b = (JButton)obj;
				// Checks if the switch was successful, the clicked button was next to the empty space
				if (Switch(b))	
				{
					iMoveCount++;
					validate();
					repaint();
				}
				if (Win())
				{
					lEndTime = System.nanoTime();
					long lTotalTime = (lEndTime - lStartTime)/1000000000;
					JOptionPane.showMessageDialog(null,"Congratulations!!! You Win!!!\nMoves:" + iMoveCount + "\nTime:" +
					lTotalTime + " seconds", "You Win", JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
				}
			}
		}
	}

}