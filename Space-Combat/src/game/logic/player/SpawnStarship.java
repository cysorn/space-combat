package game.logic.player;

public class SpawnStarship {
	private int alphaChangeCounter;
	private int alphaChangesCount;
	private float alphaChangeSpeed;
	private Starship starship;
//	FIXME Make stars stop while the spaceship is spawning, fix transparency and add textures "speeding up" textures for the spaceship
	public SpawnStarship(Starship starship)
	{
		this.starship = starship;
		alphaChangeCounter = 0;
		alphaChangesCount = 6;
		alphaChangeSpeed = -0.03f;
		starship.currentAlpha = 0.5f;
	}
	
	public void nextFrame()
	{
		if(alphaChangeCounter == alphaChangesCount)
		{
			return;
		}
		if(starship.currentAlpha + alphaChangeSpeed <= 0.6f
		&& starship.currentAlpha + alphaChangeSpeed >= 0f)
		{
			starship.currentAlpha += alphaChangeSpeed;
		}
		else
		{
			++alphaChangeCounter;
			alphaChangeSpeed *= (-1);
		}
	}
}
