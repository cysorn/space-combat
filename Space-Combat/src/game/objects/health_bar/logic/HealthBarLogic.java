package game.objects.health_bar.logic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.Sprite;
import game.objects.health_bar.HealthBarSprite;
import game.objects.logic.ObjectStats;
import game.objects.logic.ObjectSpawn;

public class HealthBarLogic{

	public ObjectStats objectStats;
	private ObjectSpawn healthBarSpawn;
	private HealthBarMove healthBarMove;
	private HealthBarSprite healthBarSprite;
	private HealthDecrease healthDecrease;
	
	public HealthBarLogic(Sprite object, int health) throws IOException {
		healthBarSprite = new HealthBarSprite(object.xPos, object.yPos);
		this.healthBarMove = new HealthBarMove(healthBarSprite, object);
		objectStats = new ObjectStats(health);
		//4 pixels are black (2 black pixels from each side)
		healthDecrease = new HealthDecrease(healthBarSprite.getSpriteWidth() - 4, objectStats);
	}

	public void nextFrame()
	{
		healthDecrease.nextFrame();
		healthBarMove.nextFrame();
	}
	
	public BufferedImage getSpriteTexture()
	{
		return healthBarSprite.getSpriteTexture();
	}
}
