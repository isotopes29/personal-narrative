import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

  // Instance Variables
  private String[][] variable1;
  private ImageFilter[][] variable2;
  
  // Constructor
  public MyStory(String[][] variable1, ImageFilter[][] variable2) {
    this.variable1 = variable1;
    this.variable2 = variable2;
  }

  // Calls all the parts of your animation, in order
  public void drawScene() {
    drawEntryScene();
    
  drawFirstScene();
  drawSecondScene();
    drawThirdScene();
    clear("white");
    drawImage(variable2[2][0], 0, 0, 400);
    drawText(variable1[2][0], 150, 325);
  }

  public void drawEntryScene() {
    clear("white");

    drawText(variable1[0][0], 150, 325);
    pause(.5);
    drawImage(variable2[0][0], 0, 0, 400);
    drawText(variable1[0][0], 150, 325);
    pause(1.5);
    // start of trnasition
    ImageFilter ya = new ImageFilter("66b3e5d0c2ab246786ca1d5e_86.png");
    ya.threshold(46);
    drawImage(ya, 0, 0, 400);
    pause(.4);
    
  }

 public void drawFirstScene() {
    clear("white");

    drawText(variable1[0][1], 150, 325);
    drawImage(variable2[0][1], 0, 0, 400);
    drawText(variable1[0][1], 150, 325);
    pause(1.5);
ImageFilter ya = new ImageFilter("convert-(1).png");
    ya.applyBlur();
    drawImage(ya, 0, 0, 400);
    pause(.4);
  }

  public void drawSecondScene() {
    clear("white");

    drawText(variable1[1][0], 150, 325);
    drawImage(variable2[1][0], 0, 0, 400);
    drawText(variable1[1][0], 150, 325);
    pause(1.5);
    ImageFilter ya = new ImageFilter("61zIszX-2YL.jpg");
    ya.adjustContrast(2);
    drawImage(ya, 0, 0, 400);
    pause(.4);
  }


  public void drawThirdScene() {
    clear("white");

    drawText(variable1[1][1], 150, 325);
    drawImage(variable2[1][1], 0, 0, 400);
    drawText(variable1[1][1], 150, 325);
    pause(1.5);
    ImageFilter ya = new ImageFilter("reading.jpg");
    ya.mirrorVertical();
    drawImage(ya, 0, 0, 400);
    pause(.4);
  }

  
}
