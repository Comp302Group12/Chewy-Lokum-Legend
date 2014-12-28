package test.assertion;

import model.lokum.Lokum;

public class LokumAssertions {

	public boolean isValid(Lokum lokum) {
		if(lokum.getX()!=0
				&& lokum.getY() != 0
				&& lokum.getHeight() != 0
				&& lokum.getWidth() != 0) {
			return true;
		}
		return false;
	}

	public boolean equals(Lokum lokum1, Lokum lokum2) {
		if(lokum1.getClass() == lokum2.getClass()
				&& lokum1.getX() == lokum2.getX()
				&& lokum1.getY() == lokum2.getY()
				&& lokum1.getWidth() == lokum2.getWidth()
				&& lokum1.getHeight() == lokum2.getHeight()
				&& lokum1.getColor() == lokum2.getColor()) {
			return true;
		}
		return false;
	}

	public boolean isSameType(Lokum lokum1, Lokum lokum2) {
		if(lokum1.getClass() == lokum2.getClass()){
			return true;
		}
		return false;
	}

}
