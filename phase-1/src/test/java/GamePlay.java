
import Adapters.LokumDestroyerAdapter;
import Adapters.ScoreCalculatorAdapter;
import Adapters.GameStateAdapter;
import Adapters.InformationAdapter;


public class GamePlay implements LokumDestroyerAdapter, ScoreCalculatorAdapter, GameStateAdapter, InformationAdapter{

	/**
	 * @modifies selectedLokum1, selectedLokum2
	 * @requires player to click a lokum in board
	 * @effects  selectedLokum1 or selectedLokum2 is changed or unselected depends on which lokums are clicked
	 */
	public void selectLokum(int x1, int y1, int x2, int y2) {
		
	}
	
	/**
	 * @modifies selectedLokum1, selectedLokum2
	 * @requires player to click a  second lokum in board which is not adjacent to selectedLokum1
	 * @effects  selectedLokum1 or selectedLokum2 is unselected 
	 */
	public void unselectLokums() {
		
	}
	
	/**
	 * @modifies isSwappale
	 * @requires selectedLokum1 and selectedLokum2 iscombination or they are adjacent and creates destroyable lokums
	 * @effects  isSwappable set to true 
	 * 
	 */
	public boolean areLookumsSwappable() {
		return false;
	}
	
	/**
	 * @modifies specialCombinationNumber
	 * @requires selectedLokum1 and selectedLokum2 is combination to be true
	 * @effects  changes specialCombinationNumber according to selectedlokums type
	 * 
	 */
	public int getWhichSpecialCombination(Lokum lokum1, Lokum lokum2) {
		return 0;
	}
	
	/**
	 * @modifies selectedLokum1, selectedLokum2, board
	 * @requires selectedLokum1 and selectedLokum2 is not empty, isSwappale or isCombination is true
	 * @effects  selectedLokum1 or selectedLokum2 is unselected 
	 * 
	 */
	public void swapSelectedLokums(Lokum lokum1, Lokum lokum2) {
		
	}
	
	/**
	 * @modifies boardState
	 * @requires objective to be completed or not
	 * @effects  chages boardState if objective is completed, if not boardState is not changed
	 * 
	 */
	public void checkObjective() {
		
	}
	
	/**
	 * @modifies 
	 * @requires requires an explosion after player's swap.
	 * @effects 
	 */	
	@Override
	public boolean checkDestroyableLokums() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @modifies
	 * @requires requires 2 or more same colored lokums to create combination/s by swapping.
	 * @effects lokums that create the combination/s are converted to empty spaces, score is calculated, board is updated.
	 */	
	@Override
	public void destroySwappedLokums() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @modifies
	 * @requires requires an explosion after player's swap, and combination/s after fall of lokums is completed.
	 * @effects lokums that create the combination are converted to empty spaces, score is calculated, board is updated.
	 */	
	@Override
	public void destroyLokums() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @modifies
	 * @requires requires a combination that has a streak lokum in it.
	 * @effects lokums that create the combination and others in the same row or column with the streak lokum are converted to empty spaces, score is calculated, board is updated.
	 */	
	@Override
	public void destroyStreakLokums() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @modifies
	 * @requires requires following combinations;
	 * Color Bomb + Color Bomb, Striped + Wrapped, Wrapped + Wrapped, Striped + Color Bomb, Wrapped + Color Bomb, Color Bomb + Color Bomb
	 * @effects lokums that create the combination and others according to the combination are converted to empty spaces, score is calculated, board is updated.
	 */	
	@Override
	public void destroySpecialCombinationLokum(int typeOfCombination) {
		// TODO Auto-generated method stub
		
	}


