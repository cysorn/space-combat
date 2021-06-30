package game.ui.gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.List;

import game.field.logic.FieldLogic;
import game.introducing.IntroducingLogic;
import game.loading.logic.LoadingLogic;
import game.objects.Sprite;
import game.objects.background.BackgroundLogic;
import game.objects.background.star.logic.StarLogic;
import game.objects.enemies.enemy_laser.EnemyLaserLogic;
import game.objects.enemies.logic.EnemySpaceshipLogic;
import game.objects.health_bar.logic.HealthBarLogic;

public class PaintSprites {
	private LoadingLogic loadingLogic;
	private SpaceCombatPanel spaceCombatPanel;
    public BackgroundLogic backgroundSprites;
    public FieldLogic fieldLogic;
    public IntroducingLogic introducingSprites;
    private int windowWidth;
    private int windowHeight;
    
    public PaintSprites(SpaceCombatPanel spaceCombatPanel, int windowWidth, int windowHeight) throws IOException {
    	loadingLogic = new LoadingLogic(windowWidth, windowHeight);
    	this.spaceCombatPanel = spaceCombatPanel;
    	backgroundSprites = new BackgroundLogic(windowWidth, windowHeight);
    	fieldLogic = new FieldLogic(windowWidth, windowHeight);
        introducingSprites = new IntroducingLogic();
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
	}
    
    public void introducing(Graphics2D g2d, boolean continueIntroducing)
    {
    	if(introducingSprites.introducingContinues == true)
        {
	    	g2d.setComposite(AlphaComposite.SrcOver.derive(introducingSprites.blackScreenLogic.blackScreenSprite.currentAlpha));
	    	g2d.drawImage(introducingSprites.getBlackScreenTexture(),
	           		0,
	           		0,
	           		spaceCombatPanel);
	    	if(continueIntroducing == true)
	    	{
		    	introducingSprites.nextFrame();
	    	}
	    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
        }
    }
    
