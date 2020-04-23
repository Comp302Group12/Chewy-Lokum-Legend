package model.adapter;

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
	/**
	 * @modifies
	 * @requires 2 lokums ,numOfRemainingSpecialSwaps >0
	 * @effects checks if they are swappable and returns a boolean
	 */	
	@Override
	public boolean checkConditions() {
		// TODO Auto-generated method stub
		return numOfRemainingSpecialSwaps > 0;
	}
	/**
	 * @modifies board
	 * @requires lokums to be selected
	 * @effects checks if they are adjacent and swaps them board is updated
	 */	
	@Override
	public void doBeforeSwapIsStarted() {
		// TODO Auto-generated method stub
		if(numOfRemainingSpecialSwaps == 0){
			AdapterManager.getInstance().changeToRegularLokumSwapperAdapter();
			cancelSwap();
		} else {
			numOfRemainingSpecialSwaps--;
			gamePlay.getBoard().swap(lokum1, lokum2);
		}
	}
	@Override
	public void doAfterSwapIsEnded() {
		// TODO Auto-generated method stub
		AdapterManager.getInstance().changeToRegularLokumSwapperAdapter();
	}

}
