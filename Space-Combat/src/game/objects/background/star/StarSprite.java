package game.objects.background.star;

import java.awt.image.BufferedImage;

import game.objects.SimpleSprite;
import game.objects.background.StarSize;

public class StarSprite extends SimpleSprite{

	public final StarSize starSize;
	private BufferedImage starTexture;
	public StarSprite(float xPos, float yPos, BufferedImage starTexture, StarSize starSize) {
		super(xPos, yPos);
		this.starSize = starSize;
		this.starTexture = starTexture;
	}
	
	public BufferedImage getSpriteTexture()
	{
		return starTexture;
	}
}
