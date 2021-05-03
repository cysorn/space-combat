package game.sprites.player_sprites.starship;

import java.awt.image.BufferedImage;
import java.util.List;

import game.Animation;
import game.sprites.SimpleSprite;
import game.sprites.Sprite;

public class Starship extends Sprite{

	private Animation flyingAnimation;
	private Spawn spawnStarship;
	public StarshipMove starshipMove;
	
//	FIXME find a way to store textures
	public Starship(List<BufferedImage> textures, int winWidth, int winHeight) {
		super(textures, winWidth / 2 - 40, winHeight / 2f, 80, 110);
		starshipMove = new StarshipMove(this, winWidth, winHeight);
		flyingAnimation = new Animation(textures.size(), 0.5f);
		spawnStarship = new Spawn(this);
	}

	@Override
	public void nextFrame() {
	
		starshipMove.nextFrame();
		flyingAnimation.nextFrame();
		spawnStarship.nextFrame();
	}
	
	@Override
	public BufferedImage getSpriteTexture() {
		
		return textures.get(flyingAnimation.getCurrentFrame());
	}
}