package game.logic.player;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import game.logic.ReadAnimation;

public abstract class StarshipTextures{

	protected List<BufferedImage> starshipTextures;
	protected List<BufferedImage> starshipEngineTextures;

	public StarshipTextures() throws IOException{

	    //add textures of the starship
	    starshipTextures = new ArrayList<BufferedImage>();
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly_2.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly_3.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly_4.png")));
	    
	    
	    //add textures of the starship engine
//	    starshipEngineTextures = new ArrayList<BufferedImage>();
//	    ReadAnimation.readFlipedAnimation(starshipEngineTextures,
//	    		new File("src/textures/starship/engine__.png"),
//	    		512, 256, 64, 32);
	}
}