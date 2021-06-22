package game.field.logic.enemies.alien_waves;

import java.util.List;

public abstract class AlienWave {
	private int delayBetweenSpawn;
	private int delayBeforeNextWave;
	private int starshipTypeNrToSpawn;
	protected List<Character> enemyStarshipTypes;
	private int delayBetweenSpawnCounter;
	private int delayBeforeNextWaveCounter;
	
	protected AlienWave(int delayBetweenSpawn, int delayBeforeNextWave)
	{
		this.delayBetweenSpawn = delayBetweenSpawn;
		this.delayBeforeNextWave = delayBeforeNextWave;
		starshipTypeNrToSpawn = 0;
		delayBetweenSpawnCounter = delayBetweenSpawn;
		delayBeforeNextWaveCounter = 0;
	}
	
	public Character getStarshipTypeOrContinueTimer()
	{
		if(starshipTypeNrToSpawn < enemyStarshipTypes.size())
		{
			if(delayBetweenSpawnCounter == delayBetweenSpawn)
			{
				++starshipTypeNrToSpawn;
				delayBetweenSpawnCounter = 0;
				return enemyStarshipTypes.get(starshipTypeNrToSpawn - 1);
			}
			else
			{
				++delayBetweenSpawnCounter;
			}
		}
		else if(delayBeforeNextWaveCounter < delayBeforeNextWave)
		{
			++delayBeforeNextWaveCounter;
		}
		return null;
	}
	
	public boolean waveIsGone()
	{
		if(delayBeforeNextWaveCounter == delayBeforeNextWave)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
