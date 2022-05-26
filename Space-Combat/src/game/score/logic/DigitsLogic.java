package game.score.logic;

import java.io.IOException;

import game.score.DigitsTextures;

public class DigitsLogic {
	public DigitsTextures digitsTextures;
	
	public DigitsLogic()
	{
		try {
			digitsTextures = new DigitsTextures();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}