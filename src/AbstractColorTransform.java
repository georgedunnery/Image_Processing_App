/**
 * Abstract class to centralize common methods in color transformation operations. All color
 * transformations will have a matrix and apply the matrix to each color channel of each pixel.
 */
public class AbstractColorTransform implements ColorTransform {
  private float[][] matrix;

  /**
   * Constructs an abstract color transformation. This object can be initialized on its own. The
   * constructor is designed to take in a multiplication matrix so that extending classes simply
   * call super(matrix). Floats are used instead of doubles for compatibility with the Math.round
   * function.
   *
   * @param colorMatrix 2D float array, multiplication matrix corresponding to a color transform.
   */
  protected AbstractColorTransform(float[][] colorMatrix) {
    this.matrix = colorMatrix;
  }

  @Override
  public int[][][] applyColorTransform(int[][][] pixels) {
    // For each row of pixels, e.g. "height"
    for (int h = 0; h < pixels.length; h++) {
      // For each column of pixels, e.g. "width"
      for (int w = 0; w < pixels[h].length; w++) {
        // Save constants for each color channel in this pixel
        int red = pixels[h][w][0];
        int green = pixels[h][w][1];
        int blue = pixels[h][w][2];
        // Perform the transformation on each color channel.
        for (int c = 0; c < pixels[h][w].length; c++) {
          pixels[h][w][c] = Math.round((this.matrix[c][0] * red) +
                  (this.matrix[c][1] * green) +
                  (this.matrix[c][2] * blue));
          // Clamp each pixel within the bounds of the color channel
          if (pixels[h][w][c] > 255) {
            pixels[h][w][c] = 255;
          } else if (pixels[h][w][c] < 0) {
            pixels[h][w][c] = 0;
          }
        }
      }
    }
    return pixels;
  }
}
