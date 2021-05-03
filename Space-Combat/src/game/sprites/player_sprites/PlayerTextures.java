package game.sprites.player_sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import game.sprites.ReadAnimation;

public abstract class PlayerTextures{

	protected List<BufferedImage> starshipTextures;

	public PlayerTextures() throws IOException{

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