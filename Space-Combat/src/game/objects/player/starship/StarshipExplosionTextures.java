package game.objects.player.starship;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class StarshipExplosionTextures {
	public List<BufferedImage> starshipExplosionTextures;
	public StarshipExplosionTextures() throws IOException {
		
		starshipExplosionTextures = new ArrayList<>();
		for(int fileNr = 1; fileNr < 49; ++fileNr)
		{
			String fileNrString = Integer.toString(fileNr);
			if(fileNrString.length() < 2)
			{
				fileNrString = "0" + fileNrString;
			}
			starshipExplosionTextures.add(ImageIO.read(new File("src/textures/starship/explosion/image_part_0" + fileNrString + ".png")));
		}
	}
}