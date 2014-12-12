
import java.awt.Color;
import java.awt.Graphics;

public class EmptySpace extends Lokum implements LokumDrawerAdapter {

	public EmptySpace() {
		// TODO Auto-generated constructor stub
		super(Color.WHITE, 0, 0, 0, 0);
	}

	public EmptySpace(int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		super(Color.WHITE, x, y, width, height);
	}

	@Override
	public void drawlokum(Graphics g) {
		// TODO Auto-generated method stub
	}

}
