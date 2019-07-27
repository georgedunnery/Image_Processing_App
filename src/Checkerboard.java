/**
 * A class to represent a checkerboard pattern. This class generates an image with a checkerboard
 * pattern with squares of a specified size.
 */
public class Checkerboard implements Pattern {
  private int size;

  /**
   * Constructs a checkerboard object. Pass this object to the generatePattern() in Image method to
   * create an image of this pattern with the dimensions of the image it was invoked upon. Requires
   * a checker size.
   *
   * @param squareEdge Integer, the size of the checkerboard squares.
   * @throws IllegalArgumentException When the square edge is less than 1.
   */
  public Checkerboard(int squareEdge) throws IllegalArgumentException {
    if (squareEdge < 1) {
      throw new IllegalArgumentException("Invalid size: Square edge must be at least 1.");
    }
    this.size = squareEdge;
  }

  @Override
  public int[][][] generate(int[][][] pixels) {
    // Set the dimensions of the checkerboard
    int height = pixels.length;
    int width = pixels[0].length;
    int[][] colors = {{0, 0, 0}, {255, 255, 255}};
    int choice = 0;
    // Draw black and white squares
    for (int h = 0; h < height; h++) {
      if (h % this.size == 0) {
        choice = (choice + 1) % 2;
      }
      for (int w = 0; w < width; w++) {
        if (w % this.size == 0) {
          choice = (choice + 1) % 2;
        }
        pixels[h][w] = colors[choice];
      }
    }
    return pixels;
  }
}
