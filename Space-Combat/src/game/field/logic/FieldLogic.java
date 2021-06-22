package game.field.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.field.logic.enemies.appearance.EnemyStarshipAppearanceManager;
import game.objects.enemies.EnemyStarshipSprite;
import game.objects.enemies.EnemyStarshipTextures;
import game.objects.enemies.logic.EnemyStarshipLogic;
import game.objects.player.starship.logic.StarshipLogic;

//	TODO delete unused logics and sprites
public class FieldLogic {
	public int windowWidht;
	public int windowHeight;
	public StarshipLogic starshipLogic;
	public List<EnemyStarshipLogic> enemyStarshipLogics;
	public EnemyStarshipTextures enemyStarshipTextures;
	private EnemyStarshipAppearanceManager enemyStarshipAppearanceManager;
	private List<EnemyStarshipSprite> enemyStarshipSprites;
	
	public FieldLogic(int windowWidth, int windowHeight) throws IOException
	{
		this.windowWidht = windowWidth;
		this.windowHeight = windowHeight;
		starshipLogic = new StarshipLogic(windowWidth, windowHeight);
		enemyStarshipLogics = new ArrayList<EnemyStarshipLogic>();
		enemyStarshipTextures = new EnemyStarshipTextures();
		enemyStarshipSprites = new ArrayList<>();
		updateEnemyStarhsipSpritesAndDeleteSuperfluousEnemyStarships();
//		enemyStarshipLogics.add(new EnemyStarshipLogic(enemyStarshipAppearance.getInitialXPos(), enemyStarshipAppearance.getInitialYPos()));
		enemyStarshipAppearanceManager = new EnemyStarshipAppearanceManager(windowWidth, windowHeight,//
				enemyStarshipSprites, enemyStarshipLogics, enemyStarshipTextures);
	}
	
	public void nextFrame()
	{
		updateEnemyStarhsipSpritesAndDeleteSuperfluousEnemyStarships();
		try {
			enemyStarshipAppearanceManager.nextFrame();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void updateEnemyStarhsipSpritesAndDeleteSuperfluousEnemyStarships()
	{
		enemyStarshipSprites.clear();
		for(int enemyStarshipNr = 0; enemyStarshipNr < enemyStarshipLogics.size(); ++enemyStarshipNr)
		{
			if(enemyStarshipLogics.get(enemyStarshipNr).getEnemyStarshipSprite().yPos > windowHeight
			|| enemyStarshipLogics.get(enemyStarshipNr).starshipExplosion.starshipIsExploded == true)
			{
				enemyStarshipLogics.remove(enemyStarshipNr);
				--enemyStarshipNr;
				continue;
			}
			enemyStarshipSprites.add(enemyStarshipLogics.get(enemyStarshipNr).getEnemyStarshipSprite());
		}
	}
}