package test.junittest.blackboxtest;

import static org.junit.Assert.*;

import java.awt.Color;

import model.Board;
import model.GamePlay;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RegularLokumSwapperAdapterJUnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCheckConditions() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoBeforeSwapIsStarted() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoAfterSwapIsEnded() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegularLokumSwapperAdapter() {
		fail("Not yet implemented");
	}

	@Test
	public void testSwapBack() {
		fail("Not yet implemented");
	}

	@Test
	public void testLokumSwapperAdapter() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsSwapInProgres() {
		fail("Not yet implemented");
	}

	@Test
	public void testSwapLokums() {
		fail("Not yet implemented");
	}

	@Test
	public void testStartSwap() {
		fail("Not yet implemented");
	}

	@Test
	public void testStopSwap() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancelSwap() {
		//fail("Not yet implemented");
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(300, 300, boardShape);
		
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[0][1].setColor(Color.BLUE);
		board.lokumArray[0][2].setColor(Color.BLUE);
		
		GamePlay gamePlay = new GamePlay(board);
		
		assertTrue(gamePlay.doesBoardHaveCombination());
	}

}
