package model.adapter;

import model.adapter.*;

public class RegularLokumSwapperAdapter extends LokumSwapperAdapter {

	private boolean isSwapBackInProgress;

	public RegularLokumSwapperAdapter() {
		// TODO Auto-generated constructor stub
		isSwapBackInProgress = false;
	}
	/**
	 * @modifies
	 * @requires 2 lokums
	 * @effects checks if they are adjacent and returns a boolean
	 */	
	@Override
	public boolean checkConditions() {
		// TODO Auto-generated method stub
		return gamePlay.getBoard().areLokumsAdjacent(lokum1, lokum2);
	}
	/**
	 * @modifies board
	 * @requires lokums to be selected
	 * @effects checks if they are adjacent and swaps them board is updated
	 */	
	@Override
	public void doBeforeSwapIsStarted() {
		// TODO Auto-generated method stub
		gamePlay.getBoard().swap(lokum1, lokum2);
	}
	/**
	 * @modifies board
	 * @requires lokums to be swapped
	 * @effects checks if they make combination and if they dont it swaps them back. board is updated
	 */	
	@Override
	public void doAfterSwapIsEnded() {
		// TODO Auto-generated method stub
		if(!gamePlay.doLokumsFormSpecialCombination(lokum1, lokum2) && !gamePlay.doesBoardHaveCombination()){
			if(isSwapBackInProgress) {
				isSwapBackInProgress = false;
			} else {
				swapBack();
			}
		} else {
			gamePlay.level.playerSwapped();
		}
	}
	/**
	 * @modifies board
	 * @requires lokums to be swapped
	 * @effects  swaps lokums back. board is updated
	 */	
	public void swapBack() {
		isSwapBackInProgress = true;
		swapLokums(gamePlay, lokum1, lokum2);
	}


}
