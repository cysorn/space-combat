package game.objects.enemies.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpaceshipIndexes {
	public static EnemySpaceshipLogic createAndGetSpaceshipByCode(char code, int initialXPos, int initialYPos, BufferedImage enemySpaceshipTexture) throws IOException
	{
		switch(code)
		{
		case 'A': return new EnemySpaceshipALogic(initialXPos, initialYPos, enemySpaceshipTexture);
		default : return new EnemySpaceshipALogic(initialXPos, initialYPos, enemySpaceshipTexture);
		}
	}
}
