import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomeMessage extends JFrame {
	private JLabel message;
	
	public WelcomeMessage() {
		super("Welcome to the game");
		setLayout(new FlowLayout());
		
		message = new JLabel("Order the numbers from 1 to 15 starting from the top-left corner.\n"
				+ " The bottom-right corner of the puzzle should be empty in order to win.");
		add(message);
	}
}
