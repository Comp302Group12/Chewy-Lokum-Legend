package model.adapter;

public class FallingLokumSwapperAdapter extends LokumSwapperAdapter {

	@Override
	public boolean checkConditions() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void doBeforeSwapIsStarted() {
		// TODO Auto-generated method stub
		gamePlay.getBoard().swap(lokum1, lokum2);
	}

	@Override
	public void doAfterSwapIsEnded() {
		// TODO Auto-generated method stub

	}

}
