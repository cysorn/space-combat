package game.objects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class SpaceshipExplosionTextures {
	public List<BufferedImage> spaceshipExplosionTextures;
	public SpaceshipExplosionTextures() throws IOException {
		
		spaceshipExplosionTextures = new ArrayList<>();
		for(int fileNr = 1; fileNr < 49; ++fileNr)
		{
			String fileNrString = Integer.toString(fileNr);
			if(fileNrString.length() < 2)
			{
				fileNrString = "0" + fileNrString;
			}
			spaceshipExplosionTextures.add(ImageIO.read(getClass().getResource("/textures/explosion/image_part_0" + fileNrString + ".png")));
		}
	}
}