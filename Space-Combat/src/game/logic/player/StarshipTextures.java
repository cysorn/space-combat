package game.logic.player;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public abstract class StarshipTextures{

	protected List<BufferedImage> starshipTextures;

	public StarshipTextures() throws IOException{

	    //add textures of the starship
	    starshipTextures = new ArrayList<BufferedImage>();
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_stop.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_flying.png")));
	    
	}
}