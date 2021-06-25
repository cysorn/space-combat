package game.introducing.black_screen.logic;

import java.io.IOException;

import game.introducing.IntroducingLogic;
import game.introducing.black_screen.BlackScreenSprite;

public class BlackScreenLogic{
	
	public BlackScreenSprite blackScreenSprite;
	private float animationSpeed;
	private IntroducingLogic introducingLogic;
	
	public BlackScreenLogic(IntroducingLogic introducingLogic) throws IOException
	{
		this.blackScreenSprite = new BlackScreenSprite();
		this.introducingLogic = introducingLogic;
		blackScreenSprite.currentAlpha = 1f;
		animationSpeed = 0.005f;
	}
	
	public void nextFrame()
	{
		if(blackScreenSprite.currentAlpha - animationSpeed >= 0f)
		{
			blackScreenSprite.currentAlpha -= animationSpeed;
		}
		else
		{
			blackScreenSprite.currentAlpha = 0f;
			introducingLogic.introducingContinues = false;
		}
	}
}
