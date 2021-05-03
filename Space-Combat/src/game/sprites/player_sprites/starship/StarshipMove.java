package game.sprites.player_sprites.starship;

import game.Direction;
import game.StarshipAction;

public class StarshipMove {
	
	private int winWidth;
	private int winHeight;
	private Starship starship;
	private StarshipAction[] moveDirections;
	private int moveSpeed;
	
	public StarshipMove(Starship starship, int winWidth, int winHeight)
	{
		this.winWidth = winWidth;
		this.winHeight = winHeight;
		this.starship = starship;
		moveDirections = new StarshipAction[4];
		moveDirections[0] = StarshipAction.HANG;
		moveDirections[1] = StarshipAction.HANG;
		moveDirections[2] = StarshipAction.HANG;
		moveDirections[3] = StarshipAction.HANG;
		moveSpeed = 20;
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
	}
	
	public void moveTo(Direction moveDirection, StarshipAction action)
	{
		moveDirections[moveDirection.getDirectionIndex()] = action;
	}
}
