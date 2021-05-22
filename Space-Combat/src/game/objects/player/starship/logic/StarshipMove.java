package game.objects.player.starship.logic;

import java.awt.image.BufferedImage;

import game.Animation;
import game.Direction;
import game.StarshipAction;
import game.objects.player.starship.StarshipSprite;
import game.objects.player.starship.StarshipTextures;

public class StarshipMove {
	
	private StarshipFlyToASideAnimation starshipFlyingToASideAnimation;
	private Animation flyingForwardAnimation;
	private int winWidth;
	private int winHeight;
	private StarshipSprite starshipSprite;
	private StarshipAction[] moveDirections;
	private int moveSpeed;
	
	public StarshipMove(StarshipSprite starshipSprite, int winWidth, int winHeight)
	{
		this.starshipSprite = starshipSprite;
		moveDirections = new StarshipAction[4];
		moveDirections[0] = StarshipAction.HANG;
		moveDirections[1] = StarshipAction.HANG;
		moveDirections[2] = StarshipAction.HANG;
		moveDirections[3] = StarshipAction.HANG;
		starshipFlyingToASideAnimation = new StarshipFlyToASideAnimation(starshipSprite.starshipTextures, moveDirections);
		this.winWidth = winWidth;
		this.winHeight = winHeight;
		moveSpeed = 20;
		flyingForwardAnimation = new Animation(starshipSprite.starshipTextures.starshipTextures.size(), 0.5f);
	}
	
	public void nextFrame()
	{
		if(moveDirections[Direction.RIGHT.getDirectionIndex()] == StarshipAction.FLY
		&& starshipSprite.xPos + starshipSprite.getSpriteWidth() + moveSpeed + 20 < winWidth)
		{
			starshipSprite.xPos += moveSpeed;
		}
		if(moveDirections[Direction.DOWN.getDirectionIndex()] == StarshipAction.FLY
		&& starshipSprite.yPos + starshipSprite.getSpriteHeight() + moveSpeed + 20 < winHeight)
		{
			starshipSprite.yPos += moveSpeed;
		}
		if(moveDirections[Direction.LEFT.getDirectionIndex()] == StarshipAction.FLY
		&& starshipSprite.xPos - moveSpeed > 0)
		{
			starshipSprite.xPos -= moveSpeed;
		}
		if(moveDirections[Direction.UP.getDirectionIndex()] == StarshipAction.FLY
		&& starshipSprite.yPos - moveSpeed > 0)
		{
			starshipSprite.yPos -= moveSpeed;
		}
		starshipFlyingToASideAnimation.nextFrame();
		flyingForwardAnimation.nextFrame();
	}
	
	public void moveTo(Direction moveDirection, StarshipAction action)
	{
		moveDirections[moveDirection.getDirectionIndex()] = action;
	}
	
	public BufferedImage getSpriteTexture()
	{
		BufferedImage temp = starshipFlyingToASideAnimation.getSpriteTexture();
		if(temp != null)
		{
			flyingForwardAnimation.setCurrentFrameToZero();
			return temp;
		}
		else
		{
			return starshipSprite.starshipTextures.starshipTextures.get((flyingForwardAnimation.getCurrentFrame()));
		}
	}
	
	public void resetTexture()
	{
		starshipFlyingToASideAnimation.resetTextureChangeProcess();
		flyingForwardAnimation.setCurrentFrameToZero();
	}
}
