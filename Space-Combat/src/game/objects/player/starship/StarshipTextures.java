package game.objects.player.starship;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class StarshipTextures{

	public List<BufferedImage> starshipTextures;
	public List<BufferedImage> starshipToTheLeftTextures;
	public List<BufferedImage> starshipToTheRightTextures;

	public StarshipTextures() throws IOException{
		
	    //add textures of the starship
	    starshipTextures = new ArrayList<BufferedImage>();
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly_2.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly_3.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly_4.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly_5.png")));
	    starshipTextures.add(ImageIO.read(new File("src/textures/starship/starship_fly_6.png")));
	    
	    starshipToTheLeftTextures = new ArrayList<BufferedImage>();
	    starshipToTheLeftTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_left/starship_fly_to_the_left_1.png")));
	    starshipToTheLeftTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_left/starship_fly_to_the_left_2.png")));
	    starshipToTheLeftTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_left/starship_fly_to_the_left_3.png")));
	    starshipToTheLeftTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_left/starship_fly_to_the_left_4.png")));
	    starshipToTheLeftTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_left/starship_fly_to_the_left_5.png")));
	    starshipToTheLeftTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_left/starship_fly_to_the_left_6.png")));
	    starshipToTheLeftTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_left/starship_fly_to_the_left_7.png")));
	    starshipToTheLeftTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_left/starship_fly_to_the_left_8.png")));
//	    starshipToTheLeftTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_left/starship_fly_to_the_left_9.png")));
	    
	    starshipToTheRightTextures = new ArrayList<BufferedImage>();
	    starshipToTheRightTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_right/starship_fly_to_the_right_1.png")));
	    starshipToTheRightTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_right/starship_fly_to_the_right_2.png")));
	    starshipToTheRightTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_right/starship_fly_to_the_right_3.png")));
	    starshipToTheRightTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_right/starship_fly_to_the_right_4.png")));
	    starshipToTheRightTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_right/starship_fly_to_the_right_5.png")));
	    starshipToTheRightTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_right/starship_fly_to_the_right_6.png")));
	    starshipToTheRightTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_right/starship_fly_to_the_right_7.png")));
	    starshipToTheRightTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_right/starship_fly_to_the_right_8.png")));
//	    starshipToTheRightTextures.add(ImageIO.read(new File("src/textures/starship/move_to_the_right/starship_fly_to_the_right_9.png")));
	}
}