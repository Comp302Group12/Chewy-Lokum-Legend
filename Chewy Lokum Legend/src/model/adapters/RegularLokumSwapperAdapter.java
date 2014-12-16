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

	private boolean isSwapBackInProgress;

	public RegularLokumSwapperAdapter() {
		// TODO Auto-generated constructor stub
		isSwapBackInProgress = false;
	}

	@Override
	public boolean checkConditions() {
		// TODO Auto-generated method stub
		return gamePlay.level.getBoard().areLokumsAdjacent(lokum1, lokum2);
	}

	@Override
	public void doBeforeSwapIsStarted() {
		// TODO Auto-generated method stub
		gamePlay.level.getBoard().swap(lokum1, lokum2);
	}

	@Override
	public void doAfterSwapIsEnded() {
		// TODO Auto-generated method stub
		if(!gamePlay.doesBoardHaveCombination()) {
			if(isSwapBackInProgress) {
				isSwapBackInProgress = false;
			} else {
				swapBack();
			}
		}
	}

	public void swapBack() {
		isSwapBackInProgress = true;
		swapLokums(gamePlay, lokum1, lokum2);
	}


}
