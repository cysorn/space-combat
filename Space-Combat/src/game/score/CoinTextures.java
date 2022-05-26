package game.score;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class CoinTextures {
	public List<BufferedImage> coins;
	
	public CoinTextures() throws IOException
	{
		coins = new ArrayList<>();
		coins.add(ImageIO.read(new File("src/textures/score/coing/1.png")));
		coins.add(ImageIO.read(new File("src/textures/score/coing/2.png")));
		coins.add(ImageIO.read(new File("src/textures/score/coing/3.png")));
		coins.add(ImageIO.read(new File("src/textures/score/coing/4.png")));
		coins.add(ImageIO.read(new File("src/textures/score/coing/5.png")));
		coins.add(ImageIO.read(new File("src/textures/score/coing/6.png")));
	}
}
