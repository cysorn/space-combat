package game.ui.gui;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.io.IOException;

import game.objects.background.BackgroundLogic;
import game.objects.background.star.logic.StarLogic;
import game.objects.introducing.IntroducingLogic;
import game.objects.player.starship.logic.StarshipLogic;

public class PaintSprites {
	private SpaceCombatPanel spaceCombatPanel;
    public BackgroundLogic backgroundSprites;
    public StarshipLogic starshipLogic;
    public IntroducingLogic introducingSprites;
    
    public PaintSprites(SpaceCombatPanel spaceCombatPanel, int windowWidth, int windowHeight) throws IOException {
    	this.spaceCombatPanel = spaceCombatPanel;
    	backgroundSprites = new BackgroundLogic(windowWidth, windowHeight);
    	starshipLogic = new StarshipLogic(windowWidth, windowHeight);
        introducingSprites = new IntroducingLogic();
	}
    
    public void introducing(Graphics2D g2d)
    {
    	if(introducingSprites.introducingContinues == true)
        {
	    	g2d.setComposite(AlphaComposite.SrcOver.derive(introducingSprites.blackScreenLogic.blackScreenSprite.currentAlpha));
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
    	for(StarLogic starLogic: backgroundSprites.starsLogics)
    	{
    		g2d.setComposite(AlphaComposite.SrcOver.derive(starLogic.starSprite.currentAlpha));
            g2d.drawImage(starLogic.starSprite.getSpriteTexture(),
            		(int)starLogic.starSprite.xPos,
            		(int)starLogic.starSprite.yPos,
            		spaceCombatPanel);
            starLogic.nextFrame();
    	}
        g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
    
    public void paintPlayersStarship(Graphics2D g2d)
    {
    	g2d.setComposite(AlphaComposite.SrcOver.derive(starshipLogic.starshipSprite.currentAlpha));
    	g2d.drawImage(starshipLogic.getSpriteTexture(),//
    			(int)starshipLogic.starshipSprite.xPos,
    			(int)starshipLogic.starshipSprite.yPos,
    			spaceCombatPanel);
    	starshipLogic.nextFrame();
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
    
    public void paintStarshipExplosion(Graphics2D g2d)
    {
    	g2d.drawImage(starshipLogic.starshipExplosion.getSpriteTexture(),//
    			(int)starshipLogic.starshipSprite.xPos - 93,
    			(int)starshipLogic.starshipSprite.yPos - 75,
    			spaceCombatPanel);
    	starshipLogic.starshipExplosion.nextFrame();
    }
    
    public void paintHealthBar(Graphics2D g2d)
    {
    	g2d.setComposite(AlphaComposite.SrcOver.derive(starshipLogic.starshipSprite.currentAlpha));
    	g2d.drawImage(starshipLogic.healthBarLogic.getSpriteTexture(),//
    			(int)starshipLogic.healthBarLogic.healthBarSprite.xPos,
    			(int)starshipLogic.healthBarLogic.healthBarSprite.yPos,
    			spaceCombatPanel);
    	starshipLogic.healthBarLogic.nextFrame();
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
}
