package model.level;
import java.sql.Time;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;


public abstract class TimeBasedLevel extends Level {
	
	Time time;

	@Override
	public void playerSwapped() {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean shouldGameFinish() {
		// TODO Auto-generated method stub
		if(objectiveScore <= AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().score || time.getSeconds() == 0){
			return true;
		}
		return false;
	}

}
