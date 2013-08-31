package com.percolation.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;





public class PercolationGUI {
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new MainFrameGUI("Percolation System Test");
				frame.setSize(640, 480);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.pack();				
				frame.setVisible(true);			
			}
		});
		
	}

}
