package game.objects.background.star.logic;

import game.objects.background.StarSize;
import game.objects.background.star.StarSprite;

public class StarBlink {

	private StarSprite starSprite;
	private float destinationAlpha;
	private float runningSpeed;
	private int framesCount;
	private boolean increaseAlpha;
	private boolean startMakingTheStarOpaque;
	
	StarBlink(StarSprite starSprite)
	{
		this.starSprite = starSprite;
		startMakingTheStarOpaque = false;
		generateNewValues();
	}
	
	public void nextFrame()
	{
		if(increaseAlpha == true)
		{
			if(starSprite.currentAlpha < destinationAlpha
			&& starSprite.currentAlpha + runningSpeed <= 1)
			{
				starSprite.currentAlpha = starSprite.currentAlpha + runningSpeed;
			}
			else
			{
				generateNewValues();
			}
		}
		else
		{
			if(starSprite.currentAlpha > destinationAlpha
			&& starSprite.currentAlpha - runningSpeed > 0)
			{
				starSprite.currentAlpha = starSprite.currentAlpha - runningSpeed;
			}
			else
			{
				startMakingTheStarOpaque = true;
				generateNewValues();
			}
		}
	}
	
	private void generateNewValues() {
		//cyclically changes the value of currentAlpha to a random value and back to 1f
		if(startMakingTheStarOpaque == true)
		{
			destinationAlpha = 1f;
			startMakingTheStarOpaque = false;
		}
		else
		{
			destinationAlpha = (float) (Math.random());
			makeBigStarsNotBeAbleToDisappear();
		}
		
		framesCount = (int) (Math.random() * 50) + 50;
		runningSpeed = (float) (Math.abs(destinationAlpha - starSprite.currentAlpha)) / framesCount;
		if(starSprite.currentAlpha < destinationAlpha)
		{
			increaseAlpha = true;
		}
		else
		{
			increaseAlpha = false;
		}
	}
	
	private void makeBigStarsNotBeAbleToDisappear()
	{
		if((starSprite.starSize == StarSize.LARGE_STAR
		|| starSprite.starSize == StarSize.BIG_STAR)
		&& destinationAlpha < 0.5f)
		{
			destinationAlpha = 0.6f;
		}
	}
}
