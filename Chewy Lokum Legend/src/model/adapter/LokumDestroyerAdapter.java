package model.adapter;

import model.Board;
import model.GamePlay;
import model.interfaces.Destructible;
import model.lokum.ColorBombLokum;
import model.lokum.DestroyedLokum;
import model.lokum.Lokum;
import model.lokum.NormalLokum;
import model.lokum.StripedLokum;
import model.lokum.WrappedLokum;

public class LokumDestroyerAdapter {

	Board board;

	public void destroyExistingCombinations(GamePlay gamePlay) {
		board = gamePlay.getBoard();
		for(int i=0; i< AdapterManager.getInstance().getCurrentLokumCombinationAdapter().rowCombinations.size(); i++) {
			for(int j=0; j<AdapterManager.getInstance().getCurrentLokumCombinationAdapter().rowCombinations.get(i).length; j++) {
				Lokum lokum = AdapterManager.getInstance().getCurrentLokumCombinationAdapter().rowCombinations.get(i)[j];
				int k = board.getLokumArrayCoordinatesOfLokum(lokum)[0];
				int l = board.getLokumArrayCoordinatesOfLokum(lokum)[1];
				if(board.lokumArray[k][l] instanceof Destructible){
					((Destructible)board.lokumArray[k][l]).destroy();
				}
			}
		}

		for(int i=0; i< AdapterManager.getInstance().getCurrentLokumCombinationAdapter().columnCombinations.size(); i++) {
			for(int j=0; j<AdapterManager.getInstance().getCurrentLokumCombinationAdapter().columnCombinations.get(i).length; j++) {
				Lokum lokum = AdapterManager.getInstance().getCurrentLokumCombinationAdapter().columnCombinations.get(i)[j];
				int k = board.getLokumArrayCoordinatesOfLokum(lokum)[0];
				int l = board.getLokumArrayCoordinatesOfLokum(lokum)[1];
				if(board.lokumArray[k][l] instanceof Destructible){
					((Destructible)board.lokumArray[k][l]).destroy();
				}
			}
		}
	}

	public void destroy(NormalLokum lokum) {
		int[] coor = board.getLokumArrayCoordinatesOfLokum(lokum);
		board.lokumArray[coor[0]][coor[1]] = new DestroyedLokum(lokum.getX(), lokum.getY(), lokum.getWidth(), lokum.getHeight());
	}

	public void destroy(StripedLokum lokum) {
		int[] coor = board.getLokumArrayCoordinatesOfLokum(lokum);
		board.lokumArray[coor[0]][coor[1]] = new DestroyedLokum(lokum.getX(), lokum.getY(), lokum.getWidth(), lokum.getHeight());
		if(lokum.isHorizontal()) {
			for(int i=0; i<board.getNumOfLokumsInARow(); i++) {
				Lokum currentLokum = board.lokumArray[coor[0]][i];
				if(currentLokum instanceof Destructible){
					((Destructible) currentLokum).destroy();
				}
			}
		} else {
			for(int i=0; i<board.getNumOfLokumsInAColumn(); i++) {
				Lokum currentLokum = board.lokumArray[i][coor[1]];
				if(currentLokum instanceof Destructible){
					((Destructible) currentLokum).destroy();
				}
			}
		}
	}

	public void destroy(WrappedLokum lokum) {
		int[] coor = board.getLokumArrayCoordinatesOfLokum(lokum);
		board.lokumArray[coor[0]][coor[1]] = new DestroyedLokum(lokum.getX(), lokum.getY(), lokum.getWidth(), lokum.getHeight());
		Lokum topAdjacent = board.getTopAdjacentOfLokum(lokum);
		if(topAdjacent instanceof Destructible) {
			((Destructible) topAdjacent).destroy();
		}
		Lokum bottomAdjacent = board.getBottomAdjacentOfLokum(lokum);
		if(bottomAdjacent instanceof Destructible) {
			((Destructible) bottomAdjacent).destroy();
		}
		Lokum rightAdjacent = board.getRightAdjacentOfLokum(lokum);
		if(rightAdjacent instanceof Destructible) {
			((Destructible) rightAdjacent).destroy();
		}
		Lokum leftAdjacent = board.getLeftAdjacentOfLokum(lokum);
		if(leftAdjacent instanceof Destructible) {
			((Destructible) leftAdjacent).destroy();
		}
		Lokum upperRightAdjacent = board.getUpperRightAdjacentOfLokum(lokum);
		if(upperRightAdjacent instanceof Destructible) {
			((Destructible) upperRightAdjacent).destroy();
		}
		Lokum upperLeftAdjacent = board.getUpperLeftAdjacentOfLokum(lokum);
		if(upperLeftAdjacent instanceof Destructible) {
			((Destructible) upperLeftAdjacent).destroy();
		}
		Lokum lowerRightAdjacent = board.getLowerRightAdjacentOfLokum(lokum);
		if(lowerRightAdjacent instanceof Destructible) {
			((Destructible) lowerRightAdjacent).destroy();
		}
		Lokum lowerLeftAdjacent = board.getLowerLeftAdjacentOfLokum(lokum);
		if(lowerLeftAdjacent instanceof Destructible) {
			((Destructible) lowerLeftAdjacent).destroy();
		}
	}

	public void destroy(ColorBombLokum lokum) {
		int[] coor = board.getLokumArrayCoordinatesOfLokum(lokum);
		board.lokumArray[coor[0]][coor[1]] = new DestroyedLokum(lokum.getX(), lokum.getY(), lokum.getWidth(), lokum.getHeight());
	}

}
