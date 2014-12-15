package model.adapters;

import model.GamePlay;
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

	@Override
	public void swapLokums(GamePlay gamePlay, Lokum lokum1, Lokum lokum2) {
		// TODO Auto-generated method stub
		if(numOfRemainingSpecialSwaps > 0) {
			numOfRemainingSpecialSwaps--;
			this.lokum1 = lokum1;
			this.lokum2 = lokum2;
			xOfLokum1AtTheBeg = lokum1.getX();
			yOfLokum1AtTheBeg = lokum1.getY();
			xOfLokum2AtTheBeg = lokum2.getX();
			yOfLokum2AtTheBeg = lokum2.getY();
			timer.start();
			isSwapInProgres = true;
		}
	}

	public int getNumOfRemainingSpecialSwaps() {
		return numOfRemainingSpecialSwaps;
	}

}
