package model.adapters;

import java.awt.event.ActionEvent;

import model.GamePlay;
import model.interfaces.Movable;
import model.lokum.Lokum;

public class SpecialLokumSwapperAdapter extends LokumSwapperAdapter {

	private int numOfRemainingSpecialSwaps;

	public SpecialLokumSwapperAdapter() {
		// TODO Auto-generated constructor stub
		numOfRemainingSpecialSwaps = 5;
	}

	public SpecialLokumSwapperAdapter(int numOfRemainingSpecialSwaps) {
		// TODO Auto-generated constructor stub
		super();
		this.numOfRemainingSpecialSwaps = numOfRemainingSpecialSwaps;
	}

	public int getNumOfRemainingSpecialSwaps() {
		return numOfRemainingSpecialSwaps;
	}

	@Override
	public boolean checkConditions() {
		// TODO Auto-generated method stub
		return numOfRemainingSpecialSwaps > 0;
	}

	@Override
	public void doBeforeSwapIsStarted() {
		// TODO Auto-generated method stub
		numOfRemainingSpecialSwaps--;
		gamePlay.level.getBoard().swap(lokum1, lokum2);
	}

	@Override
	public void doAfterSwapIsEnded() {
		// TODO Auto-generated method stub

	}

}
