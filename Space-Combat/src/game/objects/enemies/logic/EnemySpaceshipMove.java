package game.objects.enemies.logic;

import game.objects.enemies.EnemySpaceshipSprite;

public class EnemySpaceshipMove {
	private EnemySpaceshipSprite enemySpaceshipSprite;
	public float moveSpeed;
	final float invisibleMoveSpeed = 3.5f;
	
	public EnemySpaceshipMove(EnemySpaceshipSprite enemySpaceshipSprite, float moveSpeed)
	{
		this.enemySpaceshipSprite = enemySpaceshipSprite;
		this.moveSpeed = moveSpeed;
	}
	
	public void nextFrame()
	{
		if(enemySpaceshipSprite.yPos + enemySpaceshipSprite.getSpriteHeight() < 0)
		{
			enemySpaceshipSprite.yPos += invisibleMoveSpeed;
		}
		else
		{
			enemySpaceshipSprite.yPos += moveSpeed;			
		}
	}
}
