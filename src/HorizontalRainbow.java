/**
 * A class to represent a horizontal rainbow pattern. This pattern generates an image with
 * horizontal rainbow stripes.
 */
public class HorizontalRainbow implements Pattern {

  /**
   * Constructs a HorizontalRainbow object. Takes no parameters. Pass this object to the
   * generatePattern() in Image method to create an image of this pattern with the dimensions of the
   * image it was invoked upon.
   */
  public HorizontalRainbow() {
    // Empty Constructor
  }

  /**
   * Method to get the colors of the rainbow.
   *
   * @return 2D Integer array, containing RBG 8-bit rainbow colors.
   */
  private static int[][] getRainbow() {
    int[][] colors = {{255, 0, 0}, {255, 127, 0}, {255, 255, 0}, {0, 255, 0},
                      {0, 0, 255}, {75, 0, 130}, {148, 0, 211}};
    return colors;
  }

  @Override
  public int[][][] generate(int[][][] pixels) {
    int h = pixels.length;
    int w = pixels[0].length;
    int[][] rainbow = getRainbow();
    int mod = h % rainbow.length;
    int stripeLength = (h - mod) / rainbow.length;
    int c = 1;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        // Draw the current color
        if (i < stripeLength * c) {
          pixels[i][j] = rainbow[c - 1];
        }
        // Change colors each time the stripe length reached
        else if (c < rainbow.length) {
          c++;
        }
        // Draw the last few pixels when the total length wasn't divisible by 7 evenly
        else if (i >= stripeLength * c) {
          pixels[i][j] = rainbow[c - 1];
        }
      }
    }
    return pixels;
  }
}
