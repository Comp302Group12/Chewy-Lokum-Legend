import java.awt.Color;
import java.awt.Graphics;

public class SimpleGraphicsDrawingAdapter extends DrawingAdapter {

	int ROUND_RECT_ARC_CONS_FOR_LOKUMS = 2;

	@Override
	public void draw(Graphics g, EmptySpace emptySpace) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g, NormalLokum lokum) {
		// TODO Auto-generated method stub
		g.setColor(lokum.getColor());
		g.fillRoundRect(lokum.getX(), lokum.getY(), lokum.getWidth(),
				lokum.getHeight(), lokum.getWidth()
						/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, lokum.getHeight()
						/ ROUND_RECT_ARC_CONS_FOR_LOKUMS);
	}

	@Override
	public void draw(Graphics g, StripedLokum lokum) {
		// TODO Auto-generated method stub
		if (lokum.isHorizontal()) {
			int heightOfLokumPart = lokum.getHeight() / 5;
			g.setColor(lokum.getColor());
			g.fillRoundRect(lokum.getX(), lokum.getY(), lokum.getWidth(),
					lokum.getHeight(), lokum.getWidth()
							/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, lokum.getHeight()
							/ ROUND_RECT_ARC_CONS_FOR_LOKUMS);
			g.setColor(Color.WHITE);
			g.fillRect(lokum.getX(), lokum.getY() + heightOfLokumPart,
					lokum.getWidth(), heightOfLokumPart);
			g.fillRect(lokum.getX(), lokum.getY() + 3 * heightOfLokumPart,
					lokum.getWidth(), heightOfLokumPart);
		} else {
			int widthOfLokumPart = lokum.getWidth() / 5;
			g.setColor(lokum.getColor());
			g.fillRoundRect(lokum.getX(), lokum.getY(), lokum.getWidth(),
					lokum.getHeight(), lokum.getWidth()
							/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, lokum.getHeight()
							/ ROUND_RECT_ARC_CONS_FOR_LOKUMS);
			g.setColor(Color.WHITE);
			g.fillRect(lokum.getX() + widthOfLokumPart, lokum.getY(),
					widthOfLokumPart, lokum.getHeight());
			g.fillRect(lokum.getX() + 3 * widthOfLokumPart, lokum.getY(),
					widthOfLokumPart, lokum.getHeight());
		}
	}

	@Override
	public void draw(Graphics g, WrappedLokum lokum) {
		// TODO Auto-generated method stub
		Color colorOfOuterPart = Color.LIGHT_GRAY;
		// Color colorOfOuterPart = new Color(getColor().getRed(), getColor()
		// .getGreen(), getColor().getBlue(), 128);
		g.setColor(colorOfOuterPart);
		g.fillRoundRect(lokum.getX(), lokum.getY(), lokum.getWidth(),
				lokum.getHeight(), lokum.getWidth()
						/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, lokum.getHeight()
						/ ROUND_RECT_ARC_CONS_FOR_LOKUMS);
		g.setColor(lokum.getColor());
		g.fillOval(
				(lokum.getX() + (lokum.getWidth() - lokum.getWidth() * 3 / 5) / 2),
				(lokum.getY() + (lokum.getHeight() - lokum.getHeight() * 3 / 5) / 2),
				lokum.getWidth() * 3 / 5, lokum.getHeight() * 3 / 5);
	}

	@Override
	public void draw(Graphics g, ColorBombLokum lokum) {
		// TODO Auto-generated method stub
		for (int i = 0; i < Lokum.lokumColors.length; i++) {
			int widthOfLokumPart = (lokum.getWidth() / Lokum.lokumColors.length)
					* (Lokum.lokumColors.length - i);
			int heightOfLokumPart = (lokum.getHeight() / Lokum.lokumColors.length)
					* (Lokum.lokumColors.length - i);
			g.setColor(Lokum.lokumColors[i]);
			g.fillRoundRect(
					(lokum.getX() + (lokum.getWidth() - widthOfLokumPart) / 2),
					(lokum.getY() + (lokum.getHeight() - heightOfLokumPart) / 2),
					widthOfLokumPart, heightOfLokumPart, widthOfLokumPart
							/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, heightOfLokumPart
							/ ROUND_RECT_ARC_CONS_FOR_LOKUMS);
		}
	}

	@Override
	public void draw(Graphics g, Board board) {
		// TODO Auto-generated method stub
		// drawing lines
		for (int i = 0; i <= board.getNumOfLokumsInAColumn(); i++) {
			g.drawLine(0,
					i * board.getHeight() / board.getNumOfLokumsInAColumn(),
					board.getWidth(),
					i * board.getHeight() / board.getNumOfLokumsInAColumn());
		}
		for (int i = 0; i <= board.getNumOfLokumsInARow(); i++) {
			g.drawLine(i * board.getWidth() / board.getNumOfLokumsInARow(), 0,
					i * board.getWidth() / board.getNumOfLokumsInARow(),
					board.getHeight());
		}
		// drawing lokums
		for (int i = 0; i < board.getNumOfLokumsInAColumn(); i++) {
			for (int j = 0; j < board.getNumOfLokumsInARow(); j++) {
				board.getLokumArray()[i][j].draw(g);
			}
		}
	}

}
