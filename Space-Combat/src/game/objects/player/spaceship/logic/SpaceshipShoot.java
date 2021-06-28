package game.objects.player.spaceship.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.SpaceshipAction;
import game.objects.laser.LaserLogic;
import game.objects.player.spaceship.SpaceshipSprite;

public class SpaceshipShoot {
	
	public List<LaserLogic> laserLogics;
	private float shootingSpeed;
	private float shootingSpeedCounter;
	private SpaceshipSprite starshipSprite;
	public SpaceshipAction shoot;
	
	public SpaceshipShoot(SpaceshipSprite starshipSprite)
	{
		this.shootingSpeed = 10f;
		this.shootingSpeedCounter = shootingSpeed;
		laserLogics = new ArrayList<LaserLogic>();
		this.starshipSprite = starshipSprite;
		shoot = SpaceshipAction.STOP;
	}
	
	public void nextFrame()
	{
//		checkCollisions(enemies);
		if(shootingSpeedCounter < shootingSpeed)
		{
			++shootingSpeedCounter;
		}
		else if(shoot == SpaceshipAction.START)
		{
			try {
				laserLogics.add(new LaserLogic(starshipSprite.xPos + 11, starshipSprite.yPos + 33));
				laserLogics.add(new LaserLogic(starshipSprite.xPos + starshipSprite.getSpriteWidth() - 25, starshipSprite.yPos + 33));
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
