package game.sprites.introducing_sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class IntroducingSprites extends IntroducingTextures{
	public boolean introducingContinues;
	public BlackScreen blackScreen;

	public IntroducingSprites() throws IOException
	{
		blackScreen = new BlackScreen(introducingTextures.get(0), this);
		introducingContinues = true;
	}
	
	public void nextFrame()
	{
		blackScreen.nextFrame();
	}
	
	public BufferedImage getBlackScreenTexture()
	{
		return blackScreen.getSpriteTexture();
	}
}
