package ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

@SuppressWarnings("serial")
public class InformationWindow extends JPanel {

	int width;
	int height;

	JLabel goalScoreLabel;
	JLabel scoreLabel;
	JLabel remainingQuantityLabel;
	JLabel remainingSpecialSwapLabel;

	public InformationWindow(int width, int height) {
		// TODO Auto-generated constructor stub
		super();
		this.width = width;
		this.height = height;
		setSize(width, height);
		setLayout(null);
		int x = width / 8;
		int y = height / 20;

		goalScoreLabel = new JLabel("Goal Score:");
		goalScoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		goalScoreLabel.setBounds(x, y, 12 * x, 4 * y);
		add(goalScoreLabel);

		scoreLabel = new JLabel("Score:");
		scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scoreLabel.setBounds(x, 6 * y, 12 * x, 4 * y);
		add(scoreLabel);

		remainingQuantityLabel = new JLabel("Remaining Quantity:");
		remainingQuantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		remainingQuantityLabel.setBounds(x, 11 * y, 12 * x, 4 * y);
		add(remainingQuantityLabel);

		remainingSpecialSwapLabel = new JLabel("Remaining S. Swaps:");
		remainingSpecialSwapLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		remainingSpecialSwapLabel.setBounds(x, 16 * y, 12 * x, 4 * y);
		add(remainingSpecialSwapLabel);

	}

	public void updateInformationWindow (String goalScore, String score, String remainingQuantity, String remainingSSwaps) {
		goalScoreLabel.setText(goalScore);
		scoreLabel.setText(score);
		remainingQuantityLabel.setText(remainingQuantity);
		remainingSpecialSwapLabel.setText(remainingSSwaps);
	}
}
