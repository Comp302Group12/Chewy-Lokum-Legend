import java.awt.Color;
import java.awt.Graphics;

public class NormalLokum extends Lokum {

	public NormalLokum() {
		// TODO Auto-generated constructor stub
		super(Color.WHITE, 0, 0, 0, 0);
	}

	public NormalLokum(Color color, int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		super(color, x, y, width, height);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		g.fillRoundRect(getX(), getY(), getWidth(), getHeight(), getWidth()
				/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, getHeight() / ROUND_RECT_ARC_CONS_FOR_LOKUMS);
	}
	
	public void explode() {
		new NormalLokum();
	}
}
