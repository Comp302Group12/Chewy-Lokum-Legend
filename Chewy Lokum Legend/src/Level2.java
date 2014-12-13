
public class Level2 extends MoveBasedLevel {

	public Level2() {
		// TODO Auto-generated constructor stub
		this.objective = new Objective(10);
		String[][] boardShape = {
				{"ColorBombLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "ColorBombLokum"},
				{"EmptySpace", "EmptySpace", "EmptySpace", "NormalLokum", "NormalLokum", "EmptySpace", "EmptySpace", "EmptySpace"},
				{"EmptySpace", "EmptySpace", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "EmptySpace", "EmptySpace"},
				{"EmptySpace", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "EmptySpace"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
				{"EmptySpace", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "EmptySpace"},
				{"EmptySpace", "EmptySpace", "NormalLokum", "Obstacle", "Obstacle", "NormalLokum", "EmptySpace", "EmptySpace"},
				{"EmptySpace", "EmptySpace", "EmptySpace", "NormalLokum", "NormalLokum", "EmptySpace", "EmptySpace", "EmptySpace"}
		};
		this.board = new Board(430, 430, boardShape);
		this.gamePlay = new GamePlay(this);
	}
}
