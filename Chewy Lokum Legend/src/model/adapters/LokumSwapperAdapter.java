package model.adapters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.*;
import model.adapters.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public abstract class LokumSwapperAdapter implements ActionListener {

	Timer timer;
	GamePlay gamePlay;
	Lokum lokum1;
	Lokum lokum2;
	int xOfLokum1AtTheBeg;
	int yOfLokum1AtTheBeg;
	int xOfLokum2AtTheBeg;
	int yOfLokum2AtTheBeg;
	int speedOfSwap;
	private boolean isSwapInProgres;

	public abstract boolean checkConditions();
	public abstract void doBeforeSwapIsStarted();
	public abstract void doAfterSwapIsEnded();

	public LokumSwapperAdapter() {
		// TODO Auto-generated constructor stub
		timer = new Timer(AnimationWindow.getTIMER_DELAY_CONS(), this);
		speedOfSwap = 10;
		isSwapInProgres = false;
	}

	public boolean isSwapInProgres() {
		return isSwapInProgres;
	}

	public void swapLokums(GamePlay gamePlay, Lokum lokum1, Lokum lokum2) {
		isSwapInProgres = true;
		this.gamePlay = gamePlay;
		this.lokum1 = lokum1;
		this.lokum2 = lokum2;
		xOfLokum1AtTheBeg = lokum1.getX();
		yOfLokum1AtTheBeg = lokum1.getY();
		xOfLokum2AtTheBeg = lokum2.getX();
		yOfLokum2AtTheBeg = lokum2.getY();
		if(checkConditions()) {
			startSwap();
		} else {
			cancelSwap();
		}
	}

	public void startSwap() {
		doBeforeSwapIsStarted();
		timer.start();
	}

	public void stopSwap() {
		timer.stop();
		doAfterSwapIsEnded();
		isSwapInProgres = false;
	}

	public void cancelSwap() {
		timer.stop();
		isSwapInProgres = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(lokum1.getX() > xOfLokum2AtTheBeg
				&& (Math.abs(lokum1.getX() - xOfLokum2AtTheBeg) > speedOfSwap)) {
			((Movable) lokum1).move(-speedOfSwap, 0);
			((Movable) lokum2).move(speedOfSwap, 0);
		} else if(lokum1.getX()<xOfLokum2AtTheBeg) {
			((Movable) lokum1).move(speedOfSwap, 0);
			((Movable) lokum2).move(-speedOfSwap, 0);
		}
		if((lokum1.getY() > yOfLokum2AtTheBeg)
				&& (Math.abs(lokum1.getY() - yOfLokum2AtTheBeg) > speedOfSwap)) {
			((Movable) lokum1).move(0, -speedOfSwap);
			((Movable) lokum2).move(0, speedOfSwap);
		} else if(lokum1.getY()<yOfLokum2AtTheBeg) {
			((Movable) lokum1).move(0, speedOfSwap);
			((Movable) lokum2).move(0, -speedOfSwap);
		}
		if((Math.abs(lokum1.getX() - xOfLokum2AtTheBeg) <= speedOfSwap)
				&& (Math.abs(lokum1.getY() - yOfLokum2AtTheBeg) <= speedOfSwap)) {
			lokum1.setX(xOfLokum2AtTheBeg);
			lokum1.setY(yOfLokum2AtTheBeg);
			lokum2.setX(xOfLokum1AtTheBeg);
			lokum2.setY(yOfLokum1AtTheBeg);
			stopSwap();			
		}
	}

}
