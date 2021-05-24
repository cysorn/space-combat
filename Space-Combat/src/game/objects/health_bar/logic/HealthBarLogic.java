package game.objects.health_bar.logic;

import java.io.IOException;

import game.objects.ObjectStats;
import game.objects.health_bar.HealthBarSprite;

public class HealthBarLogic{

	ObjectStats objectStats;
	HealthBarSprite healthBarSprite;
	HealthDecrease healthDecrease;
	
	protected HealthBarLogic(float xPos, float yPos, int health) throws IOException {
		healthBarSprite = new HealthBarSprite(xPos, yPos);
		objectStats = new ObjectStats(health);
		healthDecrease = new HealthDecrease();
	}

	void nextFrame()
	{
		
	}
}
