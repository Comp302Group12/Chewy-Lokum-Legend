package model;

import model.*;
import model.adapters.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public class GamePlay {

	public Lokum selectedLokum1;
	public Lokum selectedLokum2;
	public Level level;
	boolean isGameModeOn;

	public GamePlay(Level level) {
		// TODO Auto-generated constructor stub
		this.level = level;
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
		AdapterManager.getInstance().getCurrentLokumSwapperAdapter().swapLokums(this, selectedLokum1, selectedLokum2);
		selectedLokum1 = null;
		selectedLokum2 = null;
	}

	public boolean doesBoardHaveCombination() {
		return true;
	}

	public boolean isGameModeOn() {
		isGameModeOn = true;
		if(AdapterManager.getInstance().getCurrentLokumSwapperAdapter().isSwapInProgres()) {
			isGameModeOn = false;
		}
		return isGameModeOn;
	}

}
