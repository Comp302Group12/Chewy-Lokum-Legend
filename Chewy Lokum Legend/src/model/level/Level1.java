package model.level;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public class Level1 extends MoveBasedLevel {

	public Level1() {
		// TODO Auto-generated constructor stub
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "StripedLokum", "StripedLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "StripedLokum", "StripedLokum", "NormalLokum", "NormalLokum", "NormalLokum"}
		};
		Board board = new Board(430, 430, boardShape);
		this.gamePlay = new GamePlay(board, this);
		remainingMove = 10;
		objectiveScore = 5000;
		AdapterManager.getInstance().newGame();
	}

}
