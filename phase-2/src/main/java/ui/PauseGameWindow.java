package ui;

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
		resumeGameButton.setBounds(245, 175, 150, 35);
		add(resumeGameButton);

		saveGameButton = new JButton("Save Game");
		saveGameButton.setBounds(245, 220, 150, 35);
		add(saveGameButton);

		quitGameButton = new JButton("Quit Game");
		quitGameButton.setBounds(245, 265, 150, 35);
		add(quitGameButton);
	}

}
