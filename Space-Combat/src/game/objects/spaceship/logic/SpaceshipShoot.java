package game.objects.spaceship.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.SpaceshipAction;
import game.objects.spaceship.SpaceshipSprite;
import game.objects.spaceship.laser.LaserLogic;

public class SpaceshipShoot {
	
	public List<LaserLogic> laserLogics;
	private float shootingSpeed;
	private float shootingSpeedCounter;
	private SpaceshipLogic spaceshipLogic;
	public SpaceshipAction shoot;
	
	public SpaceshipShoot(SpaceshipLogic spaceshipLogic)
	{
		this.shootingSpeed = 10f;
		this.shootingSpeedCounter = shootingSpeed;
		laserLogics = new ArrayList<LaserLogic>();
		this.spaceshipLogic = spaceshipLogic;
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
			if(spaceshipLogic.spaceshipExplosion.animationPlays() == false)
			{
				try {
					laserLogics.add(new LaserLogic(spaceshipLogic.spaceshipSprite.xPos + 11, spaceshipLogic.spaceshipSprite.yPos + 33));
					laserLogics.add(new LaserLogic(spaceshipLogic.spaceshipSprite.xPos + spaceshipLogic.spaceshipSprite.getSpriteWidth() - 25, spaceshipLogic.spaceshipSprite.yPos + 33));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				shootingSpeedCounter = 0f;
			}
			else
			{
				shoot = SpaceshipAction.STOP;
			}
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
