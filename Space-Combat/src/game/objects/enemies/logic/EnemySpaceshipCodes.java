package game.objects.enemies.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import game.objects.enemies.enemy_laser.EnemyLaserLogic;

public class EnemySpaceshipCodes {
	public static EnemySpaceshipLogic createAndGetSpaceshipByCode(char code, int initialXPos, int initialYPos, BufferedImage enemySpaceshipTexture, List<EnemyLaserLogic> enemyLaserLogics) throws IOException
	{
		switch(code)
		{
		case 'A': return new EnemySpaceshipALogic(initialXPos, initialYPos, enemySpaceshipTexture, enemyLaserLogics);
		default : return new EnemySpaceshipALogic(initialXPos, initialYPos, enemySpaceshipTexture, enemyLaserLogics);
		}
	}
}
