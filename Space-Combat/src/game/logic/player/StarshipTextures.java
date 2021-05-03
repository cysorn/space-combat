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

	public StarshipTextures() throws IOException{

	    //add textures of the starship
	    starshipTextures = new ArrayList<BufferedImage>();
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly_2.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly_3.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly_4.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly_5.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly_6.png")));
	}
}