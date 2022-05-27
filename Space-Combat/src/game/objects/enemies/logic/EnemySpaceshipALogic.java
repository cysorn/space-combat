package game.objects.enemies.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.enemies.enemy_laser.EnemyLaserLogic;
import game.objects.spaceship.logic.SpaceshipLogic;

public class EnemySpaceshipALogic extends EnemySpaceshipLogic{
	private EnemySpaceshipShoot enemySpaceshipShoot;
	private float projectileFlySpeed;
	
	public EnemySpaceshipALogic(int initialXPos, int initialYPos, BufferedImage enemySpaceshipTexture, List<EnemyLaserLogic> enemyLaserLogics) throws IOException {
		super(new EnemySpaceshipSprite(initialXPos, initialYPos, 80, 80, enemySpaceshipTexture), 3.5f);
		projectileFlySpeed = 10f;
		enemySpaceshipShoot = new EnemySpaceshipShoot(enemyLaserLogics, projectileFlySpeed);
//		healthBarLogic.setHpAndBarToFull();
	}
	
	@Override
	public void nextFrame(SpaceshipLogic spaceshipLogic) {
		
		if(freezeSpaceship == false)
		{
			enemySpaceshipMove.nextFrame();
			enemySpaceshipShoot.nextFrame(enemySpaceshipSprite, spaceshipLogic);
		}
//		++temp;
//		if(temp == 200)
//		{
//			healthBarLogic.objectStats.kill();
//		}
		ram(spaceshipLogic, 20);
		if(healthBarLogic.objectStats.objectIsDead() == true)
		{
			if(spaceshipExplosion.spaceshipIsExploded == false)
			{
				if(spaceshipExplosion.animationPlays() == false)
				{
					freezeSpaceship = true;
					spaceshipExplosion.startExplosion();
				}
			}
		}
	}
	
	@Override
	public int getSpriteWidth() {
		return enemySpaceshipSprite.getSpriteWidth();
	}

	@Override
	public int getSpriteHeight() {
		return enemySpaceshipSprite.getSpriteHeight();
	}

	@Override
	public EnemySpaceshipSprite getEnemySpaceshipSprite() {
		return enemySpaceshipSprite;
	}
}
