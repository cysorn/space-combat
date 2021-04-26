package game.logic.background.star;

import java.awt.image.BufferedImage;

import game.logic.Entity;

public class Star extends Entity{
	
	private Blink b;
	private int windowWidth;
	private int windowHeight;
	private int starSize;
	private int rnd;

	public Star(BufferedImage texture, int windowWidth, int windowHeight, int xPos, int yPos)
	{
		super(texture, xPos, yPos);
		b = new Blink(this);
		rnd = (int) (Math.random() * 2) + 1;
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
	}
	
	@Override
	public void nextFrame()
	{
		b.blinking();
		if(yPos + rnd < windowHeight)
		{
			yPos += rnd;
		}
		else
		{
			rnd = (int) (Math.random() * 2) + 1;
			yPos = 0;
		}
	}
	
	@Override
	public BufferedImage getTexture()
	{
		return textures.get(0);
	}
}