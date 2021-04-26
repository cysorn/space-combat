package game.ui.gui;

public class SmartFramesDelay {

	private long nextFrameAt;
	private int minMsDelayAfterFrame;
	private long currentTime;
	
	public SmartFramesDelay() {
		minMsDelayAfterFrame = 16;
		nextFrameAt = 0;
	}
	
    public void smartDelay()
    {
    	currentTime = System.currentTimeMillis();
		if(currentTime <= nextFrameAt)
		{
			try {
				Thread.sleep(nextFrameAt - currentTime);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
		}
		
		nextFrameAt = System.currentTimeMillis() + minMsDelayAfterFrame;
    }
}
