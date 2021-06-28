package game.field.logic.levels;

import java.util.ArrayList;
import java.util.List;

import game.objects.enemies.logic.EnemySpaceshipLogic;

public class LevelManager {
	public List<Level> level;
	private int currentLevelNr;
	private List<EnemySpaceshipLogic> enemySpaceshipLogics;
	
	public LevelManager(List<EnemySpaceshipLogic> enemySpaceshipLogics)
	{
		level = new ArrayList<>();
		level.add(new LevelA());
		level.add(new LevelB());
		currentLevelNr = -1;
		this.enemySpaceshipLogics = enemySpaceshipLogics;
	}
	
	public void updateLevelNr()
	{
		++currentLevelNr;
	}
	
	public Level getCurrentLevelInformation()
	{
		if(level.size() > currentLevelNr)
		{
			return level.get(currentLevelNr);
		}
		else
		{
			return null;
		}
	}
	
	public boolean levelIsDone()
	{
		return enemySpaceshipLogics.size() == 0;
	}
}
