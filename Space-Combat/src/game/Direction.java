package game;

public enum Direction {
	RIGHT(0),
	DOWN(1),
	LEFT(2),
	UP(3);
	
	private final int index;
	
	private Direction(int index)
	{
		this.index = index;
	}
	
	public int getDirectionIndex()
	{
		return index;
	}
}
