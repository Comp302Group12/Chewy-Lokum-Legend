package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Model.Board;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class BoardView extends GraphicsProgram {

	int boardWidth;
	int boardHeight;
	final double RATIO = 0.66;
	LokumView[][]array;
	public int saved=0;
	Font font = new Font("Arial", Font.PLAIN, 50);
	//GLabel scores = new GLabel("Score: " + sco, 700 ,100 );



	public BoardView(int boardWidth, int boardHeight) {
		// TODO Auto-generated constructor stub
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public void setBoardWidth(int boardWidth) {
		this.boardWidth = boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}

	public void setBoardHeight(int boardHeight) {
		this.boardHeight = boardHeight;
	}

	public void drawBoard(Board board){
		drawLines(board);
		drawLokums(board);
		addinfo(board);
	}

	public void addinfo(Board board){
		GRect ref = new GRect(500, 125);
		ref.setColor(Color.BLUE);
		ref.setFilled(true);



		GLabel SaveGame = new GLabel("SaveGame" , 700 ,300 );
		SaveGame.setFont(font);

		SaveGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				saved=1;	
			}
		});
		ref.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				saved=1;	
			}
		});
		GRect rect = new GRect(500, 250);
		rect.setColor(Color.RED);
		rect.setFilled(true);
		add(rect, 700, 0);

		GLabel scores = new GLabel("Score: " + board.sco, 700 ,100 );
		scores.setFont(font);
		add(scores);

		GLabel remMove = new GLabel("Remaining Moves: " + board.movesLeft, 700 ,200 );
		if(board.movesLeft>0){

			remMove.setFont(font);
			add(remMove);
			add(ref, 700, 250);
			add(SaveGame);
		}else{
			remove(remMove);
			remove(SaveGame);
			remove(ref);
			GRect gameoverrect = new GRect(700, 700);
			gameoverrect.setColor(Color.YELLOW);
			gameoverrect.setFilled(true);

			add(gameoverrect, 0, 0);
			GLabel gameover = new GLabel("Game Over", 0 ,300 );
			Font fontg = new Font("Arial", Font.PLAIN, 100);
			gameover.setFont(fontg);
			add(gameover);


		}
	}

	public void drawLines(Board board) {
		for(int i=0; i<=board.getLokumArray().length; i++){
			GLine line = new GLine(0, i*boardHeight/board.getLokumArray().length, boardWidth, i*boardHeight/board.getLokumArray().length);
			add(line);
		}
		for(int i=0; i<=board.getLokumArray()[0].length; i++){
			GLine line = new GLine(i*boardWidth/board.getLokumArray()[0].length, 0, i*boardWidth/board.getLokumArray()[0].length, boardHeight);
			add(line);
		}
	}

	public void drawLokums(Board board) {
		array = new LokumView[board.getLokumArray().length][board.getLokumArray()[0].length];
		double lokumWidth = boardWidth/board.getLokumArray()[0].length*RATIO;
		double lokumHeight = boardHeight/board.getLokumArray().length*RATIO;
		for(int i=0; i<board.getLokumArray().length; i++){
			for(int j=0; j<board.getLokumArray()[0].length; j++){
				String nameOfLokumView = board.getLokumArray()[i][j].getClass().getName();
				nameOfLokumView = nameOfLokumView.substring(nameOfLokumView.lastIndexOf('.')+1);
				nameOfLokumView = "View." + nameOfLokumView;
				nameOfLokumView += "View";
				Class classOfLokumView;
				try {
					classOfLokumView = Class.forName(nameOfLokumView);
					try {
						LokumView lokum = (LokumView) classOfLokumView.newInstance();
						lokum.drawLokum(lokumWidth, lokumHeight, board.getLokumArray()[i][j]);
						lokum.setLocation((j*boardWidth/board.getLokumArray()[0].length)+(boardWidth/board.getLokumArray()[0].length-lokumWidth)/2,
								(i*boardHeight/board.getLokumArray().length)+(boardHeight/board.getLokumArray().length-lokumHeight)/2);
						add(lokum);
						array[i][j] = lokum;
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
