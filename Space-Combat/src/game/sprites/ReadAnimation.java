package game.sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

public class ReadAnimation {
    
    static public void readAnimation(List<BufferedImage> animationBuffer, File file, int fileWidth, int fileHeight, int picWidth, int picHeight) throws IOException
    {
	    for(int picY = 0; picY < fileHeight; picY += picHeight)
	    {
	    	for(int picX = 0; picX < fileWidth; picX += picWidth)
	    	{
	    		animationBuffer.add(ImageIO.read(file).getSubimage(picX, picY, picWidth, picHeight));
	    	}
	    }
    }
    
    static public void readFlipedAnimation(List<BufferedImage> animationBuffer, File file, int fileWidth, int fileHeight, int picWidth, int picHeight) throws IOException
    {
    	for(int picY = fileHeight - picHeight; picY >= 0; picY -= picHeight)
	    {
	    	for(int picX = 0; picX < fileWidth; picX += picWidth)
	    	{
	    		animationBuffer.add(ImageIO.read(file).getSubimage(picX, picY, picWidth, picHeight));
	    	}
	    }
    }
}