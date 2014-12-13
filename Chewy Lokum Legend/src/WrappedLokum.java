
import java.awt.Color;
import java.awt.Graphics;

public class WrappedLokum extends Lokum {

	public WrappedLokum() {
		// TODO Auto-generated constructor stub
		super(Color.WHITE, 0, 0, 0, 0);
	}

	public WrappedLokum(Color color, int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		super(color, x, y, width, height);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Color colorOfOuterPart = Color.LIGHT_GRAY;
		//Color colorOfOuterPart = new Color(getColor().getRed(), getColor()
		//	.getGreen(), getColor().getBlue(), 128);
		g.setColor(colorOfOuterPart);
		g.fillRoundRect(getX(), getY(), getWidth(), getHeight(), getWidth()
				/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, getHeight() / ROUND_RECT_ARC_CONS_FOR_LOKUMS);
		g.setColor(getColor());
		g.fillOval((getX() + (getWidth() - getWidth() * 3 / 5) / 2),
				(getY() + (getHeight() - getHeight() * 3 / 5) / 2),
				getWidth() * 3 / 5, getHeight() * 3 / 5);

	}

}
