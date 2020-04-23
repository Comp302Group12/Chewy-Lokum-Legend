package Model;

import java.awt.Color;

public class WrappedLokum extends Lokum {

	public WrappedLokum() {
		// TODO Auto-generated constructor stub
	}

	public WrappedLokum(Color colorOfLokum) {
		// TODO Auto-generated constructor stub
		super(colorOfLokum);
	}

	@Override
	public String toString() {
		return "WrappedLokum [colorOfLokum=" + getColorOfLokum() + "]";
	}

}
