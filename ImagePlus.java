import org.code.theater.*;
import org.code.media.*;

// image that can be modified with filters
public class ImagePlus extends Image{

  private Pixel[][] pixels;    //array name

// sets superclass filename to filename, calls getPixelsFromImage to "make it"
  public ImagePlus(String filename) {
    super(filename);   

// initialized pixels array. gets evreything started...
    pixels = getPixelsFromImage();
  }

// returns pixels
  public Pixel[][] getImagePixels() {
    return pixels;
  }

// also returns pixels but as better more malleable pixels or.  something
  public Pixel[][] getPixelsFromImage() {
    
    Pixel[][] tempPixels = new Pixel[getHeight()][getWidth()];
    
    for (int row = 0; row < tempPixels.length; row++) {
      for (int col = 0; col < tempPixels[0].length; col++) {
        
        tempPixels[row][col] = getPixel(col, row);
        
      }
    }

    return tempPixels;
  }



  
}
