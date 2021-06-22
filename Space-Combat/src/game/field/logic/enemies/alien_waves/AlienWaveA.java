package game.field.logic.enemies.alien_waves;

import java.util.ArrayList;

public class AlienWaveA extends AlienWave{
	@SuppressWarnings("serial")
	public AlienWaveA()
	{
		super(300, 300);
		enemyStarshipTypes = new ArrayList<>(){{
			add('A');
			add('A');
			add('A');
			add('A');
			add('A');
			add('A');
			add('A');
			add('A');
		}};
	}
}
