package game.score;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class BoardTexture {
	public BufferedImage boardTexture;
	
	public BoardTexture() throws IOException
	{
		boardTexture = ImageIO.read(getClass().getResource("/textures/score/board.png"));
	}
}
