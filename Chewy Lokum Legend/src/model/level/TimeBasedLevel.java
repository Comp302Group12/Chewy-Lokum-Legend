package model.level;
import java.sql.Time;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;


public abstract class TimeBasedLevel extends Level {

	private int currentFPS = 0;
	public int Fps; //Actual frames per second
	private long start = 0;
	public int remainingTime = 10; //120 seconds = 2 minutes

	
	@Override
	public int getRemainingQuantity() {
		// TODO Auto-generated method stub
		return remainingTime;
	}
	
	@Override
	public void setRemainingQuantity(int quantity) {
		// TODO Auto-generated method stub
		remainingTime = quantity;
	}
	
	@Override
	public void playerSwapped() {
		// TODO Auto-generated method stub

	}

	
	@Override
	public boolean shouldGameFinish() {
		// TODO Auto-generated method stub
		if(goalScore <= AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().score || remainingTime<0){
			return true;
		}
		return false;
	}

	public void expandTime(int time){
		remainingTime += time;
	}
	public void updateFps() {
		currentFPS++;
		if (System.currentTimeMillis() - start >= 1000) { 
			remainingTime -= 1; //We deduct 1 second, every second.
			Fps = currentFPS;
			currentFPS = 0;
			start = System.currentTimeMillis();
		}
	}

}
