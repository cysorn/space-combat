package game.objects.health_bar.logic;

public class HealthIncrease {
	private HealthChange healthChange;
	public boolean playBarFullHpHealAnimation;
	private float hpHealProFrame;
	private float healthBarHealAnimationSpeed;
	
	public HealthIncrease(HealthChange healthChange) {
		this.healthChange = healthChange;
		healthBarHealAnimationSpeed = 85f;
		hpHealProFrame = healthChange.hpBarLong / healthBarHealAnimationSpeed;
		playBarFullHpHealAnimation = false;
	}
	
	public void nextFrame()
	{
		if(playBarFullHpHealAnimation == true)
		{
			barFullHpHealAnimation();
		}
	}
	
	public void barFullHpHealAnimation()
	{
		if (healthChange.greyBarLong - hpHealProFrame <= 0f)
		{
			healthChange.greyBarLong = 0;
			playBarFullHpHealAnimation = false;
		}
		else
		{
			healthChange.greyBarLong -= hpHealProFrame;
		}
	}
	
	public void setHpToFullAndPlayAnimation()
	{
		healthChange.greyBarLong = healthChange.hpBarLong;
		healthChange.objectStats.setHpToFull();
		playBarFullHpHealAnimation = true;
	}
}