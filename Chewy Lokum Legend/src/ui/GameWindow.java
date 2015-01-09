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
	JButton specialSwapButton;

	public GameWindow() {
		// TODO Auto-generated constructor stub
		super();

		setLayout(null);

		informationWindow = new InformationWindow(180, 120);
		informationWindow.setLocation(441, 0);

		add(informationWindow);

		animationWindow = new AnimationWindow(431, 431, new Level1(), informationWindow);
		animationWindow.setLocation(0, 0);

		add(animationWindow);

		specialSwapButton = new JButton("Special Swap");

		specialSwapButton.setBounds(461, 190, 120, 35);
		add(specialSwapButton);

		pauseGameButton = new JButton("Pause Game");

		pauseGameButton.setBounds(461, 250, 120, 35);
		add(pauseGameButton);
	}

	public void newLevelSelected(Level level) {
		remove(informationWindow);
		informationWindow = new InformationWindow(180, 120);
		informationWindow.setLocation(441, 0);
		add(informationWindow);

		remove(animationWindow);
		animationWindow = new AnimationWindow(430, 430, level, informationWindow);
		animationWindow.setLocation(0, 0);
		add(animationWindow);

		String objectiveScore = "Goal Score: "+level.objectiveScore;
		String score = "Score: "+AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().score;		
		String remainingQuantity;
		if(level instanceof MoveBasedLevel){
			remainingQuantity = "Remaining Moves: "+((MoveBasedLevel)level).remainingMove;
		} else {
			remainingQuantity = "Remaining Time: "+((TimeBasedLevel)level).remainingTime;
		}
		String remainingSSwaps = "Remaining S. Swaps: "+ AdapterManager.getInstance().getSlsAdaper().getNumOfRemainingSpecialSwaps();
		informationWindow.updateInformationWindow(objectiveScore, score, remainingQuantity, remainingSSwaps);
	}

}
