package game.objects.enemies;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.Sprite;

public class EnemyStarshipSprite extends Sprite{

	private BufferedImage enemyStarshipTexture;
	public EnemyStarshipSprite(float xPos, float yPos, int spriteWidth, int spriteHeight, BufferedImage enemyStarshipTexture) throws IOException {
//		72, 80
		super(xPos, yPos, spriteWidth, spriteHeight);
		this.enemyStarshipTexture = enemyStarshipTexture;
	}
	
	public BufferedImage getEnemyStarshipTexture()
	{
		return enemyStarshipTexture;
	}
}