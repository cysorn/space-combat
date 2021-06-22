package game.objects;

public abstract class Sprite extends SimpleSprite{

	private final int spriteWidth;
	private final int spriteHeight;
	public Sprite(float xPos, float yPos, int spriteWidth, int spriteHeight)
	{
		super(xPos, yPos);
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