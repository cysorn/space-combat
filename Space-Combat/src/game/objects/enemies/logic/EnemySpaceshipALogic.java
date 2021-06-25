package game.objects.enemies.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.player.spaceship.logic.SpaceshipLogic;

public class EnemySpaceshipALogic extends EnemySpaceshipLogic{
	
	public EnemySpaceshipALogic(int initialXPos, int initialYPos, BufferedImage enemySpaceshipTexture) throws IOException {
		super(new EnemySpaceshipSprite(initialXPos, initialYPos, 80, 80, enemySpaceshipTexture));
//		healthBarLogic.setHpAndBarToFull();
	}
	
	@Override
	public void nextFrame(SpaceshipLogic spaceshipLogic) {
		
		if(freezeStarship == false)
		{
			enemySpaceshipMove.nextFrame();
		}
//		++temp;
//		if(temp == 200)
//		{
//			healthBarLogic.objectStats.kill();
//		}
		ram(spaceshipLogic, 30);
		if(healthBarLogic.objectStats.objectIsDead() == true)
		{
			if(spaceshipExplosion.spaceshipIsExploded == false)
			{
				if(spaceshipExplosion.animationPlays() == false)
				{
					freezeStarship = true;
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
