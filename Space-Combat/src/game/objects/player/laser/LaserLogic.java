package game.objects.player.laser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.objects.Sprite;

public class LaserLogic {
	
	public LaserSprite laserSprite;
	private Shoot shoot;
	private List<Sprite> enemies;
	
	public LaserLogic(float xPos, float yPos) throws IOException
	{
		laserSprite = new LaserSprite(xPos, yPos);
		shoot = new Shoot(laserSprite);
		enemies = new ArrayList<>();
	}
	
	void nextFrame()
	{
		shoot.nextFrame();
	}
}