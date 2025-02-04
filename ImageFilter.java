import org.code.theater.*;
import org.code.media.*;

// extends imageplus class
public class ImageFilter extends ImagePlus{

  public ImageFilter(String filename) {
    super(filename);
  }

 
   //threshold
  public void threshold(int value) {
    
    Pixel[][] pixels = getPixelsFromImage();
int placeholder = 0;
    
        for (int row = 0; row < pixels.length; row++) {
          for (int col = 0; col < pixels[0].length; col++) {
              
            Pixel currentPixel = pixels[row][col];


           placeholder = (int)((currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue())/3);

            if (value > placeholder){
              currentPixel.setColor(Color.BLACK);
            } else {
              currentPixel.setColor(Color.WHITE);
            }
  }
}
}
//adjust contrast
public void adjustContrast(int multiplier) {
    Pixel[][] pixels = getPixelsFromImage();
    
for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];

        int currentRed = currentPixel.getRed();
        int currentGreen = currentPixel.getGreen();
        int currentBlue = currentPixel.getBlue();

        int newRed = (int)((multiplier * currentRed));
        int newGreen = (int)((multiplier * currentGreen));
        int newBlue = (int)((multiplier * currentBlue));

        currentPixel.setRed(newRed);
        currentPixel.setGreen(newGreen);
        currentPixel.setBlue(newBlue);
      }
    }
  }
//this is all for gaussian blur
public void applyBlur() {
Pixel[][] pixels = getPixelsFromImage();

    for (int row = 1; row < pixels.length-1; row++) {
      for (int col = 1; col < pixels[0].length-1; col++) {
       
        Pixel currentPixel = pixels[row][col];

        int currentRed = calcWeightedRed(pixels, row, col);
        int currentGreen = calcWeightedGreen(pixels, row, col);
        int currentBlue = calcWeightedBlue(pixels, row, col);


        currentPixel.setRed(currentRed);
        currentPixel.setGreen(currentGreen);
        currentPixel.setBlue(currentBlue);
      }
    }
  }

  /*
   * returns reds of pixels around r and c
   */
  public int calcWeightedRed(Pixel[][] pixels, int row, int col) {
    int avgRed = (pixels[row-1][col-1].getRed() + pixels[row-1][col].getRed() + pixels[row-1][col+1].getRed() +
                  pixels[row][col-1].getRed() + pixels[row][col].getRed() + pixels[row][col+1].getRed() +
                  pixels[row+1][col-1].getRed() + pixels[row+1][col].getRed() + pixels[row+1][col+1].getRed()) / 9;
    return avgRed;
  }

  /*
   * returns weighted green average of the pixels around specified row and col 
   */
  public int calcWeightedGreen(Pixel[][] pixels, int row, int col) {
    int avgGreen = (pixels[row-1][col-1].getGreen() + pixels[row-1][col].getGreen() + pixels[row-1][col+1].getGreen() +
                    pixels[row][col-1].getGreen() + pixels[row][col].getGreen() + pixels[row][col+1].getGreen() +
                    pixels[row+1][col-1].getGreen() + pixels[row+1][col].getGreen() + pixels[row+1][col+1].getGreen()) / 9;
    return avgGreen;
  }

  /*
   * the other two but blue
   */
  public int calcWeightedBlue(Pixel[][] pixels, int row, int col) {
    int avgBlue = (pixels[row-1][col-1].getBlue() + pixels[row-1][col].getBlue() + pixels[row-1][col+1].getBlue() +
                   pixels[row][col-1].getBlue() + pixels[row][col].getBlue() + pixels[row][col+1].getBlue() +
                   pixels[row+1][col-1].getBlue() + pixels[row+1][col].getBlue() + pixels[row+1][col+1].getBlue()) / 9;
    return avgBlue;
  }
//end of gaussian blur

  //mirror so that both sides are the same
    public void mirrorVertical() {
      Pixel[][] pixels = getPixelsFromImage();

      for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length/2; col++) {
        Pixel leftPixel = pixels[row][col];
        Pixel rightPixel = pixels[row][pixels[0].length-col-1];

        leftPixel.setRed(rightPixel.getRed());
        leftPixel.setGreen(rightPixel.getGreen());
        leftPixel.setBlue(rightPixel.getBlue());
      }
    }
    }




  
}
