package model.level;

import model.*;

public abstract class Level {

	public int goalScore;
	protected GamePlay gamePlay;
	public String[][] boardShape;
	
	public abstract int getRemainingQuantity();
	public abstract void setRemainingQuantity(int quantity);
	public abstract boolean shouldGameFinish();
	public abstract void playerSwapped();

	public GamePlay getGamePlay() {
		return gamePlay;
	}
	
	public String[][] getBoardShape() {
		return boardShape;
	}

}
