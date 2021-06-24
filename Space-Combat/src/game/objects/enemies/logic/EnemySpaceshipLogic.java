package game.objects.enemies.logic;

import java.io.IOException;

import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.health_bar.logic.HealthBarLogic;
import game.objects.logic.SpaceshipExplosion;
import game.objects.player.spaceship.logic.SpaceshipLogic;

public abstract class EnemySpaceshipLogic implements EnemySpaceshipLogicInterface{
	protected EnemySpaceshipSprite enemySpaceshipSprite;
	protected EnemySpaceshipMove enemySpaceshipMove;
	public HealthBarLogic healthBarLogic;
	public boolean freezeStarship;
	public SpaceshipExplosion spaceshipExplosion;
	private boolean ramHappened;
	
	protected EnemySpaceshipLogic(EnemySpaceshipSprite enemyStarshipSprite) throws IOException
	{
		enemySpaceshipMove = new EnemySpaceshipMove(enemyStarshipSprite);
		this.enemySpaceshipSprite = enemyStarshipSprite;
		healthBarLogic = new HealthBarLogic(enemyStarshipSprite, 100, false);
		freezeStarship = false;
		spaceshipExplosion = new SpaceshipExplosion(enemyStarshipSprite, healthBarLogic.healthBarSprite);
		ramHappened = false;
	}
	
	protected void ram(SpaceshipLogic starshipLogic, int ramDamage)
	{
		if(ramHappened == false 
		&& starshipLogic.spaceshipSprite.yPos + starshipLogic.spaceshipSprite.getSpriteHeight() / 2 <= enemySpaceshipSprite.yPos + enemySpaceshipSprite.getSpriteHeight()
		&& starshipLogic.spaceshipSprite.yPos >= enemySpaceshipSprite.yPos
		&& starshipLogic.spaceshipSprite.xPos + starshipLogic.spaceshipSprite.getSpriteWidth() / 2 >= enemySpaceshipSprite.xPos
		&& starshipLogic.spaceshipSprite.xPos <= enemySpaceshipSprite.xPos + enemySpaceshipSprite.getSpriteWidth())
		{
			healthBarLogic.objectStats.kill();
			ramHappened = true;
			starshipLogic.healthBarLogic.objectStats.decreaseHealthBy(ramDamage);
		}
	}
}