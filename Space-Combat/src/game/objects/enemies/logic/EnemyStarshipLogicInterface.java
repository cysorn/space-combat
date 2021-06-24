package game.objects.enemies.logic;

import game.objects.enemies.EnemyStarshipSprite;
import game.objects.player.starship.logic.StarshipLogic;

public interface EnemyStarshipLogicInterface {
	public void nextFrame(StarshipLogic starshipLogic);
	public int getSpriteWidth();
	public int getSpriteHeight();
	public EnemyStarshipSprite getEnemyStarshipSprite();
}
