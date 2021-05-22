package game.objects.player.laser;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.Sprite;

public class LaserSprite extends Sprite{

	LaserTextures laserTextures;
	
	public LaserSprite(float xPos, float yPos) throws IOException {
		
		super(xPos, yPos, 15, 42);
		laserTextures = new LaserTextures();
	}

	public BufferedImage getSpriteTexture() {
		return laserTextures.laserTexture;
	}
}