package game.objects.health_bar;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HealthBarTextures {
	
	BufferedImage healthBarTexture;
	
	public HealthBarTextures() throws IOException
	{
		healthBarTexture = ImageIO.read(new File("src/textures/healthbar.png"));
	}
}