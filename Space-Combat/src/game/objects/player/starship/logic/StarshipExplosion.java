package game.objects.player.starship.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.Animation;
import game.objects.player.starship.StarshipSprite;

public class StarshipExplosion {
	private StarshipExplosionTextures starshipExplosionTextures;
	public Animation explosionAnimation;
	private boolean playAnimation;
	private StarshipSprite starshipSprite;
	private boolean freezeStarship;
	
	public StarshipExplosion(StarshipSprite starshipSprite) throws IOException {
		starshipExplosionTextures = new StarshipExplosionTextures();
		explosionAnimation = new Animation(starshipExplosionTextures.starshipExplosionTextures.size(), 1f);
		playAnimation = false;
		this.starshipSprite = starshipSprite;
		freezeStarship = false;
	}
	
	public void nextFrame()
	{
		if(playAnimation == false)
		{
			return;
		}
		if(explosionAnimation.getCurrentFrame() >= 25)
        {
	    	starshipSprite.currentAlpha = 0f;
	    }
		if(explosionAnimation.nextFrameIsLast() == true)
		{
			freezeStarship = false;
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
		freezeStarship = true;
	}
	
	public boolean animationPlays()
	{
		return playAnimation;
	}
	
	public boolean starshipIsFrozen()
	{
		return freezeStarship;
	}
}
