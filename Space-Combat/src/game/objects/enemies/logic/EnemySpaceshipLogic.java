package game.objects.enemies.logic;

import java.io.IOException;

import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.health_bar.logic.HealthBarLogic;
import game.objects.logic.SpaceshipExplosion;
import game.objects.spaceship.logic.SpaceshipLogic;

public abstract class EnemySpaceshipLogic implements EnemySpaceshipLogicInterface{
	protected EnemySpaceshipSprite enemySpaceshipSprite;
	protected EnemySpaceshipMove enemySpaceshipMove;
	public HealthBarLogic healthBarLogic;
	public boolean freezeSpaceship;
	public SpaceshipExplosion spaceshipExplosion;
	private boolean ramHappened;
	
	protected EnemySpaceshipLogic(EnemySpaceshipSprite enemyStarshipSprite, float moveSpeed) throws IOException
	{
		enemySpaceshipMove = new EnemySpaceshipMove(enemyStarshipSprite, moveSpeed);
		this.enemySpaceshipSprite = enemyStarshipSprite;
		healthBarLogic = new HealthBarLogic(enemyStarshipSprite, 100, false);
		freezeSpaceship = false;
		spaceshipExplosion = new SpaceshipExplosion(enemyStarshipSprite, healthBarLogic.healthBarSprite, 1.15f);
		ramHappened = false;
	}
	
	protected void ram(SpaceshipLogic spaceshipLogic, int ramDamage)
	{
		if(ramHappened == false 
		&& spaceshipLogic.spawnSpaceship.animationPlays() == false
		&& spaceshipLogic.spaceshipExplosion.animationPlays() == false
		&& spaceshipLogic.spaceshipSprite.yPos + spaceshipLogic.spaceshipSprite.getSpriteHeight() / 2 <= enemySpaceshipSprite.yPos + enemySpaceshipSprite.getSpriteHeight()
		&& spaceshipLogic.spaceshipSprite.yPos >= enemySpaceshipSprite.yPos
		&& spaceshipLogic.spaceshipSprite.xPos + spaceshipLogic.spaceshipSprite.getSpriteWidth() / 2 >= enemySpaceshipSprite.xPos
		&& spaceshipLogic.spaceshipSprite.xPos <= enemySpaceshipSprite.xPos + enemySpaceshipSprite.getSpriteWidth())
		{
			healthBarLogic.objectStats.kill();
			ramHappened = true;
			spaceshipLogic.healthBarLogic.objectStats.decreaseHealthBy(ramDamage);
		}
	}
	
	public boolean enemySpaceshipShotDown()
	{
		if(spaceshipExplosion.explosionAnimation.getCurrentFrame() >= 1 || spaceshipExplosion.spaceshipIsExploded)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}