import java.awt.Color;
import java.awt.Graphics;

public class NormalLokum extends Lokum implements LokumDrawerAdapter {

	public NormalLokum() {
		// TODO Auto-generated constructor stub
		super(Color.WHITE, 0, 0, 0, 0);
	}

	public NormalLokum(Color color, int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		super(color, x, y, width, height);
	}

	@Override
	public void drawlokum(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		g.fillRoundRect(getX(), getY(), getWidth(), getHeight(), getWidth()
				/ ROUND_RECT_ARC_CONS, getHeight() / ROUND_RECT_ARC_CONS);
	}
}
