package game.field.logic.enemies.appearance;

import java.io.IOException;
import java.util.List;

import game.field.logic.enemies.stages.LevelManager;
import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.enemies.EnemySpaceshipTextures;
import game.objects.enemies.logic.EnemySpaceshipLogic;

public class EnemySpaceshipAppearanceManager {
	
	private EnemySpaceshipAppearance enemySpaceshipAppearance;
	private LevelManager levelManager;
//	private List<EnemyStarshipSprite> enemyStarshipSprites;
//	private List<EnemyStarshipLogic> enemyStarshipLogics;
//	private EnemyStarshipTextures enemyStarshipTextures;
	private Character tempEnemySpaceshipCodeToSpawn;

	public EnemySpaceshipAppearanceManager(int winWidth, int winHeight, List<EnemySpaceshipSprite> enemySpaceshipSprites, List<EnemySpaceshipLogic> enemySpaceshipLogics, EnemySpaceshipTextures enemySpaceshipTextures) {
		enemySpaceshipAppearance = new EnemySpaceshipAppearance(winWidth, winHeight, enemySpaceshipSprites, enemySpaceshipLogics, enemySpaceshipTextures);
//		this.enemyStarshipSprites = enemyStarshipSprites;
//		this.enemyStarshipLogics = enemyStarshipLogics;
//		this.enemyStarshipTextures = enemyStarshipTextures;
		tempEnemySpaceshipCodeToSpawn = null;
		levelManager = new LevelManager();
		
	}
	
	public void nextFrame() throws IOException
	{
		tempEnemySpaceshipCodeToSpawn = levelManager.getSpaceshipCodeOrContinueTimer();
		if(tempEnemySpaceshipCodeToSpawn != null)
		{
			enemySpaceshipAppearance.findCordinatgesAndAddEnemyStarship(tempEnemySpaceshipCodeToSpawn);
		}
	}
}
