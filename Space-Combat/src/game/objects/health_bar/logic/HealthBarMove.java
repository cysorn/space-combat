package game.objects.health_bar.logic;

import game.objects.Sprite;
import game.objects.health_bar.HealthBarSprite;

public class HealthBarMove {
	
	public HealthBarSprite healthBarSprite;
	private Sprite object;
	public int distanceFromObjectX;
	public int distanceFromObjectY;
	
	public HealthBarMove(HealthBarSprite healthBarSprite, Sprite object, int distanceFromObjectX, int distanceFromObjectY) {
		this.healthBarSprite = healthBarSprite;
		this.object = object;
		this.distanceFromObjectX = distanceFromObjectX;
		this.distanceFromObjectY = distanceFromObjectY;
		nextFrame();
	}
	
	public void nextFrame()
	{
		healthBarSprite.xPos = object.xPos + distanceFromObjectX;
		healthBarSprite.yPos = object.yPos + distanceFromObjectY;
	}
}
