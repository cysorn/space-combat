package game.objects.enemies.enemy_laser;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.spaceship.logic.SpaceshipLogic;

public class EnemyLaserLogic {
	
	public EnemyLaserSprite enemyLaserSprite;
	public EnemyProjectileFly enemyProjectileFly;
	
	public EnemyLaserLogic(float xPos, float yPos, SpaceshipLogic spaceshipLogic, float laserFlySpeed) throws IOException
	{
		enemyLaserSprite = new EnemyLaserSprite(xPos, yPos);
		enemyProjectileFly = new EnemyProjectileFly(enemyLaserSprite, spaceshipLogic, laserFlySpeed);
	}
	
	public void nextFrame()
	{
		enemyProjectileFly.nextFrame();
	}
	
	public BufferedImage getLaserTexture()
	{
		return enemyProjectileFly.getLaserTexture();
	}
}