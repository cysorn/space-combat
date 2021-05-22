package game.objects.introducing.black_screen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BlackScreenTexture {
	public BufferedImage blackScreenTexture;

	public BlackScreenTexture() throws IOException{
		
		blackScreenTexture = ImageIO.read(new File("src/textures/introducing/black_screen.png"));
	}
}
