package game.score;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class DigitsTextures {
	public List<BufferedImage> greenDigits;
	
	public DigitsTextures() throws IOException
	{
		greenDigits = new ArrayList<>();
		greenDigits.add(ImageIO.read(getClass().getResource("/textures/score/green_digits/0.png")));
		greenDigits.add(ImageIO.read(getClass().getResource("/textures/score/green_digits/1.png")));
		greenDigits.add(ImageIO.read(getClass().getResource("/textures/score/green_digits/2.png")));
		greenDigits.add(ImageIO.read(getClass().getResource("/textures/score/green_digits/3.png")));
		greenDigits.add(ImageIO.read(getClass().getResource("/textures/score/green_digits/4.png")));
		greenDigits.add(ImageIO.read(getClass().getResource("/textures/score/green_digits/5.png")));
		greenDigits.add(ImageIO.read(getClass().getResource("/textures/score/green_digits/6.png")));
		greenDigits.add(ImageIO.read(getClass().getResource("/textures/score/green_digits/7.png")));
		greenDigits.add(ImageIO.read(getClass().getResource("/textures/score/green_digits/8.png")));
		greenDigits.add(ImageIO.read(getClass().getResource("/textures/score/green_digits/9.png")));
	}
}
