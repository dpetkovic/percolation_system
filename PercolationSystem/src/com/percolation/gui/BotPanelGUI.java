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

/**
 * Bottom panel of our gui it runs PercolationVisualizer with a script text file you chose 
 * @author deki
 */
@SuppressWarnings("serial")
public class BotPanelGUI extends JPanel{
	
	private JList<String> list; // item that holds textFIles and can be scrolled and selected
	private JButton button; // button that starts the simulation
	private int selected; // selected item in JList
	private static final String[] textFiles= {"greeting57.txt", "heart25.txt", "input1.txt", "input10.txt", "input10-no.txt", "input1-no.txt", "input2.txt",
											"input20.txt", "input2-no.txt", "input3.txt", "input4.txt", "input5.txt", "input50.txt", "input6.txt", "input7.txt",
											"input8.txt", "input8-no.txt"}; // Sting array of names of text files in visualizer folder
	/**
	 * Constructor, creates the panel
	 */
	public BotPanelGUI() {
		// we set the size of panel
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
		
		// add a scroll bar to our list
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		
		
		button = new JButton("Start Simulation");
		// adding on action listener to the button and a event
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
		
		// adding List to the top of the panel
		gc.gridx = 0;
		gc.gridy = 0;
		add(listScroller, gc);
		
		// adding button to the bottom of the panel
		gc.gridx = 0;
		gc.gridy = 1;
		add(button, gc);
				
		
		
	}
}
