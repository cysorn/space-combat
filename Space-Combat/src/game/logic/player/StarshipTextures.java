package game.logic.player;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public abstract class StarshipTextures{

	protected List<BufferedImage> starshipTextures;
	public List<BufferedImage> starshipEngineTextures;

	public StarshipTextures() throws IOException{

	    //add textures of the starship
	    starshipTextures = new ArrayList<BufferedImage>();
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_stop.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_flying.png")));
	    
	    
	    //add textures of the starship engine
	    starshipEngineTextures = new ArrayList<BufferedImage>();
//	    not fliped animation
//	    int fileWidth = 1024;
//	    int fileHeight = 1024;
//	    int picWidth = 128;
//	    int picHeight = 128;
//	    for(int picY = 0; picY < fileHeight; picY += picHeight)
//	    {
//	    	for(int picX = 0; picX < fileWidth; picX += picWidth)
//	    	{
//	    		starshipEngineTextures.add(ImageIO.read(new File("src/textures/starship/fire5_64.png")).getSubimage(picX, picY, picWidth, picHeight));
//	    	}
//	    }
//	    fliped animation
	    int fileWidth = 512;
	    int fileHeight = 512;
	    int picWidth = 64;
	    int picHeight = 64;
	    for(int picY = fileHeight - picHeight; picY >= 0; picY -= picHeight)
	    {
	    	for(int picX = 0; picX < fileWidth; picX += picWidth)
	    	{
	    		//TODO
	    		starshipEngineTextures.add(ImageIO.read(new File("src/textures/starship/engine.png")).getSubimage(picX, picY, picWidth, picHeight));
	    	}
	    }
	}
}