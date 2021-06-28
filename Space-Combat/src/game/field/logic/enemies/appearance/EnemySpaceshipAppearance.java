package game.field.logic.enemies.appearance;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import game.field.logic.levels.LevelObjectInformation;
import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.enemies.EnemySpaceshipTextures;
import game.objects.enemies.logic.EnemySpaceshipLogic;
import game.objects.enemies.logic.EnemySpaceshipCodes;

public class EnemySpaceshipAppearance {
	private int winWidth;
	private int winHeight;
	private Random xRnd;
	private int initialXPos;
	private final int initialYPos;
	private List<EnemySpaceshipSprite> enemySpaceshipSprites;
	private List<EnemySpaceshipLogic> enemySpaceshipLogics;
	private EnemySpaceshipTextures enemySpaceshipTextures;
	private int initialYPosOfNextEnemySpaceship;
	
	public EnemySpaceshipAppearance(int winWidth, int winHeight, List<EnemySpaceshipSprite> enemySpaceshipSprites,//
			List<EnemySpaceshipLogic> enemyStarshipLogics, EnemySpaceshipTextures enemySpaceshipTextures) {
		xRnd = new Random(); 
		this.winWidth = winWidth;
		this.winHeight = winHeight;
		initialYPos = -200;
		this.enemySpaceshipSprites = enemySpaceshipSprites;
		this.enemySpaceshipLogics = enemyStarshipLogics;
		this.enemySpaceshipTextures = enemySpaceshipTextures;
		resetInitialYPosOfNextEnemySpaceship();
	}
	
	private void generateNewInitialXPos(BufferedImage enemySpaceshipTexture)
	{
		initialXPos = Math.abs(xRnd.nextInt() % (int)(winWidth - enemySpaceshipTexture.getWidth() * 1.5f));
	}

