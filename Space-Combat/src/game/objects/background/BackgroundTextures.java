package game.objects.background;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class BackgroundTextures {
	protected List<BufferedImage> starsTextures;

	@SuppressWarnings("serial")
	public BackgroundTextures() throws IOException{
		//add textures of stars
		starsTextures = new ArrayList<>() 
		{{
			add(ImageIO.read(getClass().getResource("/textures/space/faint 5x4 max.png")));
		    add(ImageIO.read(getClass().getResource("/textures/space/mid 4x5 max.png")));
		    add(ImageIO.read(getClass().getResource("/textures/space/mid 6x5 max.png")));
		    add(ImageIO.read(getClass().getResource("/textures/space/bright 7x7 max.png")));
		    add(ImageIO.read(getClass().getResource("/textures/space/mid 9x8 max.png")));
		    add(ImageIO.read(getClass().getResource("/textures/space/bright 10x10 max.png")));
		    add(ImageIO.read(getClass().getResource("/textures/space/bright 11x11 auto.png")));
		    add(ImageIO.read(getClass().getResource("/textures/space/bright 13x14 auto.png")));
		    add(ImageIO.read(getClass().getResource("/textures/space/bright 21x20 auto.png")));
		    add(ImageIO.read(getClass().getResource("/textures/space/mid 21x21 auto.png")));
		    add(ImageIO.read(getClass().getResource("/textures/space/bright 32x32 auto.png")));
		}};
	}
}