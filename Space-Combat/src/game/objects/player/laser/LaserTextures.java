package game.objects.player.laser;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LaserTextures {
	
	BufferedImage laserTexture;
	
	public LaserTextures() throws IOException
	{
		laserTexture = ImageIO.read(new File("src/textures/starship/laser.png"));
	}
}