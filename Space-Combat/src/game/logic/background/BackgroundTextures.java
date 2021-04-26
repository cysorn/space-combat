package game.logic.background;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public abstract class BackgroundTextures {
	protected List<BufferedImage> starsTextures;

	public BackgroundTextures() throws IOException{
		//add textures of stars
		starsTextures = new ArrayList<BufferedImage>();
//	    starsTextures.add(ImageIO.read(new File("src/textures/space/faint 5x4.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/space/mid 4x5.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/space/mid 6x5.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/space/bright 7x7.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/space/mid 9x8.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/space/bright 10x10.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/space/bright 11x11.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/space/bright 13x14.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/space/bright 21x20.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/space/mid 21x21.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/space/bright 32x32.png")));
	    
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/max/faint 5x4 max.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/max/mid 4x5 max.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/max/mid 6x5 max.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/max/bright 7x7 max.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/max/mid 9x8 max.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/max/bright 10x10 max.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/max/bright 11x11 max.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/max/bright 13x14 max.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/max/bright 21x20 max.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/max/mid 21x21 max.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/max/bright 32x32 max.png")));
		
//		starsTextures.add(ImageIO.read(new File("src/textures/bright space/auto/faint 5x4 auto.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/auto/mid 4x5 auto.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/auto/mid 6x5 auto.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/auto/bright 7x7 auto.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/auto/mid 9x8 auto.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/auto/bright 10x10 auto.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/auto/bright 11x11 auto.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/auto/bright 13x14 auto.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/auto/bright 21x20 auto.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/auto/mid 21x21 auto.png")));
//	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/auto/bright 32x32 auto.png")));
		
		starsTextures.add(ImageIO.read(new File("src/textures/bright space/combined/faint 5x4 max.png")));
	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/combined/mid 4x5 max.png")));
	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/combined/mid 6x5 max.png")));
	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/combined/bright 7x7 max.png")));
	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/combined/mid 9x8 max.png")));
	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/combined/bright 10x10 max.png")));
	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/combined/bright 11x11 auto.png")));
	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/combined/bright 13x14 auto.png")));
	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/combined/bright 21x20 auto.png")));
	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/combined/mid 21x21 auto.png")));
	    starsTextures.add(ImageIO.read(new File("src/textures/bright space/combined/bright 32x32 auto.png")));
	}
}