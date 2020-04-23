package ui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import ui.*;

@SuppressWarnings("serial")
public class AnimationWindow extends JPanel {

	private static int TIMER_DELAY_CONS = 16;

	int width;
	int height;
	Level level;
	GamePlay gamePlay;
	InformationWindow informationWindow;
	private AnimationEventListener eventListener;
	private Timer timer;

	public AnimationWindow(int width, int height, Level level, InformationWindow informationWindow) {
		// TODO Auto-generated constructor stub
		super();		
		this.width = width;
		this.height = height;
		setSize(width, height);
		this.level = level;
		gamePlay = level.getGamePlay();
		this.informationWindow = informationWindow;
		eventListener = new AnimationEventListener();
		timer = new Timer(TIMER_DELAY_CONS, eventListener);
		addMouseListener(eventListener);
		addMouseMotionListener(eventListener);
		timer.start();

		//mode = false;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if(gamePlay.isGameFinished()){
			timer.stop();
			g.drawString("Game Over", getWidth()/2, getHeight()/2);
		} else {
			gamePlay.getBoard().draw(g);
		}

	}

	public static int getTIMER_DELAY_CONS() {
		return TIMER_DELAY_CONS;
	}

	class AnimationEventListener extends MouseAdapter implements MouseMotionListener, ActionListener {
		/*
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			gamePlay.destroy();
			gamePlay.placeSpecialLokums();
		}
		 */
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if(gamePlay.getBoard().lokumAtPosition(e.getX(), e.getY()) instanceof Movable) {
				gamePlay.selectLokum1(e.getX(), e.getY());
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(gamePlay.getBoard().lokumAtPosition(e.getX(), e.getY()) instanceof Movable) {
				gamePlay.selectLokum2(e.getX(), e.getY());
			}
		}

		public void actionPerformed(ActionEvent e) {
			String objectiveScore = "Goal Score: "+level.goalScore;
			String score = "Score: "+AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().score;		
			String remainingQuantity;
			if(level instanceof MoveBasedLevel){
				remainingQuantity = "Remaining Moves: "+((MoveBasedLevel)level).remainingMove;
			} else {
				remainingQuantity = "Remaining Time: "+((TimeBasedLevel)level).remainingTime;
			}
			String remainingSSwaps = "Special Swaps: "+ AdapterManager.getInstance().getSlsAdaper().getNumOfRemainingSpecialSwaps();
			informationWindow.updateInformationWindow(objectiveScore, score, remainingQuantity, remainingSSwaps);
			gamePlay.update();
			repaint();
		}
	}

}
