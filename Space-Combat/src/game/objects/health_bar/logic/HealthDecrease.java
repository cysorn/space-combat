package game.objects.health_bar.logic;

import game.objects.logic.ObjectStats;

public class HealthDecrease {
	
	private int hpBarLong;
	private ObjectStats objectStats;
	private float redBarLong;
	private float greyBarLong;
	private float greyFillingSpeed;
	private int greyBarDelayBeforeFilling;
	private int currentFramesCountBeforeFill;
	
	public HealthDecrease(int hpBarLong, ObjectStats objectStats)
	{
		this.hpBarLong = hpBarLong;
		this.objectStats = objectStats;
		redBarLong = 0;
		greyBarLong = 0;
		greyFillingSpeed = 0.02f;
		greyBarDelayBeforeFilling = 120;
		currentFramesCountBeforeFill = 0;
	}
	
	public void nextFrame()
	{
		if(currentFramesCountBeforeFill < greyBarDelayBeforeFilling)
		{
			++currentFramesCountBeforeFill;
		}
		if(greyBarLong < redBarLong)
		{
			if(greyBarLong + greyFillingSpeed < redBarLong)
			{
				currentFramesCountBeforeFill = 0;
				greyBarLong = redBarLong;
			}
			else
			{
				greyBarLong += greyFillingSpeed;
			}
		}
	}
	
	public void updateRedBarLong()
	{
		//calculate the number of pixels corresponding to the number of HP
		redBarLong = hpBarLong / 100 * (objectStats.currentHealth / (objectStats.maxHealth / 100));
	}
	
	public int getRedBarLong()
	{
		return (int) redBarLong;
	}
	
	public int getGreyBarLong()
	{
		return (int) greyBarLong;
	}
}
