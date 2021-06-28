package game.loading;

import game.objects.Sprite;

public class LoadingSprite extends Sprite{
	
	public LoadingTextures loadingTextures;
	
	public LoadingSprite(float xPos, float yPos, int spriteWidth, int spriteHeight) {
		super(xPos, yPos, spriteWidth, spriteHeight);
		loadingTextures = new LoadingTextures();
	}
}
