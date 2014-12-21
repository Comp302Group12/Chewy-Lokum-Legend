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
	public Board board;
	private boolean gameMode;

	public GamePlay(Board board) {
		// TODO Auto-generated constructor stub
		this.board = board;
		gameMode = true;
	}

	public Board getBoard() {
		return board;
	}

	public void selectLokum1(int x, int y) {
		if(isGameModeOn()){
			selectedLokum1 = board.lokumAtPosition(x, y);
		}
	}

	public void selectLokum2(int x, int y) {
		if(isGameModeOn()){
			Lokum chosenLokum = board.lokumAtPosition(x, y);
			if(selectedLokum2 == null && selectedLokum1 != null && chosenLokum != selectedLokum1) {
				selectedLokum2 = chosenLokum;
				swapSelectedLokums();
			} else {
				resetSelectedLokums();
			}
		}
	}

	public void resetSelectedLokums() {
		selectedLokum1 = null;
		selectedLokum2 = null;
	}

	public void swapSelectedLokums() {
		AdapterManager.getInstance().getCurrentLokumSwapperAdapter().swapLokums(this, selectedLokum1, selectedLokum2);
		resetSelectedLokums();
	}

	public boolean doesBoardHaveCombination() {
		return AdapterManager.getInstance().getCurrentLokumCombinationAdapter().doesBoardHaveCombination(this);
	}

	public void destroyExistingCombinations() {
		AdapterManager.getInstance().getCurrentLokumDestroyerAdapter().destroyExistingCombinations(this);
	}

	public void placeSpecialLokums() {
		AdapterManager.getInstance().getCurrentLokumCombinationAdapter().placeSpecialLokums();
	}

	public void fallLokums() {
		AdapterManager.getInstance().getCurrentLokumFallerAdapter().fallLokums(this);
	}

	public boolean isGameModeOn() {
		gameMode = true;
		if(AdapterManager.getInstance().getCurrentLokumSwapperAdapter().isSwapInProgres()) {
			gameMode = false;
		}
		if(AdapterManager.getInstance().getCurrentLokumFallerAdapter().isFallInProgress()) {
			gameMode = false;
		}
		return gameMode;
	}

	public void update() {
		if(isGameModeOn() && doesBoardHaveCombination()){
			destroyExistingCombinations();
			placeSpecialLokums();
			fallLokums();

		}
	}

}
