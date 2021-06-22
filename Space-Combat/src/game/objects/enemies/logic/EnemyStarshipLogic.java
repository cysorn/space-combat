package game.objects.enemies.logic;

import java.io.IOException;

import game.objects.StarshipExplosion;
import game.objects.enemies.EnemyStarshipSprite;
import game.objects.health_bar.logic.HealthBarLogic;

public abstract class EnemyStarshipLogic implements EnemyStarshipLogicInterface{
	protected EnemyStarshipSprite enemyStarshipSprite;
	protected EnemyStarshipMove enemyStarshipMove;
	public HealthBarLogic healthBarLogic;
	public boolean freezeStarship;
	public StarshipExplosion starshipExplosion;
	
	protected EnemyStarshipLogic(EnemyStarshipSprite enemyStarshipSprite) throws IOException
	{
		enemyStarshipMove = new EnemyStarshipMove(enemyStarshipSprite);
		this.enemyStarshipSprite = enemyStarshipSprite;
		healthBarLogic = new HealthBarLogic(enemyStarshipSprite, 100, false);
		freezeStarship = false;
		starshipExplosion = new StarshipExplosion(enemyStarshipSprite, healthBarLogic.healthBarSprite);
	}
}