package game.objects.enemies.enemy_laser;

import java.awt.image.BufferedImage;

import game.objects.Sprite;
import game.objects.spaceship.logic.SpaceshipLogic;

public class EnemyProjectileFly {
	
	public EnemyLaserSprite enemyLaserSprite;
	private float laserFlySpeed;
	private float laserYFlySpeed;
	private float laserXFlySpeed;
	private boolean freezeLaser;
	private boolean hit;
	private SpaceshipLogic spaceshipLogic;
	
	public EnemyProjectileFly(EnemyLaserSprite enemyLaserSprite, SpaceshipLogic spaceshipLogic)
	{
		this.enemyLaserSprite = enemyLaserSprite;
		laserFlySpeed = 10f;
		freezeLaser = false;
		hit = false;
		findAndSetLaserXAndYSpeed(spaceshipLogic.spaceshipSprite);
		this.spaceshipLogic = spaceshipLogic;
	}
	
	public void nextFrame()
	{
		checkCollisions();
		if(freezeLaser == false)
		{
			enemyLaserSprite.yPos += laserYFlySpeed;
			enemyLaserSprite.xPos += laserXFlySpeed;
		}
	}
	
	private void findAndSetLaserXAndYSpeed(Sprite spaceshipSprite)
	{
		float xAbsDistance = Math.abs(enemyLaserSprite.xPos - spaceshipSprite.xPos);
		float yAbsDistance = Math.abs(enemyLaserSprite.yPos - spaceshipSprite.yPos - spaceshipSprite.getSpriteHeight() / 4);
		float framesCountToFlyAllTheDistance = (xAbsDistance + yAbsDistance) / laserFlySpeed;
		if(enemyLaserSprite.xPos > spaceshipSprite.xPos)
		{
			laserXFlySpeed = -((xAbsDistance - spaceshipSprite.getSpriteWidth() / 3)/ framesCountToFlyAllTheDistance);
		}
		else
		{
			laserXFlySpeed = ((xAbsDistance + spaceshipSprite.getSpriteWidth() / 3)/ framesCountToFlyAllTheDistance);
		}
		laserYFlySpeed = yAbsDistance / framesCountToFlyAllTheDistance;
	}
	
	private void checkCollisions()
	{
		if(spaceshipLogic.spaceshipShotDown() == false
		&& spaceshipLogic.spawnSpaceship.animationPlays() == false
		&& enemyLaserSprite.xPos > spaceshipLogic.spaceshipSprite.xPos
		&& enemyLaserSprite.xPos < spaceshipLogic.spaceshipSprite.xPos + spaceshipLogic.spaceshipSprite.getSpriteWidth()
		&& enemyLaserSprite.yPos > spaceshipLogic.spaceshipSprite.yPos
		&& enemyLaserSprite.yPos < spaceshipLogic.spaceshipSprite.yPos + spaceshipLogic.spaceshipSprite.getSpriteHeight())
		{
			spaceshipLogic.healthBarLogic.objectStats.decreaseHealthBy(20);
			freezeLaser = true;
			hit = true;
		}
	}
	
	public BufferedImage getLaserTexture()
	{
		return enemyLaserSprite.enemyLaserTextures.getLaserTexture();
//		if(currentTextureNr > 0)
//		{
//			if(currentTextureNr < laserSprite.laserTextures.getFadeTextures().size())
//			{
//				return laserSprite.laserTextures.getFadeTextures().get(currentTextureNr);
//			}
//			return null;
//		}
//		else
//		{
//			return laserSprite.laserTextures.getLaserTexture();
//		}
	}
	
	public boolean hitIsTrue()
	{
		return hit;
	}
}