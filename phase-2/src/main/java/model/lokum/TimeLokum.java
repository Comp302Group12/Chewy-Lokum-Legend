package model.lokum;

import java.awt.Color;
import java.awt.Graphics;

import model.adapter.AdapterManager;
import model.interfaces.Destructible;
import model.interfaces.Movable;

public class TimeLokum extends Lokum implements Movable, Destructible {

	private int time;

	public TimeLokum() {
		// TODO Auto-generated constructor stub
		super(Color.WHITE, 0, 0, 00, 0);
		time = 5;
	}

	public TimeLokum(Color color, int x, int y, int width, int height) {
		super(color, x, y, width, height);
		time = 5;
		// TODO Auto-generated constructor stub
	}

	public int getTime() {
		return time;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		AdapterManager.getInstance().getCurrentDrawingAdapter().draw(g, this);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		AdapterManager.getInstance().getCurrentLokumDestroyerAdapter().destroy(this);
	}

	@Override
	public void move(int x, int y) {
		// TODO Auto-generated method stub
		setX(getX()+x);
		setY(getY()+y);
	}

}
