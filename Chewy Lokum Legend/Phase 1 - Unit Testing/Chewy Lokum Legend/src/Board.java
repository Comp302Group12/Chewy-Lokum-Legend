

public class Board {

	private int boardState;
	private int boardHeight;
	private int boardWidth;
	private Lokum[][] boardAsAnArray;
	private static Board board;

	private Board() {
		// TODO Auto-generated constructor stub
	}

	public static Board getInstance() {
		return board;
	}

	/**
	 * @modifies: board, boardAsAnArray,
	 * @requires: A new game must be started 
	 * @effects: The board is filled with the random lokums.
	 * When the game is started as a new game,
	 * it generates a board with random combinations of lokums.
	 */
	public void initializeBoard() {

	}

	/**
	 *@modifies: boardWidth, boardHeight
	 *@requires:
	 *@effects: The Width and the Height of the board are set
	 *The method that changes the dimensions of the board.
	 */
	public void setSize() {

	}

	
	/**
	 * @modifies: boardAsAnArray
	 * @requires: A swap becomes an existence when; three, four or five pieces of Lokums, in the same color, create a row.
	 * @effects: Two Lokums are swapped. Eventually, the empty spaces are created,
	 * which later on they need to be filled with available Lokums up there.
	 * The method that accomplish the swap of Lokums.
	 */
	public void swap(int x1, int y1, int x2, int y2) {

	}

	/**
	 * @modifies: board, boardAsAnArray
	 * @requires: After relevant lokums are destroyed, empty spaces appear on the board
	 * @effects: It fills the empty spaces on the board, after the lokums are destroyed.
	 * When the swap is accomplished, this method fills the empty spaces on the board accordingly.
	 */
	public void fillEmptyBoard() {

	}

	/**
	 * @modifies: board, boardState
	 * @requires: Destroy of the lokums and filling the empty spaces, after the swap is succesfully accomplished.
	 * @effects: Keeps checking the board for other lokum combinations that need to be destroyed.
	 * After each successful swap, it checks the whole board in case there are lokums that must be destroyed.
	 * This is done everytime, when the lokums are destroyed.
	 */
	public boolean checkBoard() {
		return false;
	}

	/**
	 * @modifies: boardAsAnArray
	 * @requires: After relevant lokums are destroyed, empty spaces appear on the board
	 * @effects: Brings the upper Lokums to lower steps by filling the empty spaces.
	 * When the swap is accomplished, this method lets Lokums fall off according to the empty spaces.
	 */
	public void fallLokums() {

	}

	/**
	 * @modifies: board, boardState
	 * @requires: The checkBoard decides if there are empty spaces on the board
	 * @effects: It destroy the lokums which are detected by checkBoard, 
	 * until there is no more automatically created destory by falling off the lokums.
	 * After board checking is done, it updates the board for the next move by calling the relevant methods. 
	 */
	public void updateBoard() {

	}

	public boolean hasUnassignedPartInArray() {
		for (int i=0; i<boardHeight-1; i++){
			for (int j=0; j<boardWidth -1; j++){
				if(boardAsAnArray[i][j] == null){return false;}; //checks each place at array to see if there is null element
			}
		}
		return true;
	}

	public boolean checkLokumsRepOK(){
		for (int i=0; i<boardHeight-1; i++){
			for (int j=0; j<boardWidth -1; j++){
				if(boardAsAnArray[i][j].repOk()){return false;}; //checks each loklums repOk if one of them is false return false
			}
		}
		return true;

	}

	public boolean repOkAfterInitializeBoard(){
		if (boardHeight == 0 || boardWidth == 0 ){ return false;} //height or weight is not zero
		else if(board.checkBoard() == true){return false;}// if there is emptyspace at board after initialize not done correctly
		else if(board.hasUnassignedPartInArray() == true){return false;}//in array there is a null element return false
		else if(board.checkLokumsRepOK() == true){return false;}//check lokums repok in array
		else{return true;}        
	}

	public boolean repOkAfterLokumsDestroyed(){
		if (boardHeight == 0 || boardWidth == 0 ){ return false;}
		else if(board.checkBoard() == false){return false;}// if there is not empty spaces after destroy there is a problem
		else if(board.hasUnassignedPartInArray() == true){return false;}
		else if(board.checkLokumsRepOK() == true){return false;}
		else{return true;}        
	}

	public String toString(){
		String result = "Board.toString \n";
		result += "Board Height:" + boardHeight   +"\n";
		result += "Board Width:"+  boardWidth   +"\n";
		result += "Board State:"+  boardState   +"\n";
		result += "Array of lokums :" + boardAsAnArray +"\n";
		return result;
	}

}
