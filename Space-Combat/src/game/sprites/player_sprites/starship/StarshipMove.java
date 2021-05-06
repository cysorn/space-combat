package game.sprites.player_sprites.starship;

import java.awt.image.BufferedImage;

import game.Animation;
import game.Direction;
import game.StarshipAction;

public class StarshipMove {
	
	private StarshipTextures starshipTextures;
	private StarshipFlyingToASideAnimation starshipFlyingToASideAnimation;
	private Animation flyingForwardAnimation;
	private int winWidth;
	private int winHeight;
	private Starship starship;
	private StarshipAction[] moveDirections;
	private int moveSpeed;
	
	public StarshipMove(Starship starship, StarshipTextures starshipTextures, int winWidth, int winHeight)
	{
		this.starship = starship;
		this.starshipTextures = starshipTextures;
		moveDirections = new StarshipAction[4];
		moveDirections[0] = StarshipAction.HANG;
		moveDirections[1] = StarshipAction.HANG;
		moveDirections[2] = StarshipAction.HANG;
		moveDirections[3] = StarshipAction.HANG;
		starshipFlyingToASideAnimation = new StarshipFlyingToASideAnimation(starshipTextures, moveDirections);
		this.winWidth = winWidth;
		this.winHeight = winHeight;
		moveSpeed = 20;
		flyingForwardAnimation = new Animation(starshipTextures.starshipTextures.size(), 0.5f);
	}
	
	public void nextFrame()
	{
		if(moveDirections[Direction.RIGHT.getDirectionIndex()] == StarshipAction.FLY
		&& starship.xPos + starship.getSpriteWidth() + moveSpeed + 20 < winWidth)
		{
			starship.xPos += moveSpeed;
		}
		if(moveDirections[Direction.DOWN.getDirectionIndex()] == StarshipAction.FLY
		&& starship.yPos + starship.getSpriteHeight() + moveSpeed + 20 < winHeight)
		{
			starship.yPos += moveSpeed;
		}
		if(moveDirections[Direction.LEFT.getDirectionIndex()] == StarshipAction.FLY
		&& starship.xPos - moveSpeed > 0)
		{
			starship.xPos -= moveSpeed;
		}
		if(moveDirections[Direction.UP.getDirectionIndex()] == StarshipAction.FLY
		&& starship.yPos - moveSpeed > 0)
		{
			starship.yPos -= moveSpeed;
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
			return starshipTextures.starshipTextures.get((flyingForwardAnimation.getCurrentFrame()));
		}
	}
}
