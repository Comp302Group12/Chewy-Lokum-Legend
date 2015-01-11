package model.level;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public abstract class MoveBasedLevel extends Level {

	public int remainingMove;

	@Override
	public int getRemainingQuantity() {
		// TODO Auto-generated method stub
		return remainingMove;
	}
	
	@Override
	public void setRemainingQuantity(int quantity) {
		// TODO Auto-generated method stub
		remainingMove = quantity;
	}

	@Override
	public boolean shouldGameFinish() {
		// TODO Auto-generated method stub
		if(goalScore <= AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().score || remainingMove <= 0){
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
