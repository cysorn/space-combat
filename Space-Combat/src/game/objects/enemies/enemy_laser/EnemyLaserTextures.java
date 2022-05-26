package game.objects.enemies.enemy_laser;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemyLaserTextures{
	protected BufferedImage enemyLaserTexture;
	
	public EnemyLaserTextures() throws IOException
	{
		enemyLaserTexture = ImageIO.read(getClass().getResource("/textures/enemies/laser/laser.png"));
	}
	
	public BufferedImage getLaserTexture()
	{
		return enemyLaserTexture;
	}
}