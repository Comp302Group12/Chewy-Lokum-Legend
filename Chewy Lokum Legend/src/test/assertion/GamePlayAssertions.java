package test.assertion;

import model.GamePlay;

public class GamePlayAssertions {

	public boolean isValid(GamePlay gamePlay) {
		BoardAssertions ba = new BoardAssertions();
		if(ba.isValid(gamePlay.getBoard())) return true;
		return false;
	}
	
}
