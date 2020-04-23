package View;

import java.awt.Color;

import Model.Lokum;
import Model.StripedLokum;
import acm.graphics.GRect;

public class StripedLokumView extends LokumView {
	@Override
	public void drawLokum(double lokumWidth, double lokumHeight, Lokum lokum) {
		// TODO Auto-generated method stub
		//GCompound c = new GCompound();
		if(((StripedLokum) lokum).isHorizontal()){
			GRect lokumPart1 = new GRect(lokumWidth, lokumHeight/5);
			lokumPart1.setColor(lokum.getColorOfLokum());
			lokumPart1.setFilled(true);
			add(lokumPart1, 0, 0);		
			GRect lokumPart2 = new GRect(lokumWidth, lokumHeight/5);
			lokumPart2.setColor(Color.WHITE);
			lokumPart2.setFilled(true);
			add(lokumPart2, 0, lokumHeight/5);		
			GRect lokumPart3 = new GRect(lokumWidth, lokumHeight/5);
			lokumPart3.setColor(lokum.getColorOfLokum());
			lokumPart3.setFilled(true);
			add(lokumPart3, 0, 2*lokumHeight/5);		
			GRect lokumPart4 = new GRect(lokumWidth, lokumHeight/5);
			lokumPart4.setColor(Color.WHITE);
			lokumPart4.setFilled(true);
			add(lokumPart4, 0, 3*lokumHeight/5);		
			GRect lokumPart5 = new GRect(lokumWidth, lokumHeight/5);
			lokumPart5.setColor(lokum.getColorOfLokum());
			lokumPart5.setFilled(true);
			add(lokumPart5, 0, 4*lokumHeight/5);
		} else {
			GRect lokumPart1 = new GRect(lokumWidth/5, lokumHeight);
			lokumPart1.setColor(lokum.getColorOfLokum());
			lokumPart1.setFilled(true);
			add(lokumPart1, 0, 0);		
			GRect lokumPart2 = new GRect(lokumWidth/5, lokumHeight);
			lokumPart2.setColor(Color.WHITE);
			lokumPart2.setFilled(true);
			add(lokumPart2, lokumWidth/5, 0);		
			GRect lokumPart3 = new GRect(lokumWidth/5, lokumHeight);
			lokumPart3.setColor(lokum.getColorOfLokum());
			lokumPart3.setFilled(true);
			add(lokumPart3, 2*lokumWidth/5, 0);		
			GRect lokumPart4 = new GRect(lokumWidth/5, lokumHeight);
			lokumPart4.setColor(Color.WHITE);
			lokumPart4.setFilled(true);
			add(lokumPart4, 3*lokumWidth/5, 0);		
			GRect lokumPart5 = new GRect(lokumWidth/5, lokumHeight);
			lokumPart5.setColor(lokum.getColorOfLokum());
			lokumPart5.setFilled(true);
			add(lokumPart5, 4*lokumWidth/5, 0);
		}
		GRect frame = new GRect(lokumWidth, lokumHeight);
		frame.setColor(lokum.getColorOfLokum());
		add(frame, 0, 0);
		//return c;
	}
}
