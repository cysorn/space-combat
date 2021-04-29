package game.ui.gui;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import game.Direction;
import game.StarshipAction;
import game.logic.background.BackgroundEntities;
import game.logic.player.Player;
import game.logic.player.StarshipTextures;
import game.ui.control.SpaceCombatKeyAdapter;

@SuppressWarnings("serial")
public class SpaceCombatPanel extends JPanel {

    private BackgroundEntities bgEntities;
    private Player player;
    private SmartFramesDelay sfd;
    private StarshipTextures temp = new StarshipTextures() {};
    float frame;
    float fireAnimationSpeed = 0.5f;
    float additionalY = 0;

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
            g2d.drawImage(bgEntities.starsEntities.get(starNr).getTexture(),
            		bgEntities.starsEntities.get(starNr).xPos,
            		bgEntities.starsEntities.get(starNr).yPos,
            		this);
            bgEntities.starsEntities.get(starNr).nextFrame();
        }
        g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
    
    private void paintPlayersStarship(Graphics2D g2d)
    {
    	paintPlayersStarshipEngine(g2d);
    	g2d.drawImage(player.starship.getTexture(),//
        		player.starship.xPos,
        		player.starship.yPos,
        		this);
        player.starship.nextFrame();
    }
    
    private void paintPlayersStarshipEngine(Graphics2D g2d)
    {
        g2d.drawImage(temp.starshipEngineTextures.get((int)frame),
//        		100,
//        		100,
        		player.starship.xPos + 8 + 1,
        		player.starship.yPos + 15 + 60 + 1,
            	this);
        
        
        if(frame + 1 < 64)
        {
//        	if(frame > 30 && frame <= 40)
//        	{
//        		additionalY += 0.5f;
//        	}
//        	else if(frame >= 40 && frame < 50)
//        	{
//        		additionalY -= 0.5f;
//        	}
        	frame += 1f;
        }
        else
        {
        	frame = 0;
        }
//        if(frame + fireAnimationSpeed == 31.5f)
//        {
//        	fireAnimationSpeed = fireAnimationSpeed * (-1);
//        	frame = 27;
//        }
//        else if(frame + fireAnimationSpeed == -0.5f)
//        {
//        	fireAnimationSpeed = fireAnimationSpeed * (-1);
//        	frame = 6;
//        }
//        else
//        {
//        	frame += fireAnimationSpeed;
//        }
    }
}