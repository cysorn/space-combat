package game.objects.health_bar;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.Sprite;

public class HealthBarSprite extends Sprite{
	
	private HealthBarTextures healthBarTexture;
	
	public HealthBarSprite(float xPos, float yPos) throws IOException {
		super(xPos, yPos, 100, 10);
		healthBarTexture = new HealthBarTextures();
	}
	
	public BufferedImage getSpriteTexture()
	{
		return healthBarTexture.healthBarTexture;
	}
}