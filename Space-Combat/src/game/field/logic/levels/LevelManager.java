package game.field.logic.levels;

import java.util.ArrayList;
import java.util.List;

public class LevelManager {
	public List<Level> level;
	private int currentLevelNr;
	
	public LevelManager()
	{
		level = new ArrayList<>();
		level.add(new LevelA());
		level.add(new LevelB());
		currentLevelNr = 0;
	}
	
	public Character getSpaceshipCodeOrContinueTimer()
	{
		if(currentLevelNr > level.size() - 1)
		{
			return null;
		}
		if(level.get(currentLevelNr).levelIsDone() == true)
		{
			++currentLevelNr;
		}
		if(currentLevelNr < level.size())
		{
			return level.get(currentLevelNr).getStarshipTypeOrContinueTimer();
		}
		return null;
	}
}
