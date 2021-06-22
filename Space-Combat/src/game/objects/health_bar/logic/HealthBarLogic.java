package game.objects.health_bar.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.Sprite;
import game.objects.health_bar.HealthBarSprite;
import game.objects.logic.ObjectSpawn;
import game.objects.logic.ObjectStats;

public class HealthBarLogic{

	public ObjectStats objectStats;
//	TODO create new spawn for the health bar that makes the health bar slightly transparent
//	TODO make that the health bar fades out if the starship receives no damage
//	TODO maybe the health bar should slowly fade out after the starship is exploded
	public ObjectSpawn healthBarSpawn;
	private HealthBarMove healthBarMove;
	public HealthBarSprite healthBarSprite;
	public HealthChange healthChange;
	private boolean spawnAnimationEnabled;
	
	public HealthBarLogic(Sprite object, int health, boolean spawnAnimationEnabled) throws IOException {
		healthBarSprite = new HealthBarSprite(object.xPos, object.yPos);
		healthBarMove = new HealthBarMove(healthBarSprite, object, -10, -10);
		objectStats = new ObjectStats(health);
		healthChange = new HealthChange(healthBarSprite.getSpriteWidth(), objectStats);
		healthBarSpawn = new ObjectSpawn(healthBarSprite, healthBarSprite.xPos, healthBarSprite.yPos);
		this.spawnAnimationEnabled = spawnAnimationEnabled;
		if(spawnAnimationEnabled == false)
		{
			healthBarSprite.currentAlpha = 1f;
		}
	}

	public void nextFrame()
	{
		healthChange.nextFrame();
		healthBarMove.nextFrame();
		if(spawnAnimationEnabled == true)
		{
			healthBarSpawn.nextFrame();
		}
	}
	
	public BufferedImage getSpriteTexture()
	{
		return healthBarSprite.getSpriteTexture();
	}
	
	public void setHpAndBarToFull()
	{
//		objectStats.setHpToFull();
		healthChange.resetBarsAndPlayFullHpAnimation();
	}
}