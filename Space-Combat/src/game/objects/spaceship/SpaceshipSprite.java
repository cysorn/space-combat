package game.objects.spaceship;

import java.io.IOException;

import game.objects.Sprite;

public class SpaceshipSprite extends Sprite{

	public SpaceshipTextures spaceshipTextures;
	public SpaceshipSprite(int winWidth, int winHeight) throws IOException {
		super(winWidth / 2f - 40, winHeight / 1.5f, 80, 110);
		spaceshipTextures = new SpaceshipTextures();
	}
}