    public void paintStars(Graphics2D g2d, boolean continueIntroducing)
    {
    	for(StarLogic starLogic: backgroundSprites.starsLogics)
    	{
    		g2d.setComposite(AlphaComposite.SrcOver.derive(starLogic.starSprite.currentAlpha));
            g2d.drawImage(starLogic.starSprite.getSpriteTexture(),
            		(int)starLogic.starSprite.xPos,
            		(int)starLogic.starSprite.yPos,
            		spaceCombatPanel);
            if(continueIntroducing == true)
            {
            	starLogic.nextFrame();
            }
    	}
        g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
    
    public void paintPlayersStarship(Graphics2D g2d, boolean continueIntroducing)
    {
    	g2d.setComposite(AlphaComposite.SrcOver.derive(fieldLogic.spaceshipLogic.spaceshipSprite.currentAlpha));
    	g2d.drawImage(fieldLogic.spaceshipLogic.getSpriteTexture(),//
    			(int)fieldLogic.spaceshipLogic.spaceshipSprite.xPos,
    			(int)fieldLogic.spaceshipLogic.spaceshipSprite.yPos,
    			spaceCombatPanel);
    	if(continueIntroducing == true)
    	{
    		fieldLogic.spaceshipLogic.nextFrame();
    	}
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
    
    public void paintSpaceshipExplosion(Graphics2D g2d)
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
    
    public void paintEnemySpaceshipExplosions(Graphics2D g2d)
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
    
    public void paintEnemyHealthBars(Graphics2D g2d)
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
	    			(int)healthBarSprite.xPos - 1,
	    			(int)healthBarSprite.yPos,
	    			spaceCombatPanel);
	    	if(enemyHealthBarLogic.healthChange.healthDecrease.paintRedBar() == true)
	    	{
	    		g2d.setColor(redHealthBarColor);
	        	g2d.fillRect((int)healthBarSprite.xPos + healthBarSprite.getSpriteWidth() - 1,
	        			(int)healthBarSprite.yPos + 2,
	        			-enemyHealthBarLogic.healthChange.healthDecrease.getRedBarLong(),
	        			healthBarSprite.getSpriteHeight() - 4);
	    	}
	    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
	    	if(enemyHealthBarLogic.healthChange.paintGreyBar() == true)
	    	{
	    		g2d.setColor(greyHealthBarColor);
	        	g2d.fillRect((int)healthBarSprite.xPos + healthBarSprite.getSpriteWidth() - 1,
	        			(int)healthBarSprite.yPos + 2,
	        			-enemyHealthBarLogic.healthChange.getGreyBarLong(),
	        			healthBarSprite.getSpriteHeight() - 4);
	    	}
	    	enemyHealthBarLogic.nextFrame();
    	}
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    }
    
    public void paintPlayerHealthBars(Graphics2D g2d)
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
    
    public void paintEnemyStarships(Graphics2D g2d, boolean continueIntroducing)
    {
    	for(EnemySpaceshipLogic enemySpaceshipLogic: fieldLogic.enemySpaceshipLogics)
    	{
    		g2d.setComposite(AlphaComposite.SrcOver.derive(enemySpaceshipLogic.getEnemySpaceshipSprite().currentAlpha));
        	g2d.drawImage(enemySpaceshipLogic.getEnemySpaceshipSprite().getEnemySpaceshipTexture(),//
        			(int)enemySpaceshipLogic.getEnemySpaceshipSprite().xPos,
        			(int)enemySpaceshipLogic.getEnemySpaceshipSprite().yPos,
        			spaceCombatPanel);
        	if(continueIntroducing == true)
        	{
        		enemySpaceshipLogic.nextFrame(fieldLogic.spaceshipLogic);
        	}
    	}
    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    	fieldLogic.nextFrame(g2d, spaceCombatPanel);
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
    
    public void paintEnemyLaser(Graphics2D g2d)
    {
	    for(int laserLogicNr = 0; laserLogicNr < fieldLogic.enemyLaserLogics.size(); ++laserLogicNr)
	   	{
	    	if(fieldLogic.enemyLaserLogics.get(laserLogicNr).enemyProjectileFly.hitIsTrue() == true
	   		|| fieldLogic.enemyLaserLogics.get(laserLogicNr).enemyLaserSprite.yPos > windowHeight
	   		|| fieldLogic.enemyLaserLogics.get(laserLogicNr).enemyLaserSprite.xPos > windowWidth
	   		|| fieldLogic.enemyLaserLogics.get(laserLogicNr).enemyLaserSprite.xPos + fieldLogic.enemyLaserLogics.get(laserLogicNr).enemyLaserSprite.getSpriteWidth() < 0)
	   		{
	    		fieldLogic.enemyLaserLogics.remove(laserLogicNr);
	   			--laserLogicNr;
	    		continue;
	    	}
	    	g2d.drawImage(fieldLogic.enemyLaserLogics.get(laserLogicNr).getLaserTexture(),//
	       			(int)fieldLogic.enemyLaserLogics.get(laserLogicNr).enemyLaserSprite.xPos,
	       			(int)fieldLogic.enemyLaserLogics.get(laserLogicNr).enemyLaserSprite.yPos,
	       			spaceCombatPanel);
	    	fieldLogic.enemyLaserLogics.get(laserLogicNr).nextFrame();
	    }
    }
    
    public void paintLoadingBar(Graphics2D g2d)
    {
    	if(LoadingLogic.loadedObjectsCounter > 0)
    	{
        	g2d.setComposite(AlphaComposite.SrcOver.derive(loadingLogic.loadingSprite.currentAlpha));
        	g2d.drawImage(loadingLogic.getLoadingTexture(),//
//        	g2d.drawImage(LoadingLogic.loadingSprite.loadingTextures.loadingTextures.get(counter % 46),
        			(int)loadingLogic.loadingSprite.xPos,
        			(int)loadingLogic.loadingSprite.yPos,
        			spaceCombatPanel);
        	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
    	}
    }
    
    void waitAndSetCounterToZeroIfLoadingWasFinished()
    {
        if(LoadingLogic.loadedObjectsCounter == LoadingLogic.objectsToLoadCount)
        {
        	LoadingLogic.loadedObjectsCounter = 0;
        	if(fieldLogic.thereIsNoNextLevel() == false)
			{
	    		try 
	    		{
	    			Thread.sleep(100);
	    		}
	    		catch(InterruptedException ex)
	    		{
	    		    Thread.currentThread().interrupt();
	    		}
        	}
        }
    }
}
