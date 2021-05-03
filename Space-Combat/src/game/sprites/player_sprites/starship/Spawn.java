package game.sprites.player_sprites.starship;

import game.sprites.SimpleSprite;

public class Spawn {
	private int alphaChangeCounter;
	private int alphaChangesCount;
	private float alphaChangeSpeed;
	private SimpleSprite sprite;

	public Spawn(SimpleSprite sprite)
	{
		this.sprite = sprite;
		alphaChangeCounter = 0;
		alphaChangesCount = 7;
		alphaChangeSpeed = 0.05f;
		sprite.currentAlpha = 0f;
	}
	
	public void nextFrame()
	{
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
}
