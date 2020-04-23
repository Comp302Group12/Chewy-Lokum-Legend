package ui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
		int x = (int) (width * 0.1);
		int y = (int) (height * 0.1);
		int labels_width = (int) (width * 0.9);
		int labels_height = (int) (height * 0.2);

		goalScoreLabel = new JLabel("Goal Score:");
		goalScoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		goalScoreLabel.setBounds(x, y, labels_width, labels_height);
		add(goalScoreLabel);
		y += labels_height;
		scoreLabel = new JLabel("Score:");
		scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scoreLabel.setBounds(x, y, labels_width, labels_height);
		add(scoreLabel);
		y += labels_height;
		remainingQuantityLabel = new JLabel("Remaining Quantity:");
		remainingQuantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		remainingQuantityLabel.setBounds(x, y, labels_width, labels_height);
		add(remainingQuantityLabel);
		y += labels_height;
		remainingSpecialSwapLabel = new JLabel("Special Swaps:");
		remainingSpecialSwapLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		remainingSpecialSwapLabel.setBounds(x, y, labels_width, labels_height);
		add(remainingSpecialSwapLabel);
	}

	public void updateInformationWindow (String goalScore, String score, String remainingQuantity, String remainingSSwaps) {
		goalScoreLabel.setText(goalScore);
		scoreLabel.setText(score);
		remainingQuantityLabel.setText(remainingQuantity);
		remainingSpecialSwapLabel.setText(remainingSSwaps);
	}
}
