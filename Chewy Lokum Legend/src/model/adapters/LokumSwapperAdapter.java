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
	Lokum lokum1;
	Lokum lokum2;
	int xOfLokum1AtTheBeg;
	int yOfLokum1AtTheBeg;
	int xOfLokum2AtTheBeg;
	int yOfLokum2AtTheBeg;
	int speedOfSwap;
	boolean isSwapInProgres;

	public LokumSwapperAdapter() {
		// TODO Auto-generated constructor stub
		timer = new Timer(AnimationWindow.getTIMER_DELAY_CONS(), this);
		speedOfSwap = 10;
		isSwapInProgres = false;
	}

	public abstract void swapLokums(GamePlay gamePlay, Lokum lokum1, Lokum lokum2);

	public boolean isSwapInProgres() {
		return isSwapInProgres;
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
