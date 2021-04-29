package game.ui.gui;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.Timer;

import game.logic.background.BackgroundEntities;
import game.logic.player.Player;
import game.ui.control.SpaceCombatKeyAdapter;

@SuppressWarnings("serial")
public class SpaceCombatPanel extends JPanel {

    private BackgroundEntities bgEntities;
    private Player player;
    private SmartFramesDelay sfd;

    public SpaceCombatPanel(int windowWidth, int windowHeight) throws IOException 
    {
        bgEntities = new BackgroundEntities(windowWidth, windowHeight);
        player = new Player(windowWidth, windowHeight);
        sfd = new SmartFramesDelay();

        setBackground(Color.BLACK);
        setFocusable(true);

        new Timer(0, actionPerformed -> repaint()).start();
        
        addKeyListener(new SpaceCombatKeyAdapter(player));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        sfd.smartDelay();
        paintStars(g2d);
        paintPlayersStarship(g2d);
        g2d.dispose();
    }
    
    private void paintStars(Graphics2D g2d)
    {
    	for(int starNr = 0; starNr < bgEntities.starsEntities.size(); ++starNr)
        {
            g2d.setComposite(AlphaComposite.SrcOver.derive(bgEntities.starsEntities.get(starNr).currentAlpha));
            g2d.drawImage(bgEntities.starsEntities.get(starNr).getStarshipTexture(),
            		(int)bgEntities.starsEntities.get(starNr).xPos,
            		(int)bgEntities.starsEntities.get(starNr).yPos,
            		this);
            bgEntities.starsEntities.get(starNr).nextFrame();
        }
        g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
    
    private void paintPlayersStarship(Graphics2D g2d)
    {
    	g2d.drawImage(player.starship.getStarshipTexture(),//
    			(int)player.starship.xPos,
    			(int)player.starship.yPos,
        		this);
        player.starship.nextFrame();
    }
}