package game.objects.enemies.enemy_laser;

import java.awt.image.BufferedImage;

public abstract class LaserTextures {
	protected BufferedImage laserTexture;
//	protected List<BufferedImage> fadeTextures;
	
//	public List<BufferedImage> getFadeTextures()
//	{
//		return fadeTextures;
//	}
	
	public BufferedImage getLaserTexture()
	{
		return laserTexture;
	}
}
