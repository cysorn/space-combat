package game.objects.enemies.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import game.objects.enemies.EnemySpaceshipSprite;
import game.objects.enemies.enemy_laser.EnemyLaserLogic;

public class EnemySpaceshipCodes {
	public static EnemySpaceshipLogic createAndGetSpaceshipByCode(char code, int initialXPos, int initialYPos, BufferedImage enemySpaceshipTexture, List<EnemyLaserLogic> enemyLaserLogics) throws Exception
	{
		switch(code)
		{
		case 'A': return new EnemySpaceshipALogic(initialXPos, initialYPos, enemySpaceshipTexture, enemyLaserLogics);
		case 'B': return new EnemySpaceshipBLogic(initialXPos, initialYPos, enemySpaceshipTexture, enemyLaserLogics);
//		TODO add throw
		default : return new EnemySpaceshipALogic(initialXPos, initialYPos, enemySpaceshipTexture, enemyLaserLogics);
		}
	}
}
