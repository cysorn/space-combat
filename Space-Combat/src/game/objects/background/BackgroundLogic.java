package game.objects.background;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.objects.background.star.logic.StarLogic;

public class BackgroundLogic{
	
	private BackgroundTextures backgroundTextures;
	private int windowWidth;
	private int windowHeight;
	public List<StarLogic> starsLogics = new ArrayList<>();

	public BackgroundLogic(int windowWidth, int windowHeight) throws IOException{
		backgroundTextures = new BackgroundTextures();
		this.windowWidth = windowWidth;
		this.windowHeight = windowHeight;
		createStars();
	}
	
	private void createStars()
	{
		int starsCountByNr[] = {200, 150, 100, 50, 25, 15, 10, 5, 3, 2, 2};
//		int starsCountByTypes[] = {400, 250, 150, 70, 35, 20, 15, 10, 5, 3};
		//(9, 2)!, (11, 6), (11, 9)!, (20, 6), (20, 9)!
		Random[] rand = {
				new Random(20),
				new Random(9)
				};
		for(int textureNr = 0; textureNr < starsCountByNr.length; ++textureNr)
		{
			for(int starsCountToCreate = 0; starsCountToCreate < starsCountByNr[textureNr]; ++starsCountToCreate)
			{
				starsLogics.add(new StarLogic(backgroundTextures.starsTextures.get(textureNr),
					windowWidth,
					windowHeight,
					Math.abs(rand[0].nextInt() % (windowWidth)),
					Math.abs(rand[1].nextInt() % (windowHeight)),
					StarSize.getStarSizeByTextureNr(textureNr)));
			}
		}
	}
	
//	public void nextFrame()
//	{
//		
//	}
}