package game.objects.enemies;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class EnemyStarshipTextures {
	
	public List<BufferedImage> enemyStarshipTextures;
	
	public EnemyStarshipTextures() throws IOException {
		enemyStarshipTextures = new ArrayList<BufferedImage>();
		enemyStarshipTextures.add(ImageIO.read(new File("src/textures/enemies/ship 1.png")));
	}
	
	public BufferedImage getEnemyStarshipTextureByCode(char code)
	{
		switch(code)
		{
		case 'A': return enemyStarshipTextures.get(0);
		default: return enemyStarshipTextures.get(0);
		}
	}
}
