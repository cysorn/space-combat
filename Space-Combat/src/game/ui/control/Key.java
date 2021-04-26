package game.ui.control;

public enum Key {
	D(68),
	S(83),
	A(65),
	W(87);
	
	private final int keyCode;
	
	Key(int keyCode)
	{
		this.keyCode = keyCode;
	}
	
	public int getKeyCode()
	{
		return keyCode;
	}
}
