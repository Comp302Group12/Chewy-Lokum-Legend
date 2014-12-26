package View;

import Model.Lokum;
import acm.graphics.*;

public class NormalLokumView extends LokumView {

	@Override
	public void drawLokum(double lokumWidth, double lokumHeight, Lokum lokum) {
		// TODO Auto-generated method stub
		//GCompound lokum0 = new GCompound();
		GRect lokumPart = new GRect(lokumWidth, lokumHeight);
		lokumPart.setColor(lokum.getColorOfLokum());
		lokumPart.setFilled(true);
		add(lokumPart, 0, 0);
		//return lokum0;
	}

}
