package game.objects.spaceship;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class SpaceshipTextures{

	public List<BufferedImage> spaceshipTextures;
	public List<BufferedImage> spaceshipToTheLeftTextures;
	public List<BufferedImage> spaceshipToTheRightTextures;

	public SpaceshipTextures() throws IOException{
		
	    //add textures of the spaceship
	    spaceshipTextures = new ArrayList<BufferedImage>();
	    spaceshipTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/spaceship_fly.png")));
	    spaceshipTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/spaceship_fly_2.png")));
	    spaceshipTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/spaceship_fly_3.png")));
	    spaceshipTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/spaceship_fly_4.png")));
	    spaceshipTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/spaceship_fly_5.png")));
	    spaceshipTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/spaceship_fly_6.png")));
	    
	    spaceshipToTheLeftTextures = new ArrayList<BufferedImage>();
	    spaceshipToTheLeftTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_left/spaceship_fly_to_the_left_1.png")));
	    spaceshipToTheLeftTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_left/spaceship_fly_to_the_left_2.png")));
	    spaceshipToTheLeftTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_left/spaceship_fly_to_the_left_3.png")));
	    spaceshipToTheLeftTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_left/spaceship_fly_to_the_left_4.png")));
	    spaceshipToTheLeftTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_left/spaceship_fly_to_the_left_5.png")));
	    spaceshipToTheLeftTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_left/spaceship_fly_to_the_left_6.png")));
	    spaceshipToTheLeftTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_left/spaceship_fly_to_the_left_7.png")));
	    spaceshipToTheLeftTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_left/spaceship_fly_to_the_left_8.png")));
//	    spaceshipToTheLeftTextures.add(ImageIO.read(new File("src/textures/spaceship/move_to_the_left/spaceship_fly_to_the_left_9.png")));
	    
	    spaceshipToTheRightTextures = new ArrayList<BufferedImage>();
	    spaceshipToTheRightTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_right/spaceship_fly_to_the_right_1.png")));
	    spaceshipToTheRightTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_right/spaceship_fly_to_the_right_2.png")));
	    spaceshipToTheRightTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_right/spaceship_fly_to_the_right_3.png")));
	    spaceshipToTheRightTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_right/spaceship_fly_to_the_right_4.png")));
	    spaceshipToTheRightTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_right/spaceship_fly_to_the_right_5.png")));
	    spaceshipToTheRightTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_right/spaceship_fly_to_the_right_6.png")));
	    spaceshipToTheRightTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_right/spaceship_fly_to_the_right_7.png")));
	    spaceshipToTheRightTextures.add(ImageIO.read(getClass().getResource("/textures/spaceship/move_to_the_right/spaceship_fly_to_the_right_8.png")));
//	    spaceshipToTheRightTextures.add(ImageIO.read(new File("src/textures/spaceship/move_to_the_right/spaceship_fly_to_the_right_9.png")));
	}
}