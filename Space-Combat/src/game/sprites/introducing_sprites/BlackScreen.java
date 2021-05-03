package game.sprites.introducing_sprites;

import java.awt.image.BufferedImage;

import game.sprites.SimpleSprite;

public class BlackScreen extends SimpleSprite{
	private float animationSpeed;
	private IntroducingSprites introducingSprites;
	
	public BlackScreen(BufferedImage texture, IntroducingSprites introducingSprites)
	{
		super(texture, 0, 0);
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
//			animationSpeed += 0.0001f;
		}
		else
		{
			currentAlpha = 0f;
			introducingSprites.introducingContinues = false;
		}
	}

	@Override
	public BufferedImage getSpriteTexture() {

		return textures.get(0);
	}
}
