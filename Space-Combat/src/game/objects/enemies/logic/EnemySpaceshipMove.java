package game.objects.enemies.logic;

import game.objects.enemies.EnemySpaceshipSprite;

public class EnemySpaceshipMove {
	private EnemySpaceshipSprite enemySpaceshipSprite;
	public float moveSpeed;
	
	public EnemySpaceshipMove(EnemySpaceshipSprite enemySpaceshipSprite)
	{
		this.enemySpaceshipSprite = enemySpaceshipSprite;
		moveSpeed = 3.5f;
	}
	
	public void nextFrame()
	{
		enemySpaceshipSprite.yPos += moveSpeed;
	}
}
