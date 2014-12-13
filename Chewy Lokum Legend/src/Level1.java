
public class Level1 extends MoveBasedLevel {

	public Level1() {
		// TODO Auto-generated constructor stub
		this.objective = new Objective(10);
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum", "NormalLokum"},
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
