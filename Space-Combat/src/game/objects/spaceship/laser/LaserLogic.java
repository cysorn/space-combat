package game.objects.spaceship.laser;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import game.objects.enemies.logic.EnemySpaceshipLogic;

public class LaserLogic {
	
	public LaserSprite laserSprite;
	public ProjectileFly projectileFly;
	
	public LaserLogic(float xPos, float yPos) throws IOException
	{
		laserSprite = new LaserSprite(xPos, yPos, LaserColors.RED);
		projectileFly = new ProjectileFly(laserSprite);
	}
	
	public void nextFrame(List<EnemySpaceshipLogic> enemies)
	{
		projectileFly.nextFrame(enemies);
	}
	
	public BufferedImage getLaserTexture()
	{
		return projectileFly.getLaserTexture();
	}
}