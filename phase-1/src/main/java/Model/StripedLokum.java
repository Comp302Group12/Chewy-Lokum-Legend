package Model;

import java.awt.Color;

public class StripedLokum extends Lokum {

	private boolean isHorizontal;

	public StripedLokum() {
		// TODO Auto-generated constructor stub
	}

	public StripedLokum(boolean isHorizonral, Color colorOfLokum) {
		// TODO Auto-generated constructor stub
		super(colorOfLokum);
		this.isHorizontal = isHorizonral;
	}

	public boolean isHorizontal() {
		return isHorizontal;
	}

	public void setHorizontal(boolean isHorizontal) {
		this.isHorizontal = isHorizontal;
	}

	@Override
	public String toString() {
		return "StripedLokum [isHorizontal=" + isHorizontal + ", colorOfLokum=" + getColorOfLokum()
				+ "]";
	}
}
