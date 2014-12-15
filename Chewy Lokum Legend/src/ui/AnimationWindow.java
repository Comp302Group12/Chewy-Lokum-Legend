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
import model.adapters.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

@SuppressWarnings("serial")
public class AnimationWindow extends JPanel {

	private static int TIMER_DELAY_CONS = 16;

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
		this.level = level;
		eventListener = new AnimationEventListener();
		// The first parameter is how often (in milliseconds) the timer
		// should call us back. 50 milliseconds = 20 frames/second

		timer = new Timer(TIMER_DELAY_CONS, eventListener);
		addMouseListener(eventListener);
		addMouseMotionListener(eventListener);
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
		}

		mode = m;

		if (mode == true) {
			// the mode is true: turn on the listeners
			addMouseListener(eventListener);
			addMouseMotionListener(eventListener);
			requestFocus(); // make sure keyboard is directed to us
			timer.start();
		} else {
			timer.stop();
		}
	}

	public static int getTIMER_DELAY_CONS() {
		return TIMER_DELAY_CONS;
	}

	class AnimationEventListener extends MouseAdapter implements
	MouseMotionListener, ActionListener {

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if (level.getGamePlay().isGameModeOn()) {
				level.getGamePlay().selectLokum(e.getX(), e.getY());				
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if (level.getGamePlay().isGameModeOn()) {
				level.getGamePlay().selectLokum(e.getX(), e.getY());				
			}
		}

		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}

}
