package model.adapter;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.print.attribute.standard.Finishings;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public class LokumCombinationAdapter {
	public GamePlay gamePlay;
	public Board board;
	public ArrayList<Lokum[]> rowCombinations;
	public ArrayList<Lokum[]> columnCombinations;
	public ArrayList<Lokum[]> specialCombination;
	public ArrayList<Lokum> specialLokums;

	public boolean doLokumsFormSpecialCombination(Lokum lokum1, Lokum lokum2){
		if(lokum1 instanceof NormalLokum){
			if(lokum2 instanceof ColorBombLokum){
				return true;
			}

		} else if(lokum1 instanceof StripedLokum){
			if(lokum2 instanceof StripedLokum){
				return true;
			}
			else if (lokum2 instanceof WrappedLokum){
				return true;
			}
			else if (lokum2 instanceof ColorBombLokum){
				return true;
			}

		} else if(lokum1 instanceof WrappedLokum) {
			if(lokum2 instanceof StripedLokum){
				return true;
			}
			else if (lokum2 instanceof WrappedLokum){
				return true;
			}
			else if (lokum2 instanceof ColorBombLokum){
				return true;
			}

		} else if(lokum1 instanceof ColorBombLokum){
			if(lokum2 instanceof NormalLokum){
				return true;
			}
			else if(lokum2 instanceof StripedLokum){
				return true;
			}
			else if (lokum2 instanceof WrappedLokum){
				return true;
			}
			else if (lokum2 instanceof ColorBombLokum){
				return true;
			}
		}
		return false;
	}

	public void formSpecialCombination(Lokum lokum1, Lokum lokum2){
		if(lokum1 instanceof NormalLokum){
			if(lokum2 instanceof ColorBombLokum){
				formSpecialCombination((NormalLokum) lokum1, (ColorBombLokum) lokum2);
			}
		} else if(lokum1 instanceof StripedLokum){
			if(lokum2 instanceof StripedLokum){
				formSpecialCombination((StripedLokum) lokum1, (StripedLokum) lokum2);
			}
			else if (lokum2 instanceof WrappedLokum){
				formSpecialCombination((StripedLokum) lokum1, (WrappedLokum) lokum2);
			}
			else if (lokum2 instanceof ColorBombLokum){
				formSpecialCombination((StripedLokum) lokum1, (ColorBombLokum) lokum2);
			}

		} else if(lokum1 instanceof WrappedLokum) {
			if(lokum2 instanceof StripedLokum){
				formSpecialCombination((StripedLokum) lokum2, (WrappedLokum) lokum1);
			}
			else if (lokum2 instanceof WrappedLokum){
				formSpecialCombination((WrappedLokum) lokum2, (WrappedLokum) lokum1);
			}
			else if (lokum2 instanceof ColorBombLokum){
				formSpecialCombination((WrappedLokum) lokum1, (ColorBombLokum) lokum2);
			}

		} else if(lokum1 instanceof ColorBombLokum){
			if(lokum2 instanceof NormalLokum){
				formSpecialCombination((NormalLokum) lokum2, (ColorBombLokum) lokum1);
			}
			else if(lokum2 instanceof StripedLokum){
				formSpecialCombination((StripedLokum) lokum2, (ColorBombLokum) lokum1);
			}
			else if (lokum2 instanceof WrappedLokum){
				formSpecialCombination((WrappedLokum) lokum2, (ColorBombLokum) lokum1);
			}
			else if (lokum2 instanceof ColorBombLokum){
				formSpecialCombination((ColorBombLokum) lokum2, (ColorBombLokum) lokum1);
			}
		}
	}

	public void formSpecialCombination(StripedLokum lokum1, StripedLokum lokum2){
		specialCombination = new ArrayList<Lokum[]>();
		int[] coorOfLokum1 = board.getLokumArrayCoordinatesOfLokum(lokum1);
		board.lokumArray[coorOfLokum1[0]][coorOfLokum1[1]] = convertToNormanLokum(lokum1);
		int[] coorOfLokum2 = board.getLokumArrayCoordinatesOfLokum(lokum2);
		board.lokumArray[coorOfLokum2[0]][coorOfLokum2[1]] = convertToNormanLokum(lokum2);
		Lokum[] rowLokums = new Lokum[board.getNumOfLokumsInARow()];
		Lokum[] columnLokums = new Lokum[board.getNumOfLokumsInAColumn()];
		for(int i=0; i< rowLokums.length; i++){
			rowLokums[i] = board.lokumArray[coorOfLokum1[0]][i];
		}
		for(int i=0; i< columnLokums.length; i++){
			columnLokums[i] = board.lokumArray[i][coorOfLokum2[1]];
		}
		specialCombination.add(rowLokums);
		specialCombination.add(columnLokums);
	}

	public void formSpecialCombination(StripedLokum lokum1, WrappedLokum lokum2){
		specialCombination = new ArrayList<Lokum[]>();
		int[] coorOfLokum1 = board.getLokumArrayCoordinatesOfLokum(lokum1);
		board.lokumArray[coorOfLokum1[0]][coorOfLokum1[1]] = convertToNormanLokum(lokum1);
		int[] coorOfLokum2 = board.getLokumArrayCoordinatesOfLokum(lokum2);
		board.lokumArray[coorOfLokum2[0]][coorOfLokum2[1]] = convertToNormanLokum(lokum2);
		if(board.getTopAdjacentOfLokum(lokum1) != null){
			Lokum[] row1Lokums = new Lokum[board.getNumOfLokumsInARow()];
			for(int i=0; i< row1Lokums.length; i++){
				row1Lokums[i] = board.lokumArray[coorOfLokum1[0]-1][i];
			}
			specialCombination.add(row1Lokums);
		}
		Lokum[] row2Lokums = new Lokum[board.getNumOfLokumsInARow()];
		for(int i=0; i< row2Lokums.length; i++){
			row2Lokums[i] = board.lokumArray[coorOfLokum1[0]][i];
		}
		specialCombination.add(row2Lokums);
		if(board.getBottomAdjacentOfLokum(lokum1) != null){
			Lokum[] row3Lokums = new Lokum[board.getNumOfLokumsInARow()];
			for(int i=0; i< row3Lokums.length; i++){
				row3Lokums[i] = board.lokumArray[coorOfLokum1[0]+1][i];
			}
			specialCombination.add(row3Lokums);
		}
		if(board.getLeftAdjacentOfLokum(lokum2) != null){
			Lokum[] column1Lokums = new Lokum[board.getNumOfLokumsInAColumn()];
			for(int i=0; i< column1Lokums.length; i++){
				column1Lokums[i] = board.lokumArray[i][coorOfLokum2[1]-1];
			}
			specialCombination.add(column1Lokums);
		}
		Lokum[] column2Lokums = new Lokum[board.getNumOfLokumsInAColumn()];
		for(int i=0; i< column2Lokums.length; i++){
			column2Lokums[i] = board.lokumArray[i][coorOfLokum2[1]];
		}
		specialCombination.add(column2Lokums);
		if(board.getRightAdjacentOfLokum(lokum2) != null){

			Lokum[] column3Lokums = new Lokum[board.getNumOfLokumsInAColumn()];
			for(int i=0; i< column3Lokums.length; i++){
				column3Lokums[i] = board.lokumArray[i][coorOfLokum2[1]+1];
			}
			specialCombination.add(column3Lokums);
		}
	}

	public void formSpecialCombination(WrappedLokum lokum1, WrappedLokum lokum2){
		specialCombination = new ArrayList<Lokum[]>();
		int[] coorOfLokum1 = board.getLokumArrayCoordinatesOfLokum(lokum1);
		board.lokumArray[coorOfLokum1[0]][coorOfLokum1[1]] = convertToNormanLokum(lokum1);
		int[] coorOfLokum2 = board.getLokumArrayCoordinatesOfLokum(lokum2);
		board.lokumArray[coorOfLokum2[0]][coorOfLokum2[1]] = convertToNormanLokum(lokum2);
		ArrayList<Lokum> tempa = new ArrayList<Lokum>();
		for(int i=0; i< 5; i++){
			if(coorOfLokum2[0]+2 < board.getNumOfLokumsInARow() && coorOfLokum2[1]-2+i >= 0 && coorOfLokum2[1]-2+i < board.getNumOfLokumsInAColumn()){
				tempa.add(board.lokumArray[coorOfLokum2[0]+2][coorOfLokum2[1]-2+i]);
			}
		}
		for(int i=0; i< 5; i++){
			if(coorOfLokum2[0]+1 < board.getNumOfLokumsInARow() && coorOfLokum2[1]-2+i >= 0 && coorOfLokum2[1]-2+i < board.getNumOfLokumsInAColumn()){
				tempa.add(board.lokumArray[coorOfLokum2[0]+1][coorOfLokum2[1]-2+i]);
			}
		}
		for(int i=0; i< 5; i++){
			if(coorOfLokum2[1]-2+i >= 0 && coorOfLokum2[1]-2+i < board.getNumOfLokumsInAColumn()){
				tempa.add(board.lokumArray[coorOfLokum2[0]+0][coorOfLokum2[1]-2+i]);
			}
		}
		for(int i=0; i< 5; i++){
			if(coorOfLokum2[0]-1 >=0 && coorOfLokum2[1]-2+i >= 0 && coorOfLokum2[1]-2+i < board.getNumOfLokumsInAColumn()){
				tempa.add(board.lokumArray[coorOfLokum2[0]-1][coorOfLokum2[1]-2+i]);
			}
		}
		for(int i=0; i< 5; i++){
			if(coorOfLokum2[0]-2 >=0 && coorOfLokum2[1]-2+i >= 0 && coorOfLokum2[1]-2+i < board.getNumOfLokumsInAColumn()){
				tempa.add(board.lokumArray[coorOfLokum2[0]-2][coorOfLokum2[1]-2+i]);
			}
		}
		Lokum[] wrapdest = new Lokum[tempa.size()];
		for(int k=0; k< tempa.size(); k++){
			wrapdest[k] = tempa.get(k);
		}
		specialCombination.add(wrapdest);
	}

	public void formSpecialCombination(StripedLokum lokum1, ColorBombLokum lokum2){
		specialCombination = new ArrayList<Lokum[]>();
		ArrayList<Lokum> sameColoredLokums = new ArrayList<Lokum>();
		int[] coorOfLokum2 = board.getLokumArrayCoordinatesOfLokum(lokum2);
		NormalLokum tempLokum = convertToNormanLokum(lokum2);
		tempLokum.setColor(lokum1.getColor());
		board.lokumArray[coorOfLokum2[0]][coorOfLokum2[1]] = tempLokum;
		for(int i=0; i<board.getNumOfLokumsInAColumn(); i++){
			for(int j=0; j<board.getNumOfLokumsInARow(); j++){
				Lokum lokum = board.lokumArray[i][j];
				if(lokum.getColor() == lokum1.getColor()){
					lokum = convertToStripedLokum(lokum);
					board.lokumArray[i][j] = lokum;
					sameColoredLokums.add(lokum);
				}
			}
		}
		Lokum[] lokums = new Lokum[sameColoredLokums.size()];
		for(int i=0; i<sameColoredLokums.size();i++){
			lokums[i] = sameColoredLokums.get(i);
		}
		specialCombination.add(lokums);
	}

	public void formSpecialCombination(WrappedLokum lokum1, ColorBombLokum lokum2){
		specialCombination = new ArrayList<Lokum[]>();
		ArrayList<Lokum> sameColoredLokums = new ArrayList<Lokum>();
		int[] coorOfLokum2 = board.getLokumArrayCoordinatesOfLokum(lokum2);
		NormalLokum tempLokum = convertToNormanLokum(lokum2);
		tempLokum.setColor(lokum1.getColor());
		board.lokumArray[coorOfLokum2[0]][coorOfLokum2[1]] = tempLokum;
		for(int i=0; i<board.getNumOfLokumsInAColumn(); i++){
			for(int j=0; j<board.getNumOfLokumsInARow(); j++){
				Lokum lokum = board.lokumArray[i][j];
				if(lokum.getColor() == lokum1.getColor()){
					lokum = convertToWrappedLokum(lokum);
					board.lokumArray[i][j] = lokum;
					sameColoredLokums.add(lokum);
				}
			}
		}
		Lokum[] lokums = new Lokum[sameColoredLokums.size()];
		for(int i=0; i<sameColoredLokums.size();i++){
			lokums[i] = sameColoredLokums.get(i);
		}
		specialCombination.add(lokums);
	}

	public void formSpecialCombination(ColorBombLokum lokum1, ColorBombLokum lokum2){
		specialCombination = new ArrayList<Lokum[]>();
		ArrayList<Lokum> allLokums = new ArrayList<Lokum>();
		for(int i=0; i<board.getNumOfLokumsInAColumn(); i++){
			for(int j=0; j<board.getNumOfLokumsInARow(); j++){
				Lokum lokum = board.lokumArray[i][j];
				allLokums.add(lokum);
			}
		}
		Lokum[] lokums = new Lokum[allLokums.size()];
		for(int i=0; i<allLokums.size();i++){
			lokums[i] = allLokums.get(i);
		}
		specialCombination.add(lokums);
	}

	public void formSpecialCombination(NormalLokum lokum1, ColorBombLokum lokum2){
		specialCombination = new ArrayList<Lokum[]>();
		ArrayList<Lokum> sameColoredLokums = new ArrayList<Lokum>();
		int[] coorOfLokum2 = board.getLokumArrayCoordinatesOfLokum(lokum2);
		NormalLokum tempLokum = convertToNormanLokum(lokum2);
		tempLokum.setColor(lokum1.getColor());
		board.lokumArray[coorOfLokum2[0]][coorOfLokum2[1]] = tempLokum;
		for(int i=0; i<board.getNumOfLokumsInAColumn(); i++){
			for(int j=0; j<board.getNumOfLokumsInARow(); j++){
				Lokum lokum = board.lokumArray[i][j];
				if(lokum.getColor() == lokum1.getColor()){
					sameColoredLokums.add(lokum);
				}
			}
		}
		Lokum[] lokums = new Lokum[sameColoredLokums.size()];
		for(int i=0; i<sameColoredLokums.size();i++){
			lokums[i] = sameColoredLokums.get(i);
		}
		specialCombination.add(lokums);
	}

	public NormalLokum convertToNormanLokum(Lokum lokum){
		NormalLokum convertedLokum = new NormalLokum(lokum.getColor(), lokum.getX(), lokum.getY(), lokum.getWidth(), lokum.getHeight());
		return convertedLokum;
	}

	public StripedLokum convertToStripedLokum(Lokum lokum){
		boolean horizontal;
		Random rgen = new Random();
		int random = rgen.nextInt(2);
		if(random==0){
			horizontal = true;
		} else {
			horizontal = false;
		}
		StripedLokum convertedLokum = new StripedLokum(lokum.getColor(), lokum.getX(), lokum.getY(), lokum.getWidth(), lokum.getHeight(), horizontal);
		return convertedLokum;
	}
	
	public WrappedLokum convertToWrappedLokum(Lokum lokum){
		WrappedLokum convertedLokum = new WrappedLokum(lokum.getColor(), lokum.getX(), lokum.getY(), lokum.getWidth(), lokum.getHeight());
		return convertedLokum;
	}
	/**
	 * @modifies board lokumarray
	 * @requires speciallokums are found and put into array list
	 * @effects speciallokums are placed
	 */	
	public void placeSpecialLokums() {
		for(int i=0; i<specialLokums.size(); i++){
			int[] coor = board.getLokumArrayCoordinatesOfLokum(specialLokums.get(i));
			board.lokumArray[coor[0]][coor[1]] = specialLokums.get(i);
		}
	}
	/**
	 * @modifies speciallokum arraylist
	 * @requires lokums fell or swapped
	 * @effects speciallokums are found and put into array list
	 */	
	public void searchCombinationsToFormSpecialLokums() {
		specialLokums = new ArrayList<Lokum>();
		for(int i=0; i<rowCombinations.size(); i++){
			Lokum[] combination = rowCombinations.get(i);
			if(combination.length == 3){
				searchRowCombinationToFormWrappedLokum(combination);
			} else if(combination.length == 4) {
				Lokum lokum = new StripedLokum(combination[2].getColor(), combination[2].getX(), 
						combination[2].getY(), combination[2].getWidth(), combination[2].getHeight(), false);
				specialLokums.add(lokum);

				AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().formedStripedLokumScore();

			} else if(combination.length >= 5) {
				Lokum lokum = new ColorBombLokum(combination[2].getX(), combination[2].getY(), combination[2].getWidth(), combination[2].getHeight());
				specialLokums.add(lokum);

				AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().formedColorBombLokumScore();

			}
		}
		for(int i=0; i<columnCombinations.size(); i++){
			Lokum[] combination = columnCombinations.get(i);
			if(combination.length == 4) {
				Lokum lokum = new StripedLokum(combination[2].getColor(), combination[2].getX(), 
						combination[2].getY(), combination[2].getWidth(), combination[2].getHeight(), true);
				specialLokums.add(lokum);

				AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().formedStripedLokumScore();

			} else if(combination.length == 5) {
				Lokum lokum = new ColorBombLokum(combination[2].getX(), combination[2].getY(), combination[2].getWidth(), combination[2].getHeight());
				specialLokums.add(lokum);

				AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().formedColorBombLokumScore();

			}
		}
	}
	/**
	 * @modifies speciallokum arraylist
	 * @requires lokums fell or swapped
	 * @effects wrappedlokums are found and put into array list
	 */	
	public void searchRowCombinationToFormWrappedLokum(Lokum[] combination) {
		for(int i=0; i<combination.length; i++){
			Lokum lokumToSearchAdjacents = combination[i];			
			Lokum topAdjacent = board.getTopAdjacentOfLokum(lokumToSearchAdjacents);			
			Lokum bottomAdjacent = board.getBottomAdjacentOfLokum(lokumToSearchAdjacents);		
			if(topAdjacent != null && lokumToSearchAdjacents.getColor() == topAdjacent.getColor()) {
				if(bottomAdjacent != null && lokumToSearchAdjacents.getColor() == bottomAdjacent.getColor()) {
					Lokum wrappedLokum = new WrappedLokum(combination[i].getColor(), combination[i].getX(), 
							combination[i].getY(), combination[i].getWidth(), combination[i].getHeight());
					specialLokums.add(wrappedLokum);

					AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().formedWrappedLokumScore();

				}
			}
			if(topAdjacent != null && lokumToSearchAdjacents.getColor() == topAdjacent.getColor()) {
				lokumToSearchAdjacents = topAdjacent;
				topAdjacent = board.getTopAdjacentOfLokum(lokumToSearchAdjacents);
				if(topAdjacent != null && lokumToSearchAdjacents.getColor() == topAdjacent.getColor()) {
					Lokum wrappedLokum = new WrappedLokum(combination[i].getColor(), combination[i].getX(), 
							combination[i].getY(), combination[i].getWidth(), combination[i].getHeight());
					specialLokums.add(wrappedLokum);

					AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().formedWrappedLokumScore();

				}
			}
			if(bottomAdjacent != null && lokumToSearchAdjacents.getColor() == bottomAdjacent.getColor()) {
				lokumToSearchAdjacents = bottomAdjacent;
				bottomAdjacent = board.getBottomAdjacentOfLokum(lokumToSearchAdjacents);
				if(bottomAdjacent != null && lokumToSearchAdjacents.getColor() == bottomAdjacent.getColor()) {
					Lokum wrappedLokum = new WrappedLokum(combination[i].getColor(), combination[i].getX(), 
							combination[i].getY(), combination[i].getWidth(), combination[i].getHeight());
					specialLokums.add(wrappedLokum);

					AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().formedWrappedLokumScore();

				}
			}
		}
	}
	/**
	 * @modifies combinations arraylists
	 * @requires lokums fell or swapped
	 * @effects combinations found put into neccessary arraylists and if there is combination 
	 * returns true
	 */	
	public boolean doesBoardHaveCombination(GamePlay gamePlay) {
		this.gamePlay = gamePlay;
		this.board = gamePlay.getBoard();
		rowCombinations = new ArrayList<Lokum[]>();
		columnCombinations = new ArrayList<Lokum[]>();
		findCombinations();
		searchCombinationsToFormSpecialLokums();
		return (!rowCombinations.isEmpty() || !columnCombinations.isEmpty());
	}

	public void findCombinations() {
		findRowCombinations();
		findColumnCombinations();
	}
	/**
	 * @modifies rowCombinations arraylist
	 * @requires lokums fell or swapped
	 * @effects rowCombinations are found and put into array list
	 */	
	public void findRowCombinations() {
		for(int i=0; i<board.getLokumArray().length; i++) {
			Lokum[] row = board.getLokumArray()[i];
			ArrayList<Lokum[]> combinationsOfRow = getCombinationsInOneDimensionalLokumArray(row);
			for(int j=0; j<combinationsOfRow.size(); j++) {
				rowCombinations.add(combinationsOfRow.get(j));
			}
		}
	}
	/**
	 * @modifies ColumnCombinations arraylist
	 * @requires lokums fell or swapped
	 * @effects ColumnCombinations are found and put into array list
	 */	
	public void findColumnCombinations() {
		for(int i=0; i<board.lokumArray[0].length; i++) {
			Lokum[] column = new Lokum[board.getLokumArray().length];
			for(int j=0; j<board.getLokumArray().length; j++) {
				column[j] = board.getLokumArray()[j][i];
			}
			ArrayList<Lokum[]> combinationsOfColumn = getCombinationsInOneDimensionalLokumArray(column);
			for(int j=0; j<combinationsOfColumn.size(); j++) {
				columnCombinations.add(combinationsOfColumn.get(j));
			}
		}
	}

	public ArrayList<Lokum[]> getCombinationsInOneDimensionalLokumArray(Lokum[] lokumArray) {
		ArrayList<Lokum[]> combinations = new ArrayList<Lokum[]>();
		int[] tagArray = getTagArrayForOneDimensionalLokumArray(lokumArray);
		for(int i=tagArray.length-1; i>=0; i--) {
			if(tagArray[i] >= 3) {
				int indexOfLokumInLokumArray = i;
				int numOfLokumsToAddCombination = tagArray[i];
				Lokum[] combination = new Lokum[numOfLokumsToAddCombination];
				while(numOfLokumsToAddCombination != 0) {
					numOfLokumsToAddCombination--;
					combination[numOfLokumsToAddCombination] = lokumArray[indexOfLokumInLokumArray];
					tagArray[indexOfLokumInLokumArray] = 0;
					indexOfLokumInLokumArray--;
				}
				combinations.add(combination);
			}
		}
		return combinations;
	}

	public int[] getTagArrayForOneDimensionalLokumArray(Lokum[] lokumArray) {
		int[] tagArray = new int[lokumArray.length];
		int tag = 1;
		Color previousColor = null;
		Color currentColor = null;
		for(int i=0; i<lokumArray.length; i++) {
			previousColor = currentColor;
			currentColor = lokumArray[i].getColor();
			if(previousColor == currentColor && lokumArray[i] instanceof Movable
					&& lokumArray[i] instanceof Destructible) {
				tag++;
				tagArray[i] = tag;
			} else {
				tag = 1;
				tagArray[i] = tag;
			}
		}
		return tagArray;
	}
}
