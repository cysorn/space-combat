package game.ui.gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.Timer;

import game.loading.logic.LoadingLogic;
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
        
        addKeyListener(new SpaceCombatKeyAdapter(paintSprites.fieldLogic.spaceshipLogic));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        paintSprites.waitAndSetCounterToZeroIfLoadingWasFinished();
        SmartFramesDelay.smartDelay();
        paintSprites.paintStars(g2d, LoadingLogic.loadingIsFinished);
    	paintSprites.paintLaser(g2d);
    	paintSprites.paintEnemyStarships(g2d, LoadingLogic.loadingIsFinished);
    	paintSprites.paintPlayersStarship(g2d, paintSprites.introducingSprites.introducingContinues == false);
	    if(paintSprites.introducingSprites.introducingContinues == false)
	    {
	    	paintSprites.paintEnemyHealthBars(g2d);
	    	paintSprites.paintPlayerHealthBars(g2d);
	    	paintSprites.paintEnemySpaceshipExplosions(g2d);
		    paintSprites.paintSpaceshipExplosion(g2d);
    	}
	    else
	    {
	    	paintSprites.introducing(g2d, LoadingLogic.loadingIsFinished);
	    }
	    paintSprites.paintLoadingBar(g2d);
        g2d.dispose();
    }
}