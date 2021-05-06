package game.sprites.player_sprites;

import java.io.IOException;

import game.sprites.player_sprites.starship.Starship;

public class PlayerSprites{

	public Starship starship;
	
	public PlayerSprites(int windowWidth, int windowHeight) throws IOException {
		starship = new Starship(windowWidth, windowHeight);
	}
}