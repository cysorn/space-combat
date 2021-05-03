package game.ui.gui.introducing;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Introducing extends IntroducingTextures{
	private boolean doIntroducing;
	private float animationSpeed;
	private float blackAlpha;
	
	public Introducing() throws IOException
	{
		doIntroducing = true;
		blackAlpha = 1f;
		animationSpeed = 0.004f;
	}
	
	public void nextFrame()
	{
		if(blackAlpha - animationSpeed >= 0f)
		{
			blackAlpha -= animationSpeed;
//			animationSpeed += 0.0001f;
		}
		else
		{
			blackAlpha = 0f;
			doIntroducing = false;
		}
	}
	
	public boolean introducingIsInProcess()
	{
		return doIntroducing;
	}
	
	public float getBlackAlpha()
	{
		return blackAlpha;
	}
	
	public BufferedImage getBlackTexture()
	{
		return introducingTextures.get(0);
	}
}
