import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {

    
     // 2D Array
    String[][] array1 = {
      {"things i like", "hockey"},
      {"guitar", "reading"},
      {"thanks for watching"}
    };

    ImageFilter[][] array2 = {
      { new ImageFilter("66b3e5d0c2ab246786ca1d5e_86.png"), new ImageFilter("convert-(1).png") },
      { new ImageFilter("61zIszX-2YL.jpg"), new ImageFilter("reading.jpg") },
      { new ImageFilter("images.jpg")},
    };
    
// creates new scene from theater
MyStory images = new MyStory(array1, array2);

//SpecialImage placeholder = new SpecialImage("66b3e5d0c2ab246786ca1d5e_86.png");

    
 // call drawImage
    images.drawScene();
    
    // play scene
    Theater.playScenes(images);
   // SpecialImage fish = new SpecialImage("images.jpg");

    
    
  }
}
