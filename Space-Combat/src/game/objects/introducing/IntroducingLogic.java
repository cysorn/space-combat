package game.objects.introducing;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.introducing.black_screen.BlackScreenTexture;
import game.objects.introducing.black_screen.logic.BlackScreenLogic;

public class IntroducingLogic{
	public boolean introducingContinues;
	public BlackScreenLogic blackScreenLogic;

	public IntroducingLogic() throws IOException
	{
		blackScreenLogic = new BlackScreenLogic(this);
		introducingContinues = true;
	}
	
	public void nextFrame()
	{
		blackScreenLogic.nextFrame();
	}
	
	public BufferedImage getBlackScreenTexture()
	{
		return blackScreenLogic.blackScreenSprite.getSpriteTexture();
	}
}
