
import java.awt.Color;
import java.awt.Graphics;

public class StripedLokum extends Lokum {

	private boolean isHorizontal;

	public StripedLokum() {
		// TODO Auto-generated constructor stub
		super(Color.WHITE, 0, 0, 0, 0);
	}

	public StripedLokum(Color color, int x, int y, int width, int height,
			boolean isHorizonral) {
		// TODO Auto-generated constructor stub
		super(color, x, y, width, height);
		this.isHorizontal = isHorizonral;
	}

	public boolean isHorizontal() {
		return isHorizontal;
	}

	public void setHorizontal(boolean isHorizontal) {
		this.isHorizontal = isHorizontal;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if (isHorizontal) {
			int heightOfLokumPart = getHeight() / 5;
			g.setColor(getColor());
			g.fillRoundRect(getX(), getY(), getWidth(), getHeight(), getWidth()
					/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, getHeight() / ROUND_RECT_ARC_CONS_FOR_LOKUMS);
			g.setColor(Color.WHITE);
			g.fillRect(getX(), getY() + heightOfLokumPart, getWidth(),
					heightOfLokumPart);
			g.fillRect(getX(), getY() + 3 * heightOfLokumPart, getWidth(),
					heightOfLokumPart);
		} else {
			int widthOfLokumPart = getWidth() / 5;
			g.setColor(getColor());
			g.fillRoundRect(getX(), getY(), getWidth(), getHeight(), getWidth()
					/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, getHeight() / ROUND_RECT_ARC_CONS_FOR_LOKUMS);
			g.setColor(Color.WHITE);
			g.fillRect(getX() + widthOfLokumPart, getY(), widthOfLokumPart,
					getHeight());
			g.fillRect(getX() + 3 * widthOfLokumPart, getY(), widthOfLokumPart,
					getHeight());
		}
	}
}
