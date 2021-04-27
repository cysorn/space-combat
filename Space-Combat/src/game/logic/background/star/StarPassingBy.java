package game.logic.background.star;

import game.logic.background.StarSize;

public class StarPassingBy {
	private Star star;
	private int windowWidth;
	private int windowHeight;
	private float starPassingBySpeed;
	private int starSlow;
	private int counterOfSlow;
	
	public StarPassingBy(Star star, int windowWidth, int windowHeight, StarSize starSize)
	{
		this.star = star;
		
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		switch(starSize)
		{
		case SMALL_STAR:
			starSlow = 4;
			starPassingBySpeed = 1;
			break;
		case MEDIUM_STAR:
			starSlow = 2;
			starPassingBySpeed = 1;
			break;
		case BIG_STAR:
			starSlow = 1;
			starPassingBySpeed = 1;
			break;
		case LARGE_STAR:
			starSlow = 0;
			starPassingBySpeed = 2;
		}
	}
	
	public void passingBy()
	{
		if(counterOfSlow == starSlow)
		{
			if(star.yPos + starPassingBySpeed < windowHeight)
			{
				star.yPos += starPassingBySpeed;
			}
			else
			{
				star.xPos = (int) (Math.random() * 10000) % windowWidth;
				star.yPos = -30;
			}
			counterOfSlow = 0;
		}
		else
		{
			++counterOfSlow;
		}
	}
}
