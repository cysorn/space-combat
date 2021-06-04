package game.objects.health_bar.logic;

public class HealthDecrease {
	private int redBarLong;
	private HealthChange healthChange;
	private float greyFillingSpeed;
	private int greyBarDelayBeforeFilling;
	public int currentFramesCountBeforeFill;
	
	public HealthDecrease(HealthChange healthChange) {
		this.healthChange = healthChange;
		redBarLong = 0;
		greyFillingSpeed = 0.4f;
		greyBarDelayBeforeFilling = 0;
		currentFramesCountBeforeFill = 0;
	}
	
	public void nextFrame()
	{
		updateRedBarLong();
		currentFramesCountBeforeFill = 0;
		if(currentFramesCountBeforeFill < greyBarDelayBeforeFilling)
		{
			++currentFramesCountBeforeFill;
		}
		if(healthChange.greyBarLong < redBarLong)
		{
			if(healthChange.greyBarLong + greyFillingSpeed > redBarLong)
			{
				currentFramesCountBeforeFill = 0;
				healthChange.greyBarLong = redBarLong;
			}
			else if(currentFramesCountBeforeFill == greyBarDelayBeforeFilling)
			{
				healthChange.greyBarLong += greyFillingSpeed;
			}
		}
	}
	
	private void updateRedBarLong()
	{
		redBarLong = healthChange.objectStats.maxHealth - healthChange.objectStats.currentHealth;
		//calculate the number of pixels corresponding to the number of HP
//		redBarLong = (hpBarLong / 100f) * ((objectStats.maxHealth - objectStats.currentHealth) / (float) (objectStats.maxHealth / 100f));
	}
	
	public int getRedBarLong()
	{
		return (int) redBarLong;
	}
	
	public boolean paintRedBar()
	{
		return redBarLong > 0;
	}
}
