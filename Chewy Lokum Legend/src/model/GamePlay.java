package model;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public class GamePlay {
	public Lokum selectedLokum1;
	public Lokum selectedLokum2;
	
	Level level;
	
	public GamePlay(Level level) {
		// TODO Auto-generated constructor stub
		this.level = level;
	}
	
	/*public void selectLokum(int x, int y) {
		if(selectedLokum1==null) {
			selectedLokum1 = lokumAtPosition(x, y);
		} else {
			selectedLokum2 = lokumAtPosition(x, y);
			swapSelectedLokums(selectedLokum1, selectedLokum2);
		}
	}*/
	
	public void swapSelectedLokums(Lokum selectedLokum1, Lokum selectedLokum2) {
		// TODO Auto-generated method stub
		int temp = selectedLokum1.getX();
		selectedLokum1.setX(selectedLokum2.getX());
		selectedLokum2.setX(temp);
		
		temp = selectedLokum1.getY();
		selectedLokum1.setY(selectedLokum2.getY());
		selectedLokum2.setY(temp);
	}



}
