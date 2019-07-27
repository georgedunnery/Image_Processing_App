/**
 * Abstract class to centralize common methods in filter operations. All filters will apply a kernel
 * about each individual pixel. A kernel is a 2D array of floats (always odd quantity).
 */
public class AbstractFilter implements Filter {
  private float[][] kernel;

  /**
   * Constructs an AbstractFilter object. This object can be initialized on its own. The constructor
   * is designed to take in a kernel so that extending classes simply call super() with the kernel
   * array. Floats are used instead of doubles for compatibility with Math.round() to an integer.
   *
   * @param filterKernel 2D float array, the kernel of the filter operation.
   */
  protected AbstractFilter(float[][] filterKernel) {
    this.kernel = filterKernel;
  }

  @Override
  public int[][][] applyFilter(int[][][] pixels) {
    // For each row of pixels, e.g. "height"
    for (int h = 0; h < pixels.length; h++) {
      // For each column of pixels, e.g. "width"
      for (int w = 0; w < pixels[h].length; w++) {
        // Apply filter to each color channel
        for (int c = 0; c < pixels[h][w].length; c++) {
          // Accumulate the new value for this color channel after filtering
          float filterChannel = 0;
          // Kernel depth: Subtract one for center, divide by two to get net change per side
          // Track the vertical location of the neighboring pixel in relation to this pixel
          int vertical = h - ((this.kernel.length - 1) / 2);
          // Two variables to track the kernel value to apply
          int kRow;
          int kCol;
          // Perform operation for each cell (row, col) of the kernel: top left -> bottom right
          for (kRow = 0; kRow < this.kernel.length; kRow++) {
            // Track the horizontal location of the neighboring pixel in relation to this pixel
            int horizontal = w - ((this.kernel[kRow].length - 1) / 2);
            //System.out.println(horizontal)
            for (kCol = 0; kCol < this.kernel[kRow].length; kCol++) {
              // If the pixel is out of bounds, assume it to be zero by ignoring it
              if ((vertical >= 0 && vertical < pixels.length) &&
                      (horizontal >= 0 && horizontal < pixels[h].length)) {
                // This is the actual calculation performed on the color channel
                filterChannel += this.kernel[kRow][kCol] * pixels[vertical][horizontal][c];
              }
              // Move to the right
              horizontal++;
            }
            // Move down
            vertical++;
          }
          // Apply the new value of the color channel after performing the filter
          pixels[h][w][c] = Math.round(filterChannel);
          // Clamp the value within the bounds of the color channel: 0 to 255
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
