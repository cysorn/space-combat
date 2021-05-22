package game.objects.player.starship;

import java.io.IOException;

import game.objects.Sprite;

public class StarshipSprite extends Sprite{

	public StarshipTextures starshipTextures;
	public StarshipSprite(int winWidth, int winHeight) throws IOException {
		super(winWidth / 2 - 40, winHeight / 2f, 80, 110);
		starshipTextures = new StarshipTextures();
	}
}
