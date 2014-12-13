
import java.awt.Color;
import java.awt.Graphics;

public class StripedLokum extends Lokum {

	private boolean isHorizontal;

	public StripedLokum() {
		// TODO Auto-generated constructor stub
		super(Color.WHITE, 0, 0, 0, 0);
	}

	public StripedLokum(Color color, int x, int y, int width, int height,
			boolean isHorizonral) {
		// TODO Auto-generated constructor stub
		super(color, x, y, width, height);
		this.isHorizontal = isHorizonral;
	}

	public boolean isHorizontal() {
		return isHorizontal;
	}

	public void setHorizontal(boolean isHorizontal) {
		this.isHorizontal = isHorizontal;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		AdapterManager.getInstance().getCurrentDrawingAdapter().draw(g, this);
	}
	
}
