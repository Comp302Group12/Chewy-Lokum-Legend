package View;

import java.awt.Color;
import acm.graphics.GOval;
import Model.Lokum;

public class ColorBombLokumView extends LokumView {

	@Override
	public void drawLokum(double lokumWidth, double lokumHeight, Lokum lokum) {
		// TODO Auto-generated method stub
		//GCompound c = new GCompound();
		int numberOfColors = Lokum.lokumColors.length;
		for(int i=0; i<numberOfColors; i++) {
			double widthOfInnerPart = lokumWidth/numberOfColors*(numberOfColors-i);
			double	heightOfInnerPart =	lokumHeight/numberOfColors*(numberOfColors-i);
			Color color = new Color(Lokum.lokumColors[i].getRed(),
					Lokum.lokumColors[i].getGreen(),
					Lokum.lokumColors[i].getBlue(), 
					255);
			GOval lokumPart = new GOval(widthOfInnerPart, heightOfInnerPart);
			lokumPart.setColor(color);
			lokumPart.setFilled(true);
			add(lokumPart, (lokumWidth-widthOfInnerPart)/2, (lokumHeight-heightOfInnerPart)/2);
		}
		//return c;
	}

}
