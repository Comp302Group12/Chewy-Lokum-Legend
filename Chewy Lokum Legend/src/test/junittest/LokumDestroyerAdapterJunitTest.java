/*package test.junittest;

import static org.junit.Assert.*;

import java.awt.Color;

import model.Board;
import model.GamePlay;
import model.lokum.DestroyedLokum;
import model.lokum.NormalLokum;
import model.lokum.StripedLokum;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LokumDestroyerAdapterJunitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDestroyExistingCombinations() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(300, 300, boardShape);
		
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[0][1].setColor(Color.BLUE);
		board.lokumArray[0][2].setColor(Color.BLUE);
		board.lokumArray[1][0].setColor(Color.GREEN);
		board.lokumArray[1][1].setColor(Color.GREEN);
		board.lokumArray[1][2].setColor(Color.BLUE);
		board.lokumArray[2][0].setColor(Color.RED);
		board.lokumArray[2][1].setColor(Color.BLUE);
		board.lokumArray[2][2].setColor(Color.RED);
		
		GamePlay gamePlay = new GamePlay(board);
		gamePlay.doesBoardHaveCombination();
		gamePlay.destroyExistingCombinations();
		boolean istrue = (board.lokumArray[0][0] instanceof DestroyedLokum && 
				board.lokumArray[0][1] instanceof DestroyedLokum && 
				board.lokumArray[0][2] instanceof DestroyedLokum && 
				board.lokumArray[2][2] instanceof NormalLokum);
		assertTrue(istrue);
	}

	@Test
	public void testDestroyNormalLokum() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(300, 300, boardShape);
		
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[0][1].setColor(Color.BLUE);
		board.lokumArray[0][2].setColor(Color.BLUE);
		board.lokumArray[1][0].setColor(Color.GREEN);
		board.lokumArray[1][1].setColor(Color.GREEN);
		board.lokumArray[1][2].setColor(Color.BLUE);
		board.lokumArray[2][0].setColor(Color.RED);
		board.lokumArray[2][1].setColor(Color.BLUE);
		board.lokumArray[2][2].setColor(Color.RED);
		
		GamePlay gamePlay = new GamePlay(board);
		gamePlay.doesBoardHaveCombination();
		gamePlay.destroyExistingCombinations();
		boolean istrue = (board.lokumArray[0][0] instanceof DestroyedLokum && 
				board.lokumArray[0][1] instanceof DestroyedLokum && 
				board.lokumArray[0][2] instanceof DestroyedLokum && 
				board.lokumArray[2][2] instanceof NormalLokum);
		assertTrue(istrue);
	}

	@Test
	public void testDestroyStripedLokum() {
		String[][] boardShape = {
				{"NormalLokum", "StripedLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(300, 300, boardShape);
		
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[0][1].setColor(Color.BLUE);
		
	((StripedLokum)	board.lokumArray[0][1]).setHorizontal(false);
		board.lokumArray[0][2].setColor(Color.BLUE);
		board.lokumArray[1][0].setColor(Color.GREEN);
		board.lokumArray[1][1].setColor(Color.GREEN);
		board.lokumArray[1][2].setColor(Color.BLUE);
		board.lokumArray[2][0].setColor(Color.RED);
		board.lokumArray[2][1].setColor(Color.BLUE);
		board.lokumArray[2][2].setColor(Color.RED);
		
		GamePlay gamePlay = new GamePlay(board);
		gamePlay.doesBoardHaveCombination();
		gamePlay.destroyExistingCombinations();
		boolean istrue = (board.lokumArray[0][1] instanceof DestroyedLokum && 
				board.lokumArray[1][1] instanceof DestroyedLokum && 
				board.lokumArray[2][1] instanceof DestroyedLokum);
		assertTrue(istrue);
	}

	@Test
	public void testDestroyWrappedLokum() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "WrappedLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(300, 300, boardShape);
		
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[0][1].setColor(Color.YELLOW);
		board.lokumArray[0][2].setColor(Color.BLUE);
		board.lokumArray[1][0].setColor(Color.GREEN);
		board.lokumArray[1][1].setColor(Color.GREEN);
		board.lokumArray[1][2].setColor(Color.GREEN);
		board.lokumArray[2][0].setColor(Color.RED);
		board.lokumArray[2][1].setColor(Color.BLUE);
		board.lokumArray[2][2].setColor(Color.RED);
		
		GamePlay gamePlay = new GamePlay(board);
		gamePlay.doesBoardHaveCombination();
		gamePlay.destroyExistingCombinations();
		
		boolean istrue = (board.lokumArray[0][0] instanceof DestroyedLokum && 
				board.lokumArray[0][1] instanceof DestroyedLokum && 
				board.lokumArray[0][2] instanceof DestroyedLokum && 
				board.lokumArray[1][0] instanceof DestroyedLokum && 
				board.lokumArray[1][1] instanceof DestroyedLokum && 
				board.lokumArray[1][2] instanceof DestroyedLokum && 
				board.lokumArray[2][0] instanceof DestroyedLokum && 
				board.lokumArray[2][1] instanceof DestroyedLokum && 
				board.lokumArray[2][2] instanceof DestroyedLokum );
		assertTrue(istrue);
	}

	@Test
	public void testDestroyColorBombLokum() {
		fail("Not yet implemented");
	}

}
*/