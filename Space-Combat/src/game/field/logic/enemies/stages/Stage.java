package game.field.logic.enemies.stages;

import java.util.List;

public abstract class Stage {
	private int delayBetweenSpawn;
	private int delayBeforeThisStage;
	private int spaceshipTypeNrToSpawn;
	protected List<Character> enemySpaceshipTypes;
	private int delayBetweenSpawnCounter;
	private int delayBeforeThisStageCounter;
	
	protected Stage(int delayBetweenSpawn, int delayBeforeThisStage)
	{
		this.delayBetweenSpawn = delayBetweenSpawn;
		this.delayBeforeThisStage = delayBeforeThisStage;
		spaceshipTypeNrToSpawn = 0;
		delayBetweenSpawnCounter = delayBetweenSpawn;
		delayBeforeThisStageCounter = 0;
	}
	
	public Character getStarshipTypeOrContinueTimer()
	{
		if(delayBeforeThisStageCounter < delayBeforeThisStage)
		{
			++delayBeforeThisStageCounter;
			return null;
		}
		else if(spaceshipTypeNrToSpawn < enemySpaceshipTypes.size())
		{
			if(delayBetweenSpawnCounter == delayBetweenSpawn)
			{
				++spaceshipTypeNrToSpawn;
				delayBetweenSpawnCounter = 0;
				return enemySpaceshipTypes.get(spaceshipTypeNrToSpawn - 1);
			}
			else
			{
				++delayBetweenSpawnCounter;
			}
		}
		return null;
	}
	
	public boolean waveIsGone()
	{
		if(spaceshipTypeNrToSpawn == enemySpaceshipTypes.size())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
