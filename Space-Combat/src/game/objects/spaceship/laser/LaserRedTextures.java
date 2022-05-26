package game.objects.spaceship.laser;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LaserRedTextures extends LaserTextures{
	
	public LaserRedTextures() throws IOException
	{
		laserTexture = ImageIO.read(getClass().getResource("/textures/spaceship/laser/laser.png"));
	}
}