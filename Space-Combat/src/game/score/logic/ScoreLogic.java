package game.score.logic;

import game.score.ScoreSprite;

public class ScoreLogic {
	ScoreSprite scoreSprite;
	DigitsLogic digitsLogic;
	CoinLogic coinLogic;
	
	public ScoreLogic(int winWidth, int winHeight)
	{
		scoreSprite = new ScoreSprite(winHeight, winHeight);
	}
}
