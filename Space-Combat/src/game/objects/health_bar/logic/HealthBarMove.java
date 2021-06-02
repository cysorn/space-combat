package game.objects.health_bar.logic;

import game.objects.Sprite;
import game.objects.health_bar.HealthBarSprite;

public class HealthBarMove {
	
	HealthBarSprite healthBarSprite;
	Sprite object;
	
	public HealthBarMove(HealthBarSprite healthBarSprite, Sprite object) {
		this.healthBarSprite = healthBarSprite;
		this.object = object;
	}
	
	void nextFrame()
	{
		healthBarSprite.xPos = object.xPos;
		healthBarSprite.yPos = object.yPos + 50;
	}
}
