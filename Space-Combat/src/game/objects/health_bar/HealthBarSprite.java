package game.objects.health_bar;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.SimpleSprite;

public class HealthBarSprite extends SimpleSprite{
	
	private HealthBarTextures healthBarTexture;
	
	public HealthBarSprite(float xPos, float yPos) throws IOException {
		super(xPos, yPos);
		healthBarTexture = new HealthBarTextures();
	}
	
	public BufferedImage getSpriteTexture()
	{
		return healthBarTexture.healthBarTexture;
	}
}