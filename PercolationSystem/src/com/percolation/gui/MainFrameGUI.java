package com.percolation.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrameGUI extends JFrame {	
	
	private TopPanelGUI topPanel; // top panel of JFrame holds TopPanelGUI
	private MidPanelGUI midPanel; // middle panel of JFrame holds MidPanelGUI
	private BotPanelGUI botPanel; // bottom panel of JFrame holds BotPanelGUI
	
	/**
	 * Constructor, takes in a string as a title
	 * @param title title of the frame
	 */
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
		
		// first row
		gc.gridx = 0;
		gc.gridy = 0;
		add(topPanel, gc);
		
		// second row
		gc.gridx = 0;
		gc.gridy = 1;
		add(midPanel, gc);
		
		// third row
		gc.gridx = 0;
		gc.gridy = 2;
		add(botPanel, gc);
		
		
		
		
		
		
		
		
		
		
	}

}
