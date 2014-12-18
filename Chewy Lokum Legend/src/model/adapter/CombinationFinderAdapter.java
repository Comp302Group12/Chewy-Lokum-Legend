package model.adapter;

import java.awt.Color;
import java.util.ArrayList;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public class CombinationFinderAdapter {

	Board board;
	public int[][] taggedLokumArray;
	boolean isCombinationFound;

	/*
	public boolean isSwappable(){
		if(isCombinationSwapHappened() || isCombinationHappened(gamePlay)){
			return true;
		}else{
			return false;
		}
	}
	public boolean isCombinationSwapHappened(){


		return false;
	}*/

	public boolean isThereACombination(Board board){
		this.board = board;
		taggedLokumArray = new int[board.getNumOfLokumsInAColumn()][board.getNumOfLokumsInARow()];
		fillTaggedLokumArray();
		for(int i =0; i< taggedLokumArray.length; i++){
			for(int j=0; j<taggedLokumArray[i].length; j++){
				if(taggedLokumArray[i][j]> 0){
					return true;
				}
			}
		}
		return false;

	}

	public void fillTaggedLokumArray(){
		findRowCombinations();
		findColCombinations();
	}

	public void findRowCombinations(){

		int pieceCounter =1;
		int currentPoint =0;
		int y=0;	//y
		while(y<board.getLokumArray().length){
			Lokum a = board.getLokumArray()[0][y];
			for(int k =0; k<board.getLokumArray().length-1; k++){
				if( a.getColor() != board.getLokumArray()[k+1][y].getColor()){
					a = board.getLokumArray()[k+1][y];
					///// 5 li comb bombo convert
					if(pieceCounter > 4) {
						int midToconvert = pieceCounter/2;
						currentPoint = k;
						for(int t= pieceCounter; t>0; t--){
							taggedLokumArray[currentPoint][y] = 1;
							if(midToconvert == k- currentPoint){taggedLokumArray[currentPoint][y]=5;}
							currentPoint--;
						}
					}
					///// 4 li strip bomba convert
					else if (pieceCounter > 3) {
						int midToconvert = pieceCounter/2;
						currentPoint = k;
						for(int t= pieceCounter; t>0; t--){
							taggedLokumArray[currentPoint][y] = 1;
							if(midToconvert == k-currentPoint){taggedLokumArray[currentPoint][y]=3;}
							currentPoint--;
						}
					}				 
					///// normal lokum to destroy
					else if(pieceCounter > 2) {
						currentPoint = k;
						for(int t= pieceCounter; t>0; t--){
							taggedLokumArray[currentPoint][y] = 1;
							currentPoint--;
						}
					}
					pieceCounter=1;  
				}else{
					pieceCounter++;
				}	
			}
			//////// for last element  in array
			int k=board.getLokumArray().length -1;
			if(pieceCounter > 4) {
				int midToconvert = pieceCounter/2;
				currentPoint = board.getLokumArray().length-1;
				for(int t= pieceCounter; t>0; t--){
					taggedLokumArray[currentPoint][y] = 1;
					if(midToconvert == k-currentPoint){taggedLokumArray[currentPoint][y]=5;}
					currentPoint--;
				}
			}
			else if(pieceCounter > 3) {
				int midToconvert = pieceCounter/2;
				currentPoint = board.getLokumArray().length-1;
				for(int t= pieceCounter; t>0; t--){
					taggedLokumArray[currentPoint][y] = 1;
					if(midToconvert == k-currentPoint){taggedLokumArray[currentPoint][y]=3;}
					currentPoint--;
				}
			}

			else if(pieceCounter > 2) {
				currentPoint = board.getLokumArray().length-1;
				for(int t= pieceCounter; t>0; t--){
					taggedLokumArray[currentPoint][y] = 1;
					currentPoint--;
				}
			}
			y++;
			pieceCounter =1;
		}
	}
	public void findColCombinations(){

		int pieceCounter =1;
		int currentPoint =0;
		int y=0;	//y
		while(y<board.getLokumArray().length){

			Lokum a = board.getLokumArray()[y][0];

			for(int k =0; k<board.getLokumArray().length-1; k++){

				if( a.getColor() != board.getLokumArray()[y][k+1].getColor()){
					a = board.getLokumArray()[y][k+1];
					///// 5 li comb bombo convert
					if(pieceCounter > 4) {
						int midToconvert = pieceCounter/2;
						currentPoint = k;
						for(int t= pieceCounter; t>0; t--){
							taggedLokumArray[y][currentPoint] = 1;
							if(midToconvert == k- currentPoint){taggedLokumArray[y][currentPoint]=5;}
							currentPoint--;
						}
					}
					///// 4 li strip bomba convert
					else if (pieceCounter > 3) {
						int midToconvert = pieceCounter/2;
						currentPoint = k;
						for(int t= pieceCounter; t>0; t--){
							taggedLokumArray[y][currentPoint] = 1;
							if(midToconvert == k-currentPoint){taggedLokumArray[y][currentPoint]=4;}
							currentPoint--;
						}
					}				 
					///// normal lokum to destroy
					else if(pieceCounter > 2) {
						currentPoint = k;
						for(int t= pieceCounter; t>0; t--){
							taggedLokumArray[y][currentPoint] = 1;
							currentPoint--;
						}
					}
					pieceCounter=1;  
				}else{
					pieceCounter++;
				}	
			}
			//////// for last element  in array
			int k= board.getLokumArray().length -1;
			if(pieceCounter > 4) {
				int midToconvert = pieceCounter/2;
				currentPoint = board.getLokumArray().length-1;
				for(int t= pieceCounter; t>0; t--){
					taggedLokumArray[y][currentPoint] = 1;
					if(midToconvert == k-currentPoint){taggedLokumArray[y][currentPoint]=5;}
					currentPoint--;
				}
			}
			else if(pieceCounter > 3) {
				int midToconvert = pieceCounter/2;
				currentPoint = board.getLokumArray().length-1;
				for(int t= pieceCounter; t>0; t--){
					taggedLokumArray[y][currentPoint] = 1;
					if(midToconvert ==k- currentPoint){taggedLokumArray[y][currentPoint]=4;}
					currentPoint--;
				}
			}
			else if(pieceCounter > 2) {
				currentPoint = board.getLokumArray().length-1;
				for(int t= pieceCounter; t>0; t--){
					taggedLokumArray[y][currentPoint] = 1;
					currentPoint--;
				}
			}
			y++;
			pieceCounter =1;
		}
	}





}
