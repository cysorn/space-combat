package game.objects.laser;

import java.awt.image.BufferedImage;
import java.util.List;

import game.objects.Sprite;
import game.objects.enemies.EnemyStarshipSprite;
import game.objects.enemies.logic.EnemyStarshipLogic;

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
	
	public void nextFrame(List<EnemyStarshipLogic> enemies, Sprite target)
	{
		checkCollisions(enemies);
		if(target != null)
		{
			
		}
		else if(freezeLaser == false)
		{
			laserSprite.yPos -= laserFlySpeed;
		}
	}
	
	private void checkCollisions(List<EnemyStarshipLogic> enemies)
	{
		for(EnemyStarshipLogic enemy: enemies)
		{
			if(laserSprite.yPos <= enemy.getEnemyStarshipSprite().yPos + enemy.getSpriteHeight()
			&& laserSprite.yPos >= enemy.getEnemyStarshipSprite().yPos
			&& laserSprite.xPos >= enemy.getEnemyStarshipSprite().xPos && laserSprite.xPos <= enemy.getEnemyStarshipSprite().xPos + enemy.getSpriteWidth())
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