package game.field.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.field.logic.enemies.appearance.EnemySpaceshipAppearanceManager;
import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.enemies.EnemySpaceshipTextures;
import game.objects.enemies.logic.EnemySpaceshipLogic;
import game.objects.player.spaceship.logic.SpaceshipLogic;

//	TODO delete unused logics and sprites
public class FieldLogic {
	public int windowWidht;
	public int windowHeight;
	public SpaceshipLogic spaceshipLogic;
	public List<EnemySpaceshipLogic> enemySpaceshipLogics;
	public EnemySpaceshipTextures enemySpaceshipTextures;
	private EnemySpaceshipAppearanceManager enemySpaceshipAppearanceManager;
	public List<EnemySpaceshipSprite> enemySpaceshipSprites;
	
	public FieldLogic(int windowWidth, int windowHeight) throws IOException
	{
		this.windowWidht = windowWidth;
		this.windowHeight = windowHeight;
		spaceshipLogic = new SpaceshipLogic(windowWidth, windowHeight);
		enemySpaceshipLogics = new ArrayList<EnemySpaceshipLogic>();
		enemySpaceshipTextures = new EnemySpaceshipTextures();
		enemySpaceshipSprites = new ArrayList<>();
		updateEnemySpaceshipSpritesAndDeleteSuperfluousEnemySpaceships();
		enemySpaceshipAppearanceManager = new EnemySpaceshipAppearanceManager(windowWidth, windowHeight,//
				enemySpaceshipSprites, enemySpaceshipLogics, enemySpaceshipTextures);
	}
	
	public void nextFrame()
	{
		updateEnemySpaceshipSpritesAndDeleteSuperfluousEnemySpaceships();
		try {
			enemySpaceshipAppearanceManager.nextFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void updateEnemySpaceshipSpritesAndDeleteSuperfluousEnemySpaceships()
	{
		enemySpaceshipSprites.clear();
		for(int enemySpaceshipNr = 0; enemySpaceshipNr < enemySpaceshipLogics.size(); ++enemySpaceshipNr)
		{
			if(enemySpaceshipLogics.get(enemySpaceshipNr).getEnemySpaceshipSprite().yPos > windowHeight
			|| enemySpaceshipLogics.get(enemySpaceshipNr).spaceshipExplosion.spaceshipIsExploded == true)
			{
				enemySpaceshipLogics.remove(enemySpaceshipNr);
				--enemySpaceshipNr;
				continue;
			}
			enemySpaceshipSprites.add(enemySpaceshipLogics.get(enemySpaceshipNr).getEnemySpaceshipSprite());
		}
	}
}