package game.loading;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class LoadingTextures {
	public List<BufferedImage> loadingTextures;
	
	public LoadingTextures()
	{
		loadingTextures = new ArrayList<>();
		
		for(int fileNr = 1; fileNr < 47; ++fileNr)
		{
			try {
				loadingTextures.add(ImageIO.read(getClass().getResource("/textures/loading/" + Integer.toString(fileNr) + ".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
