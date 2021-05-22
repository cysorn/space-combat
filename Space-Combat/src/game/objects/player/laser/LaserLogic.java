package game.objects.player.laser;

import java.io.IOException;

public class LaserLogic {
	
	public LaserSprite laserSprite;
	private Shoot shoot;
	
	public LaserLogic(float xPos, float yPos) throws IOException
	{
		laserSprite = new LaserSprite(xPos, yPos);
		shoot = new Shoot(laserSprite);
	}
	
	void nextFrame()
	{
		
	}
}