package game.objects.spaceship.logic;

import java.awt.image.BufferedImage;

import game.Animation;
import game.Direction;
import game.SpaceshipAction;
import game.objects.spaceship.SpaceshipSprite;
import game.objects.spaceship.SpaceshipTextures;

public class SpaceshipMove {
	
	private SpaceshipFlyToASideAnimation spaceshipFlyingToASideAnimation;
	private Animation flyingForwardAnimation;
	private int winWidth;
	private int winHeight;
	private SpaceshipSprite spaceshipSprite;
	private SpaceshipAction[] moveDirections;
	private int moveSpeed;
	
	public SpaceshipMove(SpaceshipSprite starshipSprite, int winWidth, int winHeight)
	{
		this.spaceshipSprite = starshipSprite;
		moveDirections = new SpaceshipAction[4];
		moveDirections[0] = SpaceshipAction.STOP;
		moveDirections[1] = SpaceshipAction.STOP;
		moveDirections[2] = SpaceshipAction.STOP;
		moveDirections[3] = SpaceshipAction.STOP;
		spaceshipFlyingToASideAnimation = new SpaceshipFlyToASideAnimation(starshipSprite.spaceshipTextures, moveDirections);
		this.winWidth = winWidth;
		this.winHeight = winHeight;
		moveSpeed = 20;
		flyingForwardAnimation = new Animation(starshipSprite.spaceshipTextures.spaceshipTextures.size(), 0.5f);
	}
	
	public void nextFrame()
	{
		if(moveDirections[Direction.RIGHT.getDirectionIndex()] == SpaceshipAction.START
		^ moveDirections[Direction.LEFT.getDirectionIndex()] == SpaceshipAction.START)
		{
			if(moveDirections[Direction.RIGHT.getDirectionIndex()] == SpaceshipAction.START
			&& spaceshipSprite.xPos + spaceshipSprite.getSpriteWidth() + moveSpeed + 20 < winWidth)
			{
				spaceshipSprite.xPos += moveSpeed;
			}
			if(moveDirections[Direction.LEFT.getDirectionIndex()] == SpaceshipAction.START
			&& spaceshipSprite.xPos - moveSpeed > 0)
			{
				spaceshipSprite.xPos -= moveSpeed;
			}
		}
		if(moveDirections[Direction.UP.getDirectionIndex()] == SpaceshipAction.START
		^ moveDirections[Direction.DOWN.getDirectionIndex()] == SpaceshipAction.START)
		{
			if(moveDirections[Direction.DOWN.getDirectionIndex()] == SpaceshipAction.START
			&& spaceshipSprite.yPos + spaceshipSprite.getSpriteHeight() + moveSpeed + 20 < winHeight)
			{
				spaceshipSprite.yPos += moveSpeed;
			}
			if(moveDirections[Direction.UP.getDirectionIndex()] == SpaceshipAction.START
			&& spaceshipSprite.yPos - moveSpeed > 0)
			{
				spaceshipSprite.yPos -= moveSpeed;
			}
		}
		spaceshipFlyingToASideAnimation.nextFrame();
		flyingForwardAnimation.nextFrame();
	}
	
	public void moveTo(Direction moveDirection, SpaceshipAction action)
	{
		moveDirections[moveDirection.getDirectionIndex()] = action;
	}
	
	public BufferedImage getSpriteTexture()
	{
		BufferedImage temp = spaceshipFlyingToASideAnimation.getSpriteTexture();
		if(temp != null)
		{
			flyingForwardAnimation.setCurrentFrameToZero();
			return temp;
		}
		else
		{
			return spaceshipSprite.spaceshipTextures.spaceshipTextures.get((flyingForwardAnimation.getCurrentFrame()));
		}
	}
	
	public void resetTexture()
	{
		spaceshipFlyingToASideAnimation.resetTextureChangeProcess();
		flyingForwardAnimation.setCurrentFrameToZero();
	}
}