	public void resetInitialYPosOfNextEnemySpaceship()
	{
		initialYPosOfNextEnemySpaceship = initialYPos;
	}
	
//	TODO spaceships still are spawning too near to each other
	public void findCordinatesAndAddEnemySpaceship(LevelObjectInformation levelObjectInformation) throws IOException
	{
//		EnemyStarshipLogic enemyStarshipLogicToAdd = StarshipIndexes.createAndGetStarshipByCode(enemyStarshipCode, initialXPos,//
//				initialYPos, enemyStarshipTextures.getEnemyStarshipTextureByCode(enemyStarshipCode));
		BufferedImage enemySpaceshipTexture = enemySpaceshipTextures.getEnemySpaceshipTextureByCode(levelObjectInformation.enemySpaceshipCode);
		int spaceshipWidth = enemySpaceshipTexture.getWidth();
		int spaceshipHeight = enemySpaceshipTexture.getHeight();
		boolean thereAreNoCollisionsOnThisCordinates = true;
		initialYPosOfNextEnemySpaceship -= levelObjectInformation.distanceToTheObject;
		
		while(true)
		{
			thereAreNoCollisionsOnThisCordinates = true;
			generateNewInitialXPos(enemySpaceshipTexture);
			for(EnemySpaceshipSprite enemyStarshipSprite: enemySpaceshipSprites)
			{
				if(initialYPosOfNextEnemySpaceship - spaceshipHeight < enemyStarshipSprite.yPos
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
				enemySpaceshipLogics.add(EnemySpaceshipCodes.createAndGetSpaceshipByCode(levelObjectInformation.enemySpaceshipCode, initialXPos,//
						initialYPosOfNextEnemySpaceship, enemySpaceshipTexture));
				return;
			}
		}
	}
	
//	public void findCordinatesAndAddEnemySpaceship(Level currentLevelInformation, SpaceCombatPanel spaceCombatPanel, Graphics2D g2d) throws IOException {
//		
////		EnemyStarshipLogic enemyStarshipLogicToAdd = StarshipIndexes.createAndGetStarshipByCode(enemyStarshipCode, initialXPos,//
////		initialYPos, enemyStarshipTextures.getEnemyStarshipTextureByCode(enemyStarshipCode));
//		if(currentLevelInformation == null)
//		{
//			return;
//		}
//		BufferedImage enemySpaceshipTexture;
//		int spaceshipWidth;
//		int spaceshipHeight;
//		boolean thereAreNoCollisionsOnThisCordinates;
//		int initialYPosOfNextEnemySpaceship = initialYPos;
//		
//		for(int levelObjectNrToSpawn = 0; levelObjectNrToSpawn < currentLevelInformation.levelObjectInformation.size(); ++levelObjectNrToSpawn)
//		{
//			LevelObjectInformation levelObjectInformation = currentLevelInformation.levelObjectInformation.get(levelObjectNrToSpawn);
//			enemySpaceshipTexture = enemySpaceshipTextures.getEnemySpaceshipTextureByCode(levelObjectInformation.enemySpaceshipCode);
//			spaceshipWidth = enemySpaceshipTexture.getWidth();
//			spaceshipHeight = enemySpaceshipTexture.getHeight();
//			thereAreNoCollisionsOnThisCordinates = true;
//			initialYPosOfNextEnemySpaceship -= levelObjectInformation.distanceToTheObject;
//			
//			while(true)
//			{
//				thereAreNoCollisionsOnThisCordinates = true;
//				generateNewInitialXPos(enemySpaceshipTexture);
//				for(EnemySpaceshipSprite enemySpaceshipSprite: enemySpaceshipSprites)
//				{
//					if(initialYPosOfNextEnemySpaceship - spaceshipHeight < enemySpaceshipSprite.yPos
//					&& ((initialXPos > enemySpaceshipSprite.xPos 
//						&& initialXPos < enemySpaceshipSprite.xPos - enemySpaceshipSprite.getSpriteWidth())
//					|| (initialXPos + spaceshipWidth > enemySpaceshipSprite.xPos 
//						&& initialXPos + spaceshipWidth < enemySpaceshipSprite.xPos - enemySpaceshipSprite.getSpriteWidth())
//					|| (enemySpaceshipSprite.xPos > initialXPos && enemySpaceshipSprite.xPos < initialXPos + spaceshipWidth)))
//					{
//						thereAreNoCollisionsOnThisCordinates = false;
//						break;
//					}
//				}
//				if(thereAreNoCollisionsOnThisCordinates == true)
//				{
//					enemySpaceshipLogics.add(EnemySpaceshipCodes.createAndGetSpaceshipByCode(currentLevelInformation.levelObjectInformation.get(levelObjectNrToSpawn).enemySpaceshipCode, initialXPos,//
//							initialYPosOfNextEnemySpaceship, enemySpaceshipTexture));
////					System.out.println("Objects to load count: " + LoadingLogic.objectsToLoadCount);
////					System.out.println("Counter: " + LoadingLogic.loadedObjectsCounter);
////					paintLoadingBar(g2d, spaceCombatPanel);
//					break;
//				}
//			}
//		}
//	}
//	
//    public void paintLoadingBar(Graphics2D g2d, SpaceCombatPanel spaceCombatPanel)
//    {
//    	++counter;
//    	g2d.setComposite(AlphaComposite.SrcOver.derive(LoadingLogic.loadingSprite.currentAlpha));
////    	System.out.println(LoadingLogic.getLoadingTextureNr());
////    	g2d.drawImage(LoadingLogic.getLoadingTexture(),//
////    	g2d.drawImage(LoadingLogic.getLoadingTexture(),//
//    	g2d.drawImage(LoadingLogic.loadingSprite.loadingTextures.loadingTextures.get(counter % 46),
//    			(int)LoadingLogic.loadingSprite.xPos,
//    			(int)LoadingLogic.loadingSprite.yPos,
//    			spaceCombatPanel);
//    	g2d.setComposite(AlphaComposite.SrcOver.derive(1f));
//    }
	
//	returns false if there are no collisions
//	private boolean checkForCollisions()
//	{
//		for(EnemyStarshipLogic enemyStarshipLogic: enemyStarshipLogics)
//		{
//			if(initialXPos)
//		}
//	}
}