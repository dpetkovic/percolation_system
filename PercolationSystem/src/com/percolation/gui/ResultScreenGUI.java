package com.percolation.gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Small pop-up screen that displays the results of PercolationStats
 * to-do: maybe use some other swing item
 * @author deki
 *
 */
@SuppressWarnings("serial")
public class ResultScreenGUI extends JFrame{
	public ResultScreenGUI(String mean, String stddev, String hiLo, String time) {
		super("Result");
		setDefaultCloseOperation(ResultScreenGUI.DISPOSE_ON_CLOSE);
		// make labels that we use to display results
		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		JLabel label3 = new JLabel();
		JLabel labelRunTime = new JLabel();
		
		// set label Text
		label1.setText(mean);
		label2.setText(stddev);
		label3.setText(hiLo);
		labelRunTime.setText(time);
		
		// labels have static text 
		JLabel label4 = new JLabel("Mean: ");
		JLabel label5 = new JLabel("Standard Deviation: ");
		JLabel label6 = new JLabel("95% confidence interval: ");
		JLabel label7 = new JLabel("Run Time in Seconds: ");
	
		// set layout manager and 
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		// first row
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx  = 0;
		gc.gridy = 0;
		add(label4, gc);
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx  = 1;
		gc.gridy = 0;
		add(label1, gc);				
		
		// second row
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx  = 0;
		gc.gridy = 1;
		add(label5, gc);
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx  = 1;
		gc.gridy = 1;
		add(label2, gc);
						
		// third row
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx  = 0;
		gc.gridy = 2;
		add(label6, gc);		
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx  = 1;
		gc.gridy = 2;
		add(label3, gc);
		
		// fourth row
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx  = 0;
		gc.gridy = 3;
		add(label7, gc);		
		gc.anchor = GridBagConstraints.LAST_LINE_START;
		gc.gridx  = 1;
		gc.gridy = 3;
		add(labelRunTime, gc);
	}
}
