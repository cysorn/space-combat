package game.ui.gui;

public class SmartFramesDelay {

	static private long nextFrameAt = 0;
	static private int minMsDelayAfterFrame = 20;
	static private long currentTime;
	
	static public void smartDelay()
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
