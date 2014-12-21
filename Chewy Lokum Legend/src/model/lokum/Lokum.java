package model.lokum;
import java.awt.Color;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public abstract class Lokum implements Drawable {

	public static final Color[] lokumColors = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.MAGENTA, Color.PINK };
	private Color color;
	private int x;
	private int y;
	private int width;
	private int height;

	public Lokum(Color color, int x, int y, int width, int height) {
		// TODO Auto-generated constructor stub
		this.color = color;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean doesContain(int x, int y) {
		if ((x >= this.x && x <= this.x + width)
				&& (y >= this.y && y <= this.y + height)) {
			return true;
		}
		return false;
	}

}
