package game.logic.background.star;


public class StarPassingBy {
	private Star star;
	private int windowWidth;
	private int windowHeight;
	private float starPassingBySpeed;
	private int starSlow;
	private int counterOfSlow;
	
	public StarPassingBy(Star star, int windowWidth, int windowHeight)
	{
		this.star = star;
		
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
//		starSlow = 0;
//		starPassingBySpeed = 3;
		
//		standard
//		switch(starSize)
//		{
//		case SMALL_STAR:
//			starSlow = 4;
//			starPassingBySpeed = 1;
//			break;
//		case MEDIUM_STAR:
//			starSlow = 2;
//			starPassingBySpeed = 1;
//			break;
//		case BIG_STAR:
//			starSlow = 1;
//			starPassingBySpeed = 1;
//			break;
//		case LARGE_STAR:
//			starSlow = 0;
//			starPassingBySpeed = 2;
//		}
		
		switch(star.starSize)
		{
		case SMALL_STAR:
			starSlow = 0;
			starPassingBySpeed = 1;
			break;
		case MEDIUM_STAR:
			starSlow = 0;
			starPassingBySpeed = 2;
			break;
		case BIG_STAR:
			starSlow = 0;
			starPassingBySpeed = 3;
			break;
		case LARGE_STAR:
			starSlow = 0;
			starPassingBySpeed = 4;
		}
	}
	
	public void passingBy()
	{
		//TODO maybe change xPos and yPos types to float to remove starSlow variable
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
