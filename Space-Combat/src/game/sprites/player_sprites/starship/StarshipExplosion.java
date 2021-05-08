package game.sprites.player_sprites.starship;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.Animation;

public class StarshipExplosion {
	private StarshipExplosionTextures starshipExplosionTextures;
	public Animation explosionAnimation;
	private boolean playAnimation;
	private boolean starshipExploded;
	private Starship starship;
	
	public StarshipExplosion(Starship starship) throws IOException {
		starshipExplosionTextures = new StarshipExplosionTextures();
		explosionAnimation = new Animation(starshipExplosionTextures.starshipExplosionTextures.size(), 0.5f);
		playAnimation = false;
		this.starship = starship;
		starshipExploded = false;
	}
	
	public void nextFrame()
	{
		if(playAnimation == false)
		{
			return;
		}
		else
		{
			starship.freezeStarship = true;
		}
		if(starship.starshipExplosion.explosionAnimation.getCurrentFrame() >= 25)
        {
	    	starship.currentAlpha = 0f;
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
