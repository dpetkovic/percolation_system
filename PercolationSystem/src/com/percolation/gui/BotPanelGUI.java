package com.percolation.gui;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class BotPanelGUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JList<String> list;
	private JButton button;
	private int selected;
	private static final String[] textFiles= {"greeting57.txt", "heart25.txt", "input1.txt", "input10.txt", "input10-no.txt", "input1-no.txt", "input2.txt",
											"input20.txt", "input2-no.txt", "input3.txt", "input4.txt", "input5.txt", "input50.txt", "input6.txt", "input7.txt",
											"input8.txt", "input8-no.txt"};
	
	public BotPanelGUI() {
		Dimension size = getPreferredSize();
		size.width = 450;
		size.height = 150;
		setPreferredSize(size);
		
		// Set border
		setBorder(BorderFactory.createTitledBorder("Predefined Simulation"));
		
		// add JList
		list = new JList<String>(textFiles);
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		// adding list selector 
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				selected = list.getSelectedIndex();
				
			}
		});
		
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		
		
		button = new JButton("Start Simulation");
		// adding on action listner to the button and a event
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String textFilePath = "visualizer/" + textFiles[selected];
				
				System.out.println(textFilePath);
				String[] sendFileToRun = new String[1];
				sendFileToRun[0] = textFilePath;
				
				
				PercolationVisualizer pv = new PercolationVisualizer(textFilePath);
				Thread myThread = new Thread(pv);
				myThread.setDaemon(true); // important, otherwise JVM does not exit at end of main()
				myThread.start();
				
			}
		});
		
		// set layout manager
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		//adding items to panel
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(listScroller, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(button, gc);
				
		
		
	}
}
