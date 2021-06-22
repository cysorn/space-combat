package game.objects.enemies.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class StarshipIndexes {
	public static EnemyStarshipLogic createAndGetStarshipByCode(char code, int initialXPos, int initialYPos, BufferedImage enemyStarshipTexture) throws IOException
	{
		switch(code)
		{
		case 'A': return new EnemyStarshipALogic(initialXPos, initialYPos, enemyStarshipTexture);
		default : return new EnemyStarshipALogic(initialXPos, initialYPos, enemyStarshipTexture);
		}
	}
}
