package game.objects.logic;

public class ObjectStats {
	
	public int maxHealth;
	public int currentHealth;
	
	public ObjectStats(int maxHealth)
	{
		this.maxHealth = maxHealth;
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
}