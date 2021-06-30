package game.objects.spaceship.laser;

import java.awt.image.BufferedImage;
import java.util.List;

import game.objects.enemies.logic.EnemySpaceshipLogic;

public class ProjectileFly {
	
	public LaserSprite laserSprite;
	private float laserFlySpeed;
//	private int currentTextureNr;
	private boolean freezeLaser;
	private boolean hit;
	
	public ProjectileFly(LaserSprite laserSprite)
	{
		this.laserSprite = laserSprite;
		laserFlySpeed = 20f;
//		currentTextureNr = -1;
		freezeLaser = false;
		hit = false;
	}
	
	public void nextFrame(List<EnemySpaceshipLogic> enemies)
	{
		checkCollisions(enemies);
		if(freezeLaser == false)
		{
			laserSprite.yPos -= laserFlySpeed;
		}
	}
	
	private void checkCollisions(List<EnemySpaceshipLogic> enemies)
	{
		for(EnemySpaceshipLogic enemy: enemies)
		{
			if(enemy.enemySpaceshipShotDown() == false
			&& laserSprite.yPos <= enemy.getEnemySpaceshipSprite().yPos + enemy.getSpriteHeight()
			&& laserSprite.yPos >= enemy.getEnemySpaceshipSprite().yPos
			&& laserSprite.xPos >= enemy.getEnemySpaceshipSprite().xPos && laserSprite.xPos <= enemy.getEnemySpaceshipSprite().xPos + enemy.getSpriteWidth())
			{
				enemy.healthBarLogic.objectStats.decreaseHealthBy(20);
				freezeLaser = true;
				hit = true;
			}
		}
	}
	
	public BufferedImage getLaserTexture()
	{
		return laserSprite.laserTextures.getLaserTexture();
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