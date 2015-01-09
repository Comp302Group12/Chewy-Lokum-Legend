package model.level;

import model.Board;
import model.GamePlay;
import model.adapter.AdapterManager;

public class Level3 extends TimeBasedLevel {

	@SuppressWarnings("deprecation")
	public Level3() {
		// TODO Auto-generated constructor stub
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "ColorBombLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "ColorBombLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "TimeLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"ColorBombLokum", "TimeLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"}
		};
		Board board = new Board(430, 430, boardShape);
		this.gamePlay = new GamePlay(board, this);
		leveltime =5;
		objectiveScore = 5000;
		AdapterManager.getInstance().newGame();
	}
	
}
