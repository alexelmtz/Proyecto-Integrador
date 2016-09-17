import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Button extends JButton {
	private Icon pic;
	private JButton button;
	private int iCol;
	private int iRow;
	
	public Button(int iRand, int iR, int iC) {
		iRow = iR;
		iCol = iC;
		pic = new ImageIcon(getClass().getResource(Integer.toString(iRand) + ".png"));
		button = new JButton(pic);
		button.setBorder(BorderFactory.createEmptyBorder());
		Handler handler = new Handler();
	}
	
	public JButton getButton () {
		return button;
	}
	
	private class Handler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
		}
	}

}
