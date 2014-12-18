package model;

import java.awt.Color;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public class GamePlay {
	String strippedClassName = "class model.lokum.StripedLokum";
	String wrappedClassName = "class model.lokum.WrappedLokum";
	String colorbombClassName = "class model.lokum.ColorBombLokum";
	public Lokum selectedLokum1;
	public Lokum selectedLokum2;
	public Board board;
	private boolean isGameModeOn;

	CombinationFinderAdapter cfa;

	public GamePlay(Board board) {
		// TODO Auto-generated constructor stub
		this.board = board;
		isGameModeOn = true;

		cfa = new CombinationFinderAdapter();

	}

	public Board getBoard() {
		return board;
	}

	public void selectLokum1(int x, int y) {
		if(checkGameMode()){
			selectedLokum1 = board.lokumAtPosition(x, y);
		}
	}

	public void selectLokum2(int x, int y) {
		if(checkGameMode()){
			Lokum chosenLokum = board.lokumAtPosition(x, y);
			if(selectedLokum2 == null && selectedLokum1 != null && chosenLokum != selectedLokum1) {
				selectedLokum2 = chosenLokum;
				swapSelectedLokums();
			} else {
				resetSelectedLokums();
			}
		}
	}

	public void swapSelectedLokums() {
		AdapterManager.getInstance().getCurrentLokumSwapperAdapter().swapLokums(this, selectedLokum1, selectedLokum2);
		resetSelectedLokums();
	}

	public void resetSelectedLokums() {
		selectedLokum1 = null;
		selectedLokum2 = null;
	}

	public boolean doesBoardHaveCombination() {
		return cfa.isThereACombination(board);
	}

	public boolean checkGameMode() {
		isGameModeOn = true;
		if(AdapterManager.getInstance().getCurrentLokumSwapperAdapter().isSwapInProgres()) {
			isGameModeOn = false;
		}
		return isGameModeOn;
	}

	public void destroyMatchedLokums(int[][] array){
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array.length; j++){
				if(array[i][j]==4){
					Lokum tempLokum = board.getLokumArray()[i][j];
					Lokum convertStripedYatay = new StripedLokum(tempLokum.getColor(), tempLokum.getX(), tempLokum.getY(), 
							tempLokum.getWidth(), tempLokum.getHeight(), true );
					board.getLokumArray()[i][j] = convertStripedYatay;
				}
				else if(array[i][j]==3){
					Lokum tempLokum = board.getLokumArray()[i][j];
					Lokum convertStripedDikey = new StripedLokum(tempLokum.getColor(), tempLokum.getX(), tempLokum.getY(), 
							tempLokum.getWidth(), tempLokum.getHeight(), false );
					board.getLokumArray()[i][j] = convertStripedDikey;
				}
				else if(array[i][j]==5){
					Lokum tempLokum = board.getLokumArray()[i][j];
					Lokum cb = new ColorBombLokum(tempLokum.getX(), tempLokum.getY(),tempLokum.getWidth(), tempLokum.getHeight());
					board.getLokumArray()[i][j] = cb;

				}
				else if(array[i][j]==1){
					destroySpecialLokum(board.getLokumArray()[i][j], i, j);

				}
				array[i][j]=0;
			}						
		}
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array.length; j++){
				array[i][j] = 0;
			}
		}

	}
	public void destroySpecialLokum(Lokum specLok, int x1, int y1){
	
		if (specLok.getClass().toString().equals(strippedClassName)){
			if( ((StripedLokum)specLok).isHorizontal()){
				for(int k=0; k<board.lokumArray.length; k++){
					board.lokumArray[x1][k] =  new DestroyedLokum();
				}
			}else{
				for(int k=0; k<board.lokumArray.length; k++){
					board.lokumArray[k][y1] =  new DestroyedLokum();
				}
			}
		}
		if (specLok.getClass().toString().equals(wrappedClassName)){
			if(x1 == board.lokumArray.length && y1 ==board.lokumArray.length){
				for(int k = x1-1; k < x1+1; k++){
					for(int l=y1-1; l<y1+1; l++){
						board.lokumArray[k][l] =  new EmptySpace(k, l, board.getLokumWidth(), board.getLokumHeight());
					}
				}
			}

			if(x1 == 0 && y1 ==board.lokumArray.length){
				for(int k = x1; k < x1+2; k++){
					for(int l=y1-1; l<y1+1; l++){
						board.lokumArray[k][l] =  new EmptySpace(k, l, board.getLokumWidth(), board.getLokumHeight());
					}
				}
			}
			if(x1 == board.lokumArray.length && y1 ==0){

				for(int k = x1-1; k < x1+1; k++){
					for(int l=y1; l<y1+2; l++){
						board.lokumArray[k][l] =  new EmptySpace(k, l, board.getLokumWidth(), board.getLokumHeight());
					}
				}
			}
			if(x1 == 0 && y1 ==0){

				for(int k = x1; k < x1+2; k++){
					for(int l=y1; l<y1+2; l++){
						board.lokumArray[k][l] =  new EmptySpace(k, l, board.getLokumWidth(), board.getLokumHeight());
					}
				}
			}
			else{
				for(int k = x1-1; k < x1+2; k++){
					for(int l=y1-1; l<y1+2; l++){
						board.lokumArray[k][l] =  new EmptySpace(k, l, board.getLokumWidth(), board.getLokumHeight());
					}
				}
			}
		}

		board.lokumArray[x1][y1] = new DestroyedLokum(); // if normal just destroy

	}



	public void update() {
		if(checkGameMode()) {
			if(doesBoardHaveCombination()) {
				destroyMatchedLokums(cfa.taggedLokumArray);
			}
		}
		/*
		if(!checkGameMode()) {
			System.out.println("Hazýr deðil!!!");
		} else {
			System.out.println("Hazýr!!!");
		}
		 */
	}

}
