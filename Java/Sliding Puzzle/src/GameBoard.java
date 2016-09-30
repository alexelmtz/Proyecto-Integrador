//	Alejandro Elizondo
//	alexelmtz@outlook.com
//	Linkedin: linkedin.com/in/alejandro-elizondo
//	Github: github.com/alexelmtz/Sliding-Puzzle

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;

public class GameBoard extends JFrame {
	private JButton[][] buttonMat;
	private Container pane;
	private int iDimension;
	private int iRowZero;
	private int iColZero;
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
		Generate();
	}
	
	// Temporal generate used for testing
	public void GenerateToWin() {
		buttonMat = new JButton[iDimension][iDimension];
		pane = getContentPane();
		pane.setLayout(new GridLayout(iDimension,iDimension));
		Handler handler = new Handler();
		
		List<Integer> lintUsed = new ArrayList<>();		// List of numbers that have been added to the game board
		for (int iR = 0; iR < iDimension; iR++)
			for (int iC = 0; iC < iDimension; iC++)
			{
			
				if (iR == iDimension-1 && iC == iDimension-1)
				{
					iRowZero = iR;
					iColZero = iC;
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
					iRowZero = iR;
					iColZero = iC;
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
		double dDistance = Math.sqrt(Math.pow(iRow - iRowZero, 2) + Math.pow(iCol - iColZero, 2));
		// Checks if the number is next to the blank space
		if (dDistance == 1)
		{				
			Icon aux = buttonMat[iRow][iCol].getIcon();
			buttonMat[iRow][iCol].setIcon(buttonMat[iRowZero][iColZero].getIcon());
			buttonMat[iRowZero][iColZero].setIcon(aux);
			iColZero = iCol;
			iRowZero = iRow;
			
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
				if (Switch(b))	//Switch is successful if the button clicked was next to the empty space
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
//					TopScores(lTotalTime);
					System.exit(0);
				}
			}
		}
		
		// Gets the top 10 scores of the game from MySQL database
		private void TopScores(long lTotalTime) {
			ArrayList<String> sTopPlayers = new ArrayList<String>();
			ArrayList<Integer> iTopMoves = new ArrayList<Integer>();
			ArrayList<Integer> iTopTime = new ArrayList<Integer>();
			String sTop = "\t\t\tTop Scores\n\n";
			String mySQLTable;
			
			String sName = JOptionPane.showInputDialog("Please type your name");
			if (sName == null || sName.length() < 1)
				sName = "Default";
			try {
				//Get connection with MySQL database
				Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sliding_Puzzle?useSSL=false",
						"root", "puzzle/");
				Statement myStmt = mycon.createStatement();
				//Adds the new score to the database
				if (iDimension == 4)
					mySQLTable = "Top_Scores_4";
				else
					mySQLTable = "Top_Scores_3";
					
				String sql = "INSERT INTO " + mySQLTable + "(Name, Score, Time) "
						+ "VALUES ('"+sName+"', '"+iMoveCount+"', '"+lTotalTime+"')";
				
				myStmt.executeUpdate(sql);
				//Execute SQL query
				ResultSet myRs = myStmt.executeQuery("SELECT * from " + mySQLTable);
				//Adds contents of the database to the lists
				while (myRs.next())
				{
					sTopPlayers.add(myRs.getString("Name"));
					iTopMoves.add(myRs.getInt("Score"));
					iTopTime.add(myRs.getInt("Time"));
				}
				Sort(sTopPlayers, iTopMoves, iTopTime);
				
				for (int i = 0; i < 10 && i < iTopTime.size(); i++)
					sTop += sTopPlayers.get(i) + " " + iTopMoves.get(i) + " moves " + iTopTime.get(i) + " seconds\n";
				
				JOptionPane.showMessageDialog(null, sTop, "Top Scores", JOptionPane.PLAIN_MESSAGE);
				
			} catch (Exception e) {
				System.out.println("Error with database connection");
				e.printStackTrace();
			}
		}
		
		// Sorts the lists in ascending order according to the amount of moves, followed by the time
		public void Sort(ArrayList<String> sL, ArrayList<Integer> iLMoves, ArrayList<Integer> iLTime)
		{
			String saux;
			int iauxM, iauxT;
			for (int i = 0; i < iLMoves.size(); i++)
				for (int j = 1; j < iLMoves.size() - i; j++)
					if(iLMoves.get(j-1) > iLMoves.get(j))
					{
						// Swaps positions of Moves List
						iauxM = iLMoves.get(j-1);
						iLMoves.set(j-1, iLMoves.get(j));
						iLMoves.set(j, iauxM);
						// Swaps positions of Time List
						iauxT = iLTime.get(j-1);
						iLTime.set(j-1, iLTime.get(j));
						iLTime.set(j, iauxT);
						// Swaps positions of Name List
						saux = sL.get(j-1);
						sL.set(j-1, sL.get(j));
						sL.set(j, saux);
					}
					else if (iLMoves.get(j-1) == iLMoves.get(j))
						if (iLTime.get(j-1) > iLTime.get(j))
						{
							// Swaps positions of Moves List
							iauxM = iLMoves.get(j-1);
							iLMoves.set(j-1, iLMoves.get(j));
							iLMoves.set(j, iauxM);
							// Swaps positions of Time List
							iauxT = iLTime.get(j-1);
							iLTime.set(j-1, iLTime.get(j));
							iLTime.set(j, iauxT);
							// Swaps positions of Name List
							saux = sL.get(j-1);
							sL.set(j-1, sL.get(j));
							sL.set(j, saux);
						}
		}
	}
}