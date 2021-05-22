package game.objects;

public abstract class SimpleSprite{
	
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