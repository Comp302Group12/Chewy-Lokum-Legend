package model.adapter;

import java.awt.Color;
import java.util.ArrayList;

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
	public ArrayList<Lokum> specialLokums;
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
			} else if(combination.length >= 5) {
				Lokum lokum = new ColorBombLokum(combination[2].getX(), combination[2].getY(), combination[2].getWidth(), combination[2].getHeight());
				specialLokums.add(lokum);
			}
		}
		for(int i=0; i<columnCombinations.size(); i++){
			Lokum[] combination = columnCombinations.get(i);
			if(combination.length == 4) {
				Lokum lokum = new StripedLokum(combination[2].getColor(), combination[2].getX(), 
						combination[2].getY(), combination[2].getWidth(), combination[2].getHeight(), true);
				specialLokums.add(lokum);
			} else if(combination.length == 5) {
				Lokum lokum = new ColorBombLokum(combination[2].getX(), combination[2].getY(), combination[2].getWidth(), combination[2].getHeight());
				specialLokums.add(lokum);
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
				}
			}
			if(topAdjacent != null && lokumToSearchAdjacents.getColor() == topAdjacent.getColor()) {
				lokumToSearchAdjacents = topAdjacent;
				topAdjacent = board.getTopAdjacentOfLokum(lokumToSearchAdjacents);
				if(topAdjacent != null && lokumToSearchAdjacents.getColor() == topAdjacent.getColor()) {
					Lokum wrappedLokum = new WrappedLokum(combination[i].getColor(), combination[i].getX(), 
							combination[i].getY(), combination[i].getWidth(), combination[i].getHeight());
					specialLokums.add(wrappedLokum);
				}
			}
			if(bottomAdjacent != null && lokumToSearchAdjacents.getColor() == bottomAdjacent.getColor()) {
				lokumToSearchAdjacents = bottomAdjacent;
				bottomAdjacent = board.getBottomAdjacentOfLokum(lokumToSearchAdjacents);
				if(bottomAdjacent != null && lokumToSearchAdjacents.getColor() == bottomAdjacent.getColor()) {
					Lokum wrappedLokum = new WrappedLokum(combination[i].getColor(), combination[i].getX(), 
							combination[i].getY(), combination[i].getWidth(), combination[i].getHeight());
					specialLokums.add(wrappedLokum);
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
