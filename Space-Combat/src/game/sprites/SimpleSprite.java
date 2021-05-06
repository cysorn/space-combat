package game.sprites;

public abstract class SimpleSprite implements SpriteInterface{
	
	public float currentAlpha;
	public float xPos;
	public float yPos;
	
	protected SimpleSprite(float xPos, float yPos)
	{
		currentAlpha = 1f;
		this.xPos = xPos;
		this.yPos = yPos;
	}
}