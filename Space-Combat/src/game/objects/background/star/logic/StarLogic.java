package game.objects.background.star.logic;

import java.awt.image.BufferedImage;

import game.objects.background.StarSize;
import game.objects.background.star.StarSprite;

public class StarLogic{
	
	public StarSprite starSprite;
	private StarBlink starBlink;
	private StarPassingBy starPassingBy;


	public StarLogic(BufferedImage texture, int windowWidth, int windowHeight, int xPos, int yPos, StarSize starSize)
	{
		starSprite = new StarSprite(xPos, yPos, texture, starSize);
		starBlink = new StarBlink(starSprite);
		starPassingBy = new StarPassingBy(starSprite, windowWidth, windowHeight);
	}
	
	public void nextFrame()
	{
		starBlink.nextFrame();
		starPassingBy.nextFrame();
	}

}