package game.sprites.player_sprites.starship;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.ReadAnimation;

public class StarshipExplosionTextures {
	public List<BufferedImage> starshipExplosionTextures;
	public StarshipExplosionTextures() throws IOException {
		starshipExplosionTextures = new ArrayList<>();
		ReadAnimation.readAnimation(starshipExplosionTextures, new File("src/textures/starship/explosion/explosion.png"), 1920, 1440, 1920 / 8, 1440 / 6);
	}
}
