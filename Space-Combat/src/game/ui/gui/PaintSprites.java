package game.ui.gui;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.io.IOException;

import game.sprites.background_sprites.BackgroundSprites;
import game.sprites.introducing_sprites.IntroducingSprites;
import game.sprites.player_sprites.PlayerSprites;

public class PaintSprites {
	private SpaceCombatPanel spaceCombatPanel;
    public BackgroundSprites backgroundSprites;
    public PlayerSprites playerSprites;
    public IntroducingSprites introducingSprites;
    
    public PaintSprites(SpaceCombatPanel spaceCombatPanel, int windowWidth, int windowHeight) throws IOException {
    	this.spaceCombatPanel = spaceCombatPanel;
    	backgroundSprites = new BackgroundSprites(windowWidth, windowHeight);
        playerSprites = new PlayerSprites(windowWidth, windowHeight);
        introducingSprites = new IntroducingSprites();
	}
    
    public void introducing(Graphics2D g2d)
    {
    	if(introducingSprites.introducingContinues == true)
        {
	    	g2d.setComposite(AlphaComposite.SrcOver.derive(introducingSprites.blackScreen.currentAlpha));
	    	g2d.drawImage(introducingSprites.getBlackScreenTexture(),
	           		0,
	           		0,
	           		spaceCombatPanel);
	    	introducingSprites.nextFrame();
	    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
        }
    }
    
    public void paintStars(Graphics2D g2d)
    {
    	for(int starNr = 0; starNr < backgroundSprites.starsEntities.size(); ++starNr)
        {
            g2d.setComposite(AlphaComposite.SrcOver.derive(backgroundSprites.starsEntities.get(starNr).currentAlpha));
            g2d.drawImage(backgroundSprites.starsEntities.get(starNr).getSpriteTexture(),
            		(int)backgroundSprites.starsEntities.get(starNr).xPos,
            		(int)backgroundSprites.starsEntities.get(starNr).yPos,
            		spaceCombatPanel);
            backgroundSprites.starsEntities.get(starNr).nextFrame();
        }
        g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
    
    public void paintPlayersStarship(Graphics2D g2d)
    {
    	g2d.setComposite(AlphaComposite.SrcOver.derive(playerSprites.starship.currentAlpha));
    	g2d.drawImage(playerSprites.starship.getSpriteTexture(),//
    			(int)playerSprites.starship.xPos,
    			(int)playerSprites.starship.yPos,
    			spaceCombatPanel);
    	playerSprites.starship.nextFrame();
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
}
