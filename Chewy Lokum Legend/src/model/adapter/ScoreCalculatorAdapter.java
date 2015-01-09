package model.adapter;

import model.Board;
import model.lokum.Lokum;

public class ScoreCalculatorAdapter {
	
	int score;
	
	public ScoreCalculatorAdapter() {
		score=0;
		
	}
	
	public void updateNormalLokumScore (Lokum[] combination) {
		
		if (combination.length==3){
			score+=60;
		} 
		System.out.println(score);
		
	}
	
	public void formedStripedLokumScore () {
		
		score+=120;
		
		System.out.println(score);
	}
	
	public void destroyStripedLokumScore (int numOfLokumsInARow) {
		
		score+= numOfLokumsInARow*60;
		
		System.out.println(score);
		
	}
	public void formedWrappedLokumScore () {
		
		score+=80;
		
		System.out.println(score);
	}
	
	
	public void destroyWrappedLokumScore () {
		
		score += 1080;
		
		System.out.println(score);
	}
	
	public void formedColorBombLokumScore () {
		
		score+=200;
		
		System.out.println(score);
	}
	
	public void destroyColorBombLokumScore (Board board) {
		
		// score += (numberOfMatchedColor^2)*60;
		
		System.out.println(score);
	}
	

}
