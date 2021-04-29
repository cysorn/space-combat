
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.ui.gui.SpaceCombatPanel;

public class main {
	final static int windowWidth = 1500;
	final static int windowHeight = 1000;
	public static void main(String[] args) throws IOException {
		
		JFrame frame = new JFrame();
		
		SpaceCombatPanel pan = new SpaceCombatPanel(windowWidth, windowHeight);
		frame.setBounds(150, 25, windowWidth, windowHeight);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Space Combat");
		frame.add(pan);
	}
}