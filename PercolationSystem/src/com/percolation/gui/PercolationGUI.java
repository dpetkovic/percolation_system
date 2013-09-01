package com.percolation.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 * Main GUI class runs all the other panels by starting MainFrame
 * @author deki
 *
 */
public class PercolationGUI {
	public static void main(String[] args) {
		
		// swing recommends using invokeLater
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new MainFrameGUI("Percolation System Test"); // set title
				frame.setSize(640, 480);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();				
				frame.setVisible(true);			
			}
		});
		
	}

}
