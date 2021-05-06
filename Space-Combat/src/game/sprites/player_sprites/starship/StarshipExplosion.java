package game.sprites.player_sprites.starship;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.Animation;

public class StarshipExplosion {
	private StarshipExplosionTextures starshipExplosionTextures;
	public Animation explosionAnimation;
	public boolean playAnimation;
	
	public StarshipExplosion() throws IOException {
		starshipExplosionTextures = new StarshipExplosionTextures();
		explosionAnimation = new Animation(starshipExplosionTextures.starshipExplosionTextures.size(), 1f);
		playAnimation = false;
	}
	
	public void nextFrame()
	{
		if(playAnimation == true)
		{
			explosionAnimation.nextFrame();
			if(explosionAnimation.getCurrentFrame() == starshipExplosionTextures.starshipExplosionTextures.size() - 1)
			{
				playAnimation = false;
			}
		}
	}
	
	public BufferedImage getSpriteTexture()
	{
		return starshipExplosionTextures.starshipExplosionTextures.get(explosionAnimation.getCurrentFrame());
	}
}
