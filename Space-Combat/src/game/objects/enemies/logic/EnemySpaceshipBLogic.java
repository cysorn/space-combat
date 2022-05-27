package game.objects.enemies.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.enemies.enemy_laser.EnemyLaserLogic;
import game.objects.spaceship.logic.SpaceshipLogic;

public class EnemySpaceshipBLogic extends EnemySpaceshipLogic{
	
	public EnemySpaceshipBLogic(int initialXPos, int initialYPos, BufferedImage enemySpaceshipTexture, List<EnemyLaserLogic> enemyLaserLogics) throws IOException {
		super(new EnemySpaceshipSprite(initialXPos, initialYPos, 80, 80, enemySpaceshipTexture), 40);
	}
	
	@Override
	public void nextFrame(SpaceshipLogic spaceshipLogic) {
		
		if(freezeSpaceship == false)
		{
			enemySpaceshipMove.nextFrame();
		}
		ram(spaceshipLogic, 35);
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
