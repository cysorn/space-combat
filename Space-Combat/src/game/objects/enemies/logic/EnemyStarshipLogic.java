package game.objects.enemies.logic;

import java.io.IOException;

import game.objects.enemies.EnemyStarshipSprite;
import game.objects.health_bar.logic.HealthBarLogic;
import game.objects.logic.StarshipExplosion;
import game.objects.player.starship.logic.StarshipLogic;

public abstract class EnemyStarshipLogic implements EnemyStarshipLogicInterface{
	protected EnemyStarshipSprite enemyStarshipSprite;
	protected EnemyStarshipMove enemyStarshipMove;
	public HealthBarLogic healthBarLogic;
	public boolean freezeStarship;
	public StarshipExplosion starshipExplosion;
	private boolean ramHappened;
	
	protected EnemyStarshipLogic(EnemyStarshipSprite enemyStarshipSprite) throws IOException
	{
		enemyStarshipMove = new EnemyStarshipMove(enemyStarshipSprite);
		this.enemyStarshipSprite = enemyStarshipSprite;
		healthBarLogic = new HealthBarLogic(enemyStarshipSprite, 100, false);
		freezeStarship = false;
		starshipExplosion = new StarshipExplosion(enemyStarshipSprite, healthBarLogic.healthBarSprite);
		ramHappened = false;
	}
	
	protected void ram(StarshipLogic starshipLogic, int ramDamage)
	{
		if(ramHappened == false 
		&& starshipLogic.starshipSprite.yPos + starshipLogic.starshipSprite.getSpriteHeight() / 2 <= enemyStarshipSprite.yPos + enemyStarshipSprite.getSpriteHeight()
		&& starshipLogic.starshipSprite.yPos >= enemyStarshipSprite.yPos
		&& starshipLogic.starshipSprite.xPos + starshipLogic.starshipSprite.getSpriteWidth() / 2 >= enemyStarshipSprite.xPos
		&& starshipLogic.starshipSprite.xPos <= enemyStarshipSprite.xPos + enemyStarshipSprite.getSpriteWidth())
		{
			healthBarLogic.objectStats.kill();
			ramHappened = true;
			starshipLogic.healthBarLogic.objectStats.decreaseHealthBy(ramDamage);
		}
	}
}