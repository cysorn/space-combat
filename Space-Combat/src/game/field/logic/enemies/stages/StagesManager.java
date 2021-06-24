package game.field.logic.enemies.stages;

import java.util.ArrayList;
import java.util.List;

public class StagesManager {
	public List<Stage> alienWaves;
	private int currentAllienWaveNr;
	
	public StagesManager()
	{
		alienWaves = new ArrayList<>();
		alienWaves.add(new StageA());
		alienWaves.add(new StageB());
		currentAllienWaveNr = 0;
	}
	
	public Character getStarshipTypeOrContinueTimer()
	{
		if(currentAllienWaveNr > alienWaves.size() - 1)
		{
			return null;
		}
		if(alienWaves.get(currentAllienWaveNr).waveIsGone() == true)
		{
			++currentAllienWaveNr;
		}
		if(currentAllienWaveNr < alienWaves.size())
		{
			return alienWaves.get(currentAllienWaveNr).getStarshipTypeOrContinueTimer();
		}
		return null;
	}
}
