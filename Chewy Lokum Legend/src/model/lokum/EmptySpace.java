package model.lokum;

import java.awt.Color;
import java.awt.Graphics;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public class EmptySpace extends Lokum {

	public EmptySpace() {
		// TODO Auto-generated constructor stub
		super(Color.WHITE, 0, 0, 0, 0);
	}

	public EmptySpace(int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		super(Color.WHITE, x, y, width, height);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		AdapterManager.getInstance().getCurrentDrawingAdapter().draw(g, this);
	}

}
