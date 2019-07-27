/**
 * A class to represent the flag of France. This class generates an image of the flag of France.
 */
public class France implements Pattern {

  /**
   * Constructs a France object. Takes no parameters. Pass this object to the generatePattern() in
   * Image method to create an image of this pattern with the dimensions of the image it was invoked
   * upon. This flag expects dimensions in a 2:3 ratio. If the ratio is different, the dimensions
   * will be reset according to the shorter side.
   */
  public France() {
    // Does nothing
  }

  @Override
  public int[][][] generate(int[][][] pixels) {
    // Set the height and width
    int height = pixels.length;
    int width = pixels[0].length;
    // RGB 8-bit colors sourced from wikipedia
    int[][] colors = {{0, 85, 164}, {239, 65, 53}, {255, 255, 255}};
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
    int[][][] flag = new int[height][width][3];
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        // Draw blue stripe
        if (w < width / 3) {
          flag[h][w] = colors[0];
        }
        // Draw white stripe
        else if (w > 2 * (width / 3)) {
          flag[h][w] = colors[1];
        }
        // Draw red stripe
        else {
          flag[h][w] = colors[2];
        }
      }
    }
    return flag;
  }
}
