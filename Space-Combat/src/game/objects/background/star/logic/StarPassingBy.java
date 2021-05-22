package game.objects.background.star.logic;

import game.objects.background.star.StarSprite;

public class StarPassingBy {
	private StarSprite starSprite;
	private int windowWidth;
	private int windowHeight;
	private float starPassingBySpeed;
	
	public StarPassingBy(StarSprite starSprite, int windowWidth, int windowHeight)
	{
		this.starSprite = starSprite;
		
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		
		starPassingBySpeed = 1f;

	}
	
	public void nextFrame()
	{
		if(starSprite.yPos + starPassingBySpeed < windowHeight)
		{
			starSprite.yPos += starPassingBySpeed;
		}
		else
		{
			starSprite.xPos = (int) (Math.random() * 10000) % windowWidth;
			starSprite.yPos = -30;
		}
	}
	
	private void twoAndAHalfDimensionalBackground()
	{
		switch(starSprite.starSize)
		{
		case SMALL_STAR:
			starPassingBySpeed = 1f;
			break;
		case MEDIUM_STAR:
			starPassingBySpeed = 2f;
			break;
		case BIG_STAR:
			starPassingBySpeed = 3f;
			break;
		case LARGE_STAR:
			starPassingBySpeed = 4f;
		}
	}
}
