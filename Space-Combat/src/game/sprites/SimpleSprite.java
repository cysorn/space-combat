package game.sprites;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class SimpleSprite implements SpriteInterface{
	
	public float currentAlpha;
	public float xPos;
	public float yPos;
	protected List<BufferedImage> textures;
	
	protected SimpleSprite(BufferedImage texture, float xPos, float yPos)
	{
		currentAlpha = 1f;
		this.xPos = xPos;
		this.yPos = yPos;
		textures = new ArrayList<>();
		textures.add(texture);
	}
	
	protected SimpleSprite(List<BufferedImage> textures, float xPos, float yPos)
	{
		currentAlpha = 1f;
		this.xPos = xPos;
		this.yPos = yPos;
		this.textures = textures;
	}
}