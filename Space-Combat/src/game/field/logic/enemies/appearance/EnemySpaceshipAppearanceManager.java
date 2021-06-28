package game.field.logic.enemies.appearance;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.List;

import game.field.logic.levels.LevelManager;
import game.loading.logic.LoadingLogic;
import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.enemies.EnemySpaceshipTextures;
import game.objects.enemies.logic.EnemySpaceshipLogic;
import game.ui.gui.SpaceCombatPanel;

public class EnemySpaceshipAppearanceManager {
	
	private EnemySpaceshipAppearance enemySpaceshipAppearance;
	private LevelManager levelManager;
	private int spaceshipsToBeSpawnedCount;
	private int objectToSpawnNr;
//	private List<EnemyStarshipSprite> enemyStarshipSprites;
//	private List<EnemyStarshipLogic> enemyStarshipLogics;
//	private EnemyStarshipTextures enemyStarshipTextures;
//	private Character tempEnemySpaceshipCodeToSpawn;

	public EnemySpaceshipAppearanceManager(int winWidth, int winHeight, List<EnemySpaceshipSprite> enemySpaceshipSprites, List<EnemySpaceshipLogic> enemySpaceshipLogics, EnemySpaceshipTextures enemySpaceshipTextures) {
		enemySpaceshipAppearance = new EnemySpaceshipAppearance(winWidth, winHeight, enemySpaceshipSprites, enemySpaceshipLogics, enemySpaceshipTextures);
//		this.enemyStarshipSprites = enemyStarshipSprites;
//		this.enemyStarshipLogics = enemyStarshipLogics;
//		this.enemyStarshipTextures = enemyStarshipTextures;
//		tempEnemySpaceshipCodeToSpawn = null;
		levelManager = new LevelManager(enemySpaceshipLogics);
		spaceshipsToBeSpawnedCount = 0;
		objectToSpawnNr = 0;
	}
	
	public void nextFrame(Graphics2D g2d, SpaceCombatPanel spaceCombatPanel) throws IOException
	{
//		tempEnemySpaceshipCodeToSpawn = levelManager.getSpaceshipCodeOrContinueTimer();
//		if(tempEnemySpaceshipCodeToSpawn != null)
//		{
//			enemySpaceshipAppearance.findCordinatgesAndAddEnemyStarship(tempEnemySpaceshipCodeToSpawn);
//		}
		if(levelManager.levelIsDone() == true)
		{
			levelManager.updateLevelNr();
			LoadingLogic.startLoading();
//			paintLoadingBar(g2d, spaceCombatPanel);
			if(levelManager.getCurrentLevelInformation() != null)
			{
				LoadingLogic.objectsToLoadCount += levelManager.getCurrentLevelInformation().levelObjectInformation.size();
				spaceshipsToBeSpawnedCount = levelManager.getCurrentLevelInformation().levelObjectInformation.size();
				objectToSpawnNr = 0;
				enemySpaceshipAppearance.resetInitialYPosOfNextEnemySpaceship();
			}
		}
		if(spaceshipsToBeSpawnedCount > 0)
		{
			enemySpaceshipAppearance.findCordinatesAndAddEnemySpaceship(levelManager.getCurrentLevelInformation().levelObjectInformation.get(objectToSpawnNr));
			++LoadingLogic.loadedObjectsCounter;
			--spaceshipsToBeSpawnedCount;
			++objectToSpawnNr;
		}
		else
		{
			LoadingLogic.loadingIsFinished = true;
		}
	}
	
	public boolean thereIsNoNextLevel()
	{
		return levelManager.getCurrentLevelInformation() == null || levelManager.getCurrentLevelInformation().levelObjectInformation.size() == 0;
	}
}