import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ApplicationWindow extends JFrame {

	private JPanel contentPane;
	JPanel menuWindow;
	JPanel levelSelectionWindow;
	JPanel gameWindow;
	JPanel pauseGameWindow;

	public ApplicationWindow() {
		super("Chewy Lokum Legend");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		// //////////////////////////////////////////////////////////////////////
		menuWindow = new JPanel();
		contentPane.add(menuWindow, "name_92135036815278");

		menuWindow.setLayout(null);

		JLabel gameTitleLabel = new JLabel("Chewy Lokum Legend");
		gameTitleLabel.setForeground(Color.BLACK);
		gameTitleLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		gameTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameTitleLabel.setBounds(140, 100, 360, 100);
		menuWindow.add(gameTitleLabel);

		JButton startNewGameButton = new JButton("Start New Game");
		startNewGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuWindow.setVisible(false);
				levelSelectionWindow.setVisible(true);
			}
		});
		startNewGameButton.setBounds(255, 230, 130, 35);
		menuWindow.add(startNewGameButton);

		JButton loadGameButton = new JButton("Load Game");
		loadGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuWindow.setVisible(false);
				gameWindow.setVisible(true);
			}
		});
		loadGameButton.setBounds(255, 275, 130, 35);
		menuWindow.add(loadGameButton);

		JButton exitGameButton = new JButton("Exit Game");
		exitGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitGameButton.setBounds(255, 320, 130, 35);
		menuWindow.add(exitGameButton);

		// ///////////////////////////////////////////////////////////////////////////
		levelSelectionWindow = new JPanel();
		contentPane.add(levelSelectionWindow, "name_92176023342318");

		levelSelectionWindow.setLayout(null);

		JPanel level1Panel = new JPanel();
		level1Panel.setBounds(200, 175, 100, 130);
		level1Panel.setBackground(Color.BLACK);
		levelSelectionWindow.add(level1Panel);
		level1Panel.setLayout(null);

		JButton level1Button = new JButton("Level 1");
		level1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelSelectionWindow.setVisible(false);
				gameWindow.setVisible(true);
			}
		});
		level1Button.setBounds(0, 100, 100, 30);
		level1Panel.add(level1Button);

		JPanel level2Panel = new JPanel();
		level2Panel.setLayout(null);
		level2Panel.setBounds(340, 175, 100, 130);
		level2Panel.setBackground(Color.BLACK);
		levelSelectionWindow.add(level2Panel);

		JButton level2Button = new JButton("Level 2");
		level2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelSelectionWindow.setVisible(false);
				gameWindow.setVisible(true);
			}
		});
		level2Button.setBounds(0, 100, 100, 30);
		level2Panel.add(level2Button);

		//////////////////////////////////////////////////////////////////////////////////
		gameWindow = new JPanel();
		contentPane.add(gameWindow, "name_92260090971391");

		gameWindow.setLayout(null);

		AnimationWindow animationWindow = new AnimationWindow(431, 431);
		animationWindow.setLocation(0, 0);

		gameWindow.add(animationWindow);
		
		InformationWindow informationWindow = new InformationWindow(180, 120);
		informationWindow.setLocation(441, 0);
		
		
		gameWindow.add(informationWindow);

		JButton pauseGameButton = new JButton("Pause Game");
		pauseGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameWindow.setVisible(false);
				pauseGameWindow.setVisible(true);
			}
		});
		pauseGameButton.setBounds(461, 130, 120, 35);
		gameWindow.add(pauseGameButton);
		// ////////////////////////////////////////////////////////
		pauseGameWindow = new JPanel();
		contentPane.add(pauseGameWindow, "name_44933427952662");
		pauseGameWindow.setLayout(null);

		JButton resumeGameButton = new JButton("Resume Game");
		resumeGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pauseGameWindow.setVisible(false);
				gameWindow.setVisible(true);
			}
		});
		resumeGameButton.setBounds(255, 175, 130, 35);
		pauseGameWindow.add(resumeGameButton);

		JButton saveGameButton = new JButton("Save Game");
		saveGameButton.setBounds(255, 220, 130, 35);
		pauseGameWindow.add(saveGameButton);

		JButton quitGameButton = new JButton("Quit Game");
		quitGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pauseGameWindow.setVisible(false);
				menuWindow.setVisible(true);
			}
		});
		quitGameButton.setBounds(255, 265, 130, 35);
		pauseGameWindow.add(quitGameButton);
	}
}