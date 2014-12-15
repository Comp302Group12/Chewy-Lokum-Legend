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

public class RegularLokumSwapperAdapter extends LokumSwapperAdapter {

	public void swapLokums(GamePlay gamePlay, Lokum lokum1, Lokum lokum2) {
		if(gamePlay.level.getBoard().areLokumsAdjacent(lokum1, lokum2)){
			gamePlay.level.getBoard().swap(lokum1, lokum2);
			if(gamePlay.doesBoardHaveCombination()) {
				this.lokum1 = lokum1;
				this.lokum2 = lokum2;
				xOfLokum1AtTheBeg = lokum1.getX();
				yOfLokum1AtTheBeg = lokum1.getY();
				xOfLokum2AtTheBeg = lokum2.getX();
				yOfLokum2AtTheBeg = lokum2.getY();
				timer.start();
				isSwapInProgres = true;
			} else {
				gamePlay.level.getBoard().swap(lokum1, lokum2);
			}
		}
	}

}
