package game.sprites.player_sprites.starship;

import java.awt.image.BufferedImage;

import game.Direction;
import game.StarshipAction;

public class StarshipFlyToASideAnimation {
	private StarshipTextures starshipTextures;
	private StarshipAction[] moveDirections;
	private int currentFrame;
	private Direction currentDirection;
	private int maxFrame;
	public StarshipFlyToASideAnimation(StarshipTextures starshipTextures, StarshipAction[] moveDirections) {
		this.moveDirections = moveDirections;
		this.starshipTextures = starshipTextures;
		currentFrame = 0;
		currentDirection = Direction.UP;
	}
	
	public void nextFrame()
	{
		if(moveDirections[Direction.UP.getDirectionIndex()] == StarshipAction.FLY
		|| moveDirections[Direction.DOWN.getDirectionIndex()] == StarshipAction.FLY)
		{
			maxFrame = 4;
		}
		else
		{
			maxFrame = starshipTextures.starshipToTheLeftTextures.size() - 1;
		}
		if(moveDirections[Direction.LEFT.getDirectionIndex()] == StarshipAction.FLY
		&& moveDirections[Direction.RIGHT.getDirectionIndex()] == StarshipAction.HANG)
		{
			if(currentDirection != Direction.LEFT)
			{
				if(currentFrame > 0)
				{
					--currentFrame;
				}
				else if(currentFrame == 0)
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
			}
			else
			{
				currentFrame -= 2;
			}
		}
		else if(moveDirections[Direction.RIGHT.getDirectionIndex()] == StarshipAction.FLY
		&& moveDirections[Direction.LEFT.getDirectionIndex()] == StarshipAction.HANG)
		{
			if(currentDirection != Direction.RIGHT)
			{
				if(currentFrame > 0)
				{
					--currentFrame;
				}
				else if(currentFrame == 0)
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
			return starshipTextures.starshipToTheLeftTextures.get(currentFrame);
		}
		else if(currentDirection == Direction.RIGHT)
		{
			return starshipTextures.starshipToTheRightTextures.get(currentFrame);
		}
		else
		{
			return null;
		}
	}
	
    public void resetTextureEditProcess()
    {
    	currentDirection = Direction.UP;
    	currentFrame = 0;
    }
}
