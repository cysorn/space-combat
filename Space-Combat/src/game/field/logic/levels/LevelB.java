package game.field.logic.levels;

import java.util.ArrayList;

public class LevelB extends Level{
	public LevelB()
	{
		levelObjectInformation = new ArrayList<>();
		
		for(int i = 0; i < 30; ++i)
		{
			levelObjectInformation.add(new LevelObjectInformation('B', 50));
		}
	}
}