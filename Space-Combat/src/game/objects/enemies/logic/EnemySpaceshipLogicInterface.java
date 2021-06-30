package game.objects.enemies.logic;

import java.util.List;

import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.enemies.enemy_laser.EnemyLaserLogic;
import game.objects.spaceship.logic.SpaceshipLogic;

public interface EnemySpaceshipLogicInterface {
	public void nextFrame(SpaceshipLogic spaceshipLogic);
	public int getSpriteWidth();
	public int getSpriteHeight();
	public EnemySpaceshipSprite getEnemySpaceshipSprite();
}
