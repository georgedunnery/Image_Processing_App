/**
 * A class to represent a vertical rainbow pattern. This pattern generates an image with vertical
 * rainbow stripes.
 */
public class VerticalRainbow implements Pattern {

  /**
   * Constructs a VerticalRainbow object. Takes no parameters. Pass this object to the
   * generatePattern() in Image method to create an image of this pattern with the dimensions of the
   * image it was invoked upon.
   */
  public VerticalRainbow() {
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
    int mod = w % rainbow.length;
    int stripeLength = (w - mod) / rainbow.length;
    int c = 1;
    for (int j = 0; j < w; j++) {
      for (int i = 0; i < h; i++) {
        // Draw the current color
        if (j < stripeLength * c) {
          pixels[i][j] = rainbow[c - 1];
        }
        // Change colors each time the stripe length reached
        else if (c < rainbow.length) {
          c++;
        }
        // Draw the last few pixels when the total length wasn't divisible by 7 evenly
        else if (j >= stripeLength * c) {
          pixels[i][j] = rainbow[c - 1];
        }
      }
    }
    return pixels;
  }
}
