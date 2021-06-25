package game.loading;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class LoadingTextures {
	List<BufferedImage> loadingTextures;
	
	public LoadingTextures() throws IOException
	{
		loadingTextures = new ArrayList<>();
		
		for(int fileNr = 1; fileNr < 48; ++fileNr)
		{
			loadingTextures.add(ImageIO.read(new File("src/textures/loading/" + Integer.toString(fileNr) + ".png")));
		}
	}
}
