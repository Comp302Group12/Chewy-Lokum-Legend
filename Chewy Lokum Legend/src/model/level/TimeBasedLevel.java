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
	private static int currentFPS = 0;
    public static int Fps; //Actual frames per second
    private static long start = 0;
    public static int leveltime = 10; //120 seconds = 2 minutes

	@Override
	public void playerSwapped() {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean shouldGameFinish() {
		// TODO Auto-generated method stub
		if(objectiveScore <= AdapterManager.getInstance().getCurrentScoreCalculatorAdapter().score || leveltime<0){
			return true;
		}
		return false;
	}
	 public static void updateFps() {
	      currentFPS++;
	      if (System.currentTimeMillis() - start >= 1000) { 
	    	  leveltime -= 1; //We deduct 1 second, every second.
	         Fps = currentFPS;
	         currentFPS = 0;
	         start = System.currentTimeMillis();
	      }
	   }

}
