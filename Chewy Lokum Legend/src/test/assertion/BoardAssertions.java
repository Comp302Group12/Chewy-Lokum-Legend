package test.assertion;

import model.Board;
import model.lokum.Lokum;

public class BoardAssertions {

	public boolean isValid(Board board) {
		LokumAssertions la = new LokumAssertions();
		for(int i=0; i<board.getNumOfLokumsInAColumn(); i++){
			for(int j=0; j<board.getNumOfLokumsInARow(); j++){
				Lokum lokum = board.lokumArray[i][j];
				if(!la.isValid(lokum)) return false;
			}
		}
		return true;
	}

}
