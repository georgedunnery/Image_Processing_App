/**
 * A class to represent the flag of Greece. This class generates an image of the flag of Greece.
 */
public class Greece implements Pattern {

  /**
   * Constructs a Greece object. Takes no parameters. Pass this object to the generatePattern() in
   * Image method to create an image of this pattern with the dimensions of the image it was invoked
   * upon.
   */
  public Greece() {
    // Does nothing
  }

  @Override
  public int[][][] generate(int[][][] pixels) {
    int height = pixels.length;
    int width = pixels[0].length;
    int[][] colors = {{255, 255, 255}, {0, 0, 255}};
    // Set proportions when the ratio is not 2:3 (according to shorter side)
    if (height / 2 != width / 3) {
      if (height <= width) {
        // Keep height the same
        width = 3 * (height / 2);
      } else {
        // Keep width the same
        height = 2 * (width / 3);
      }
    }
    // Flag has 9 alternating stripes, and canton proportions will reference stripe thickness
    int countStripes = 0;
    int stripe = height / 9;
    int[][][] flag = new int[height][width][3];
    // Draw the horizontal blue and white stripes to the background
    int choice = 0;
    for (int h = 0; h < height; h++) {
      if (h % stripe == 0 && countStripes < 9) {
        choice = (choice + 1) % 2;
        countStripes++;
      }
      for (int w = 0; w < width; w++) {
        flag[h][w] = colors[choice];
      }
    }
    // Draw a blue box in the top left corner, proportions according to stripe thickness
    int canton = stripe * 5;
    for (int h = 0; h < canton; h++) {
      for (int w = 0; w < canton; w++) {
        flag[h][w] = colors[1];
      }
    }
    // Draw vertical white rectangle
    for (int h = 0; h < canton; h++) {
      for (int w = stripe * 2; w < stripe * 3; w++) {
        flag[h][w] = colors[0];
      }
    }
    // Draw horizontal white rectangle
    for (int h = stripe * 2; h < stripe * 3; h++) {
      for (int w = 0; w < canton; w++) {
        flag[h][w] = colors[0];
      }
    }
    return flag;
  }
}
