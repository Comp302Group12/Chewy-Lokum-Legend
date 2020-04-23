package junittest;

import model.Board;
import model.lokum.Lokum;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import assertion.BoardAssertions;
import assertion.LokumAssertions;

import static org.junit.Assert.assertTrue;

public class BoardJUnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFillBoardRandomly() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);		
		board.fillBoardRandomly();		
		BoardAssertions ba = new BoardAssertions();		
		assertTrue(ba.isValid(board));
	}

	@Test
	public void testCreateRandomLokum() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);
		Lokum lokum = board.createRandomLokum("NormalLokum", 0, 0);
		LokumAssertions la = new LokumAssertions();
		assertTrue(la.isValid(lokum));
	}

	@Test
	public void testGetLokumArrayCoordinatesOfLokumAtPosition() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);
		board.fillBoardRandomly();
		Lokum lokum = board.lokumArray[0][0];
		int[] coor = board.getLokumArrayCoordinatesOfLokumAtPosition(lokum.getX(), lokum.getY());
		boolean test = false;
		if(coor[0]==0 && coor[1]==0) test = true;
		assertTrue(test);
	}

	@Test
	public void testGetLokumArrayCoordinatesOfLokum() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);
		board.fillBoardRandomly();
		Lokum lokum = board.lokumArray[0][0];
		int[] coor = board.getLokumArrayCoordinatesOfLokum(lokum);
		boolean test = false;
		if(coor[0]==0 && coor[1]==0) test = true;
		assertTrue(test);
	}

	@Test
	public void testLokumAtPosition() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);
		board.fillBoardRandomly();
		Lokum lokum = board.lokumArray[0][0];
		Lokum lokum2 = board.lokumAtPosition(lokum.getX(), lokum.getY());
		LokumAssertions la = new LokumAssertions();
		assertTrue(la.equals(lokum, lokum2));
	}

	@Test
	public void testSwap() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);
		board.fillBoardRandomly();
		Lokum lokum0 = board.lokumArray[0][0];
		Lokum lokum1 = board.lokumArray[0][1];
		board.swap(lokum0, lokum1);
		LokumAssertions la = new LokumAssertions();
		assertTrue(la.equals(lokum0, board.lokumArray[0][1]));
	}

	@Test
	public void testAreLokumsAdjacent() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);
		board.fillBoardRandomly();
		Lokum lokum0 = board.lokumArray[0][0];
		Lokum lokum1 = board.lokumArray[0][1];
		assertTrue(board.areLokumsAdjacent(lokum0, lokum1));
	}

	@Test
	public void testGetTopAdjacentOfLokum() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);
		board.fillBoardRandomly();
		Lokum lokum = board.lokumArray[1][1];
		Lokum topAdjacent = board.lokumArray[0][1];
		LokumAssertions la = new LokumAssertions();
		assertTrue(la.equals(board.getTopAdjacentOfLokum(lokum), topAdjacent));
	}

	@Test
	public void testGetBottomAdjacentOfLokum() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);
		board.fillBoardRandomly();
		Lokum lokum = board.lokumArray[1][1];
		Lokum bottomAdjacent = board.lokumArray[2][1];
		LokumAssertions la = new LokumAssertions();
		assertTrue(la.equals(board.getBottomAdjacentOfLokum(lokum), bottomAdjacent));
	}

	@Test
	public void testGetLeftAdjacentOfLokum() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);
		board.fillBoardRandomly();
		Lokum lokum = board.lokumArray[1][1];
		Lokum leftAdjacent = board.lokumArray[1][0];
		LokumAssertions la = new LokumAssertions();
		assertTrue(la.equals(board.getLeftAdjacentOfLokum(lokum), leftAdjacent));
	}

	@Test
	public void testGetRightAdjacentOfLokum() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);
		board.fillBoardRandomly();
		Lokum lokum = board.lokumArray[1][1];
		Lokum rightAdjacent = board.lokumArray[1][2];
		LokumAssertions la = new LokumAssertions();
		assertTrue(la.equals(board.getRightAdjacentOfLokum(lokum), rightAdjacent));
	}

	@Test
	public void testGetUpperLeftAdjacentOfLokum() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);
		board.fillBoardRandomly();
		Lokum lokum = board.lokumArray[1][1];
		Lokum upperLeftAdjacent = board.lokumArray[0][0];
		LokumAssertions la = new LokumAssertions();
		assertTrue(la.equals(board.getUpperLeftAdjacentOfLokum(lokum), upperLeftAdjacent));
	}

	@Test
	public void testGetUpperRightAdjacentOfLokum() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);
		board.fillBoardRandomly();
		Lokum lokum = board.lokumArray[1][1];
		Lokum upperRightAdjacent = board.lokumArray[0][2];
		LokumAssertions la = new LokumAssertions();
		assertTrue(la.equals(board.getUpperRightAdjacentOfLokum(lokum), upperRightAdjacent));
	}

	@Test
	public void testGetLowerLeftAdjacentOfLokum() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);
		board.fillBoardRandomly();
		Lokum lokum = board.lokumArray[1][1];
		Lokum lowerLeftAdjacent = board.lokumArray[2][0];
		LokumAssertions la = new LokumAssertions();
		assertTrue(la.equals(board.getLowerLeftAdjacentOfLokum(lokum), lowerLeftAdjacent));
	}

	@Test
	public void testGetLowerRightAdjacentOfLokum() {
		String[][] boardShape = {
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
				{"NormalLokum", "NormalLokum", "NormalLokum"},
		};		
		Board board = new Board(300, 300, boardShape);
		board.fillBoardRandomly();
		Lokum lokum = board.lokumArray[1][1];
		Lokum lowerRightAdjacent = board.lokumArray[2][2];
		LokumAssertions la = new LokumAssertions();
		assertTrue(la.equals(board.getLowerRightAdjacentOfLokum(lokum), lowerRightAdjacent));
	}

}
