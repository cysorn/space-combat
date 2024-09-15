package game.field.logic.enemies.appearance;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import game.field.logic.levels.LevelObjectInformation;
import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.enemies.EnemySpaceshipTextures;
import game.objects.enemies.enemy_laser.EnemyLaserLogic;
import game.objects.enemies.logic.EnemySpaceshipLogic;
import game.objects.enemies.logic.EnemySpaceshipCodes;

public class EnemySpaceshipAppearance {
	private int winWidth;
	private int winHeight;
	private int initialXPos;
	private final int initialYPos;
	private List<EnemySpaceshipSprite> enemySpaceshipSprites;
	private List<EnemySpaceshipLogic> enemySpaceshipLogics;
	private EnemySpaceshipTextures enemySpaceshipTextures;
	private int initialYPosOfNextEnemySpaceship;
	private List<EnemyLaserLogic> enemyLaserLogics;
	
	public EnemySpaceshipAppearance(int winWidth, int winHeight, List<EnemySpaceshipSprite> enemySpaceshipSprites,//
			List<EnemySpaceshipLogic> enemySpaceshipLogics, EnemySpaceshipTextures enemySpaceshipTextures, List<EnemyLaserLogic> enemyLaserLogics) {
		this.winWidth = winWidth;
		this.winHeight = winHeight;
		initialYPos = -200;
		this.enemySpaceshipSprites = enemySpaceshipSprites;
		this.enemySpaceshipLogics = enemySpaceshipLogics;
		this.enemySpaceshipTextures = enemySpaceshipTextures;
		resetInitialYPosOfNextEnemySpaceship();
		this.enemyLaserLogics = enemyLaserLogics;
	}
	
	private void generateNewInitialXPos(EnemySpaceshipSprite enemySpaceshipSprite, LevelObjectInformation levelObjectInformation)
	{
		
		int rangeBegin = getSpawnRangeBeginByCode(enemySpaceshipSprite, levelObjectInformation.enemySpaceshipCode);
		int rangeEnd = getSpawnRangeEndByCode(enemySpaceshipSprite, levelObjectInformation.enemySpaceshipCode);
		initialXPos = Math.abs(new Random().nextInt() % (winWidth - 200));
		System.out.println(initialXPos);
	}

	public void resetInitialYPosOfNextEnemySpaceship()
	{
		initialYPosOfNextEnemySpaceship = initialYPos;
	}
	
//	TODO spaceships still are spawning too near to each other
	public void findCordinatesAndAddEnemySpaceship(LevelObjectInformation levelObjectInformation) throws IOException
	{

		BufferedImage enemySpaceshipTexture = enemySpaceshipTextures.getEnemySpaceshipTextureByCode(levelObjectInformation.enemySpaceshipCode);
		int spaceshipWidth = enemySpaceshipTexture.getWidth();
		int spaceshipHeight = enemySpaceshipTexture.getHeight();
		boolean thereAreNoCollisionsOnThisCordinates = true;
		initialYPosOfNextEnemySpaceship -= levelObjectInformation.distanceToTheObject;
		
		while(true)
		{
			thereAreNoCollisionsOnThisCordinates = true;
			for(EnemySpaceshipSprite enemySpaceshipSprite: enemySpaceshipSprites)
			{
				generateNewInitialXPos(enemySpaceshipSprite, levelObjectInformation);
				if(initialYPosOfNextEnemySpaceship - spaceshipHeight < enemySpaceshipSprite.yPos
				&& ((initialXPos > enemySpaceshipSprite.xPos 
					&& initialXPos < enemySpaceshipSprite.xPos - enemySpaceshipSprite.getSpriteWidth())
				|| (initialXPos + spaceshipWidth > enemySpaceshipSprite.xPos 
					&& initialXPos + spaceshipWidth < enemySpaceshipSprite.xPos - enemySpaceshipSprite.getSpriteWidth())
				|| (enemySpaceshipSprite.xPos > initialXPos && enemySpaceshipSprite.xPos < initialXPos + spaceshipWidth)))
				{
					thereAreNoCollisionsOnThisCordinates = false;
					break;
				}
			} 
			if(thereAreNoCollisionsOnThisCordinates == true)
			{
				try {
					enemySpaceshipLogics.add(EnemySpaceshipCodes.createAndGetSpaceshipByCode(levelObjectInformation.enemySpaceshipCode, initialXPos,//
							initialYPosOfNextEnemySpaceship, enemySpaceshipTexture, enemyLaserLogics));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		}
	}
	
	private int getSpawnRangeBeginByCode(EnemySpaceshipSprite enemySpaceshipSprite, char code)
	{
		float enemySpaceshipHalfWidth = enemySpaceshipSprite.getSpriteWidth() * 1.5f;
		float xPos = enemySpaceshipSprite.xPos;
		switch(code)
		{
		case 'A': return 0;
		case 'B':
			int halfRange = 200;
			if(xPos - enemySpaceshipHalfWidth - halfRange > 0)
			{
				return (int)(xPos - enemySpaceshipHalfWidth - halfRange);
			}
			else
			{
				return 0;				
			}
//		TODO add throw
		default: return 0;
		}
	}
	
	private int getSpawnRangeEndByCode(EnemySpaceshipSprite enemySpaceshipSprite, char code)
	{
		float enemySpaceshipHalfWidth = enemySpaceshipSprite.getSpriteWidth() * 1.5f;
		float xPos = enemySpaceshipSprite.xPos;
		switch(code)
		{
		case 'A': return (int)(winWidth - enemySpaceshipHalfWidth);
		case 'B':
			int halfRange = 200;
			if(xPos + enemySpaceshipHalfWidth + halfRange < (int)(winWidth - enemySpaceshipHalfWidth))
			{
				return (int)(xPos + enemySpaceshipHalfWidth + halfRange);
			}
			else
			{
				return (int)(winWidth - enemySpaceshipHalfWidth);				
			}
//		TODO add throw
		default: return (int)(winWidth - enemySpaceshipHalfWidth);
		}
	}
}