package game.field.logic.levels;

import java.util.ArrayList;

public class LevelC extends Level{
	public LevelC()
	{
		levelObjectInformation = new ArrayList<>();
		
		for(int i = 0; i < 30; ++i)
		{
			levelObjectInformation.add(new LevelObjectInformation('A', 200));
			levelObjectInformation.add(new LevelObjectInformation('B', 300));
			levelObjectInformation.add(new LevelObjectInformation('B', 300));
		}
	}
}