package game.objects.enemies.logic;

import game.objects.enemies.EnemyStarshipSprite;

public interface EnemyStarshipLogicInterface {
	public void nextFrame();
	public int getSpriteWidth();
	public int getSpriteHeight();
	public EnemyStarshipSprite getEnemyStarshipSprite();
}
