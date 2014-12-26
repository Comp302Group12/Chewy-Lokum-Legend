package View;

import Model.Lokum;
import acm.graphics.GCompound;

public abstract class LokumView extends GCompound {

	public abstract void drawLokum(double lokumWidth, double lokumHeight, Lokum lokum);

}
