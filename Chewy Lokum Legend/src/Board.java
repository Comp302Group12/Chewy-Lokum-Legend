import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Board implements Drawable {
	private int boardWidth;
	private int boardHeight;
	private int numOfLokumsInAColumn;
	private int numOfLokumsInARow;
	private Lokum[][] lokumArray;

	int lokumWidth;
	int lokumHeight;

	Board(int boardWidth, int boardHeight, int numOfLokumsInAColumn, int numOfLokumsInARow) {
		// TODO Auto-generated constructor stub
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
		this.numOfLokumsInAColumn = numOfLokumsInAColumn;
		this.numOfLokumsInARow = numOfLokumsInARow;
		lokumArray = new Lokum[numOfLokumsInAColumn][numOfLokumsInARow];
		lokumWidth = boardWidth/numOfLokumsInARow*4/5;
		lokumHeight = boardHeight/numOfLokumsInAColumn*4/5;
		fillBoardRandomly();
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

	public int getNumOfLokumsInAColumn() {
		return numOfLokumsInAColumn;
	}

	public void setNumOfLokumsInAColumn(int numOfLokumsInAColumn) {
		this.numOfLokumsInAColumn = numOfLokumsInAColumn;
	}

	public int getNumOfLokumsInARow() {
		return numOfLokumsInARow;
	}

	public void setNumOfLokumsInARow(int numOfLokumsInARow) {
		this.numOfLokumsInARow = numOfLokumsInARow;
	}

	public Lokum[][] getLokumArray() {
		return lokumArray;
	}

	public void setLokumArray(Lokum[][] lokumArray) {
		this.lokumArray = lokumArray;
	}

	public void fillBoardRandomly() {
		for(int i=0; i<numOfLokumsInAColumn; i++){
			for(int j=0; j<numOfLokumsInARow; j++){
				int x = (int) ((j*boardWidth/numOfLokumsInARow)+(boardWidth/numOfLokumsInARow-lokumWidth)/2);
				int y = (int) ((i*boardHeight/numOfLokumsInAColumn)+(boardHeight/numOfLokumsInAColumn-lokumHeight)/2);
				lokumArray[i][j] = createRandomNormalLokum(x, y);
			}
		}
		lokumArray[0][0] = new EmptySpace();
		lokumArray[0][1] = new NormalLokum(Color.YELLOW, lokumArray[0][1].getX(), lokumArray[0][1].getY(), lokumWidth, lokumHeight);
		lokumArray[0][2] = new StripedLokum(Color.RED, lokumArray[0][2].getX(), lokumArray[0][2].getY(), lokumWidth, lokumHeight, false);
		lokumArray[0][3] = new StripedLokum(Color.BLUE, lokumArray[0][3].getX(), lokumArray[0][3].getY(), lokumWidth, lokumHeight, true);
		lokumArray[0][4] = new WrappedLokum(Color.GREEN, lokumArray[0][4].getX(), lokumArray[0][4].getY(), lokumWidth, lokumHeight);
		lokumArray[0][5] = new ColorBombLokum(lokumArray[0][5].getX(), lokumArray[0][5].getY(), lokumWidth, lokumHeight);
	}

	public Lokum lokumAtPosition(int x, int y){		
		for(int i=0; i<numOfLokumsInAColumn; i++) {
			for(int j=0; j<numOfLokumsInARow; j++) {
				if(lokumArray[i][j].contains(x, y)) {
					return lokumArray[i][j];
				}
			}
		}
		return null;		
	}

	public NormalLokum createRandomNormalLokum(int x, int y) {
		Random rgen = new Random();
		Color randomColor = Lokum.lokumColors[rgen.nextInt(Lokum.lokumColors.length)];
		return new NormalLokum(randomColor, x, y, lokumWidth, lokumHeight);
	}

	public void draw(Graphics g) {
		drawLines(g);
		drawLokums(g);
	}

	public void drawLines(Graphics g) {
		for (int i = 0; i <= numOfLokumsInAColumn; i++) {
			g.drawLine(0, i * boardHeight / numOfLokumsInAColumn, boardWidth, i	* boardHeight / numOfLokumsInAColumn);
		}
		for (int i = 0; i <= numOfLokumsInARow; i++) {
			g.drawLine(i * boardWidth / numOfLokumsInARow, 0, i * boardWidth
					/ numOfLokumsInARow, boardHeight);
		}
	}

	public void drawLokums(Graphics g) {
		for(int i=0; i<numOfLokumsInAColumn; i++){
			for(int j=0; j<numOfLokumsInARow; j++){
				lokumArray[i][j].draw(g);
			}
		}
	}

}
