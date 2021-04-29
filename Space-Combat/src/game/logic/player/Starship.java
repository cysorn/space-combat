package game.logic.player;

import java.awt.image.BufferedImage;
import java.util.List;

import game.Direction;
import game.StarshipAction;
import game.logic.Entity;
import game.ui.gui.Animation;

public class Starship extends Entity{

	private StarshipAction[] moveDirections;
	private int moveSpeed;
	private int winWidth;
	private int winHeight;
	private int starshipWidth = 80;
	private int starshipHeight = 110;
	private Animation flyingAnimation;
	
//	FIXME find a way to store textures
	public Starship(List<BufferedImage> textures, int winWidth, int winHeight) {
		super(textures, winWidth / 2 - 40, winHeight / 1.4f);
		this.winWidth = winWidth;
		this.winHeight = winHeight;
		moveDirections = new StarshipAction[4];
		moveDirections[0] = StarshipAction.HANG;
		moveDirections[1] = StarshipAction.HANG;
		moveDirections[2] = StarshipAction.HANG;
		moveDirections[3] = StarshipAction.HANG;
		starshipWidth = 80;
		starshipHeight = 110;
		moveSpeed = 20;
		flyingAnimation = new Animation(textures, 0.5f);
	}

	@Override
	public void nextFrame() {
	
		if(moveDirections[Direction.RIGHT.getDirectionIndex()] == StarshipAction.FLY
		&& xPos + starshipWidth + moveSpeed + 20 < winWidth)
		{
			xPos += moveSpeed;
		}
		if(moveDirections[Direction.DOWN.getDirectionIndex()] == StarshipAction.FLY
		&& yPos + starshipHeight+ moveSpeed + 20 < winHeight)
		{
			yPos += moveSpeed;
		}
		if(moveDirections[Direction.LEFT.getDirectionIndex()] == StarshipAction.FLY
		&& xPos - moveSpeed > 0)
		{
			xPos -= moveSpeed;
		}
		if(moveDirections[Direction.UP.getDirectionIndex()] == StarshipAction.FLY
		&& yPos - moveSpeed > 0)
		{
			yPos -= moveSpeed;
		}
		flyingAnimation.nextFrame();
	}
	
	public void moveTo(Direction moveDirection, StarshipAction action)
	{
		moveDirections[moveDirection.getDirectionIndex()] = action;
	}

	private boolean starshipIsHanging()
	{
		if((moveDirections[Direction.RIGHT.getDirectionIndex()] == StarshipAction.HANG
		&& moveDirections[Direction.DOWN.getDirectionIndex()] == StarshipAction.HANG
		&& moveDirections[Direction.LEFT.getDirectionIndex()] == StarshipAction.HANG
		&& moveDirections[Direction.UP.getDirectionIndex()] == StarshipAction.HANG)
		|| (moveDirections[Direction.RIGHT.getDirectionIndex()] == StarshipAction.FLY
			&& moveDirections[Direction.LEFT.getDirectionIndex()] == StarshipAction.FLY)
		|| (moveDirections[Direction.UP.getDirectionIndex()] == StarshipAction.FLY
			&& moveDirections[Direction.DOWN.getDirectionIndex()] == StarshipAction.FLY))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public BufferedImage getStarshipTexture() {
		
		return flyingAnimation.getCurrentFrame();
	}
}