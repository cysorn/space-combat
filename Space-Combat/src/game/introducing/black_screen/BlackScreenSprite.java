package game.introducing.black_screen;

import java.awt.image.BufferedImage;
import java.io.IOException;

import game.objects.SimpleSprite;

public class BlackScreenSprite extends SimpleSprite{

	private BlackScreenTexture blackScreenTextures;
	public BlackScreenSprite() throws IOException {
		super(0, 0);
		this.blackScreenTextures = new BlackScreenTexture();
	}

	public BufferedImage getSpriteTexture() {

		return blackScreenTextures.blackScreenTexture;
	}
}
