package game.objects.enemies.enemy_laser;

import java.io.IOException;

import game.objects.Sprite;

public class EnemyLaserSprite extends Sprite{

	public EnemyLaserTextures enemyLaserTextures;
	
	public EnemyLaserSprite(float xPos, float yPos) throws IOException {
		
		super(xPos, yPos, 20, 18);
		enemyLaserTextures = new EnemyLaserTextures();
	}
}