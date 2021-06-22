package game.objects.logic;

public class ObjectStats {
	
	public int maxHealth;
	private int currentHealth;
	
	public ObjectStats(int maxHealth)
	{
		this.maxHealth = maxHealth;
		setHpToFull();
	}
	
	public void setHpToFull()
	{
		currentHealth = maxHealth;
	}
	
	public boolean objectIsDead()
	{
		return currentHealth <= 0;
	}
	
	public void kill()
	{
		currentHealth = 0;
	}
	
	public void decreaseHealthBy(int val)
	{
		if(currentHealth - val > 0)
		{
			currentHealth -= val;
		}
		else
		{
			currentHealth = 0;
		}
	}
	
	public int getCurrentHealth()
	{
		return currentHealth;
	}
}