package game.objects;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.Animation;
import game.objects.health_bar.HealthBarSprite;
import game.objects.logic.ObjectStats;
import game.objects.player.starship.StarshipExplosionTextures;
import game.objects.player.starship.StarshipSprite;

public class StarshipExplosion {
	private StarshipExplosionTextures starshipExplosionTextures;
	public Animation explosionAnimation;
	private boolean playAnimation;
	private Sprite sprite;
	public boolean starshipIsExploded;
	private HealthBarSprite healthBarSprite;
	
	public StarshipExplosion(Sprite sprite, HealthBarSprite healthBarSprite) throws IOException {
		starshipExplosionTextures = new StarshipExplosionTextures();
		explosionAnimation = new Animation(starshipExplosionTextures.starshipExplosionTextures.size(), 1f);
		playAnimation = false;
		this.sprite = sprite;
		starshipIsExploded = false;
		this.healthBarSprite = healthBarSprite;
	}
	
	public void nextFrame()
	{
		if(playAnimation == false)
		{
			return;
		}
		if(explosionAnimation.getCurrentFrame() >= 25)
        {
	    	sprite.currentAlpha = 0f;
	    	healthBarSprite.currentAlpha = 0f;
	    }
		if(explosionAnimation.nextFrameIsLast() == true)
		{
			starshipIsExploded = true;
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
}
