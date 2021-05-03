package game.sprites.background_sprites;

public enum StarSize {
	SMALL_STAR,
	MEDIUM_STAR,
	BIG_STAR,
	LARGE_STAR;
	
	public static StarSize getStarSizeByTextureNr(int textureNr)
	{
		if (textureNr < 3)
		{
			return SMALL_STAR;
		}
		if(textureNr < 7)
		{
			return MEDIUM_STAR;
		}
		if(textureNr < 9)
		{
			return BIG_STAR;
		}
		else
		{
			return LARGE_STAR;
		}
	}
}
