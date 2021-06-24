package game.field.logic.enemies.appearance;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.enemies.EnemySpaceshipTextures;
import game.objects.enemies.logic.EnemySpaceshipLogic;
import game.objects.enemies.logic.EnemySpaceshipCodes;

public class EnemySpaceshipAppearance {
	private int winWidth;
	private int winHeight;
	private Random xRnd;
	private int initialXPos;
	public final int initialYPos;
	private List<EnemySpaceshipSprite> enemySpaceshipSprites;
	private List<EnemySpaceshipLogic> enemySpaceshipLogics;
	private EnemySpaceshipTextures enemySpaceshipTextures;
	
	public EnemySpaceshipAppearance(int winWidth, int winHeight, List<EnemySpaceshipSprite> enemySpaceshipSprites,//
			List<EnemySpaceshipLogic> enemyStarshipLogics, EnemySpaceshipTextures enemySpaceshipTextures) {
		xRnd = new Random(); 
		this.winWidth = winWidth;
		this.winHeight = winHeight;
		initialYPos = -200;
		this.enemySpaceshipSprites = enemySpaceshipSprites;
		this.enemySpaceshipLogics = enemyStarshipLogics;
		this.enemySpaceshipTextures = enemySpaceshipTextures;
	}
	
	private void generateNewInitialXPos(BufferedImage enemySpaceshipTexture)
	{
		initialXPos = Math.abs(xRnd.nextInt() % (winWidth - enemySpaceshipTexture.getWidth()));
	}
	
	public void findCordinatgesAndAddEnemyStarship(Character enemySpaceshipCode) throws IOException
	{
//		EnemyStarshipLogic enemyStarshipLogicToAdd = StarshipIndexes.createAndGetStarshipByCode(enemyStarshipCode, initialXPos,//
//				initialYPos, enemyStarshipTextures.getEnemyStarshipTextureByCode(enemyStarshipCode));
		BufferedImage enemySpaceshipTexture = enemySpaceshipTextures.getEnemySpaceshipTextureByCode(enemySpaceshipCode);
		int spaceshipWidth = enemySpaceshipTexture.getWidth();
		int spaceshipHeight = enemySpaceshipTexture.getHeight();
		boolean thereAreNoCollisionsOnThisCordinates = true;
		
		while(true)
		{
			thereAreNoCollisionsOnThisCordinates = true;
			generateNewInitialXPos(enemySpaceshipTexture);
			for(EnemySpaceshipSprite enemyStarshipSprite: enemySpaceshipSprites)
			{
				if(initialYPos - spaceshipHeight < enemyStarshipSprite.yPos
				&& ((initialXPos > enemyStarshipSprite.xPos 
					&& initialXPos < enemyStarshipSprite.xPos - enemyStarshipSprite.getSpriteWidth())
				|| (initialXPos + spaceshipWidth > enemyStarshipSprite.xPos 
					&& initialXPos + spaceshipWidth < enemyStarshipSprite.xPos - enemyStarshipSprite.getSpriteWidth())
				|| (enemyStarshipSprite.xPos > initialXPos && enemyStarshipSprite.xPos < initialXPos + spaceshipWidth)))
				{
					thereAreNoCollisionsOnThisCordinates = false;
					break;
				}
			}
			if(thereAreNoCollisionsOnThisCordinates == true)
			{
				enemySpaceshipLogics.add(EnemySpaceshipCodes.createAndGetSpaceshipByCode(enemySpaceshipCode, initialXPos,//
						initialYPos, enemySpaceshipTexture));
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