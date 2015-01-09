package ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

@SuppressWarnings("serial")
public class ApplicationWindow extends JFrame {

	private JPanel contentPane;
	MenuWindow menuWindow;
	LevelSelectionWindow levelSelectionWindow;
	GameWindow gameWindow;
	PauseGameWindow pauseGameWindow;
	/**
	 * @modifies userinterface applicationwindow
	 * @requires player to press buttons to navigate between screens
	 * @effects starts game when start game button is presses, level is seleceted when level is clicked, 
	 * game is paused when pause game clicked continues when continue game is clicked...
	 */	
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
		menuWindow = new MenuWindow(640, 480);
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

		/////////////////////////////////////////////////////////////////////////////
		levelSelectionWindow = new LevelSelectionWindow(3);
		contentPane.add(levelSelectionWindow, "name_92176023342318");

		for(int i=0; i<3; i++){
			String levelName = "model.level.Level"+(i+1);
			((AbstractButton) levelSelectionWindow.levelButtons.get(i)).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Level level = (Level) Class.forName(levelName).newInstance();
						gameWindow.newLevelSelected(level);
						levelSelectionWindow.setVisible(false);
						gameWindow.setVisible(true);
					} catch (InstantiationException | IllegalAccessException
							| ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}

		//////////////////////////////////////////////////////////////////////////////////
		gameWindow = new GameWindow();
		contentPane.add(gameWindow, "name_92260090971391");

		gameWindow.pauseGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameWindow.setVisible(false);
				pauseGameWindow.setVisible(true);
			}
		});

		gameWindow.specialSwapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdapterManager.getInstance().changeToSpecialLokumSwapperAdapter();
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