package com.percolation.gui;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MidPanelGUI extends JPanel{
	
	JTextField field1;
	JTextField field2;
	private static final long serialVersionUID = 1L;

	/**
	 * This is the middle panel in PercolationGUI
	 * It has one button that starts InteractivePercolationVisualizer
	 * you can pass the size of the table that is drawn
	 * It opens InteractivePercolationVisualizer 
	 * if its open and then closed it its closed the the whole Application
	 * for now i can't fix that, it uses non-standard libs that i can't change 
	 */	
	public MidPanelGUI() {
		// setting size of panel
		Dimension size = getPreferredSize();
		size.width = 450;
		size.height = 150;
		setPreferredSize(size);
		
		// adding border and label
		setBorder(BorderFactory.createTitledBorder("Interactive Simulation"));
			
		// add Swing items to this panel
		JLabel label1 = new JLabel("N - Size of the Table (N * N): ");
			
		field1 = new JTextField(11);
		
		
		JButton button = new JButton("Start Simulation");
		// add listener
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int input = Integer.parseInt(field1.getText());
				
				InteractivePercolationVisualizer myRunnable = new InteractivePercolationVisualizer(input);				
				Thread myThread = new Thread(myRunnable);
				myThread.setDaemon(true); // important, otherwise JVM does not exit at end of main()
				myThread.start(); 	
			}
		});
		
		// set layout manager and add constraints
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		// adding first row of layout - - label, text field
		gc.anchor = GridBagConstraints.LINE_END;
		
		gc.gridx = 0;
		gc.gridy = 0;		
		add(label1, gc);
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.gridx = 1;
		gc.gridy = 0;		
		add(field1, gc);
				
		// add second row - button
		gc.weighty = 10;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.gridx = 1;
		gc.gridy = 2;
		add(button, gc);
	}
}
