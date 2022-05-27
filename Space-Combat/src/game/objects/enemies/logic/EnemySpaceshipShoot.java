package game.objects.enemies.logic;

import java.io.IOException;
import java.util.List;

import game.objects.Sprite;
import game.objects.enemies.enemy_laser.EnemyLaserLogic;
import game.objects.spaceship.logic.SpaceshipLogic;

public class EnemySpaceshipShoot {
	
	public List<EnemyLaserLogic> enemyLaserLogics;
	private float shootingSpeed;
	private float shootingSpeedCounter;
	private float projectileFlySpeed;
	
	public EnemySpaceshipShoot(List<EnemyLaserLogic> enemyLaserLogics, float projectileFlySpeed)
	{
		this.shootingSpeed = 50f;
		this.shootingSpeedCounter = shootingSpeed;
		this.enemyLaserLogics = enemyLaserLogics;
		this.projectileFlySpeed = projectileFlySpeed;
	}
	
	public void nextFrame(Sprite enemySpaceshipSprite, SpaceshipLogic spaceshipLogic)
	{
//		checkCollisions(enemies);
		if(shootingSpeedCounter < shootingSpeed)
		{
			++shootingSpeedCounter;
		}
		else if(enemySpaceshipSprite.yPos > 0 && enemySpaceshipSprite.yPos < spaceshipLogic.spaceshipSprite.yPos && spaceshipLogic.spawnSpaceship.animationPlays() == false)
		{
			try {
				enemyLaserLogics.add(new EnemyLaserLogic(enemySpaceshipSprite.xPos + 25, enemySpaceshipSprite.yPos + 50, spaceshipLogic, projectileFlySpeed));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			shootingSpeedCounter = 0f;
		}
	}
	
//	private void checkCollisions(List<EnemyStarshipSprite> enemies)
//	{
//		for(int laserLogicNr = 0; laserLogicNr < laserLogics.size(); ++laserLogicNr)
//		{
//
//			for(Sprite enemy: enemies)
//			{
//				if(laserLogics.get(laserLogicNr).laserSprite.yPos <= enemy.yPos + enemy.getSpriteHeight()
//				&& laserLogics.get(laserLogicNr).laserSprite.yPos >= enemy.yPos
//				&& laserLogics.get(laserLogicNr).laserSprite.xPos >= enemy.xPos && laserLogics.get(laserLogicNr).laserSprite.xPos <= enemy.xPos + enemy.getSpriteWidth())
//				{
//					laserLogics.remove(laserLogicNr);
//				}
//			}
//		}
//	}
}
