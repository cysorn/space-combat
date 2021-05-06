package game.sprites.introducing_sprites;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.sprites.introducing_sprites.black_screen.BlackScreen;

public class IntroducingSprites{
	public boolean introducingContinues;
	public IntroducingTextures introducingTextures;
	public BlackScreen blackScreen;

	public IntroducingSprites() throws IOException
	{
		introducingTextures = new IntroducingTextures();
		blackScreen = new BlackScreen(this, introducingTextures.blackScreenTextures.get(0));
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
