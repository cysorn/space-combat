package game.objects.player.starship.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

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
		starshipSprite = new StarshipSprite(winHeight, winHeight);
		freezeStarship = true;
		starshipMove = new StarshipMove(starshipSprite, winWidth, winHeight);
		spawnStarship = new ObjectSpawn(starshipSprite, winWidth / 2 - 40, winHeight / 2f);
		starshipExplosion = new StarshipExplosion(starshipSprite);
		healthBarLogic = new HealthBarLogic(starshipSprite, 200);
	}
	
	public void nextFrame() {
	
		if(freezeStarship == false)
		{
			starshipMove.nextFrame();
		}
		spawnStarship.nextFrame();
		if(starshipExplosion.animationPlays() == true)
		{
			freezeStarship = true;
			starshipExplosion.nextFrame();
			healthBarLogic.objectStats.kill();
		}
		else if(healthBarLogic.objectStats.objectIsDead() == true)
		{
			freezeStarship = true;
			starshipMove.resetTexture();
			spawnStarship.startSpawn();
			healthBarLogic.objectStats.setHpToFull();
		}
		if(spawnStarship.spawnIsDone() == true)
		{
			freezeStarship = false;
		}
	}
	
	public BufferedImage getSpriteTexture() {
		
		return starshipMove.getSpriteTexture();
	}
}