package test.junittest.blackboxtest;

import static org.junit.Assert.*;

import java.awt.Color;

import model.Board;
import model.GamePlay;
import model.adapter.LokumCombinationAdapter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LokumCombinationAdapterJUnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPlaceSpecialLokums() {
//		fail("Not yet implemented");
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				};
		
		Board board = new Board(500, 500, boardShape);
		
		//Forming Striped Lokum
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[1][0].setColor(Color.BLUE);
		board.lokumArray[2][0].setColor(Color.BLUE);
		board.lokumArray[3][0].setColor(Color.BLUE);
		
		//Forming Color Bomb Lokum
		board.lokumArray[4][0].setColor(Color.BLUE);
		board.lokumArray[4][1].setColor(Color.BLUE);
		board.lokumArray[4][2].setColor(Color.BLUE);
		board.lokumArray[4][3].setColor(Color.BLUE);
		board.lokumArray[4][4].setColor(Color.BLUE);
		
		GamePlay gamePlay = new GamePlay(board);
		
		assertTrue(gamePlay.doesBoardHaveCombination());
		gamePlay.placeSpecialLokums();
	}

	@Test
	public void testSearchCombinationsToFormSpecialLokums() {
//		fail("Not yet implemented");
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				};
		
		Board board = new Board(500, 500, boardShape);
		
		//Forming Striped Lokum
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[1][0].setColor(Color.BLUE);
		board.lokumArray[2][0].setColor(Color.BLUE);
		board.lokumArray[3][0].setColor(Color.BLUE);
		
		//Forming Color Bomb Lokum
		board.lokumArray[4][0].setColor(Color.BLUE);
		board.lokumArray[4][1].setColor(Color.BLUE);
		board.lokumArray[4][2].setColor(Color.BLUE);
		board.lokumArray[4][3].setColor(Color.BLUE);
		board.lokumArray[4][4].setColor(Color.BLUE);
		
		GamePlay gamePlay = new GamePlay(board);
		LokumCombinationAdapter tester = new LokumCombinationAdapter();
		
		assertTrue(gamePlay.doesBoardHaveCombination());
		tester.searchCombinationsToFormSpecialLokums();
		gamePlay.placeSpecialLokums();
	}

	@Test
	public void testSearchRowCombinationToFormWrappedLokum() {
//		fail("Not yet implemented");
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum", "Normal Lokum"},
				};
		
		Board board = new Board(500, 500, boardShape);
		
		//Forming Wrapped Lokum
		board.lokumArray[0][1].setColor(Color.BLUE);
		board.lokumArray[1][1].setColor(Color.BLUE);
		board.lokumArray[1][2].setColor(Color.BLUE);
		board.lokumArray[2][0].setColor(Color.BLUE);
		board.lokumArray[2][2].setColor(Color.BLUE);
		
		GamePlay gamePlay = new GamePlay(board);
		LokumCombinationAdapter tester = new LokumCombinationAdapter();
		//doesBoardHaveCombination(), searchRowCombinationToFormWrappedLokum() icin tarama yapmiyor.
		//Muhtemelen burada bir sorun cikabilir.
		assertTrue(gamePlay.doesBoardHaveCombination());
//		tester.searchRowCombinationToFormWrappedLokum(); //Boyle birseye ihtiyac varsa...
		gamePlay.placeSpecialLokums();
	}

	@Test
	public void testDoesBoardHaveCombination() {
//		fail("Not yet implemented");
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(300, 300, boardShape);	
		
		//Checking the second row
		board.lokumArray[1][0].setColor(Color.BLUE);
		board.lokumArray[1][1].setColor(Color.BLUE);
		board.lokumArray[1][2].setColor(Color.BLUE);
		
		GamePlay gamePlay = new GamePlay(board);
		LokumCombinationAdapter tester = new LokumCombinationAdapter();
		
		assertTrue(gamePlay.doesBoardHaveCombination());
		tester.doesBoardHaveCombination(gamePlay);
	}

	@Test
	public void testFindCombinations() {
//		fail("Not yet implemented");
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum", "Normal Lokum"},
				};
		
		Board board = new Board(400, 400, boardShape);	
		
		//Checking the first row
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[0][1].setColor(Color.BLUE);
		board.lokumArray[0][2].setColor(Color.BLUE);
		
		//Checking the fourth column
		board.lokumArray[3][0].setColor(Color.BLUE);
		board.lokumArray[3][1].setColor(Color.BLUE);
		board.lokumArray[3][2].setColor(Color.BLUE);
		
		GamePlay gamePlay = new GamePlay(board);
		LokumCombinationAdapter tester = new LokumCombinationAdapter();
		
		assertTrue(gamePlay.doesBoardHaveCombination());
		tester.findCombinations();
	}

	@Test
	public void testFindRowCombinations() {
//		fail("Not yet implemented");
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(300, 300, boardShape);	
		
		//Checking the second row
		board.lokumArray[1][0].setColor(Color.BLUE);
		board.lokumArray[1][1].setColor(Color.BLUE);
		board.lokumArray[1][2].setColor(Color.BLUE);
		
		GamePlay gamePlay = new GamePlay(board);
		LokumCombinationAdapter tester = new LokumCombinationAdapter();
		
		assertTrue(gamePlay.doesBoardHaveCombination());
		tester.findRowCombinations();
	}

	@Test
	public void testFindColumnCombinations() {
//		fail("Not yet implemented");
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(300, 300, boardShape);	
		
		//Checking the second column
		board.lokumArray[0][1].setColor(Color.BLUE);
		board.lokumArray[1][1].setColor(Color.BLUE);
		board.lokumArray[2][1].setColor(Color.BLUE);
		
		GamePlay gamePlay = new GamePlay(board);
		LokumCombinationAdapter tester = new LokumCombinationAdapter();
		
		assertTrue(gamePlay.doesBoardHaveCombination());
		tester.findColumnCombinations();
	}

}
