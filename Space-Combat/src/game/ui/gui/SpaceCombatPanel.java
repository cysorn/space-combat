package game.ui.gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.Timer;

import game.ui.control.SpaceCombatKeyAdapter;

@SuppressWarnings("serial")
public class SpaceCombatPanel extends JPanel {

	PaintSprites paintSprites;

    public SpaceCombatPanel(int windowWidth, int windowHeight) throws IOException 
    {
    	paintSprites = new PaintSprites(this, windowWidth, windowHeight);
        
        setBackground(Color.BLACK);
        setFocusable(true);
        
        new Timer(0, actionPerformed -> repaint()).start();
        
        addKeyListener(new SpaceCombatKeyAdapter(paintSprites.fieldLogic.starshipLogic));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        SmartFramesDelay.smartDelay();
        paintSprites.paintStars(g2d);
	    if(paintSprites.introducingSprites.introducingContinues == false)
	    {
	    	paintSprites.paintEnemyStarships(g2d);
	    	paintSprites.paintPlayersStarship(g2d);
	    	paintSprites.paintEnemiesHealthBars(g2d);
	    	paintSprites.paintPlayersHealthBar(g2d);
	    	paintSprites.paintEnemyStarshipExplosions(g2d);
		    paintSprites.paintStarshipExplosion(g2d);
    	}
	    else
	    {
	    	paintSprites.introducing(g2d);
	    }
        g2d.dispose();
    }
}