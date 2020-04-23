
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import Model.FileWriterAndReader;
import Model.GamePlay;
import View.BoardView;
import View.Menu;

public class Application extends JFrame {
	public static int mouseclickedXcoor;
	public static int mouseclickedYcoor;
	public static int selectedLokumx1;
	public static int selectedLokumy1;
	public static int selectedLokumx2;
	public static int selectedLokumy2;
	static int moves =1;
	static GamePlay game;
	static BoardView boardView;
	static Menu menu;

	public Application() {
		// TODO Auto-generated constructor stub
		game = new GamePlay();
		boardView = new BoardView(640,640);
	}

	public static void main (String[] args){

		Application application = new Application();
		final JFrame window = new JFrame("Game");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//window.setExtendedState( window.getExtendedState()|JFrame.MAXIMIZED_BOTH );

		window.setVisible(true);

		menu =new Menu(960, 960);

		//boardView.setVisible(true);
		// boardView.setVisible(false);
		menu.setVisible(true);
		menu.drawMenuOptions();

		window.add(menu);
		//window.add(boardView);
		//window.setExtendedState( window.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		//boardView.drawBoard(game.getBoard());

		menu.addMouseListeners(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(menu.choice==1){
					menu.setVisible(false);
					window.remove(menu);
					boardView.setVisible(true);
					window.add(boardView);
					boardView.drawBoard(game.getBoard());
					window.setExtendedState( window.getExtendedState()|JFrame.MAXIMIZED_BOTH );
				} else if(menu.choice==2) {
					GamePlay savedGame = new FileWriterAndReader().loadGameFromTheFile();
					game = savedGame;
					System.out.println(game.getBoard().sco);
					boardView.drawBoard(game.getBoard());
					window.remove(menu);
					boardView.setVisible(true);
					window.add(boardView);
					boardView.drawBoard(game.getBoard());
					window.setExtendedState( window.getExtendedState()|JFrame.MAXIMIZED_BOTH );

				}
			}
		});



		boardView.addMouseListeners(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseclickedXcoor = e.getY();
				mouseclickedYcoor = e.getX();
				System.out.println(mouseclickedXcoor+"    "+mouseclickedYcoor);
				System.out.println("W:"+boardView.getWidth() +"    H:"+boardView.getHeight());



				if(mouseclickedXcoor < boardView.getBoardWidth() &&  mouseclickedYcoor <boardView.getBoardHeight()){

					if(moves % 2 ==0){
						selectedLokumx2 = mouseclickedXcoor/(boardView.getBoardWidth()/game.getBoard().getNumOfLokumsInARow());
						selectedLokumy2 = mouseclickedYcoor/(boardView.getBoardHeight()/game.getBoard().getNumOfLokumsInAColumn());
						System.out.println(selectedLokumx2+"    "+selectedLokumy2);

						game.swapLokums(game.getBoard(), selectedLokumx1, selectedLokumy1, selectedLokumx2, selectedLokumy2 );
						System.out.println("swapped");
						boardView.drawBoard(game.getBoard());	

					}
					if(moves % 2 ==1){
						selectedLokumx1 = mouseclickedXcoor/(boardView.getBoardWidth()/game.getBoard().getNumOfLokumsInARow());
						selectedLokumy1 = mouseclickedYcoor/(boardView.getBoardHeight()/game.getBoard().getNumOfLokumsInAColumn());	
						System.out.println(selectedLokumx1+"    "+selectedLokumy1);

					}


					moves++;
					boardView.drawBoard(game.getBoard());
				} else {
					if(boardView.saved ==1){				
						new FileWriterAndReader().saveGameToTheFile(game);
						boardView.saved =0;

					}
				}
			}
		});




	}
}
