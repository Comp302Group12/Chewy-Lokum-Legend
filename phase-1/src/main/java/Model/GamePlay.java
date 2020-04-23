package Model;

public class GamePlay {

	int level;
	Board board;
	int numOfRemainingMoves;
	int score;
	int[][] willBeDestroyedorConvergedArray; 

	public GamePlay() {
		// TODO Auto-generated constructor stub
		board = new Board(10,10);
		board.fillBoardRandomly();
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
		board.sco = score;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getNumOfRemainingMoves() {
		return numOfRemainingMoves;
	}

	public void setNumOfRemainingMoves(int numOfRemainingMoves) {
		this.numOfRemainingMoves = numOfRemainingMoves;
	}

	public void swapLokums(Board board, int x1, int y1, int x2, int y2){
		board.swapLokumsInBoard(x1, y1, x2, y2);

		if(isCombination(board.lokumArray[x1][y1], board.lokumArray[x2][y2]))
		{board.destroySpecialCombination(board.lokumArray[x1][y1], board.lokumArray[x2][y2], x2, y2);
		int streak = 0;
		board.checkBoard();
		boolean b =true;
		while(b){
			board.destroyMatchedLokums(board.willbeDestroyed);
			board.fallLokumsInBoard();
			board.checkBoard();
			b = board.isThereAny();
			streak++;
			System.out.println(streak);
			board.printWillBe();
		}
		board.movesLeft--;

		}else{
			board.checkBoard();
			/////////////print test
			for(int i=0; i<board.willbeDestroyed.length; i++){
				for(int j=0; j<board.willbeDestroyed.length; j++){
					System.out.print(board.willbeDestroyed[i][j]);
				}
				System.out.println();
			}	
			//////////////
			if(!isMatchHappened(board) || !checkAdjacent(x1, y1, x2, y2)){
				for(int i=0; i<board.willbeDestroyed.length; i++){
					for(int j=0; j<board.willbeDestroyed.length; j++){
						board.willbeDestroyed[i][j]=0;
					}
				}	
				board.swapLokumsInBoard(x1, y1, x2, y2);	
				board.movesLeft++;

			}
			int streak = 0;
			boolean b =true;
			while(b){
				board.destroyMatchedLokums(board.willbeDestroyed);
				board.fallLokumsInBoard();
				board.checkBoard();
				b = board.isThereAny();
				streak++;
				System.out.println(streak);
				board.printWillBe();
			}
			board.movesLeft--;
		}
		//board.destroyMatchedLokums(board.willbeDestroyed);
		//fallLokums(board);

	}
	public boolean isMatchHappened(Board board){
		for(int i=0; i<board.willbeDestroyed.length; i++){
			for(int j=0; j<board.willbeDestroyed.length; j++){
				if (board.willbeDestroyed[i][j] >0){
					for(int k=0; i<board.willbeDestroyed.length; i++){
						for(int l=0; j<board.willbeDestroyed.length; j++){
							if (board.willbeDestroyed[i][j] >0){
								return true;
							}
						}
					}
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkAdjacent(int x1, int y1, int x2, int y2){
		if (x1==x2 && y1==y2){return false;}
		int a = Math.abs(x1 -x2);
		int b= Math.abs(y1-y2);
		if(a<=1 && b<= 1){return true;
		} else {
			return false;
		}
	}
	public boolean isCombination(Lokum a, Lokum b){

		if(a.getClass().toString().equals(board.colorbombClassName)  || b.getClass().toString().equals(board.colorbombClassName)){
			return true;
		}

		if(  (a.getClass().toString().equals(board.wrappedClassName)  || a.getClass().toString().equals(board.strippedClassName))
				&& (b.getClass().toString().equals(board.wrappedClassName)  || b.getClass().toString().equals(board.strippedClassName))
				){
			return true;
		}
		else{		
			return false;}
	}

	public void fallLokums(Board board){
		board.fallLokumsInBoard();
	}
}