	/**
	 * @modifies score, scoreAfterSwap
	 * @requires boardState to be ready to swap
	 * @effects  scoreAfterSwap added to current score, scoreAfterSwap is set to 0
	 * 
	 */
	@Override
	public int calculateScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @modifies scoreAfterSwap
	 * @requires special lokums to be destroyed
	 * @effects  scoreAfterSwap is updated according to which special lokum is destroyed
	 * 
	 */
	@Override
	public int calculateDestroyedSpecialLokumScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @modifies scoreAfterSwap
	 * @requires special lokums to be destroyed
	 * @effects  scoreAfterSwap is updated according to which combination happened
	 * 
	 */
	@Override
	public int calculateCombinationScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @modifies scoreAfterSwap
	 * @requires lokums to be destroyed after swap more than 1 times
	 * @effects  scoreAfterSwap is updated according to how many streaks happened how amny lokums destroyed in each streak
	 * 
	 */
	@Override
	public int calculateStreakScore() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * @modifies boardState
	 * @requires boardState to be ready to swap
	 * @effects  goes to pause screen
	 * 
	 */
	@Override
	public void pauseGame() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @modifies boardState
	 * @requires boardState to be paused
	 * @effects  go backs to board from where it left off
	 * 
	 */
	@Override
	public void contiuneGame() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @modifies game
	 * @requires boardState to be paused
	 * @effects  go backs to main screen
	 * 
	 */
	@Override
	public void exitCurrentGame() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @modifies savedGameFile
	 * @requires game to be paused
	 * @effects current board and information will be written into savedGameFile
	 * 
	 */
	@Override
	public void saveGame() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @modifies level
	 * @requires boardState to be wingame
	 * @effects next level's isOpen will be changed to true
	 * 
	 */
	@Override
	public void winGame() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @modifies board, boardState
	 * @requires objective to be not completed while remaining move is 0 and all destroyable lokums are destroyed(board is still)
	 * @effects  board will closed and and main screen will show up
	 * (yada bu mu boardState is changed to lose game and buttons appear to play again or go back to main screen)
	 */
	@Override
	public void loseGame() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @modifies board, lokumArray, boardState
	 * @requires objective to be completed while remaining moves greater than 0 and all destroyable lokums are destroyed(board is still)
	 * @effects boardState is changed, randomly selected lokums in array will be converted into randomly striped lokum or
	 *  bomb lokum and remaining moves will be decremented by one until remaining move is 0
	 */
	@Override
	public void convertWinGameBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setObjective(int type, int numberToComplete) {
		// TODO Auto-generated method stub
		return false;
		
	}

	@Override
	public int getObjective() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRemainingMove() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRemainingMove(int remainingMove) {
		// TODO Auto-generated method stub
		
	}
	
//	public boolean repOK(){
//        if (board.repOkAfterInitializeBoard()==false){ return false;} //if board is not initialized correctly return false
//        else if(selcetedLokum1 != null || selectedLokum2 != null ){ return false;} //if selected lokums are not null at start return false
//        else if(getRemainingMove() <= 0 ){ return false;} //if there is no moves to make return false
//        else if(getScore() !=0 ){ return false;}//if score is not zero at start return false
//        else if( getObjective() <= 0){ return false;} //returns false if the objective is done
//        else{return true;}
//    }
//    public boolean repOKAfterSelection(){
//        if (areLokumsSwappable()==false){return false;} //if not adjacent return false
//        else if(gameState!=0){return false;}// game is not playable either paused or an error
//        else{return true;}
//    }
//
//    public boolean repOKAfterSwap(){
//        if (board.repOkAfterInitializeBoard()==false){ return false;} //if board is not correct return false
//        else if(selcetedLokum1 != null || selectedLokum2 != null ){ return false;}
//        else if(gameState!=0){return false;}
//        else{return true;}
//    }
//
//    public boolean repOKAfterDestroy(){
//        if (board.repOkAfterLokumsDestroyed()==false){ return false;} //if board is not repOK after lokum destroy correctly return false
//        else if(selcetedLokum1 != null || selectedLokum2 != null ){ return false;}
//        else if(getScore() <= 0 ){ return false;} //if not bigger than 0 score is not updated correctly return false
//        else if(foreachElementInBoard[0][0] == EmptySpace() ){ return false;}// if boards top has empty spaces return false since no lokums are genrated
//        else if(gameState!=0){return false;}
//        else{return true;}
//    }
//
//
//
//    public String toString(){
//        String result = "GamePlay.toString \n";
//        result += "Game State:" + gameState   +"\n";
//        result += "Score:"+  getScore()   +"\n";
//        result += "Remaining Moves:"+  getRemainingMove()   +"\n";
//        result += "Objective:"+  getObjective()   +"\n";
//        result += "Board :" + board.toString() +"\n";
//        result += "Selected Lokums:" + selectedLokum1.toString() + selectedLokum2.toString() +"\n";
//        return result;
//    }

}
