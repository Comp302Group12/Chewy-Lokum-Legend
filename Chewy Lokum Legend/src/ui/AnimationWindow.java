package ui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

@SuppressWarnings("serial")
public class AnimationWindow extends JPanel {

	private static int TIMER_DELAY_CONS = 16;

	int width;
	int height;
	Game game;
	GamePlay gamePlay;
	private AnimationEventListener eventListener;
	private Timer timer;

	public AnimationWindow(int width, int height, GamePlay gamePlay) {
		// TODO Auto-generated constructor stub
		super();		
		this.width = width;
		this.height = height;
		setSize(width, height);
		this.gamePlay = gamePlay;
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
		gamePlay.getBoard().draw(g);
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
			gamePlay.update();
			repaint();
		}
	}

}
