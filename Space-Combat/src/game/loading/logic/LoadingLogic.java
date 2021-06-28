package game.loading.logic;

import java.awt.image.BufferedImage;


import game.loading.LoadingSprite;

public class LoadingLogic {
	public LoadingSprite loadingSprite;
	public static int objectsToLoadCount;
	public static int loadedObjectsCounter;
	public static boolean loadingIsFinished;
	
	public LoadingLogic(int windowWidth, int windowHeight)
	{
		loadingSprite = new LoadingSprite(windowWidth / 2 - 150, windowHeight / 2 - 150, 300, 300);
		objectsToLoadCount = 0;
		loadedObjectsCounter = -1;
		loadingIsFinished = false;
	}

	public BufferedImage getLoadingTexture()
	{
		int maxTextureIndex = loadingSprite.loadingTextures.loadingTextures.size() - 1;
		if(objectsToLoadCount <= 0)
		{
			return loadingSprite.loadingTextures.loadingTextures.get(0);
		}
//		return loadingSprite.loadingTextures.loadingTextures.get(objectsToLoadCount);
		try
		{
//			System.out.println((double)loadingSprite.loadingTextures.loadingTextures.size() + " / " + (double)objectsToLoadCount + " * " + ((double)loadedObjectsCounter - 1));
//			System.out.println((int)(((double)loadingSprite.loadingTextures.loadingTextures.size() / (double)objectsToLoadCount) * (double)loadedObjectsCounter) - 1);
//			if((int)((maxTextureIndex / (double)objectsToLoadCount) * (double)loadedObjectsCounter) < 0)
//			{
////				System.out.println((double)loadingSprite.loadingTextures.loadingTextures.size() + " / " + (double)objectsToLoadCount + " * " + ((double)loadedObjectsCounter - 1));
////				System.out.println((int)(((double)loadingSprite.loadingTextures.loadingTextures.size() / (double)objectsToLoadCount) * (double)loadedObjectsCounter));
//				return loadingSprite.loadingTextures.loadingTextures.get(loadingSprite.loadingTextures.loadingTextures.size() - 1);
//			}
//			try
//			{
//				System.out.println((int)((double)(maxTextureIndex / (double)objectsToLoadCount) * (double)loadedObjectsCounter));
//				System.out.println((int)maxTextureIndex + " / " + (double)objectsToLoadCount + " * " + ((double)loadedObjectsCounter));
			
//			TODO this should workd whits loadedObjectsCounter
//			TODO remove - 1
			if(objectsToLoadCount == loadedObjectsCounter)
			{
				return loadingSprite.loadingTextures.loadingTextures.get(maxTextureIndex);
			}
			else
			{
				return loadingSprite.loadingTextures.loadingTextures.get((int)((double)((double)maxTextureIndex / (double)objectsToLoadCount) * (double)loadedObjectsCounter));
			}
			
//			}
//			catch(Exception e)
//			{
//				System.out.println("Exception:");
//				System.out.println((int)((double)(texturesCount / (double)objectsToLoadCount) * (double)loadedObjectsCounter));
//				System.out.println((int)(double)loadingSprite.loadingTextures.loadingTextures.size() + " / " + (double)objectsToLoadCount + " * " + ((double)loadedObjectsCounter));
//			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return loadingSprite.loadingTextures.loadingTextures.get(0);
	}
	
	public int getLoadingTextureNr()
	{
		if(objectsToLoadCount <= 0)
		{
			return 0;
		}
		return (int)(((double)loadingSprite.loadingTextures.loadingTextures.size() / (double)objectsToLoadCount) * (double)loadedObjectsCounter);
	}
	
	public static void startLoading()
	{
		loadedObjectsCounter = 0;
		objectsToLoadCount = 0;
		loadingIsFinished = false;
	}
}