
public class StripedLokum extends Lokum {

	boolean isHorizantal;
	
	@Override
	/**
	 * @requires Initialized StripedLokum lokum. 
	 * @modifies color, row, and column
	 * @effects color is changed.
	 */	
	public Lokum setLokum(int color, int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/** 
	 * @requires Initialized StripedLokum lokum. 
	 * @modifies 
	 * @effects returns empty space.
	 */
	public Lokum destroy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean repOk(){
		if( color<1 ||color>4 )
			return false;
		else if(row < 0)
			return false;
		else if(column < 0)
				return false;
			else
				return true;
	}
	
	public String toString(){
		String result = "StripedLokum.toString :\n";
		result += "Color of the lokum is :\n" + color+"\n";
		result += "Row of the lokum is:\n"+ row+"\n";
		result += "Column of the lokum is \n:" + column+"\n";
		return result;
	}

}
