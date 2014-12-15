package model;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public class GamePlay {

	public Lokum selectedLokum1;
	public Lokum selectedLokum2;
	Level level;
	public RegularLokumSwapper rlSwapper;
	boolean isGameModeOn;

	public GamePlay(Level level) {
		// TODO Auto-generated constructor stub
		this.level = level;
		rlSwapper = new RegularLokumSwapper();
		isGameModeOn = true;
	}

	public void selectLokum(int x, int y) {
		Lokum clickedLokum = level.getBoard().lokumAtPosition(x, y);
		if(clickedLokum instanceof Movable && selectedLokum1 == null) {
			selectedLokum1 = clickedLokum;

		} else if(level.getBoard().lokumAtPosition(x, y) instanceof Movable && selectedLokum2 == null) {
			selectedLokum2 = level.getBoard().lokumAtPosition(x, y);
			swapSelectedLokums();
		}
	}

	public void swapSelectedLokums() {
		rlSwapper.swapLokums(level.getBoard(), selectedLokum1, selectedLokum2);
		if(!doesBoardHaveCombination()) {
			rlSwapper.cancelSwap();
		}
		selectedLokum1 = null;
		selectedLokum2 = null;
	}

	public boolean doesBoardHaveCombination() {
		return true;
	}

	public boolean isGameModeOn() {
		isGameModeOn = true;
		if(rlSwapper.isSwapInProgres) {
			isGameModeOn = false;
		}
		return isGameModeOn;
	}
	
}
