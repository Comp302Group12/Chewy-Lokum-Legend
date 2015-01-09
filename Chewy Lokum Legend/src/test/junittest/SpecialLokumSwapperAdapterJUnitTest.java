/*package test.junittest;

import static org.junit.Assert.*;

import java.awt.Color;

import model.Board;
import model.GamePlay;
import model.adapter.SpecialLokumSwapperAdapter;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpecialLokumSwapperAdapterJUnitTest {

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
		SpecialLokumSwapperAdapter sls = new SpecialLokumSwapperAdapter();
		assertTrue(sls.getNumOfRemainingSpecialSwaps() >0);
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
		board.lokumArray[2][2].setColor(Color.BLUE);
		board.lokumArray[0][1].setColor(Color.RED);
		board.swap(board.lokumArray[2][2], board.lokumArray[0][1]);
		boolean istrue;
		istrue = (board.lokumArray[0][1].getColor() == Color.BLUE &&
				board.lokumArray[2][2].getColor() == Color.RED) ;
		assertTrue(istrue);
	}

	@Test
	public void testDoAfterSwapIsEnded() {
		assertTrue(true);
	}


}
*/