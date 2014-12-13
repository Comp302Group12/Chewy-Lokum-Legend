import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Board implements Drawable {
	private int width;
	private int height;
	private int numOfLokumsInAColumn;
	private int numOfLokumsInARow;
	private Lokum[][] lokumArray;

	int lokumWidth;
	int lokumHeight;

	Board(int width, int height, int numOfLokumsInAColumn, int numOfLokumsInARow) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
		this.numOfLokumsInAColumn = numOfLokumsInAColumn;
		this.numOfLokumsInARow = numOfLokumsInARow;
		lokumArray = new Lokum[numOfLokumsInAColumn][numOfLokumsInARow];
		lokumWidth = width/numOfLokumsInARow*4/5;
		lokumHeight = height/numOfLokumsInAColumn*4/5;
		fillBoardRandomly();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
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
				int x = (int) ((j*width/numOfLokumsInARow)+(width/numOfLokumsInARow-lokumWidth)/2);
				int y = (int) ((i*height/numOfLokumsInAColumn)+(height/numOfLokumsInAColumn-lokumHeight)/2);
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
		AdapterManager.getInstance().getCurrentDrawingAdapter().draw(g, this);
	}

}
