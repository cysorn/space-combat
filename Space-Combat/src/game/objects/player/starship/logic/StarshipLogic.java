package game.objects.player.starship.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.StarshipExplosion;
import game.objects.health_bar.logic.HealthBarLogic;
import game.objects.logic.ObjectSpawn;
import game.objects.player.starship.StarshipSprite;

//TODO create new classes for Starship, stars, etc. and create logic classes
public class StarshipLogic{

	public StarshipSprite starshipSprite;
	private ObjectSpawn spawnStarship;
	public StarshipMove starshipMove;
	public StarshipExplosion starshipExplosion;
	public HealthBarLogic healthBarLogic;
	public boolean freezeStarship;
	
	public StarshipLogic(int winWidth, int winHeight) throws IOException {
		starshipSprite = new StarshipSprite(winWidth, winHeight);
		freezeStarship = true;
		starshipMove = new StarshipMove(starshipSprite, winWidth, winHeight);
		spawnStarship = new ObjectSpawn(starshipSprite, starshipSprite.xPos, starshipSprite.yPos);
		healthBarLogic = new HealthBarLogic(starshipSprite, 100, true);
		starshipExplosion = new StarshipExplosion(starshipSprite, healthBarLogic.healthBarSprite);
		
	}
	
	public void nextFrame() {
	
		if(freezeStarship == false)
		{
			starshipMove.nextFrame();
		}
		spawnStarship.nextFrame();
		ifNecassaryPlayDieAnimationAndRespawn();
		if(spawnStarship.spawnIsDone() == true)
		{
			freezeStarship = false;
		}
	}
	
	private void ifNecassaryPlayDieAnimationAndRespawn()
	{
		if(healthBarLogic.objectStats.objectIsDead() == true)
		{
			if(starshipExplosion.starshipIsExploded == false)
			{
				if(starshipExplosion.animationPlays() == false)
				{
					freezeStarship = true;
					starshipExplosion.startExplosion();
					starshipMove.resetTexture();
				}
			}
			else
			{
				starshipExplosion.starshipIsExploded = false;
				healthBarLogic.healthBarSpawn.startSpawn();
				spawnStarship.startSpawn();
				healthBarLogic.setHpAndBarToFull();
			}
		}
	}
	
	public BufferedImage getSpriteTexture() {
		
		return starshipMove.getSpriteTexture();
	}
}