package model.adapter;

import model.Board;
import model.lokum.Lokum;

public class ScoreCalculatorAdapter {

	public int score;

	public ScoreCalculatorAdapter() {
		score=0;

	}

	public void updateNormalLokumScore (Lokum[] combination) {

		if (combination.length==3){
			score+=60;
		} 
		//System.out.println(score);		
	}

	public void formedStripedLokumScore () {

		score+=120;

		//System.out.println(score);
	}

	public void destroyStripedLokumScore (int numOfLokumsInARow) {

		score+= numOfLokumsInARow*60;

		//System.out.println(score);

	}
	public void formedWrappedLokumScore () {

		score+=80;

		//System.out.println(score);
	}


	public void destroyWrappedLokumScore () {

		score += 1080;

		//System.out.println(score);
	}

	public void formedColorBombLokumScore () {

		score+=200;

		//System.out.println(score);
	}

	public void destroyColorBombLokumScore (Board board) {

		score+=200;

	}

	public void destroyNormalColorBombLokumScore (int i) {

		score += i*60;

	}

	public void destroyStripedStripedbLokumScore (Board board) {

		score += board.getNumOfLokumsInAColumn()*2*60 + board.getNumOfLokumsInARow()*2*60;

		//System.out.println(score);
	}

	public void destroyWrappedStripedbLokumScore (Board board) {

		score += board.getNumOfLokumsInAColumn()*3*60 + board.getNumOfLokumsInARow()*3*60;
	}

	public void destroyColorBombStripedbLokumScore (int i) {

		score += i*120;

	}

	public void destroyWrappedWrappedLokumScore () {

		score += 3600;

	}

	public void destroyColorBombWrappedLokumScore (int i) {

		score += 2*200;

	}

	public void destroyColorBombColorBombLokumScore (int i) {

		score += (i^2)*100;

	}



}
