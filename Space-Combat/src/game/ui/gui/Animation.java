package game.ui.gui;

import java.awt.image.BufferedImage;
import java.util.List;

public class Animation {
    private float frame;
    private float animationSpeed;
    private List<BufferedImage> animation;
    
    public Animation(List<BufferedImage> animation, float animationSpeed)
    {
    	this.animation = animation;
    	this.animationSpeed = animationSpeed;
    	frame = 0;
    }
    
    public BufferedImage getCurrentFrame()
    {
    	return animation.get((int)frame);
    }
    
    public void nextFrame()
    {
    	if(frame + animationSpeed < animation.size())
        {
        	frame += animationSpeed;
        }
        else
        {
        	frame = 0;
        }
    }
}
