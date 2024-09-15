package game.field.logic.enemies.appearance;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.List;

import game.field.logic.levels.LevelManager;
import game.loading.logic.LoadingLogic;
import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.enemies.EnemySpaceshipTextures;
import game.objects.enemies.enemy_laser.EnemyLaserLogic;
import game.objects.enemies.logic.EnemySpaceshipLogic;
import game.ui.gui.SpaceCombatPanel;

public class EnemySpaceshipAppearanceManager {
	
	private EnemySpaceshipAppearance enemySpaceshipAppearance;
	private LevelManager levelManager;
	private int spaceshipsToBeSpawnedCount;
	private int objectToSpawnNr;

	public EnemySpaceshipAppearanceManager(int winWidth, int winHeight, List<EnemySpaceshipSprite> enemySpaceshipSprites, List<EnemySpaceshipLogic> enemySpaceshipLogics, EnemySpaceshipTextures enemySpaceshipTextures, List<EnemyLaserLogic> enemyLaserLogics) {
		enemySpaceshipAppearance = new EnemySpaceshipAppearance(winWidth, winHeight, enemySpaceshipSprites, enemySpaceshipLogics, enemySpaceshipTextures, enemyLaserLogics);

		levelManager = new LevelManager(enemySpaceshipLogics);
		spaceshipsToBeSpawnedCount = 0;
		objectToSpawnNr = 0;
	}
	
	public void nextFrame(Graphics2D g2d, SpaceCombatPanel spaceCombatPanel) throws IOException
	{

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