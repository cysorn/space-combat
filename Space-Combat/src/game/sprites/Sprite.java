package game.sprites;

import java.awt.image.BufferedImage;
import java.util.List;

public abstract class Sprite extends SimpleSprite{

	private final int spriteWidth;
	private final int spriteHeight;
	public Sprite(BufferedImage texture, float xPos, float yPos, int spriteWidth, int spriteHeight)
	{
		super(texture, xPos, yPos);
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
	}
	
	public Sprite(List<BufferedImage> texture, float xPos, float yPos, int spriteWidth, int spriteHeight)
	{
		super(texture, xPos, yPos);
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
	}
	
	public int getSpriteWidth()
	{
		return spriteWidth;
	}
	
	public int getSpriteHeight()
	{
		return spriteHeight;
	}
}
