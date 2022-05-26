package game.score.logic;

import java.io.IOException;

import game.Animation;
import game.score.CoinTextures;

public class CoinLogic {
	public CoinTextures coinTextures;
	public Animation coinRotateAnimation;
	
	public CoinLogic()
	{
		try {
			coinTextures = new CoinTextures();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		coinRotateAnimation = new Animation(coinTextures.coins.size(), 1f);
	}
}
