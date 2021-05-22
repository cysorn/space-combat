package game.objects.player.laser;

public class Shoot {
	
	LaserSprite laserSprite;
	int moveSpeed;
	
	public Shoot(LaserSprite laserSprite)
	{
		this.laserSprite = laserSprite;
		moveSpeed = 40;
	}
	
	public void nextFrame()
	{
		laserSprite.yPos += moveSpeed;
	}
}