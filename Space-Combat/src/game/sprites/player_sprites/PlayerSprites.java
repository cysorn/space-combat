package game.sprites.player_sprites;

import java.io.IOException;

import game.sprites.player_sprites.starship.Starship;

public class PlayerSprites extends PlayerTextures{

	public Starship starship;
	
	public PlayerSprites(int windowWidth, int windowHeight) throws IOException {
		super();
		starship = new Starship(starshipTextures, windowWidth, windowHeight);
	}
}