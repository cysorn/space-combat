package game.logic.player;

import java.io.IOException;

public class Player extends StarshipTextures{

	public Starship starship;
	
	public Player(int windowWidth, int windowHeight) throws IOException {
		super();
		starship = new Starship(starshipTextures, starshipEngineTextures, windowWidth, windowHeight);
	}
}