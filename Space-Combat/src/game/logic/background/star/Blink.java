package game.logic.background.star;

public class Blink {

	Star theStar;
	private float destinationAlpha;
	private float runningSpeed;
	private int framesCount;
	private boolean increaseAlpha;
	private boolean startMakingTheStarOpaque;
	
	Blink(Star theStar)
	{
		this.theStar = theStar;
		startMakingTheStarOpaque = false;
		generateNewValues();
	}
	
	void blinking()
	{
		if(increaseAlpha == true)
		{
			if(theStar.currentAlpha < destinationAlpha
			&& theStar.currentAlpha + runningSpeed <= 1)
			{
				theStar.currentAlpha = theStar.currentAlpha + runningSpeed;
			}
			else
			{
				generateNewValues();
			}
		}
		else
		{
			if(theStar.currentAlpha > destinationAlpha
			&& theStar.currentAlpha - runningSpeed > 0)
			{
				theStar.currentAlpha = theStar.currentAlpha - runningSpeed;
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
		}
		
		framesCount = (int) (Math.random() * 50) + 50;
		runningSpeed = (float) (Math.abs(destinationAlpha - theStar.currentAlpha)) / framesCount;
		if(theStar.currentAlpha < destinationAlpha)
		{
			increaseAlpha = true;
		}
		else
		{
			increaseAlpha = false;
		}
	}
}
