package model.level;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public abstract class MoveBasedLevel extends Level {

	int remainingMove;

	@Override
	public boolean shouldGameFinish() {
		// TODO Auto-generated method stub
		if(objectiveScore <= AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().score || remainingMove <= 0){
			return true;
		}
		return false;
	}

	@Override
	public void playerSwapped() {
		// TODO Auto-generated method stub
		remainingMove--;
	}
}
