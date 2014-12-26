package Model;

import java.awt.Color;
import java.util.Random;

public class NormalLokum extends Lokum{

	public NormalLokum() {
		// TODO Auto-generated constructor stub
		Random rgen = new Random();
		Color randomColor = Lokum.lokumColors[rgen.nextInt(Lokum.lokumColors.length)];
		setColorOfLokum(randomColor);
	}

	public NormalLokum(Color colorOfLokum) {
		// TODO Auto-generated constructor stub
		super(colorOfLokum);
	}

	@Override
	public String toString() {
		return "NormalLokum [colorOfLokum=" + getColorOfLokum() + "]";
	}
}
