package test.junittest.blackboxtest;

import static org.junit.Assert.*;

import java.awt.Color;

import model.Board;
import model.GamePlay;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LokumSwapperAdapterJUnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCheckConditions() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(300, 300, boardShape);		
		GamePlay gamePlay = new GamePlay(board);
		boolean istrue;
		istrue = (board.areLokumsAdjacent(board.lokumArray[0][0], board.lokumArray[1][1]) &&
				board.areLokumsAdjacent(board.lokumArray[0][0], board.lokumArray[0][1]) &&
				board.areLokumsAdjacent(board.lokumArray[0][0], board.lokumArray[1][0]) &&
				board.areLokumsAdjacent(board.lokumArray[2][1], board.lokumArray[2][2]) &&
				!(board.areLokumsAdjacent(board.lokumArray[0][0], board.lokumArray[2][2])) &&		
				!(board.areLokumsAdjacent(board.lokumArray[0][0], board.lokumArray[2][1]))
								);
		assertTrue(istrue);
	}

	@Test
	public void testDoBeforeSwapIsStarted() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(300, 300, boardShape);		
		GamePlay gamePlay = new GamePlay(board);
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[0][1].setColor(Color.RED);
		board.swap(board.lokumArray[0][0], board.lokumArray[0][1]);
		boolean istrue;
		istrue = (board.lokumArray[0][1].getColor() == Color.BLUE &&
				board.lokumArray[0][0].getColor() == Color.RED) ;
		assertTrue(istrue);
	}

	@Test
	public void testDoAfterSwapIsEnded() {

		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(300, 300, boardShape);		
		GamePlay gamePlay = new GamePlay(board);
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[0][1].setColor(Color.RED);
		board.lokumArray[0][2].setColor(Color.GREEN);
		board.lokumArray[1][0].setColor(Color.RED);
		board.lokumArray[1][1].setColor(Color.GREEN);
		board.lokumArray[1][2].setColor(Color.BLUE);
		board.lokumArray[2][0].setColor(Color.RED);
		board.lokumArray[2][1].setColor(Color.RED);
		board.lokumArray[2][2].setColor(Color.YELLOW);
		board.swap(board.lokumArray[0][0], board.lokumArray[0][1]);
		if(!gamePlay.doesBoardHaveCombination()){
			board.swap(board.lokumArray[0][0], board.lokumArray[0][1]);
		}
		boolean istrue;
		istrue = (board.lokumArray[0][1].getColor() == Color.BLUE &&
				board.lokumArray[0][0].getColor() == Color.RED) ;
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[0][1].setColor(Color.RED);
		board.swap(board.lokumArray[2][2], board.lokumArray[2][1]);
		if(!gamePlay.doesBoardHaveCombination()){
			board.swap(board.lokumArray[2][2], board.lokumArray[2][1]);
		}
		boolean istrue2 = board.lokumArray[2][2].getColor() == Color.YELLOW;
		assertTrue(istrue && istrue2);
		
	}

	@Test
	public void testLokumSwapperAdapter() {
	//	fail("Not yet implemented");
	}

	@Test
	public void testIsSwapInProgres() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSwapLokums() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(300, 300, boardShape);		
		GamePlay gamePlay = new GamePlay(board);
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[0][1].setColor(Color.RED);
		board.swap(board.lokumArray[0][0], board.lokumArray[0][1]);
		boolean istrue;
		istrue = (board.lokumArray[0][1].getColor() == Color.BLUE &&
				board.lokumArray[0][0].getColor() == Color.RED) ;
		assertTrue(istrue);
	}

}
