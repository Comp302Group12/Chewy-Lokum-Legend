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
		this.objective = new Objective(10);
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"}
		};
		Board board = new Board(430, 430, boardShape);
		this.gamePlay = new GamePlay(board);
	}

}
