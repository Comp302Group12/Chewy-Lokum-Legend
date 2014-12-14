package ui;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

@SuppressWarnings("serial")
public class GameWindow extends JPanel {

	AnimationWindow animationWindow;
	InformationWindow informationWindow;
	JButton pauseGameButton;

	public GameWindow() {
		// TODO Auto-generated constructor stub
		super();

		setLayout(null);

		animationWindow = new AnimationWindow(431, 431, new Level1());
		animationWindow.setLocation(0, 0);

		add(animationWindow);

		informationWindow = new InformationWindow(180, 120);
		informationWindow.setLocation(441, 0);

		add(informationWindow);

		pauseGameButton = new JButton("Pause Game");

		pauseGameButton.setBounds(461, 130, 120, 35);
		add(pauseGameButton);
	}

	public void newLevelSelected(Level level) {
		remove(animationWindow);
		animationWindow = new AnimationWindow(430, 430, level);
		animationWindow.setLocation(0, 0);
		add(animationWindow);

		remove(informationWindow);
		informationWindow = new InformationWindow(180, 120);
		informationWindow.setLocation(441, 0);
		add(informationWindow);
	}

}
