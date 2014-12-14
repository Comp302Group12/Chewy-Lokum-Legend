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
	int width;
	int height;
	Level level;
	private AnimationEventListener eventListener;
	private Timer timer;
	private boolean mode;

	public AnimationWindow(int width, int height, Level level) {
		// TODO Auto-generated constructor stub
		super();		
		this.width = width;
		this.height = height;
		setSize(width, height);
		this.level = level;//new GamePlay(width-1, height-1);
		eventListener = new AnimationEventListener();
		// The first parameter is how often (in milliseconds) the timer
		// should call us back. 50 milliseconds = 20 frames/second

		timer = new Timer(50, eventListener);
		addMouseListener(eventListener);
		addMouseMotionListener(eventListener);
		addKeyListener(eventListener);
		requestFocus(); // make sure keyboard is directed to us
		timer.start();

		//mode = false;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		level.getBoard().draw(g);
		//System.out.println(getWidth());
		//System.out.println(getHeight());
	}

	public void setMode(boolean m) {
		// modifies: this
		// effects: changes the mode to <m>.

		if (mode == true) {
			// we're about to change mode: turn off all the old listeners
			removeMouseListener(eventListener);
			removeMouseMotionListener(eventListener);
			removeKeyListener(eventListener);
		}

		mode = m;

		if (mode == true) {
			// the mode is true: turn on the listeners
			addMouseListener(eventListener);
			addMouseMotionListener(eventListener);
			addKeyListener(eventListener);
			requestFocus(); // make sure keyboard is directed to us
			timer.start();
		} else {
			timer.stop();
		}
	}

	class AnimationEventListener extends MouseAdapter implements
	MouseMotionListener, KeyListener, ActionListener {

		int x;
		int y;

		public void mouseClicked(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			x = e.getX();
			y = e.getY();
			if(level.getBoard().lokumAtPosition(x, y)!=null) {
				level.getGamePlay().selectedLokum1 = level.getBoard().lokumAtPosition(x, y);
			}
			//System.out.println("When mouse is pressed x of lokum of game: "+game.selectedLokum1.getX());
			//System.out.println("When mouse is pressed x of lokum of board: "+game.board.lokumAtPosition(x, y).getX());
		}

		public void mouseDragged(MouseEvent e) {
			int dx = e.getX() - x;
			int dy = e.getY() - y;

			if(level.getGamePlay().selectedLokum1 instanceof Movable) {
				((Movable)level.getGamePlay().selectedLokum1).move(dx, dy);
			}
			x += dx;
			y += dy;
		}

		public void keyReleased(KeyEvent e) {
			level.getGamePlay().selectedLokum1 = null;
		}

		public void mouseMoved(MouseEvent e) {
		}

		public void keyPressed(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
		}

		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

}
