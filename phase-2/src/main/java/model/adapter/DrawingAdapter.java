package model.adapter;
import java.awt.Graphics;

import model.*;
import model.lokum.*;


public abstract class DrawingAdapter {

	public abstract void draw(Graphics g, EmptySpace emptySpace);
	public abstract void draw(Graphics g, Obstacle obstacle);
	public abstract void draw(Graphics g, DestroyedLokum lokum);
	public abstract void draw(Graphics g, NormalLokum lokum);
	public abstract void draw(Graphics g, StripedLokum lokum);
	public abstract void draw(Graphics g, WrappedLokum lokum);
	public abstract void draw(Graphics g, ColorBombLokum lokum);
	public abstract void draw(Graphics g, TimeLokum lokum);
	public abstract void draw(Graphics g, Board board);

}