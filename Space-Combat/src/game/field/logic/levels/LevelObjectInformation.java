package game.field.logic.levels;

public class LevelObjectInformation {
	public char enemySpaceshipCode;
	public int distanceToTheObject;
	
	public LevelObjectInformation(char enemySpaceshipCode, int distanceToTheObject)
	{
		this.enemySpaceshipCode = enemySpaceshipCode;
		this.distanceToTheObject = distanceToTheObject;
	}
}
