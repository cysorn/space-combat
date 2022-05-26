package game.score;

import java.io.IOException;

import game.objects.Sprite;

public class ScoreSprite extends Sprite{
	BoardTexture scoreTextures;
	
	public ScoreSprite(float xPos, float yPos) {
		super(xPos, yPos, 500, 100);
		try {
			scoreTextures = new BoardTexture();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
