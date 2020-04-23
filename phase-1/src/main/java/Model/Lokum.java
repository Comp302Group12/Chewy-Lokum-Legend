package Model;

import java.awt.Color;

public abstract class Lokum {

	public final static Color[] lokumColors = {Color.RED, Color.BLUE, Color.GREEN, 
		Color.YELLOW, Color.MAGENTA,	Color.PINK, Color.BLACK, Color.GRAY	};

	private Color colorOfLokum;

	public Lokum() {
		// TODO Auto-generated constructor stub
	}

	public Lokum(Color colorOfLokum) {
		// TODO Auto-generated constructor stub
		this.colorOfLokum = colorOfLokum;
	}

	public Color getColorOfLokum() {
		return colorOfLokum;
	}

	public void setColorOfLokum(Color colorOfLokum) {
		this.colorOfLokum = colorOfLokum;
	}

	@Override
	public String toString() {
		return "Lokum [colorOfLokum=" + colorOfLokum + "]";
	}
}
