package View;

import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GRect;
import Model.Lokum;

public class WrappedLokumView extends LokumView {

	final double RATIO = 0.75;
	@Override
	public void drawLokum(double lokumWidth, double lokumHeight, Lokum lokum) {
		// TODO Auto-generated method stub
		//GCompound c = new GCompound();
		GOval lokumPart1 = new GOval(lokumWidth*RATIO, lokumHeight*RATIO);
		lokumPart1.setColor(lokum.getColorOfLokum());
		lokumPart1.setFilled(true);
		add(lokumPart1, (lokumWidth-lokumWidth*RATIO)/2, (lokumHeight-lokumHeight*RATIO)/2);
		GRect lokumPart2 = new GRect(lokumWidth, lokumHeight);
		lokumPart2.setColor(new Color(lokum.getColorOfLokum().getRed(),
				lokum.getColorOfLokum().getGreen(),
				lokum.getColorOfLokum().getBlue(),
				128));
		lokumPart2.setFilled(true);
		add(lokumPart2);
		//return c;
	}
}
