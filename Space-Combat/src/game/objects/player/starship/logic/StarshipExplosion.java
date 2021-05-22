package game.objects.player.starship.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.Animation;
import game.objects.player.starship.StarshipSprite;

public class StarshipExplosion {
	private StarshipExplosionTextures starshipExplosionTextures;
	public Animation explosionAnimation;
	private boolean playAnimation;
	private boolean starshipExploded;
	private StarshipSprite starshipSprite;
	
	public StarshipExplosion(StarshipSprite starshipSprite) throws IOException {
		starshipExplosionTextures = new StarshipExplosionTextures();
		explosionAnimation = new Animation(starshipExplosionTextures.starshipExplosionTextures.size(), 0.5f);
		playAnimation = false;
		this.starshipSprite = starshipSprite;
		starshipExploded = false;
	}
	
	public void nextFrame()
	{
		if(explosionAnimation.getCurrentFrame() >= 25)
        {
	    	starshipSprite.currentAlpha = 0f;
	    }
		if(explosionAnimation.nextFrameIsLast() == true)
		{
			starshipExploded = true;
			playAnimation = false;
		}
		explosionAnimation.nextFrame();
	}
	
	public BufferedImage getSpriteTexture()
	{
		return starshipExplosionTextures.starshipExplosionTextures.get(explosionAnimation.getCurrentFrame());
	}
	
	public void startExplosion()
	{
		playAnimation = true;
	}
	
	public boolean animationPlays()
	{
		return playAnimation;
	}
	
	public boolean starshipExploded()
	{
		if(starshipExploded == true)
		{
			starshipExploded = false;
			return true;
		}
		else
		{
			return false;
		}
	}
}
