package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public class RegularLokumSwapper implements ActionListener {

	Timer timer;
	Board board;
	Lokum lokum1;
	Lokum lokum2;
	int xOfLokum1AtTheBeg;
	int yOfLokum1AtTheBeg;
	int xOfLokum2AtTheBeg;
	int yOfLokum2AtTheBeg;
	int speedOfSwap;
	boolean isSwapInProgres;

	public boolean isSwapInProgres() {
		return isSwapInProgres;
	}

	public RegularLokumSwapper() {
		// TODO Auto-generated constructor stub
		timer = new Timer(AnimationWindow.getTIMER_DELAY_CONS(), this);
		speedOfSwap = 10;
		isSwapInProgres = false;
	}

	public void swapLokums(Board board, Lokum lokum1, Lokum lokum2) {
		if(board.areLokumsAdjacent(lokum1, lokum2)){
			this.board = board;
			this.lokum1 = lokum1;
			this.lokum2 = lokum2;
			xOfLokum1AtTheBeg = lokum1.getX();
			yOfLokum1AtTheBeg = lokum1.getY();
			xOfLokum2AtTheBeg = lokum2.getX();
			yOfLokum2AtTheBeg = lokum2.getY();
			board.swap(lokum1, lokum2);
			timer.start();
			isSwapInProgres = true;
		}
	}

	public void cancelSwap() {
		board.swap(lokum1, lokum2);
		timer.stop();
		lokum1 = null;
		lokum2 = null;
		xOfLokum1AtTheBeg = 0;
		yOfLokum1AtTheBeg = 0;
		xOfLokum2AtTheBeg = 0;
		yOfLokum2AtTheBeg = 0;
		isSwapInProgres = false;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(lokum1.getX() > xOfLokum2AtTheBeg
				&& (Math.abs(lokum1.getX() - xOfLokum2AtTheBeg) >= speedOfSwap)) {
			((Movable) lokum1).move(-speedOfSwap, 0);
			((Movable) lokum2).move(speedOfSwap, 0);
		} else if(lokum1.getX()<xOfLokum2AtTheBeg) {
			((Movable) lokum1).move(speedOfSwap, 0);
			((Movable) lokum2).move(-speedOfSwap, 0);
		}
		if((lokum1.getY() > yOfLokum2AtTheBeg)
				&& (Math.abs(lokum1.getY() - yOfLokum2AtTheBeg) >= speedOfSwap)) {
			((Movable) lokum1).move(0, -speedOfSwap);
			((Movable) lokum2).move(0, speedOfSwap);
		} else if(lokum1.getY()<yOfLokum2AtTheBeg) {
			((Movable) lokum1).move(0, speedOfSwap);
			((Movable) lokum2).move(0, -speedOfSwap);
		}
		if((Math.abs(lokum1.getX() - xOfLokum2AtTheBeg) < speedOfSwap)
				&& (Math.abs(lokum1.getY() - yOfLokum2AtTheBeg) < speedOfSwap)) {
			lokum1.setX(xOfLokum2AtTheBeg);
			lokum1.setY(yOfLokum2AtTheBeg);
			lokum2.setX(xOfLokum1AtTheBeg);
			lokum2.setY(yOfLokum1AtTheBeg);
			timer.stop();
			isSwapInProgres = false;
		}
	}

}
