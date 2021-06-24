package game.ui.gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import game.field.logic.FieldLogic;
import game.objects.Sprite;
import game.objects.background.BackgroundLogic;
import game.objects.background.star.logic.StarLogic;
import game.objects.enemies.logic.EnemySpaceshipLogic;
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
    	g2d.setComposite(AlphaComposite.SrcOver.derive(fieldLogic.spaceshipLogic.spaceshipSprite.currentAlpha));
    	g2d.drawImage(fieldLogic.spaceshipLogic.getSpriteTexture(),//
    			(int)fieldLogic.spaceshipLogic.spaceshipSprite.xPos,
    			(int)fieldLogic.spaceshipLogic.spaceshipSprite.yPos,
    			spaceCombatPanel);
    	fieldLogic.spaceshipLogic.nextFrame();
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
    
    public void paintStarshipExplosion(Graphics2D g2d)
    {
	    if(fieldLogic.spaceshipLogic.spaceshipExplosion.animationPlays() == true)
	    {
	    	g2d.drawImage(fieldLogic.spaceshipLogic.spaceshipExplosion.getSpriteTexture(),//
	    			(int)fieldLogic.spaceshipLogic.spaceshipSprite.xPos - 93,
	    			(int)fieldLogic.spaceshipLogic.spaceshipSprite.yPos - 75,
	    			spaceCombatPanel);
	    	fieldLogic.spaceshipLogic.spaceshipExplosion.nextFrame();
	    }
    }
    
    public void paintEnemyStarshipExplosions(Graphics2D g2d)
    {
    	for(EnemySpaceshipLogic enemyStarshipLogic: fieldLogic.enemySpaceshipLogics)
    	{
    		if(enemyStarshipLogic.spaceshipExplosion.animationPlays() == true)
    		{
    			g2d.drawImage(enemyStarshipLogic.spaceshipExplosion.getSpriteTexture(),//
            			(int)enemyStarshipLogic.getEnemySpaceshipSprite().xPos - 95,
            			(int)enemyStarshipLogic.getEnemySpaceshipSprite().yPos - 85,
            			spaceCombatPanel);
    			enemyStarshipLogic.spaceshipExplosion.nextFrame();
    		}
    	}
    }
    
    public void paintEnemiesHealthBars(Graphics2D g2d)
    {
    	Sprite healthBarSprite;
    	HealthBarLogic enemyHealthBarLogic;
    	Color redHealthBarColor;
    	Color greyHealthBarColor;

    	for(EnemySpaceshipLogic enemyStarshipLogic: fieldLogic.enemySpaceshipLogics)
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
    	Sprite healthBarSprite = fieldLogic.spaceshipLogic.healthBarLogic.healthBarSprite;
    	Color redHealthBarColor = new Color(1f, 0f, 0f, healthBarSprite.currentAlpha);
    	Color greyHealthBarColor = new Color(0.05f, 0.05f, 0.05f, 1f);
    	g2d.setComposite(AlphaComposite.SrcOver.derive(healthBarSprite.currentAlpha));
    	g2d.drawImage(fieldLogic.spaceshipLogic.healthBarLogic.getSpriteTexture(),//
    			(int)healthBarSprite.xPos,
    			(int)healthBarSprite.yPos,
    			spaceCombatPanel);
    	if(fieldLogic.spaceshipLogic.healthBarLogic.healthChange.healthDecrease.paintRedBar() == true)
    	{
    		g2d.setColor(redHealthBarColor);
        	g2d.fillRect((int)healthBarSprite.xPos + healthBarSprite.getSpriteWidth(),
        			(int)healthBarSprite.yPos + 2,
        			-fieldLogic.spaceshipLogic.healthBarLogic.healthChange.healthDecrease.getRedBarLong(),
        			healthBarSprite.getSpriteHeight() - 4);
    	}
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    	if(fieldLogic.spaceshipLogic.healthBarLogic.healthChange.paintGreyBar() == true)
    	{
    		g2d.setColor(greyHealthBarColor);
        	g2d.fillRect((int)healthBarSprite.xPos + healthBarSprite.getSpriteWidth(),
        			(int)healthBarSprite.yPos + 2,
        			-fieldLogic.spaceshipLogic.healthBarLogic.healthChange.getGreyBarLong(),
        			healthBarSprite.getSpriteHeight() - 4);
    	}
    	fieldLogic.spaceshipLogic.healthBarLogic.nextFrame();
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
    
    public void paintEnemyStarships(Graphics2D g2d)
    {
    	for(EnemySpaceshipLogic enemySpaceshipLogic: fieldLogic.enemySpaceshipLogics)
    	{
    		g2d.setComposite(AlphaComposite.SrcOver.derive(enemySpaceshipLogic.getEnemySpaceshipSprite().currentAlpha));
        	g2d.drawImage(enemySpaceshipLogic.getEnemySpaceshipSprite().getEnemySpaceshipTexture(),//
        			(int)enemySpaceshipLogic.getEnemySpaceshipSprite().xPos,
        			(int)enemySpaceshipLogic.getEnemySpaceshipSprite().yPos,
        			spaceCombatPanel);
        	enemySpaceshipLogic.nextFrame(fieldLogic.spaceshipLogic);
    	}
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    	fieldLogic.nextFrame();
    }
    
    public void paintLaser(Graphics2D g2d)
    {
    	for(int laserLogicNr = 0; laserLogicNr < fieldLogic.spaceshipLogic.spaceshipShoot.laserLogics.size(); ++laserLogicNr)
    	{
    		if(fieldLogic.spaceshipLogic.spaceshipShoot.laserLogics.get(laserLogicNr).projectileFly.hitIsTrue() == true
    		|| fieldLogic.spaceshipLogic.spaceshipShoot.laserLogics.get(laserLogicNr).laserSprite.yPos 
    			+ fieldLogic.spaceshipLogic.spaceshipShoot.laserLogics.get(laserLogicNr).laserSprite.getSpriteHeight() < 0 )
    		{
    			fieldLogic.spaceshipLogic.spaceshipShoot.laserLogics.remove(laserLogicNr);
    			--laserLogicNr;
    			continue;
    		}
    		g2d.drawImage(fieldLogic.spaceshipLogic.spaceshipShoot.laserLogics.get(laserLogicNr).getLaserTexture(),//
        			(int)fieldLogic.spaceshipLogic.spaceshipShoot.laserLogics.get(laserLogicNr).laserSprite.xPos,
        			(int)fieldLogic.spaceshipLogic.spaceshipShoot.laserLogics.get(laserLogicNr).laserSprite.yPos,
        			spaceCombatPanel);
    		fieldLogic.spaceshipLogic.spaceshipShoot.laserLogics.get(laserLogicNr).nextFrame(fieldLogic.enemySpaceshipLogics);
    	}
    }
}
