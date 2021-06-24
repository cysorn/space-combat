package game.objects.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.Animation;
import game.objects.Sprite;
import game.objects.health_bar.HealthBarSprite;
import game.objects.player.spaceship.SpaceshipSprite;
import game.objects.player.spaceship.SpaceshipExplosionTextures;

public class SpaceshipExplosion {
	private SpaceshipExplosionTextures starshipExplosionTextures;
	public Animation explosionAnimation;
	private boolean playAnimation;
	private Sprite sprite;
	public boolean spaceshipIsExploded;
	private HealthBarSprite healthBarSprite;
	
	public SpaceshipExplosion(Sprite sprite, HealthBarSprite healthBarSprite) throws IOException {
		starshipExplosionTextures = new SpaceshipExplosionTextures();
		explosionAnimation = new Animation(starshipExplosionTextures.spaceshipExplosionTextures.size(), 1f);
		playAnimation = false;
		this.sprite = sprite;
		spaceshipIsExploded = false;
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
			spaceshipIsExploded = true;
			playAnimation = false;
		}
		explosionAnimation.nextFrame();
	}
	
	public BufferedImage getSpriteTexture()
	{
		return starshipExplosionTextures.spaceshipExplosionTextures.get(explosionAnimation.getCurrentFrame());
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
