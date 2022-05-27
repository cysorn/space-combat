package main;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import game.ui.gui.SpaceCombatPanel;

public class Main {
	public final static int WINDOW_WIDTH = 1500;
	public final static int WINDOW_HEIGHT = 1000;
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			    JFrame frame = new JFrame();
			    try
			    {
			    	SpaceCombatPanel pan = new SpaceCombatPanel(WINDOW_WIDTH, WINDOW_HEIGHT);
			    	frame.add(pan);
				}
			    catch (IOException e)
			    {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    frame.setBounds(200, 25, WINDOW_WIDTH, WINDOW_HEIGHT);
			    frame.setResizable(false);
			    frame.setVisible(true);
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    frame.setTitle("Space Combat");
		    }
		});
	}
}