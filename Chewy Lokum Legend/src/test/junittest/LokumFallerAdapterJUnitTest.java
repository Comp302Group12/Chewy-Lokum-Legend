package test.junittest;

import static org.junit.Assert.*;

import java.awt.Color;

import model.Board;
import model.GamePlay;
import model.adapter.LokumFallerAdapter;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LokumFallerAdapterJUnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLokumFallerAdapter() {
		
		
	}

	@Test
	public void testFallLokums() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(500, 500, boardShape);
		
		
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[0][1].setColor(Color.RED);
		board.lokumArray[0][2].setColor(Color.GREEN);
		
		board.lokumArray[1][0].setColor(Color.YELLOW);
		board.lokumArray[1][1].setColor(Color.YELLOW);
		board.lokumArray[1][2].setColor(Color.YELLOW);
		
		board.lokumArray[2][0].setColor(Color.RED);
		board.lokumArray[2][1].setColor(Color.RED);
		board.lokumArray[2][2].setColor(Color.RED);
		
		GamePlay gamePlay = new GamePlay(board);
		
		System.out.println(gamePlay.board.lokumArray[0][0].getColor());
		System.out.println(gamePlay.board.lokumArray[0][1].getColor());
		System.out.println(gamePlay.board.lokumArray[0][2].getColor());
		
		Color x = gamePlay.board.lokumArray[0][0].getColor();
		Color y = gamePlay.board.lokumArray[0][1].getColor();
		Color z = gamePlay.board.lokumArray[0][2].getColor();
		
		gamePlay.doesBoardHaveCombination();
		System.out.println(gamePlay.doesBoardHaveCombination());
		
		gamePlay.destroyExistingCombinations();
		
		LokumFallerAdapter test = new LokumFallerAdapter();
		test.fallLokums(gamePlay);
		
		while(test.isFallInProgress()) {
			System.out.println("in progress ");
		}
		
		
		System.out.println(" ");
		System.out.println(gamePlay.board.lokumArray[2][0].getColor());
		System.out.println(gamePlay.board.lokumArray[2][1].getColor());
		System.out.println(gamePlay.board.lokumArray[2][2].getColor());
		
		boolean isTrue;
		if (x==gamePlay.board.lokumArray[2][0].getColor() &&
				y==gamePlay.board.lokumArray[2][1].getColor() &&
				z==gamePlay.board.lokumArray[2][2].getColor()){
			isTrue = true;
		} else {
			isTrue = false;
		}
		System.out.println(isTrue);
		
		assertTrue(isTrue);
	}

	@Test
	public void testPutRandomLokumsToTopRow() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(500, 500, boardShape);
		
		
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[0][1].setColor(Color.RED);
		board.lokumArray[0][2].setColor(Color.GREEN);
		
		board.lokumArray[1][0].setColor(Color.YELLOW);
		board.lokumArray[1][1].setColor(Color.YELLOW);
		board.lokumArray[1][2].setColor(Color.YELLOW);
		
		board.lokumArray[2][0].setColor(Color.RED);
		board.lokumArray[2][1].setColor(Color.RED);
		board.lokumArray[2][2].setColor(Color.RED);
		
		GamePlay gamePlay = new GamePlay(board);
		
		System.out.println(gamePlay.board.lokumArray[0][0].getColor());
		System.out.println(gamePlay.board.lokumArray[0][1].getColor());
		System.out.println(gamePlay.board.lokumArray[0][2].getColor());
		
		Color x = gamePlay.board.lokumArray[0][0].getColor();
		Color y = gamePlay.board.lokumArray[0][1].getColor();
		Color z = gamePlay.board.lokumArray[0][2].getColor();
		
		gamePlay.doesBoardHaveCombination();
		System.out.println(gamePlay.doesBoardHaveCombination());
		
		gamePlay.destroyExistingCombinations();
		
		LokumFallerAdapter test = new LokumFallerAdapter();
		test.fallLokums(gamePlay);
		test.putRandomLokumsToTopRow();
		
		while(test.isFallInProgress()) {
			System.out.println("in progress ");
		}
		
		
		System.out.println(" ");
		System.out.println(gamePlay.board.lokumArray[0][0].getColor());
		System.out.println(gamePlay.board.lokumArray[0][1].getColor());
		System.out.println(gamePlay.board.lokumArray[0][2].getColor());
		
		boolean isTrue;
		if (x==gamePlay.board.lokumArray[0][0].getColor() &&
				y==gamePlay.board.lokumArray[0][1].getColor() &&
				z==gamePlay.board.lokumArray[0][2].getColor()){
			isTrue = false;
		} else {
			isTrue = true;
		}
		System.out.println(isTrue);
		
		assertTrue(isTrue);
	}

	@Test
	public void testFindLokumsWhichNeedToFall() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				};
		
		Board board = new Board(500, 500, boardShape);
		
		
		board.lokumArray[0][0].setColor(Color.BLUE);
		board.lokumArray[0][1].setColor(Color.RED);
		board.lokumArray[0][2].setColor(Color.GREEN);
		
		board.lokumArray[1][0].setColor(Color.YELLOW);
		board.lokumArray[1][1].setColor(Color.YELLOW);
		board.lokumArray[1][2].setColor(Color.YELLOW);
		
		GamePlay gamePlay = new GamePlay(board);
		
		System.out.println(gamePlay.board.lokumArray[0][0].getColor());
		System.out.println(gamePlay.board.lokumArray[0][1].getColor());
		System.out.println(gamePlay.board.lokumArray[0][2].getColor());
		
		Color x = gamePlay.board.lokumArray[0][0].getColor();
		Color y = gamePlay.board.lokumArray[0][1].getColor();
		Color z = gamePlay.board.lokumArray[0][2].getColor();
		
		gamePlay.doesBoardHaveCombination();
		System.out.println(gamePlay.doesBoardHaveCombination());
		
		gamePlay.destroyExistingCombinations();
		
		LokumFallerAdapter test = new LokumFallerAdapter();
		test.fallLokums(gamePlay);
		test.findLokumsWhichNeedToFall();
		
		while(test.isFallInProgress()) {
			System.out.println("in progress ");
		}
		
		
		System.out.println(" ");
		System.out.println(gamePlay.board.lokumArray[0][0].getColor());
		System.out.println(gamePlay.board.lokumArray[0][1].getColor());
		System.out.println(gamePlay.board.lokumArray[0][2].getColor());
		
		boolean isTrue;
		if (x==gamePlay.board.lokumArray[1][0].getColor() &&
				y==gamePlay.board.lokumArray[1][1].getColor() &&
				z==gamePlay.board.lokumArray[1][2].getColor()){
			isTrue = true;
		} else {
			isTrue = false;
		}
		System.out.println(isTrue);
		assertTrue(isTrue);
	}

	@Test
	public void testStopFalling() {
		//fail("Not yet implemented");
	}

	@Test
	public void testIsFallNeeded() {
		//fail("Not yet implemented");
	}

	@Test
	public void testIsFallInProgress() {
		//fail("Not yet implemented");
	}

	@Test
	public void testIsTest() {
		//fail("Not yet implemented");
	}


}
