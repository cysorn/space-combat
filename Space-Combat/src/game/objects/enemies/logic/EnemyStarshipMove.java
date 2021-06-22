package game.objects.enemies.logic;

import game.objects.enemies.EnemyStarshipSprite;

public class EnemyStarshipMove {
	private EnemyStarshipSprite enemyStarshipSprite;
	private float moveSpeed;
	
	public EnemyStarshipMove(EnemyStarshipSprite enemyStarshipSprite)
	{
		this.enemyStarshipSprite = enemyStarshipSprite;
		moveSpeed = 3.5f;
	}
	
	public void nextFrame()
	{
		enemyStarshipSprite.yPos += moveSpeed;
	}
}
