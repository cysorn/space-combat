package game.field.logic.enemies.alien_waves;

import java.util.ArrayList;
import java.util.List;

public class AlienWavesManager {
	public List<AlienWave> alienWaves;
	private int currentAllienWaveNr;
	
	public AlienWavesManager()
	{
		alienWaves = new ArrayList<>();
		alienWaves.add(new AlienWaveA());
		currentAllienWaveNr = 0;
	}
	
	public Character getStarshipTypeOrContinueTimer()
	{
		return alienWaves.get(currentAllienWaveNr).getStarshipTypeOrContinueTimer();
	}
}
