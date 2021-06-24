package game.objects.enemies;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.Sprite;

public class EnemySpaceshipSprite extends Sprite{

	private BufferedImage enemySpaceshipTexture;
	public EnemySpaceshipSprite(float xPos, float yPos, int spriteWidth, int spriteHeight, BufferedImage enemySpaceshipTexture) throws IOException {
//		72, 80
		super(xPos, yPos, spriteWidth, spriteHeight);
		this.enemySpaceshipTexture = enemySpaceshipTexture;
	}
	
	public BufferedImage getEnemySpaceshipTexture()
	{
		return enemySpaceshipTexture;
	}
}