package game.field.logic.enemies.appearance;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import game.objects.enemies.EnemyStarshipSprite;
import game.objects.enemies.EnemyStarshipTextures;
import game.objects.enemies.logic.EnemyStarshipLogic;
import game.objects.enemies.logic.StarshipIndexes;

public class EnemyStarshipAppearance {
	private int winWidth;
	private int winHeight;
	private Random xRnd;
	private int initialXPos;
	public final int initialYPos;
	private List<EnemyStarshipSprite> enemyStarshipSprites;
	private List<EnemyStarshipLogic> enemyStarshipLogics;
	private EnemyStarshipTextures enemyStarshipTextures;
	
	public EnemyStarshipAppearance(int winWidth, int winHeight, List<EnemyStarshipSprite> enemyStarshipSprites,//
			List<EnemyStarshipLogic> enemyStarshipLogics, EnemyStarshipTextures enemyStarshipTextures) {
		xRnd = new Random(); 
		this.winWidth = winWidth;
		this.winHeight = winHeight;
		initialYPos = -200;
		this.enemyStarshipSprites = enemyStarshipSprites;
		this.enemyStarshipLogics = enemyStarshipLogics;
		this.enemyStarshipTextures = enemyStarshipTextures;
	}
	
	private void generateNewInitialXPos(BufferedImage enemyStarshipTexture)
	{
		initialXPos = Math.abs(xRnd.nextInt() % (winWidth - enemyStarshipTexture.getWidth()));
	}
	
	public void findCordinatgesAndAddEnemyStarship(Character enemyStarshipCode) throws IOException
	{
//		EnemyStarshipLogic enemyStarshipLogicToAdd = StarshipIndexes.createAndGetStarshipByCode(enemyStarshipCode, initialXPos,//
//				initialYPos, enemyStarshipTextures.getEnemyStarshipTextureByCode(enemyStarshipCode));
		BufferedImage enemyStarshipTexture = enemyStarshipTextures.getEnemyStarshipTextureByCode(enemyStarshipCode);
		int starshipWidth = enemyStarshipTexture.getWidth();
		int starshipHeight = enemyStarshipTexture.getHeight();
		boolean thereAreNoCollisionsOnThisCordinates = true;
		
		while(true)
		{
			thereAreNoCollisionsOnThisCordinates = true;
			generateNewInitialXPos(enemyStarshipTexture);
			for(EnemyStarshipSprite enemyStarshipSprite: enemyStarshipSprites)
			{
				if(initialYPos - starshipHeight < enemyStarshipSprite.yPos
				&& ((initialXPos > enemyStarshipSprite.xPos 
					&& initialXPos < enemyStarshipSprite.xPos - enemyStarshipSprite.getSpriteWidth())
				|| (initialXPos + starshipWidth > enemyStarshipSprite.xPos 
					&& initialXPos + starshipWidth < enemyStarshipSprite.xPos - enemyStarshipSprite.getSpriteWidth())
				|| (enemyStarshipSprite.xPos > initialXPos && enemyStarshipSprite.xPos < initialXPos + starshipWidth)))
				{
					thereAreNoCollisionsOnThisCordinates = false;
					break;
				}
			}
			if(thereAreNoCollisionsOnThisCordinates == true)
			{
				enemyStarshipLogics.add(StarshipIndexes.createAndGetStarshipByCode(enemyStarshipCode, initialXPos,//
						initialYPos, enemyStarshipTexture));
				return;
			}
		}
	}
	
//	returns false if there are no collisions
//	private boolean checkForCollisions()
//	{
//		for(EnemyStarshipLogic enemyStarshipLogic: enemyStarshipLogics)
//		{
//			if(initialXPos)
//		}
//	}
}