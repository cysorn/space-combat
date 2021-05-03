package game;

public class Animation {
    private float frame;
    private float animationSpeed;
    private int framesCount;
    
    public Animation(int framesCount, float animationSpeed)
    {
    	this.animationSpeed = animationSpeed;
    	this.framesCount = framesCount;
    	frame = 0;
    }
    
    public int getCurrentFrame()
    {
    	return (int)frame;
    }
    
    public void nextFrame()
    {
    	if(frame + animationSpeed < framesCount)
        {
        	frame += animationSpeed;
        }
        else
        {
        	frame = 0;
        }
    }
}
