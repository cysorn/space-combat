package game.sprites.introducing_sprites.black_screen;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.sprites.SimpleSprite;
import game.sprites.introducing_sprites.IntroducingSprites;

public class BlackScreen extends SimpleSprite{
	
	private BufferedImage blackScreenTexture;
	private float animationSpeed;
	private IntroducingSprites introducingSprites;
	
	public BlackScreen(IntroducingSprites introducingSprites, BufferedImage blackScreenTexture) throws IOException
	{
		super(0, 0);
		this.blackScreenTexture = blackScreenTexture;
		this.introducingSprites = introducingSprites;
		currentAlpha = 1f;
		animationSpeed = 0.004f;
	}
	
	@Override
	public void nextFrame()
	{
		if(currentAlpha - animationSpeed >= 0f)
		{
			currentAlpha -= animationSpeed;
		}
		else
		{
			currentAlpha = 0f;
			introducingSprites.introducingContinues = false;
		}
	}

	@Override
	public BufferedImage getSpriteTexture() {

		return blackScreenTexture;
	}
}
