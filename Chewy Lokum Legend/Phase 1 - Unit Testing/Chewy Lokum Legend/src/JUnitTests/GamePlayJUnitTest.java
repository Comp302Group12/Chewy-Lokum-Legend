package JUnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GamePlayJUnitTest {

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
	public void testSelectLokum() {
		Lokum[][] boardAsAnArray = new Lokum[5][5];
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				boardAsAnArray[i][j] = new EmptySpace();
			}
		}
		Lokum lokum1 = new NormalLokum();
		lokum1.setLokum(1,0,0);
		boardAsAnArray[0][0] = lokum1;
		GamePlay game = new GamePlay();
		game.board.getInstance().setBoardArray(boardAsAnArray);
		game.selectLokum(0,0);
		assertTrue(game.selectedLokum1.getColor() == 1);

	}

	@Test
	public void testUnselectLokums() {
		Lokum[][] boardAsAnArray = new Lokum[5][5];
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				boardAsAnArray[i][j] = new EmptySpace();
			}
		}
		Lokum lokum1 = new NormalLokum();
		lokum1.setLokum(1,0,0);
		boardAsAnArray[0][0] = lokum1;
		Lokum lokum2 = new NormalLokum();
		lokum1.setLokum(2,0,1);
		boardAsAnArray[0][1] = lokum2;
		GamePlay game = new GamePlay();
		game.board.getInstance().setBoardArray(boardAsAnArray);
		game.selectLokum(0,0);
		game.selectLokum(0,1);
		game.unselectLokums();
		assertTrue(game.selectedLokum1.getColor() != 1 && game.selectedLokum1.getColor() != 2);
	}

	@Test
	public void testAreLookumsSwappable() {
		Lokum[][] boardAsAnArray = new Lokum[5][5];
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				boardAsAnArray[i][j] = new EmptySpace();
			}
		}
		Lokum lokum1 = new NormalLokum();
		lokum1.setLokum(1,0,0);
		boardAsAnArray[0][0] = lokum1;
		Lokum lokum2 = new NormalLokum();
		lokum1.setLokum(2,0,1);
		boardAsAnArray[0][1] = lokum2;
		Lokum lokum3 = new NormalLokum();
		lokum3.setLokum(3,0,2);
		boardAsAnArray[0][2] = lokum3;
		GamePlay game = new GamePlay();
		game.board.getInstance().setBoardArray(boardAsAnArray);
		game.selectLokum(0,0);
		game.selectLokum(0,1);
		assertTrue(!game.areLokumsSwappable());
	}

	@Test
	public void testGetWhichSpecialCombination() {
		Lokum[][] boardAsAnArray = new Lokum[5][5];
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				boardAsAnArray[i][j] = new EmptySpace();
			}
		}
		Lokum lokum1 = new NormalLokum();
		lokum1.setLokum(1,0,0);
		boardAsAnArray[0][0] = lokum1;
		Lokum lokum2 = new NormalLokum();
		lokum2.setLokum(2,0,1);
		boardAsAnArray[0][1] = lokum2;
		Lokum lokum3 = new StripedLokum();
		lokum3.setLokum(3,0,2);
		lokum3.isHorizantal = true;
		boardAsAnArray[0][2] = lokum3;
		Lokum lokum4 = new StripedLokum();
		lokum4.setLokum(4,0,3);
		lokum4.isHorizantal = false;
		boardAsAnArray[0][3] = lokum4;
		Lokum lokum5 = new NormalLokum();
		lokum5.setLokum(1,0,4);
		boardAsAnArray[0][4] = lokum5;
		Lokum lokum6 = new NormalLokum();
		lokum6.setLokum(1,1,3);
		boardAsAnArray[1][3] = lokum6;
		Lokum lokum7 = new NormalLokum();
		lokum7.setLokum(2,2,3);
		boardAsAnArray[2][3] = lokum7;
		Lokum lokum8 = new NormalLokum();
		lokum8.setLokum(3,3,3);
		boardAsAnArray[3][3] = lokum8;
		Lokum lokum9 = new NormalLokum();
		lokum9.setLokum(4,4,3);
		boardAsAnArray[4][3] = lokum9;		
		GamePlay game = new GamePlay();
		game.board.getInstance().setBoardArray(boardAsAnArray);
		game.selectLokum(0,2);
		game.selectLokum(0,3);
		game.destroySpecialCombinationLokum(game.getWhichSpecialCombination(game.selectedLokum1, game.selectedLokum2));
		assertTrue(boardAsAnArray[0][4].getColor != 1 && boardAsAnArray[4][3].getColor != 4);
	}

	@Test
	public void testSwapSelectedLokums() {
		Lokum[][] boardAsAnArray = new Lokum[10][10];
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				boardAsAnArray[i][j] = new EmptySpace();
			}
		}
		Lokum lokum1 = new NormalLokum();
		lokum1.setLokum(1,0,0);
		boardAsAnArray[0][0] = lokum1;
		Lokum lokum2 = new NormalLokum();
		lokum2.setLokum(1,0,1);
		boardAsAnArray[0][1] = lokum2;
		Lokum lokum3 = new NormalLokum();
		lokum3.setLokum(2,0,2);
		boardAsAnArray[0][2] = lokum3;
		Lokum lokum4 = new NormalLokum();
		lokum4.setLokum(1,0,3);
		boardAsAnArray[0][3] = lokum4;
		GamePlay game = new GamePlay();
		game.board.getInstance().setBoardArray(boardAsAnArray);
		game.selectLokum(0,2);
		game.selectLokum(0,3);
		game.swapSelectedLokums();
		assertTrue(boardAsAnArray[0][3].getColor() != 1);
	}

	@Test
	public void testCheckObjective() {
		GamePlay game = new GamePlay();
		game.setObjective(1, 10);
		assertTrue(!game.checkObjective());
	}

	@Test
	public void testCheckDestroyableLokums() {
		Lokum[][] boardAsAnArray = new Lokum[10][10];
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				boardAsAnArray[i][j] = new EmptySpace();
			}
		}
		Lokum lokum1 = new NormalLokum();
		lokum1.setLokum(1,0,0);
		boardAsAnArray[0][0] = lokum1;
		Lokum lokum2 = new NormalLokum();
		lokum2.setLokum(1,0,1);
		boardAsAnArray[0][1] = lokum2;
		Lokum lokum3 = new NormalLokum();
		lokum3.setLokum(1,0,2);
		boardAsAnArray[0][2] = lokum3;
		GamePlay game = new GamePlay();
		game.board.getInstance().setBoardArray(boardAsAnArray);
		assertTrue(game.checkDestroyableLokums());
	}

	@Test
	public void testDestroySwappedLokums() {		
		Lokum[][] boardAsAnArray = new Lokum[10][10];
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				boardAsAnArray[i][j] = new EmptySpace();
			}
		}
		Lokum lokum1 = new NormalLokum();
		lokum1.setLokum(1,0,0);
		boardAsAnArray[0][0] = lokum1;
		Lokum lokum2 = new NormalLokum();
		lokum2.setLokum(1,0,1);
		boardAsAnArray[0][1] = lokum2;
		Lokum lokum3 = new NormalLokum();
		lokum3.setLokum(2,0,2);
		boardAsAnArray[0][2] = lokum3;
		Lokum lokum4 = new NormalLokum();
		lokum4.setLokum(1,0,3);
		boardAsAnArray[0][3] = lokum4;
		GamePlay game = new GamePlay();
		game.board.getInstance().setBoardArray(boardAsAnArray);
		game.selectLokum(0,2);
		game.selectLokum(0,3);
		game.swapSelectedLokums();
		game.destroySwappedLokums();
		assertTrue(boardAsAnArray[0][0].getColor() != 1);
	}

	@Test
	public void testDestroyLokums() {
		Lokum[][] boardAsAnArray = new Lokum[10][10];
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				boardAsAnArray[i][j] = new EmptySpace();
			}
		}
		Lokum lokum1 = new NormalLokum();
		lokum1.setLokum(1,0,0);
		boardAsAnArray[0][0] = lokum1;
		Lokum lokum2 = new NormalLokum();
		lokum2.setLokum(1,0,1);
		boardAsAnArray[0][1] = lokum2;
		Lokum lokum3 = new NormalLokum();
		lokum3.setLokum(1,0,2);
		boardAsAnArray[0][2] = lokum3;
		GamePlay game = new GamePlay();
		game.board.getInstance().setBoardArray(boardAsAnArray);
		game.destroyLokums();
		assertTrue(!game.checkDestroyableLokums());
	}

	@Test
	public void testDestroyStreakLokums() {
		Lokum[][] boardAsAnArray = new Lokum[10][10];
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				boardAsAnArray[i][j] = new EmptySpace();
			}
		}
		Lokum lokum1 = new NormalLokum();
		lokum1.setLokum(1,0,0);
		boardAsAnArray[0][0] = lokum1;
		Lokum lokum2 = new NormalLokum();
		lokum2.setLokum(1,0,1);
		boardAsAnArray[0][1] = lokum2;
		Lokum lokum3 = new StripedLokum();
		lokum3.setLokum(1,0,2);
		lokum3.isHorizantal = true;
		boardAsAnArray[0][2] = lokum3;
		Lokum lokum4 = new NormalLokum();
		lokum4.setLokum(1,0,3);
		boardAsAnArray[0][3] = lokum4;
		Lokum lokum5 = new NormalLokum();
		lokum5.setLokum(2,0,4);
		boardAsAnArray[0][4] = lokum5;
		Lokum lokum6 = new NormalLokum();
		lokum6.setLokum(3,0,5);
		boardAsAnArray[0][5] = lokum6;
		Lokum lokum7 = new NormalLokum();
		lokum7.setLokum(4,0,6);
		boardAsAnArray[0][6] = lokum7;
		Lokum lokum8 = new NormalLokum();
		lokum8.setLokum(1,0,7);
		boardAsAnArray[0][7] = lokum8;
		Lokum lokum9 = new NormalLokum();
		lokum9.setLokum(2,0,8);
		boardAsAnArray[0][8] = lokum9;
		Lokum lokum10 = new NormalLokum();
		lokum10.setLokum(3,0,9);
		boardAsAnArray[0][9] = lokum10;
		GamePlay game = new GamePlay();
		game.board.getInstance().setBoardArray(boardAsAnArray);
		game.destroyStreakLokums();
		assertTrue(boardAsAnArray[0][9].getColor != 3);
	}

	@Test
	//striped+striped test
	public void testDestroySpecialCombinationLokum() {
		Lokum[][] boardAsAnArray = new Lokum[5][5];
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				boardAsAnArray[i][j] = new EmptySpace();
			}
		}
		Lokum lokum1 = new NormalLokum();
		lokum1.setLokum(1,0,0);
		boardAsAnArray[0][0] = lokum1;
		Lokum lokum2 = new NormalLokum();
		lokum2.setLokum(2,0,1);
		boardAsAnArray[0][1] = lokum2;
		Lokum lokum3 = new StripedLokum();
		lokum3.setLokum(3,0,2);
		lokum3.isHorizantal = true;
		boardAsAnArray[0][2] = lokum3;
		Lokum lokum4 = new StripedLokum();
		lokum4.setLokum(4,0,3);
		lokum4.isHorizantal = false;
		boardAsAnArray[0][3] = lokum4;
		Lokum lokum5 = new NormalLokum();
		lokum5.setLokum(1,0,4);
		boardAsAnArray[0][4] = lokum5;
		Lokum lokum6 = new NormalLokum();
		lokum6.setLokum(1,1,3);
		boardAsAnArray[1][3] = lokum6;
		Lokum lokum7 = new NormalLokum();
		lokum7.setLokum(2,2,3);
		boardAsAnArray[2][3] = lokum7;
		Lokum lokum8 = new NormalLokum();
		lokum8.setLokum(3,3,3);
		boardAsAnArray[3][3] = lokum8;
		Lokum lokum9 = new NormalLokum();
		lokum9.setLokum(4,4,3);
		boardAsAnArray[4][3] = lokum9;		
		GamePlay game = new GamePlay();
		game.board.getInstance().setBoardArray(boardAsAnArray);
		game.selectLokum(0,2);
		game.selectLokum(0,3);
		game.destroySpecialCombinationLokum();
		assertTrue(boardAsAnArray[0][4].getColor != 1 && boardAsAnArray[4][3].getColor != 4);
	}

	@Test
	public void testSaveGame() {
		GamePlay game = new GamePlay();
		assertTrue(game.readFromFile().toString() == game.board.toString());
	}

	@Test
	public void testWinGame() {
		GamePlay game = new GamePlay();
		game.setRemainingMove(10);
		game.setScore(15);
		game.setObjective(1, 10)
		assertTrue(game.getRemainingMove()>=0 && game.getObjective <= game.getScore() );
	}


	@Test
	public void testLoseGame() {
		GamePlay game = new GamePlay();
		game.setRemainingMove(0);
		game.setScore(7);
		game.setObjective(1, 10);
		assertTrue(game.getRemainingMove()=0 && game.getObjective() > game.getScore() );
	}

	@Test
	public void testConvertWinGameBoard() {
		fail("Not yet implemented");
	}

}
