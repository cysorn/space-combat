package game.logic.background.star;

public class StarPassingBy {
	private Star star;
	private int windowWidth;
	private int windowHeight;
	private float starPassingBySpeed;
	
	public StarPassingBy(Star star, int windowWidth, int windowHeight)
	{
		this.star = star;
		
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		
		switch(star.starSize)
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
	
	public void passingBy()
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
	}
}
