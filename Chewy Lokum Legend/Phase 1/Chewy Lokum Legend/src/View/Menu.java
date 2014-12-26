package View;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class Menu  extends GraphicsProgram{

	int boardWidth;
	int boardHeight;
	Font font = new Font("Arial", Font.PLAIN, 50);
	public int choice=0;
	public Menu(int boardWidth, int boardHeight) {
		// TODO Auto-generated constructor stub
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;

	}

	public void drawMenuOptions(){
		GLabel start = new GLabel("Start New Game", 250, 250);
		start.setFont(font);
		add(start);
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choice=1;	
			}
		});
		GLabel load = new GLabel("Load Game", 250, 400);
		load.setFont(font);
		add(load);
		load.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				choice=2;	
			}
		});

		GLabel quit = new GLabel("Quit", 250, 550);
		quit.setFont(font);
		add(quit);
		quit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});







	}
}
