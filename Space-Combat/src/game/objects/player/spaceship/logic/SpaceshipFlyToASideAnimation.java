package game.objects.player.spaceship.logic;

import java.awt.image.BufferedImage;

import game.Direction;
import game.SpaceshipAction;
import game.objects.player.spaceship.SpaceshipTextures;

public class SpaceshipFlyToASideAnimation {
	private SpaceshipTextures spaceshipTextures;
	private SpaceshipAction[] moveDirections;
	private int currentFrame;
	private Direction currentDirection;
	private int maxFrame;
	public SpaceshipFlyToASideAnimation(SpaceshipTextures spaceshipTextures, SpaceshipAction[] moveDirections) {
		this.moveDirections = moveDirections;
		this.spaceshipTextures = spaceshipTextures;
		currentFrame = 0;
		currentDirection = Direction.UP;
	}
	
	public void nextFrame()
	{
		if(moveDirections[Direction.UP.getDirectionIndex()] == SpaceshipAction.START
		|| moveDirections[Direction.DOWN.getDirectionIndex()] == SpaceshipAction.START)
		{
			maxFrame = 4;
		}
		else
		{
			maxFrame = spaceshipTextures.spaceshipToTheLeftTextures.size() - 1;
		}
		if(moveDirections[Direction.LEFT.getDirectionIndex()] == SpaceshipAction.START
		&& moveDirections[Direction.RIGHT.getDirectionIndex()] == SpaceshipAction.STOP)
		{
			if(currentDirection != Direction.LEFT)
			{
				if(currentFrame > 0)
				{
					--currentFrame;
				}
				if(currentFrame == 0)
				{
					currentDirection = Direction.LEFT;
					++currentFrame;
				}
			}
			else if(currentFrame + 1 <= maxFrame)
			{
				++currentFrame;
			}
			else if(currentFrame > maxFrame)
			{
				--currentFrame;
				currentFrame = 0;
			}
			else
			{
				currentFrame -= 2;
			}
		}
		else if(moveDirections[Direction.RIGHT.getDirectionIndex()] == SpaceshipAction.START
		&& moveDirections[Direction.LEFT.getDirectionIndex()] == SpaceshipAction.STOP)
		{
			if(currentDirection != Direction.RIGHT)
			{
				if(currentFrame > 0)
				{
					--currentFrame;
				}
				if(currentFrame == 0)
				{
					currentDirection = Direction.RIGHT;
					++currentFrame;
				}
			}
			else if(currentFrame + 1 <= maxFrame)
			{
				++currentFrame;
			}
			else if(currentFrame > maxFrame)
			{
				--currentFrame;
			}
			else
			{
				currentFrame -= 2;
			}
		}
		else
		{
			if(currentFrame == 0)
			{
				currentDirection = Direction.UP;
			}
			if(currentFrame > 0)
			{
				--currentFrame;
			}
		}
	}
	
	public BufferedImage getSpriteTexture()
	{
		if(currentDirection == Direction.LEFT)
		{
			return spaceshipTextures.spaceshipToTheLeftTextures.get(currentFrame);
		}
		else if(currentDirection == Direction.RIGHT)
		{
			return spaceshipTextures.spaceshipToTheRightTextures.get(currentFrame);
		}
		else
		{
			return null;
		}
	}
	
    public void resetTextureChangeProcess()
    {
    	currentDirection = Direction.UP;
    	currentFrame = 0;
    }
}
