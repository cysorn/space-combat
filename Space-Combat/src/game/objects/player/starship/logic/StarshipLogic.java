package game.objects.player.starship.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.Sprite;
import game.objects.player.starship.StarshipSprite;
import game.objects.player.starship.StarshipTextures;

//TODO create new classes for Starship, stars, etc. and create logic classes
public class StarshipLogic{

	public StarshipSprite starshipSprite;
	private Spawn spawnStarship;
	public StarshipMove starshipMove;
	public StarshipExplosion starshipExplosion;
	public boolean freezeStarship;
	
	public StarshipLogic(int winWidth, int winHeight) throws IOException {
		starshipSprite = new StarshipSprite(winHeight, winHeight);
		freezeStarship = true;
		starshipMove = new StarshipMove(starshipSprite, winWidth, winHeight);
		spawnStarship = new Spawn(starshipSprite, winWidth / 2 - 40, winHeight / 2f);
		starshipExplosion = new StarshipExplosion(starshipSprite);
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
		}
		if(spawnStarship.spawnIsDone() == true)
		{
			freezeStarship = false;
		}
		if(starshipExplosion.starshipExploded() == true)
		{
			freezeStarship = true;
			starshipMove.resetTexture();
			spawnStarship.startSpawn();
		}
	}
	
	public BufferedImage getSpriteTexture() {
		
		return starshipMove.getSpriteTexture();
	}
}