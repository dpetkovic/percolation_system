package com.percolation.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;








@SuppressWarnings("serial")
public class MainFrameGUI extends JFrame {	
	
	private TopPanelGUI topPanel;
	private MidPanelGUI midPanel;
	private BotPanelGUI botPanel;

	public MainFrameGUI(String title) {
		super(title);
		
		// add Layout manager
		setLayout(new GridBagLayout());
		
		//create swing components
		
				
		topPanel = new TopPanelGUI();
		midPanel = new MidPanelGUI();
		botPanel = new BotPanelGUI();
		
		// make our layout
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(topPanel, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(midPanel, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		add(botPanel, gc);
		
		
		
		
		
		
		
		
		
		
	}

}
