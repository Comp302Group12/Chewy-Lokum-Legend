package ui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.*;
import model.adapter.*;
import model.interfaces.*;
import model.level.*;
import model.lokum.*;
import ui.*;

@SuppressWarnings("serial")
public class LevelSelectionWindow extends JPanel {

	int numOfLevels;
	ArrayList<JPanel> levelPanels;

	public LevelSelectionWindow(int numOfLevels) {
		// TODO Auto-generated constructor stub
		super();
		this.numOfLevels = numOfLevels;
		levelPanels = new ArrayList<JPanel>();
		setLayout(null);

		JPanel level1Panel = new JPanel();
		level1Panel.setBounds(200, 175, 100, 130);
		level1Panel.setBackground(Color.BLACK);
		add(level1Panel);
		level1Panel.setLayout(null);

		JButton level1Button = new JButton("Level 1");		
		level1Button.setBounds(0, 100, 100, 30);
		level1Panel.add(level1Button);

		levelPanels.add(level1Panel);

		JPanel level2Panel = new JPanel();
		level2Panel.setLayout(null);
		level2Panel.setBounds(340, 175, 100, 130);
		level2Panel.setBackground(Color.BLACK);
		add(level2Panel);

		JButton level2Button = new JButton("Level 2");
		level2Button.setBounds(0, 100, 100, 30);
		level2Panel.add(level2Button);

		levelPanels.add(level2Panel);
	}

}
