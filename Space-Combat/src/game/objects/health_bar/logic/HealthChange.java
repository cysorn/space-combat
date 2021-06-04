package game.objects.health_bar.logic;

import game.objects.logic.ObjectStats;

public class HealthChange {
	
	public int hpBarLong;
	public ObjectStats objectStats;
	public float greyBarLong;
	public HealthDecrease healthDecrease;
	private HealthIncrease healthIncrease;

	
	public HealthChange(int hpBarLong, ObjectStats objectStats)
	{
		this.hpBarLong = hpBarLong;
		this.objectStats = objectStats;
		healthDecrease = new HealthDecrease(this);
		healthIncrease = new HealthIncrease(this);
		greyBarLong = 0;

	}
	
	public void nextFrame()
	{
		healthIncrease.nextFrame();
		healthDecrease.nextFrame();
	}

	
	public int getGreyBarLong()
	{
		return (int) greyBarLong;
	}
	
	public boolean paintGreyBar()
	{
		return greyBarLong > 0;
//		return greyBarLong != redBarLong;
	}

	public void resetBarsAndPlayFullHpAnimation()
	{
		healthDecrease.currentFramesCountBeforeFill = 0;
//		greyBarLong = 0f;
		healthIncrease.setHpToFullAndPlayAnimation();
	}
}
