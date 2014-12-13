import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class InformationWindow extends JPanel {
	
	int width;
	int height;
	
	JLabel goalScoreLabel;
	JLabel scoreLabel;
	JLabel remainingQuantityLabel;
	JButton pauseGameButton;
	

	public InformationWindow(int width, int height) {
		// TODO Auto-generated constructor stub
		super();		
		this.width = width;
		this.height = height;		
		setSize(width, height);		
		setLayout(null);		
		int x = width/14;	
		int y = height/16;
		
		goalScoreLabel = new JLabel("Goal Score:");
		goalScoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		goalScoreLabel.setBounds(x, y, 12*x, 4*y);
		add(goalScoreLabel);

		scoreLabel = new JLabel("Score:");
		scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scoreLabel.setBounds(x, 6*y, 12*x, 4*y);
		add(scoreLabel);

		remainingQuantityLabel = new JLabel("Remaining Moves:");
		remainingQuantityLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		remainingQuantityLabel.setBounds(x, 11*y, 12*x, 4*y);
		add(remainingQuantityLabel);
		
		
	}
}
