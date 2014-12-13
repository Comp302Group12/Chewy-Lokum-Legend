import java.awt.Color;
import java.awt.Graphics;

public class ColorBombLokum extends Lokum implements Drawable {

	public ColorBombLokum() {
		// TODO Auto-generated constructor stub
		super(Color.BLACK, 0, 0, 0, 0);
	}

	public ColorBombLokum(int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		super(Color.BLACK, x, y, width, height);
	}

	@Override
	public String toString() {
		return "ColorBombLokum []";
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < Lokum.lokumColors.length; i++) {
			int widthOfLokumPart = (getWidth() / Lokum.lokumColors.length) * (Lokum.lokumColors.length - i );
			int heightOfLokumPart = (getHeight() / Lokum.lokumColors.length) * (Lokum.lokumColors.length - i);
			g.setColor(Lokum.lokumColors[i]);
			g.fillRoundRect((getX() + (getWidth() - widthOfLokumPart) / 2),
					(getY() + (getHeight() - heightOfLokumPart) / 2),
					widthOfLokumPart, heightOfLokumPart, widthOfLokumPart
							/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, heightOfLokumPart
							/ ROUND_RECT_ARC_CONS_FOR_LOKUMS);
		}

	}

}
