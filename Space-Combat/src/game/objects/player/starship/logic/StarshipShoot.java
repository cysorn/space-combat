package game.objects.player.starship.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.StarshipAction;
import game.objects.laser.LaserLogic;
import game.objects.player.starship.StarshipSprite;

public class StarshipShoot {
	
	public List<LaserLogic> laserLogics;
	private float shootingSpeed;
	private float shootingSpeedCounter;
	private StarshipSprite starshipSprite;
	public StarshipAction shoot;
	
	public StarshipShoot(StarshipSprite starshipSprite)
	{
		this.shootingSpeed = 20f;
		this.shootingSpeedCounter = shootingSpeed;
		laserLogics = new ArrayList<LaserLogic>();
		this.starshipSprite = starshipSprite;
		shoot = StarshipAction.STOP;
	}
	
	public void nextFrame()
	{
//		checkCollisions(enemies);
		if(shootingSpeedCounter < shootingSpeed)
		{
			++shootingSpeedCounter;
		}
		else if(shoot == StarshipAction.START)
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
