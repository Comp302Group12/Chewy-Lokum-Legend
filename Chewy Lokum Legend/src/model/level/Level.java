package model.level;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public abstract class Level {

	protected int objectiveScore;
	protected GamePlay gamePlay;

	public GamePlay getGamePlay() {
		return gamePlay;
	}

	public abstract boolean shouldGameFinish();
	public abstract void playerSwapped();

}
