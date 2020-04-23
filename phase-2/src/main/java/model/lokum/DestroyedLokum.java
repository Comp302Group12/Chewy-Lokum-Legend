package model.lokum;

import java.awt.Color;
import java.awt.Graphics;

import model.adapter.AdapterManager;
import model.interfaces.Movable;

public class DestroyedLokum extends Lokum implements Movable {

	public DestroyedLokum() {
		super(Color.WHITE, 0, 0, 0, 0);
		// TODO Auto-generated constructor stub
	}

	public DestroyedLokum(int x, int y, int width, int height) {
		super(Color.WHITE, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		AdapterManager.getInstance().getCurrentDrawingAdapter().draw(g, this);
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		setX(getX()+x);
		setY(getY()+y);
	}

}
