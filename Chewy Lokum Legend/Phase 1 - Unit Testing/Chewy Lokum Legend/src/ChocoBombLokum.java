
public class ChocoBombLokum extends Lokum {

	@Override
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
	 * @requires Initialized ChocoBombLokum lokum. 
	 * @modifies 
	 * @effects returns empty space.
	 */
	public Lokum destroy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean repOk(){
		if( color<5 ||color>5 )
			return false;
		else if(row < 0)
			return false;
		else if(column < 0)
				return false;
			else
				return true;
	}
	
	public String toString(){
		String result = "ChocoBombLokum.toString :\n";
		result += "Color of the lokum is :\n" + color+"\n";
		result += "Row of the lokum is:\n"+ row+"\n";
		result += "Column of the lokum is \n:" + column+"\n";
		return result;
	}

}
