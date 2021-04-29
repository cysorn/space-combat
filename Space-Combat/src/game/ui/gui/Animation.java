package game.ui.gui;

import java.awt.image.BufferedImage;
import java.util.List;

public class Animation {
    private float frame;
    private float animationSpeed;
    private List<BufferedImage> animation;
    
    public Animation(List<BufferedImage> animation)
    {
    	this.animation = animation;
    }
    
    public int getCurrentFrame()
    {
    	return (int)frame;
    }
    
    public void nextFrame()
    {
    	if(frame + 1 < animation.size())
        {
        	frame += animationSpeed;
        }
        else
        {
        	frame = 0;
        }
    }
}
