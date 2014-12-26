

public abstract class Lokum {

	int color;
	int row;
	int colomn;
	
	public abstract Lokum setLokum(int color, int row, int column);
	public abstract int getColor();
	public abstract Lokum destroy();
	public abstract boolean repOk();
	
}