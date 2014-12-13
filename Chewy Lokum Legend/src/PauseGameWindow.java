import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PauseGameWindow extends JPanel {

	JButton resumeGameButton;
	JButton saveGameButton;
	JButton quitGameButton;

	public PauseGameWindow() {
		// TODO Auto-generated constructor stub
		super();
		setLayout(null);

		resumeGameButton = new JButton("Resume Game");
		resumeGameButton.setBounds(255, 175, 130, 35);
		add(resumeGameButton);

		saveGameButton = new JButton("Save Game");
		saveGameButton.setBounds(255, 220, 130, 35);
		add(saveGameButton);

		quitGameButton = new JButton("Quit Game");
		quitGameButton.setBounds(255, 265, 130, 35);
		add(quitGameButton);
	}

}
