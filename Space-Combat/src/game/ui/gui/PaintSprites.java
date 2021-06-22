package game.ui.gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import game.field.logic.FieldLogic;
import game.objects.Sprite;
import game.objects.background.BackgroundLogic;
import game.objects.background.star.logic.StarLogic;
import game.objects.enemies.logic.EnemyStarshipLogic;
import game.objects.health_bar.logic.HealthBarLogic;
import game.objects.introducing.IntroducingLogic;

public class PaintSprites {
	private SpaceCombatPanel spaceCombatPanel;
    public BackgroundLogic backgroundSprites;
    public FieldLogic fieldLogic;
    public IntroducingLogic introducingSprites;
    
    public PaintSprites(SpaceCombatPanel spaceCombatPanel, int windowWidth, int windowHeight) throws IOException {
    	this.spaceCombatPanel = spaceCombatPanel;
    	backgroundSprites = new BackgroundLogic(windowWidth, windowHeight);
    	fieldLogic = new FieldLogic(windowWidth, windowHeight);
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
    	g2d.setComposite(AlphaComposite.SrcOver.derive(fieldLogic.starshipLogic.starshipSprite.currentAlpha));
    	g2d.drawImage(fieldLogic.starshipLogic.getSpriteTexture(),//
    			(int)fieldLogic.starshipLogic.starshipSprite.xPos,
    			(int)fieldLogic.starshipLogic.starshipSprite.yPos,
    			spaceCombatPanel);
    	fieldLogic.starshipLogic.nextFrame();
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
    
    public void paintStarshipExplosion(Graphics2D g2d)
    {
	    if(fieldLogic.starshipLogic.starshipExplosion.animationPlays() == true)
	    {
	    	g2d.drawImage(fieldLogic.starshipLogic.starshipExplosion.getSpriteTexture(),//
	    			(int)fieldLogic.starshipLogic.starshipSprite.xPos - 93,
	    			(int)fieldLogic.starshipLogic.starshipSprite.yPos - 75,
	    			spaceCombatPanel);
	    	fieldLogic.starshipLogic.starshipExplosion.nextFrame();
	    }
    }
    
    public void paintEnemyStarshipExplosions(Graphics2D g2d)
    {
    	for(EnemyStarshipLogic enemyStarshipLogic: fieldLogic.enemyStarshipLogics)
    	{
    		if(enemyStarshipLogic.starshipExplosion.animationPlays() == true)
    		{
    			g2d.drawImage(enemyStarshipLogic.starshipExplosion.getSpriteTexture(),//
            			(int)enemyStarshipLogic.getEnemyStarshipSprite().xPos - 95,
            			(int)enemyStarshipLogic.getEnemyStarshipSprite().yPos - 85,
            			spaceCombatPanel);
    			enemyStarshipLogic.starshipExplosion.nextFrame();
    		}
    	}
    }
    
    public void paintEnemiesHealthBars(Graphics2D g2d)
    {
    	Sprite healthBarSprite;
    	HealthBarLogic enemyHealthBarLogic;
    	Color redHealthBarColor;
    	Color greyHealthBarColor;
    	
    	
//    	enemyHealthBarLogic = fieldLogic.enemyStarshipLogics.get(0).healthBarLogic;
//		healthBarSprite = enemyHealthBarLogic.healthBarSprite;
//    	g2d.setComposite(AlphaComposite.SrcOver.derive(healthBarSprite.currentAlpha));
////    	System.out.println(healthBarSprite.currentAlpha);
//    	g2d.drawImage(enemyHealthBarLogic.getSpriteTexture(),//
//    			(int)healthBarSprite.xPos,
//    			(int)healthBarSprite.yPos,
//    			spaceCombatPanel);
//    	enemyHealthBarLogic.nextFrame();
    	
    	
    	for(EnemyStarshipLogic enemyStarshipLogic: fieldLogic.enemyStarshipLogics)
    	{
    		enemyHealthBarLogic = enemyStarshipLogic.healthBarLogic;
    		healthBarSprite = enemyHealthBarLogic.healthBarSprite;
    		redHealthBarColor = new Color(1f, 0f, 0f, healthBarSprite.currentAlpha);
        	greyHealthBarColor = new Color(0.05f, 0.05f, 0.05f, 1f);
	    	g2d.setComposite(AlphaComposite.SrcOver.derive(healthBarSprite.currentAlpha));
	    	g2d.drawImage(enemyHealthBarLogic.getSpriteTexture(),//
	    			(int)healthBarSprite.xPos - 6,
	    			(int)healthBarSprite.yPos,
	    			spaceCombatPanel);
	    	if(enemyHealthBarLogic.healthChange.healthDecrease.paintRedBar() == true)
	    	{
	    		g2d.setColor(redHealthBarColor);
	        	g2d.fillRect((int)healthBarSprite.xPos + healthBarSprite.getSpriteWidth() - 6,
	        			(int)healthBarSprite.yPos + 2,
	        			-enemyHealthBarLogic.healthChange.healthDecrease.getRedBarLong(),
	        			healthBarSprite.getSpriteHeight() - 4);
	    	}
	    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
	    	if(enemyHealthBarLogic.healthChange.paintGreyBar() == true)
	    	{
	    		g2d.setColor(greyHealthBarColor);
	        	g2d.fillRect((int)healthBarSprite.xPos + healthBarSprite.getSpriteWidth() - 6,
	        			(int)healthBarSprite.yPos + 2,
	        			-enemyHealthBarLogic.healthChange.getGreyBarLong(),
	        			healthBarSprite.getSpriteHeight() - 4);
	    	}
	    	enemyHealthBarLogic.nextFrame();
    	}
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
    
    public void paintPlayersHealthBar(Graphics2D g2d)
    {
    	Sprite healthBarSprite = fieldLogic.starshipLogic.healthBarLogic.healthBarSprite;
    	Color redHealthBarColor = new Color(1f, 0f, 0f, healthBarSprite.currentAlpha);
    	Color greyHealthBarColor = new Color(0.05f, 0.05f, 0.05f, 1f);
    	g2d.setComposite(AlphaComposite.SrcOver.derive(healthBarSprite.currentAlpha));
    	g2d.drawImage(fieldLogic.starshipLogic.healthBarLogic.getSpriteTexture(),//
    			(int)healthBarSprite.xPos,
    			(int)healthBarSprite.yPos,
    			spaceCombatPanel);
    	if(fieldLogic.starshipLogic.healthBarLogic.healthChange.healthDecrease.paintRedBar() == true)
    	{
    		g2d.setColor(redHealthBarColor);
        	g2d.fillRect((int)healthBarSprite.xPos + healthBarSprite.getSpriteWidth(),
        			(int)healthBarSprite.yPos + 2,
        			-fieldLogic.starshipLogic.healthBarLogic.healthChange.healthDecrease.getRedBarLong(),
        			healthBarSprite.getSpriteHeight() - 4);
    	}
    	g2d.setComposite(AlphaComposite.SrcOver.derive(healthBarSprite.currentAlpha));
    	if(fieldLogic.starshipLogic.healthBarLogic.healthChange.paintGreyBar() == true)
    	{
    		g2d.setColor(greyHealthBarColor);
        	g2d.fillRect((int)healthBarSprite.xPos + healthBarSprite.getSpriteWidth(),
        			(int)healthBarSprite.yPos + 2,
        			-fieldLogic.starshipLogic.healthBarLogic.healthChange.getGreyBarLong(),
        			healthBarSprite.getSpriteHeight() - 4);
    	}
    	fieldLogic.starshipLogic.healthBarLogic.nextFrame();
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
    
    public void paintEnemyStarships(Graphics2D g2d)
    {
    	for(EnemyStarshipLogic enemyStarshipLogic: fieldLogic.enemyStarshipLogics)
    	{
    		g2d.setComposite(AlphaComposite.SrcOver.derive(enemyStarshipLogic.getEnemyStarshipSprite().currentAlpha));
        	g2d.drawImage(enemyStarshipLogic.getEnemyStarshipSprite().getEnemyStarshipTexture(),//
        			(int)enemyStarshipLogic.getEnemyStarshipSprite().xPos,
        			(int)enemyStarshipLogic.getEnemyStarshipSprite().yPos,
        			spaceCombatPanel);
        	enemyStarshipLogic.nextFrame();
    	}
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    	fieldLogic.nextFrame();
    }
}
