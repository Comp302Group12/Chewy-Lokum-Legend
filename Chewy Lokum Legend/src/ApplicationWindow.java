import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ApplicationWindow extends JFrame {

	private JPanel contentPane;
	MenuWindow menuWindow;
	LevelSelectionWindow levelSelectionWindow;
	GameWindow gameWindow;
	PauseGameWindow pauseGameWindow;

	public ApplicationWindow() {
		super("Chewy Lokum Legend");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		////////////////////////////////////////////////////////////////////////
		menuWindow = new MenuWindow();
		contentPane.add(menuWindow, "name_92135036815278");

		menuWindow.startNewGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuWindow.setVisible(false);
				levelSelectionWindow.setVisible(true);
			}
		});

		menuWindow.loadGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuWindow.setVisible(false);
				gameWindow.setVisible(true);
			}
		});

		menuWindow.exitGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		// ///////////////////////////////////////////////////////////////////////////
		levelSelectionWindow = new LevelSelectionWindow(2);
		contentPane.add(levelSelectionWindow, "name_92176023342318");

		((AbstractButton) levelSelectionWindow.levelPanels.get(0).getComponent(0)).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelSelectionWindow.setVisible(false);
				gameWindow.setVisible(true);
			}
		});

		((AbstractButton) levelSelectionWindow.levelPanels.get(1).getComponent(0)).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				levelSelectionWindow.setVisible(false);
				gameWindow.setVisible(true);
			}
		});		

		//////////////////////////////////////////////////////////////////////////////////
		gameWindow = new GameWindow();
		contentPane.add(gameWindow, "name_92260090971391");

		gameWindow.pauseGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameWindow.setVisible(false);
				pauseGameWindow.setVisible(true);
			}
		});

		// ////////////////////////////////////////////////////////
		pauseGameWindow = new PauseGameWindow();
		contentPane.add(pauseGameWindow, "name_44933427952662");

		pauseGameWindow.resumeGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pauseGameWindow.setVisible(false);
				gameWindow.setVisible(true);
			}
		});

		pauseGameWindow.quitGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pauseGameWindow.setVisible(false);
				menuWindow.setVisible(true);
			}
		});
	}
}