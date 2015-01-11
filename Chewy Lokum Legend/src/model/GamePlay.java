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
	public Level level;
	private boolean gameMode;
	private boolean isGameFinished;

	public GamePlay(Board board, Level level) {
		// TODO Auto-generated constructor stub
		this.board = board;
		this.level = level;
		gameMode = true;
		isGameFinished = false;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Level getLevel() {
		return level;
	}

	public boolean isGameFinished() {
		return isGameFinished;
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

	public boolean doLokumsFormSpecialCombination(Lokum lokum1, Lokum lokum2) {
		return AdapterManager.getInstance().getCurrentLokumCombinationAdapter().doLokumsFormSpecialCombination(lokum1, lokum2);
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

	public int getScore(){
		return AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().getScore();
	}

	public void setScore(int score){
		AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().setScore(score);
	}

	public void getRemainingQuantity(){
		level.getRemainingQuantity();
	}
	
	public void setRemainingQuantity(int quantity){
		level.setRemainingQuantity(quantity);
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
		if(level instanceof TimeBasedLevel){
			((TimeBasedLevel) level).updateFps();
			if(((TimeBasedLevel) level).shouldGameFinish()){
				isGameFinished = true;
			}
		}
		if(isGameModeOn()){
			if(level.shouldGameFinish()){
				isGameFinished = true;
			} else if(doesBoardHaveCombination()) {
				destroyExistingCombinations();
				placeSpecialLokums();
				fallLokums();
			}
		}
	}

}
