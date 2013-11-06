import javax.swing.*;

public class ChosingWindow extends JOptionPane {
	JDialog chosingWindow;
	Choice[] choice = {Choice.PAPER, Choice.ROCK, Choice.SCISSORS, Choice.DECONNEXION};

	public ChosingWindow (String player) {
		setMessage (player+" chooses a hint");
		setOptions (choice);
		chosingWindow = createDialog(null, "choice");
	}

	public Choice getChoice() {
		chosingWindow.setVisible(true);
		return (Choice)getValue();
	}
}
