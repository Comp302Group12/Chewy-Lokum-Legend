import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Board implements Drawable {
	private int width;
	private int height;
	private String[][] boardShape;
	private int numOfLokumsInAColumn;
	private int numOfLokumsInARow;
	private Lokum[][] lokumArray;

	private int blockWidth;
	private int blockHeight;
	private int lokumWidth;
	private int lokumHeight;

	Board(int width, int height, String[][] boardShape) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
		this.boardShape = boardShape;
		this.numOfLokumsInAColumn = boardShape.length;
		this.numOfLokumsInARow = boardShape[0].length;
		lokumArray = new Lokum[numOfLokumsInAColumn][numOfLokumsInARow];
		blockWidth = width/numOfLokumsInARow;
		blockHeight = height/numOfLokumsInAColumn;
		lokumWidth = blockWidth*4/5;
		lokumHeight = blockHeight*4/5;
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

	public int getBlockWidth() {
		return blockWidth;
	}

	public void setBlockWidth(int blockWidth) {
		this.blockWidth = blockWidth;
	}

	public int getBlockHeight() {
		return blockHeight;
	}

	public void setBlockHeight(int blockHeight) {
		this.blockHeight = blockHeight;
	}

	public int getLokumWidth() {
		return lokumWidth;
	}

	public void setLokumWidth(int lokumWidth) {
		this.lokumWidth = lokumWidth;
	}

	public int getLokumHeight() {
		return lokumHeight;
	}

	public void setLokumHeight(int lokumHeight) {
		this.lokumHeight = lokumHeight;
	}

	public void fillBoardRandomly() {
		for(int i=0; i<numOfLokumsInAColumn; i++){
			for(int j=0; j<numOfLokumsInARow; j++){
				lokumArray[i][j] = createRandomLokum(boardShape[i][j], i, j);
			}
		}
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

	public Lokum createRandomLokum(String typeOfLokum, int i, int j) {
		Random rgen = new Random();
		Color randomColor = Lokum.lokumColors[rgen.nextInt(Lokum.lokumColors.length)];
		Lokum lokum = null;
		try {
			lokum = (Lokum) Class.forName(typeOfLokum).newInstance();
			if(lokum instanceof Destructible) {
				int x = (j*blockWidth)+(blockWidth-lokumWidth)/2;
				int y = (i*blockHeight)+(blockHeight-lokumHeight)/2;
				lokum.setColor(randomColor);
				lokum.setX(x);
				lokum.setY(y);
				lokum.setWidth(lokumWidth);
				lokum.setHeight(lokumHeight);
			} else {
				int x = j*blockWidth;
				int y = i*blockHeight;
				lokum.setX(x);
				lokum.setY(y);
				lokum.setWidth(blockWidth);
				lokum.setHeight(blockHeight);
			}
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lokum;
	}

	public void draw(Graphics g) {
		AdapterManager.getInstance().getCurrentDrawingAdapter().draw(g, this);
	}

}
