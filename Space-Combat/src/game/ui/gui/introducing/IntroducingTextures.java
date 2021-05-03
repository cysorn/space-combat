package game.ui.gui.introducing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public abstract class IntroducingTextures {
	protected List<BufferedImage> introducingTextures;

	public IntroducingTextures() throws IOException{
		introducingTextures = new ArrayList<BufferedImage>();

		introducingTextures.add(ImageIO.read(new File("src/textures/introducing/black_screen.png")));
	}
}
