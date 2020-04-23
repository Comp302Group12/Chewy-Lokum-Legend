package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class MenuWindow extends JPanel {

	JLabel gameTitleLabel;
	JButton startNewGameButton;
	JButton loadGameButton;
	JButton exitGameButton;

	public MenuWindow(int width, int height) {
		// TODO Auto-generated constructor stub
		super();
		setSize(width, height);
		setLayout(null);

		gameTitleLabel = new JLabel("Chewy Lokum Legend");
		gameTitleLabel.setForeground(Color.BLACK);
		gameTitleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		gameTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameTitleLabel.setBounds(140, 100, 360, 100);
		add(gameTitleLabel);

		startNewGameButton = new JButton("Start New Game");		
		startNewGameButton.setBounds(245, 230, 150, 35);
		add(startNewGameButton);

		loadGameButton = new JButton("Load Game");
		loadGameButton.setBounds(245, 275, 150, 35);
		add(loadGameButton);

		exitGameButton = new JButton("Exit Game");
		exitGameButton.setBounds(245, 320, 150, 35);
		add(exitGameButton);
	}

}
