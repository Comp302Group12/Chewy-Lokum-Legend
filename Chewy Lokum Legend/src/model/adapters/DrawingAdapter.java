package model.adapters;
import java.awt.Graphics;

import model.*;
import model.adapters.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;


public abstract class DrawingAdapter {
	
	public abstract void draw(Graphics g, EmptySpace emptySpace);
	public abstract void draw(Graphics g, Obstacle obstacle);
	public abstract void draw(Graphics g, NormalLokum lokum);
	public abstract void draw(Graphics g, StripedLokum lokum);
	public abstract void draw(Graphics g, WrappedLokum lokum);
	public abstract void draw(Graphics g, ColorBombLokum lokum);
	public abstract void draw(Graphics g, Board board);
	
}
