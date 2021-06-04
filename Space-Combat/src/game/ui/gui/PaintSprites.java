package game.ui.gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import game.objects.Sprite;
import game.objects.background.BackgroundLogic;
import game.objects.background.star.logic.StarLogic;
import game.objects.introducing.IntroducingLogic;
import game.objects.player.starship.logic.StarshipLogic;

public class PaintSprites {
	private SpaceCombatPanel spaceCombatPanel;
    public BackgroundLogic backgroundSprites;
    public StarshipLogic starshipLogic;
    public IntroducingLogic introducingSprites;
    private Color redHealthBarColor;
    private Color greyHealthBarColor;
    
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
    	Sprite healthBarSprite = starshipLogic.healthBarLogic.healthBarSprite;
        redHealthBarColor = new Color(1f, 0f, 0f, healthBarSprite.currentAlpha);
//        greyHealthBarColor = new Color(0.05f, 0.05f, 0.05f, healthBarSprite.currentAlpha);
        greyHealthBarColor = new Color(0.05f, 0.05f, 0.05f, 1f);
    	g2d.setComposite(AlphaComposite.SrcOver.derive(healthBarSprite.currentAlpha));
    	g2d.drawImage(starshipLogic.healthBarLogic.getSpriteTexture(),//
    			(int)healthBarSprite.xPos,
    			(int)healthBarSprite.yPos,
    			spaceCombatPanel);
    	if(starshipLogic.healthBarLogic.healthChange.healthDecrease.paintRedBar() == true)
    	{
    		g2d.setColor(redHealthBarColor);
        	g2d.fillRect((int)healthBarSprite.xPos + healthBarSprite.getSpriteWidth(),
        			(int)healthBarSprite.yPos + 2,
        			-starshipLogic.healthBarLogic.healthChange.healthDecrease.getRedBarLong(),
        			healthBarSprite.getSpriteHeight() - 4);
    	}
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    	if(starshipLogic.healthBarLogic.healthChange.paintGreyBar() == true)
    	{
    		g2d.setColor(greyHealthBarColor);
        	g2d.fillRect((int)healthBarSprite.xPos + healthBarSprite.getSpriteWidth(),
        			(int)healthBarSprite.yPos + 2,
        			-starshipLogic.healthBarLogic.healthChange.getGreyBarLong(),
        			healthBarSprite.getSpriteHeight() - 4);
    	}
    	starshipLogic.healthBarLogic.nextFrame();
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
}
