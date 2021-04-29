package game.logic;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity implements EntityInterface{
	
	public float currentAlpha;
	public float xPos;
	public float yPos;
	protected List<BufferedImage> textures;
	
	protected Entity(BufferedImage texture, float xPos, float yPos)
	{
		currentAlpha = 1f;
		this.xPos = xPos;
		this.yPos = yPos;
		textures = new ArrayList<>();
		textures.add(texture);
	}
	
	protected Entity(List<BufferedImage> textures, float xPos, float yPos)
	{
		currentAlpha = 1f;
		this.xPos = xPos;
		this.yPos = yPos;
		this.textures = textures;
	}
}