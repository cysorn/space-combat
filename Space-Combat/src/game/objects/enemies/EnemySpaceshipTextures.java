package game.objects.enemies;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class EnemySpaceshipTextures {
	
	public List<BufferedImage> enemySpaceshipTextures;
	
	public EnemySpaceshipTextures() throws IOException {
		enemySpaceshipTextures = new ArrayList<BufferedImage>();
		enemySpaceshipTextures.add(ImageIO.read(new File("src/textures/enemies/ship 1.png")));
	}
	
	public BufferedImage getEnemySpaceshipTextureByCode(char code)
	{
		switch(code)
		{
		case 'A': return enemySpaceshipTextures.get(0);
		default: return enemySpaceshipTextures.get(0);
		}
	}
}
