package game.field.logic.enemies.appearance;

import java.io.IOException;
import java.util.List;

import game.field.logic.enemies.alien_waves.AlienWavesManager;
import game.objects.enemies.EnemyStarshipSprite;
import game.objects.enemies.EnemyStarshipTextures;
import game.objects.enemies.logic.EnemyStarshipLogic;

public class EnemyStarshipAppearanceManager {
	
	private EnemyStarshipAppearance enemyStarshipAppearance;
	private AlienWavesManager alienWavesManager;
//	private List<EnemyStarshipSprite> enemyStarshipSprites;
//	private List<EnemyStarshipLogic> enemyStarshipLogics;
//	private EnemyStarshipTextures enemyStarshipTextures;
	private Character tempEnemyStarshipCodeToSpawn;

	public EnemyStarshipAppearanceManager(int winWidth, int winHeight, List<EnemyStarshipSprite> enemyStarshipSprites, List<EnemyStarshipLogic> enemyStarshipLogics, EnemyStarshipTextures enemyStarshipTextures) {
		enemyStarshipAppearance = new EnemyStarshipAppearance(winWidth, winHeight, enemyStarshipSprites, enemyStarshipLogics, enemyStarshipTextures);
//		this.enemyStarshipSprites = enemyStarshipSprites;
//		this.enemyStarshipLogics = enemyStarshipLogics;
//		this.enemyStarshipTextures = enemyStarshipTextures;
		tempEnemyStarshipCodeToSpawn = null;
		alienWavesManager = new AlienWavesManager();
		
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
