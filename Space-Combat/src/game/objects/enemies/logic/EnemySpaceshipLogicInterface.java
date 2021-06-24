package game.objects.enemies.logic;

import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.player.spaceship.logic.SpaceshipLogic;

public interface EnemySpaceshipLogicInterface {
	public void nextFrame(SpaceshipLogic spaceshipLogic);
	public int getSpriteWidth();
	public int getSpriteHeight();
	public EnemySpaceshipSprite getEnemySpaceshipSprite();
}
