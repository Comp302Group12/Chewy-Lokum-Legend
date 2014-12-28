package model.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import ui.AnimationWindow;
import model.Board;
import model.GamePlay;
import model.interfaces.Movable;
import model.lokum.DestroyedLokum;
import model.lokum.EmptySpace;
import model.lokum.Lokum;

public class LokumFallerAdapter implements ActionListener {

	GamePlay gamePlay;
	Board board;
	ArrayList<Lokum> lokumsToFallDown;
	ArrayList<Lokum> lokumsToFallRightDown;
	ArrayList<Lokum> lokumsToFallLeftDown;
	FallingLokumSwapperAdapter flsAdapter;
	Timer timer;
	private boolean isFallInProgress;
	boolean test;

	public LokumFallerAdapter() {
		// TODO Auto-generated constructor stub
		flsAdapter = new FallingLokumSwapperAdapter();
		timer = new Timer(AnimationWindow.getTIMER_DELAY_CONS(), this);
		isFallInProgress = false;
		test = false;
	}
	/**
	 * @modifies isFallInProgress, timer
	 * @requires there are destroyed lokums in board
	 * @effects falling is started
	 */	
	public void fallLokums(GamePlay gamePlay) {
		isFallInProgress = true;
		this.gamePlay = gamePlay;
		board = gamePlay.getBoard();
		timer.start();
	}
	/**
	 * @modifies board gameplay lokumarray
	 * @requires there are destroyed lokums at top
	 * @effects random lokums are generated at top
	 */	
	public void putRandomLokumsToTopRow() {
		for(int i=0; i<board.getNumOfLokumsInARow(); i++){
			if(board.lokumArray[0][i] instanceof DestroyedLokum) {
				board.lokumArray[0][i] = board.createRandomLokum("NormalLokum", 0, i);
			}
		}
	}
	/**
	 * @modifies lokumstofall array lists
	 * @requires there are destroyed lokums at board
	 * @effects finds lokums to fall and put them in array list
	 */	
	public void findLokumsWhichNeedToFall() {
		lokumsToFallDown = new ArrayList<Lokum>();
		lokumsToFallLeftDown = new ArrayList<Lokum>();
		lokumsToFallRightDown = new ArrayList<Lokum>();
		for(int i=0; i<board.getNumOfLokumsInAColumn(); i++){
			for(int j=0; j<board.getNumOfLokumsInARow(); j++){
				Lokum lokum = board.lokumArray[i][j];
				if(!(lokum instanceof DestroyedLokum) && lokum instanceof Movable){
					if((board.getBottomAdjacentOfLokum(lokum) instanceof DestroyedLokum)){
						lokumsToFallDown.add(lokum);
					} else if(!(board.getLeftAdjacentOfLokum(lokum) instanceof Movable)
							&& (board.getLowerLeftAdjacentOfLokum(lokum) instanceof DestroyedLokum)){
						lokumsToFallLeftDown.add(lokum);
					} else if(!(board.getRightAdjacentOfLokum(lokum) instanceof Movable)
							&& (board.getLowerRightAdjacentOfLokum(lokum) instanceof DestroyedLokum)){
						lokumsToFallRightDown.add(lokum);
					} 
				}
			}
		}
	}
	/**
	 * @modifies isFallInProgress, timer
	 * @requires falling is started
	 * @effects falling is stopped
	 */	
	public void stopFalling() {
		timer.stop();
		isFallInProgress = false;
	}
	
	public boolean isFallNeeded() {
		return !lokumsToFallDown.isEmpty();
	}

	public boolean isFallInProgress() {
		return isFallInProgress;
	}



	public boolean isTest() {
		return flsAdapter.isSwapInProgres();
	}
	/**
	 * @modifies board lokum array gameplay
	 * @requires destroyedlokums exist in board
	 * @effects lokums fall and new ones come until falling is not needed
	 */	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(!flsAdapter.isSwapInProgres()){
			putRandomLokumsToTopRow();
			findLokumsWhichNeedToFall();
			if(lokumsToFallDown.isEmpty() && lokumsToFallLeftDown.isEmpty() && lokumsToFallRightDown.isEmpty()){
				stopFalling();
			} else {
				for(int i=0; i<lokumsToFallDown.size(); i++){
					FallingLokumSwapperAdapter flsAdapter = new FallingLokumSwapperAdapter();
					flsAdapter.swapLokums(gamePlay, lokumsToFallDown.get(i), board.getBottomAdjacentOfLokum(lokumsToFallDown.get(i)));
					this.flsAdapter = flsAdapter;
				}
				for(int i=0; i<lokumsToFallLeftDown.size(); i++){
					FallingLokumSwapperAdapter flsAdapter = new FallingLokumSwapperAdapter();
					flsAdapter.swapLokums(gamePlay, lokumsToFallLeftDown.get(i), board.getLowerLeftAdjacentOfLokum(lokumsToFallLeftDown.get(i)));
					this.flsAdapter = flsAdapter;
				}
				for(int i=0; i<lokumsToFallRightDown.size(); i++){
					FallingLokumSwapperAdapter flsAdapter = new FallingLokumSwapperAdapter();
					flsAdapter.swapLokums(gamePlay, lokumsToFallRightDown.get(i), board.getLowerRightAdjacentOfLokum(lokumsToFallRightDown.get(i)));
					this.flsAdapter = flsAdapter;
				}
			}
		}
	}
}
