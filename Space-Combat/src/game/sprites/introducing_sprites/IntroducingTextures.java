package game.sprites.introducing_sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class IntroducingTextures {
	protected List<BufferedImage> blackScreenTextures;

	public IntroducingTextures() throws IOException{
		blackScreenTextures = new ArrayList<BufferedImage>();

		blackScreenTextures.add(ImageIO.read(new File("src/textures/introducing/black_screen.png")));
	}
}
