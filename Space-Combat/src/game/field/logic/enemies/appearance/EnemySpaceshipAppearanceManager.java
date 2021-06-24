package game.field.logic.enemies.appearance;

import java.io.IOException;
import java.util.List;

import game.field.logic.enemies.stages.StagesManager;
import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.enemies.EnemySpaceshipTextures;
import game.objects.enemies.logic.EnemySpaceshipLogic;

public class EnemySpaceshipAppearanceManager {
	
	private EnemySpaceshipAppearance enemyStarshipAppearance;
	private StagesManager alienWavesManager;
//	private List<EnemyStarshipSprite> enemyStarshipSprites;
//	private List<EnemyStarshipLogic> enemyStarshipLogics;
//	private EnemyStarshipTextures enemyStarshipTextures;
	private Character tempEnemyStarshipCodeToSpawn;

	public EnemySpaceshipAppearanceManager(int winWidth, int winHeight, List<EnemySpaceshipSprite> enemyStarshipSprites, List<EnemySpaceshipLogic> enemyStarshipLogics, EnemySpaceshipTextures enemyStarshipTextures) {
		enemyStarshipAppearance = new EnemySpaceshipAppearance(winWidth, winHeight, enemyStarshipSprites, enemyStarshipLogics, enemyStarshipTextures);
//		this.enemyStarshipSprites = enemyStarshipSprites;
//		this.enemyStarshipLogics = enemyStarshipLogics;
//		this.enemyStarshipTextures = enemyStarshipTextures;
		tempEnemyStarshipCodeToSpawn = null;
		alienWavesManager = new StagesManager();
		
	}
	
	public void nextFrame() throws IOException
	{
		tempEnemyStarshipCodeToSpawn = alienWavesManager.getStarshipTypeOrContinueTimer();
		if(tempEnemyStarshipCodeToSpawn != null)
		{
			enemyStarshipAppearance.findCordinatgesAndAddEnemyStarship(tempEnemyStarshipCodeToSpawn);
		}
	}
}
