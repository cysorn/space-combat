package game.objects.enemies.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.enemies.EnemyStarshipSprite;

public class EnemyStarshipALogic extends EnemyStarshipLogic{
	
	int temp;
	
	public EnemyStarshipALogic(int initialXPos, int initialYPos, BufferedImage enemyStarshipTexture) throws IOException {
		super(new EnemyStarshipSprite(initialXPos, initialYPos, 72, 80, enemyStarshipTexture));
//		healthBarLogic.setHpAndBarToFull();
		temp = 0;
	}
	
	@Override
	public void nextFrame() {
		
		if(freezeStarship == false)
		{
			enemyStarshipMove.nextFrame();
		}
		++temp;
		if(temp == 200)
		{
			healthBarLogic.objectStats.kill();
		}
		if(healthBarLogic.objectStats.objectIsDead() == true)
		{
			if(starshipExplosion.starshipIsExploded == false)
			{
				if(starshipExplosion.animationPlays() == false)
				{
					freezeStarship = true;
					starshipExplosion.startExplosion();
				}
			}
		}
	}
	
	@Override
	public int getSpriteWidth() {
		return enemyStarshipSprite.getSpriteWidth();
	}

	@Override
	public int getSpriteHeight() {
		return enemyStarshipSprite.getSpriteHeight();
	}

	@Override
	public EnemyStarshipSprite getEnemyStarshipSprite() {
		return enemyStarshipSprite;
	}
}