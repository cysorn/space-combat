package game.objects.laser;

import java.io.IOException;

import game.objects.Sprite;

public class LaserSprite extends Sprite{

	public LaserTextures laserTextures;
	
	public LaserSprite(float xPos, float yPos, LaserColors laserColor) throws IOException {
		
		super(xPos, yPos, 15, 42);
		if(laserColor == LaserColors.GREEN)
		{
			laserTextures = new LaserGreenTextures();
		}
		else
		{
			laserTextures = new LaserRedTextures();
		}
	}
}