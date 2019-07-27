/**
 * A class to represent the dither technique. Dithering reduces an image to a collection of dots.
 */
public class Dither implements Reduce {

  /**
   * Constructs a dither object. Takes no parameters. This should be passed into the reduce() method
   * in Image.
   */
  public Dither() {
    // Create a dither object
  }

  @Override
  public int[][][] applyReduce(int[][][] source) {
    int height = source.length;
    int width = source[0].length;
    // Convert to greyscale using the existing method
    Image greyscale = new ImageModel(source).greyscale();
    // Use the pixels from the greyscale version!
    int[][][] pixels = greyscale.getPixels();

    // Use the Floyd-Steinberg algorithm to apply the dithering technique
    // For each row of pixels, e.g. "height"
    for (int h = 0; h < pixels.length; h++) {
      // For each column of pixels, e.g. "width"
      for (int w = 0; w < pixels[h].length; w++) {
        // All color channels of a pixel equivalent from greyscale
        // Commit to using the red channel for simplicity and to prepare for an optimization below
        int old_color = pixels[h][w][0];
        // Set to 0 or 1 by rounding, then multiply by 255 to set it to 0 or 255
        int new_color = Math.round(old_color / 255.0f) * 255;
        for (int i = 0; i < 3; i++) {
          pixels[h][w][i] = new_color;
        }
        // IMPORTANT: Dithering operates using the red channel value. Code below was optimized from
        // 12 operations in for loops to just 4 that only set the red channel. Using a different
        // channel above will break this optimization!

        // Modify the neighboring pixels using the error
        int error = old_color - new_color;
        // To the right
        if (w + 1 < width) {
          pixels[h][w + 1][0] = clamp(pixels[h][w + 1][0] += Math.round((7.0f / 16.0f) * error));
        }
        // Next row and to the left
        if (h + 1 < height && w - 1 >= 0) {
          pixels[h + 1][w - 1][0] = clamp(pixels[h + 1][w - 1][0] +=
                  Math.round((3.0f / 16.0f) * error));
        }
        // Below
        if (h + 1 < height) {
          pixels[h + 1][w][0] = clamp(pixels[h + 1][w][0] += Math.round((5.0f / 16.0f) * error));
        }
        // Next row and to the right
        if (h + 1 < height && w + 1 < width) {
          pixels[h + 1][w + 1][0] = clamp(pixels[h + 1][w + 1][0] +=
                  Math.round((1.0f / 16.0f) * error));
        }
      }
    }
    return pixels;
  }

  /**
   * Helper method to clamp the values of the neighbor pixels within bounds.
   *
   * @param value Integer, the value of this color channel.
   * @return Integer, a proper color channel value between 0 and 255.
   */
  private int clamp(int value) {
    if (value > 255) {
      return 255;
    } else if (value < 0) {
      return 0;
    }
    return value;
  }
}
