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
	private boolean isGameModeOn;

	public GamePlay(Board board) {
		// TODO Auto-generated constructor stub
		this.board = board;
		isGameModeOn = true;
	}
	
	public Board getBoard() {
		return board;
	}

	public void selectLokum1(int x, int y) {
		if(checkGameMode()){
			selectedLokum1 = board.lokumAtPosition(x, y);
		}
	}

	public void selectLokum2(int x, int y) {
		if(checkGameMode()){
			Lokum chosenLokum = board.lokumAtPosition(x, y);
			if(selectedLokum2 == null && selectedLokum1 != null && chosenLokum != selectedLokum1) {
				selectedLokum2 = chosenLokum;
				swapSelectedLokums();
			} else {
				resetSelectedLokums();
			}
		}
	}

	public void swapSelectedLokums() {
		AdapterManager.getInstance().getCurrentLokumSwapperAdapter().swapLokums(this, selectedLokum1, selectedLokum2);
		resetSelectedLokums();
	}

	public void resetSelectedLokums() {
		selectedLokum1 = null;
		selectedLokum2 = null;
	}

	public boolean doesBoardHaveCombination() {
		return true;
	}

	public boolean checkGameMode() {
		isGameModeOn = true;
		if(AdapterManager.getInstance().getCurrentLokumSwapperAdapter().isSwapInProgres()) {
			isGameModeOn = false;
		}
		return isGameModeOn;
	}

	public void update() {
		/*
		if(!checkGameMode()) {
			System.out.println("Haz�r de�il!!!");
		} else {
			System.out.println("Haz�r!!!");
		}
		 */
	}

}
