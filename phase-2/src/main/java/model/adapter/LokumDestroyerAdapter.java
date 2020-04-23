package model.adapter;

import model.Board;
import model.GamePlay;
import model.interfaces.Destructible;
import model.level.TimeBasedLevel;
import model.lokum.ColorBombLokum;
import model.lokum.DestroyedLokum;
import model.lokum.Lokum;
import model.lokum.NormalLokum;
import model.lokum.StripedLokum;
import model.lokum.TimeLokum;
import model.lokum.WrappedLokum;

public class LokumDestroyerAdapter {

	GamePlay gamePlay;
	Board board;
	/**
	 * @modifies board lokumarray
	 * @requires requires 2 or more same colored lokums to create combination by swapping or lokums falling
	 * @effects lokums that create the combination are converted to destroyed lokums,  board is updated.
	 */	
	public void destroyExistingCombinations(GamePlay gamePlay) {
		this.gamePlay = gamePlay;
		board = gamePlay.getBoard();
		for(int i=0; i< AdapterManager.getInstance().getCurrentLokumCombinationAdapter().rowCombinations.size(); i++) {
			Lokum[] combination = AdapterManager.getInstance().getCurrentLokumCombinationAdapter().rowCombinations.get(i);
			for(int j=0; j<combination.length; j++) {
				Lokum lokum = AdapterManager.getInstance().getCurrentLokumCombinationAdapter().rowCombinations.get(i)[j];
				int k = board.getLokumArrayCoordinatesOfLokum(lokum)[0];
				int l = board.getLokumArrayCoordinatesOfLokum(lokum)[1];
				if(board.lokumArray[k][l] instanceof Destructible){
					((Destructible)board.lokumArray[k][l]).destroy();
				}
			}
			AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().updateNormalLokumScore(combination);
		}

		for(int i=0; i< AdapterManager.getInstance().getCurrentLokumCombinationAdapter().columnCombinations.size(); i++) {
			Lokum[] combination = AdapterManager.getInstance().getCurrentLokumCombinationAdapter().columnCombinations.get(i);
			for(int j=0; j<AdapterManager.getInstance().getCurrentLokumCombinationAdapter().columnCombinations.get(i).length; j++) {
				Lokum lokum = AdapterManager.getInstance().getCurrentLokumCombinationAdapter().columnCombinations.get(i)[j];
				int k = board.getLokumArrayCoordinatesOfLokum(lokum)[0];
				int l = board.getLokumArrayCoordinatesOfLokum(lokum)[1];
				if(board.lokumArray[k][l] instanceof Destructible){
					((Destructible)board.lokumArray[k][l]).destroy();
				}
			}
			AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().updateNormalLokumScore(combination);
		}
	}

	public void destroySpecialCombination(GamePlay gamePlay) {
		board = gamePlay.getBoard();
		for(int i=0; i< AdapterManager.getInstance().getCurrentLokumCombinationAdapter().specialCombination.size(); i++) {
			Lokum[] combination = AdapterManager.getInstance().getCurrentLokumCombinationAdapter().specialCombination.get(i);
			for(int j=0; j<combination.length; j++) {
				Lokum lokum = combination[j];
				int k = board.getLokumArrayCoordinatesOfLokum(lokum)[0];
				int l = board.getLokumArrayCoordinatesOfLokum(lokum)[1];
				if(board.lokumArray[k][l] instanceof Destructible){
					((Destructible)board.lokumArray[k][l]).destroy();
				}
			}
			//AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().aCombinationIsDestroyed(combination);
		}
	}
	/**
	 * @modifies lokum
	 * @requires normal lokum
	 * @effects lokum is converted to destroyed lokums,  board is updated.
	 */	
	public void destroy(NormalLokum lokum) {
		int[] coor = board.getLokumArrayCoordinatesOfLokum(lokum);
		board.lokumArray[coor[0]][coor[1]] = new DestroyedLokum(lokum.getX(), lokum.getY(), lokum.getWidth(), lokum.getHeight());
	}
	/**
	 * @modifies lokum
	 * @requires striped lokum
	 * @effects striped lokum and other lokums in its row or
	 * column depending on its horizantal or vertical is converted to destroyed lokums,  board is updated.
	 */	
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
			int numOfLokumsInARow = board.getNumOfLokumsInARow();
			AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().destroyStripedLokumScore(numOfLokumsInARow);
		} else {
			for(int i=0; i<board.getNumOfLokumsInAColumn(); i++) {
				Lokum currentLokum = board.lokumArray[i][coor[1]];
				if(currentLokum instanceof Destructible){
					((Destructible) currentLokum).destroy();
				}
			}
			int getNumOfLokumsInAColumn = board.getNumOfLokumsInARow();
			AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().destroyStripedLokumScore(getNumOfLokumsInAColumn);
		}
	}
	/**
	 * @modifies lokum
	 * @requires wrapped lokum
	 * @effects wrapped lokum and other lokums in its adjacent converted to destroyed lokums,  board is updated.
	 */	
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

		AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().destroyWrappedLokumScore();
	}

	public void destroy(TimeLokum lokum) {
		int[] coor = board.getLokumArrayCoordinatesOfLokum(lokum);
		board.lokumArray[coor[0]][coor[1]] = new DestroyedLokum(lokum.getX(), lokum.getY(), lokum.getWidth(), lokum.getHeight());
		if(gamePlay.level instanceof TimeBasedLevel){
			((TimeBasedLevel)gamePlay.level).expandTime(lokum.getTime());
		}
	}

	public void destroy(ColorBombLokum lokum) {
		int[] coor = board.getLokumArrayCoordinatesOfLokum(lokum);
		board.lokumArray[coor[0]][coor[1]] = new DestroyedLokum(lokum.getX(), lokum.getY(), lokum.getWidth(), lokum.getHeight());

		AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().destroyColorBombLokumScore(board);
	}

}
