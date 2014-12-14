package model.adapter;
import java.awt.Color;
import java.awt.Graphics;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

public class SimpleGraphicsDrawingAdapter extends DrawingAdapter {

	int ROUND_RECT_ARC_CONS_FOR_LOKUMS = 2;

	@Override
	public void draw(Graphics g, EmptySpace emptySpace) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g, Obstacle obstacle) {
		// TODO Auto-generated method stub
		g.setColor(obstacle.getColor());
		g.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getWidth(),
				obstacle.getHeight());
	}

	@Override
	public void draw(Graphics g, NormalLokum lokum) {
		// TODO Auto-generated method stub
		g.setColor(lokum.getColor());
		g.fillRoundRect(lokum.getX(), lokum.getY(), lokum.getWidth(),
				lokum.getHeight(), lokum.getWidth()
				/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, lokum.getHeight()
				/ ROUND_RECT_ARC_CONS_FOR_LOKUMS);
	}

	@Override
	public void draw(Graphics g, StripedLokum lokum) {
		// TODO Auto-generated method stub
		if (lokum.isHorizontal()) {
			int heightOfLokumPart = lokum.getHeight() / 5;
			g.setColor(lokum.getColor());
			g.fillRoundRect(lokum.getX(), lokum.getY(), lokum.getWidth(),
					lokum.getHeight(), lokum.getWidth()
					/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, lokum.getHeight()
					/ ROUND_RECT_ARC_CONS_FOR_LOKUMS);
			g.setColor(Color.WHITE);
			g.fillRect(lokum.getX(), lokum.getY() + heightOfLokumPart,
					lokum.getWidth(), heightOfLokumPart);
			g.fillRect(lokum.getX(), lokum.getY() + 3 * heightOfLokumPart,
					lokum.getWidth(), heightOfLokumPart);
		} else {
			int widthOfLokumPart = lokum.getWidth() / 5;
			g.setColor(lokum.getColor());
			g.fillRoundRect(lokum.getX(), lokum.getY(), lokum.getWidth(),
					lokum.getHeight(), lokum.getWidth()
					/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, lokum.getHeight()
					/ ROUND_RECT_ARC_CONS_FOR_LOKUMS);
			g.setColor(Color.WHITE);
			g.fillRect(lokum.getX() + widthOfLokumPart, lokum.getY(),
					widthOfLokumPart, lokum.getHeight());
			g.fillRect(lokum.getX() + 3 * widthOfLokumPart, lokum.getY(),
					widthOfLokumPart, lokum.getHeight());
		}
	}

	@Override
	public void draw(Graphics g, WrappedLokum lokum) {
		// TODO Auto-generated method stub
		Color colorOfOuterPart = Color.LIGHT_GRAY;
		// Color colorOfOuterPart = new Color(getColor().getRed(), getColor()
		// .getGreen(), getColor().getBlue(), 128);
		g.setColor(colorOfOuterPart);
		g.fillRoundRect(lokum.getX(), lokum.getY(), lokum.getWidth(),
				lokum.getHeight(), lokum.getWidth()
				/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, lokum.getHeight()
				/ ROUND_RECT_ARC_CONS_FOR_LOKUMS);
		g.setColor(lokum.getColor());
		g.fillOval(
				(lokum.getX() + (lokum.getWidth() - lokum.getWidth() * 3 / 5) / 2),
				(lokum.getY() + (lokum.getHeight() - lokum.getHeight() * 3 / 5) / 2),
				lokum.getWidth() * 3 / 5, lokum.getHeight() * 3 / 5);
	}

	@Override
	public void draw(Graphics g, ColorBombLokum lokum) {
		// TODO Auto-generated method stub
		for (int i = 0; i < Lokum.lokumColors.length; i++) {
			int widthOfLokumPart = (lokum.getWidth() / Lokum.lokumColors.length)
					* (Lokum.lokumColors.length - i);
			int heightOfLokumPart = (lokum.getHeight() / Lokum.lokumColors.length)
					* (Lokum.lokumColors.length - i);
			g.setColor(Lokum.lokumColors[i]);
			g.fillRoundRect(
					(lokum.getX() + (lokum.getWidth() - widthOfLokumPart) / 2),
					(lokum.getY() + (lokum.getHeight() - heightOfLokumPart) / 2),
					widthOfLokumPart, heightOfLokumPart, widthOfLokumPart
					/ ROUND_RECT_ARC_CONS_FOR_LOKUMS, heightOfLokumPart
					/ ROUND_RECT_ARC_CONS_FOR_LOKUMS);
		}
	}

	@Override
	public void draw(Graphics g, Board board) {
		// TODO Auto-generated method stub
		for (int i = 0; i < board.getNumOfLokumsInAColumn(); i++) {
			for (int j = 0; j < board.getNumOfLokumsInARow(); j++) {
				if(board.getLokumArray()[i][j] instanceof Movable){
					g.setColor(Color.BLACK);
					g.drawRect(j*board.getBlockWidth(), i*board.getBlockHeight(), board.getBlockWidth(), board.getBlockHeight());
				}
				board.getLokumArray()[i][j].draw(g);
			}
		}
	}

}
