package model.level;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public abstract class Level {

	protected Objective objective;
	protected GamePlay gamePlay;
	protected Board board;
	
	public Objective getObjective() {
		return objective;
	}
	
	public GamePlay getGamePlay() {
		return gamePlay;
	}
	
	public Board getBoard() {
		return board;
	}
	
}
