package com.percolation.gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class ResultScreenGUI extends JFrame{
	public ResultScreenGUI(String mean, String stddev, String hiLo) {
		super("Result");
		setDefaultCloseOperation(ResultScreenGUI.DISPOSE_ON_CLOSE);
		// make labels
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		
		// set label Text
		label1.setText(mean);
		label2.setText(stddev);
		label3.setText(hiLo);
		
		
		// set layout manager and 
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		// add top label
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx  = 0;
		gc.gridy = 0;
		add(label1, gc);
		
		// add mid label
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx  = 0;
		gc.gridy = 1;
		add(label2, gc);
		
		// add bot label
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx  = 0;
		gc.gridy = 2;
		add(label3, gc);
		

	}
}
