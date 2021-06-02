package game.objects.logic;

import game.objects.SimpleSprite;

public class ObjectSpawn {
	private int alphaChangeCounter;
	private int alphaChangesCount;
	private float alphaChangeSpeed;
	private SimpleSprite sprite;
	private boolean playAnimation;
	private boolean spawnIsDone;
	private float xPosForSpawn;
	private float yPosForSpawn;

	public ObjectSpawn(SimpleSprite sprite, float xPosForSpawn, float yPosForSpawn)
	{
		this.sprite = sprite;
		alphaChangeCounter = 0;
		alphaChangesCount = 7;
		alphaChangeSpeed = 0.05f;
		sprite.currentAlpha = 0f;
		playAnimation = true;
		spawnIsDone = false;
		this.xPosForSpawn = xPosForSpawn;
		this.yPosForSpawn = yPosForSpawn;
	}
	
	public void nextFrame()
	{
		if(playAnimation == false)
		{
			return;
		}
		sprite.xPos = xPosForSpawn;
		sprite.yPos = yPosForSpawn;
		if(alphaChangeCounter == alphaChangesCount)
		{
			if (sprite.currentAlpha + alphaChangeSpeed >= 0.6f
				&& sprite.currentAlpha + alphaChangeSpeed <= 1f)
			{		
				sprite.currentAlpha += alphaChangeSpeed;
			}
			else
			{
				sprite.currentAlpha = 1;
				alphaChangeCounter = 0;
				spawnIsDone = true;
				playAnimation = false;
			}
			return;
		}
		if(sprite.currentAlpha + alphaChangeSpeed <= 0.6f
		&& sprite.currentAlpha + alphaChangeSpeed >= 0f)
		{
			sprite.currentAlpha += alphaChangeSpeed;
		}
		else
		{
			++alphaChangeCounter;
			if(alphaChangeCounter != alphaChangesCount)
			{
				alphaChangeSpeed *= (-1);
			}
		}
	}
	
	public void startSpawn()
	{
		playAnimation = true;
	}
	
	public boolean animationPlays()
	{
		return playAnimation;
	}
	
//	Returns true once than return false until spawn will be done again
	public boolean spawnIsDone()
	{
		if(spawnIsDone == true)
		{
			spawnIsDone = false;
			return true;
		}
		else
		{
			return false;
		}
	}
}
