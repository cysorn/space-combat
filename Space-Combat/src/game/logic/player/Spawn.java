package game.logic.player;

import game.logic.Entity;

public class Spawn {
	private int alphaChangeCounter;
	private int alphaChangesCount;
	private float alphaChangeSpeed;
	private Entity entity;

	public Spawn(Entity entity)
	{
		this.entity = entity;
		alphaChangeCounter = 0;
		alphaChangesCount = 7;
		alphaChangeSpeed = 0.05f;
		entity.currentAlpha = 0f;
	}
	
	public void nextFrame()
	{
		if(alphaChangeCounter == alphaChangesCount)
		{
			if (entity.currentAlpha + alphaChangeSpeed >= 0.6f
				&& entity.currentAlpha + alphaChangeSpeed <= 1f)
			{		
				entity.currentAlpha += alphaChangeSpeed;
			}
			else
			{
				entity.currentAlpha = 1;
			}
			return;
		}
		if(entity.currentAlpha + alphaChangeSpeed <= 0.6f
		&& entity.currentAlpha + alphaChangeSpeed >= 0f)
		{
			entity.currentAlpha += alphaChangeSpeed;
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
