import java.io.IOException;

/**
 * An interface to represent an image. An image can be abstracted to a 3D array of integers
 * containing rows, columns, and color depth. For example, color depth can be an array of 3 integers
 * representing the RGB channels.
 */
public interface Image {

  /**
   * Method to get the height of an image.
   *
   * @return Integer, the height of the image in pixels.
   */
  int getHeight();

  /**
   * Method to get the width of an image.
   *
   * @return Integer, the width of the image in pixels.
   */
  int getWidth();

  /**
   * Method to get a deep copy of the 3D array that represents an image. This method is final.
   *
   * @return Integer[][][], 3D array representation of an image.
   */
  int[][][] getPixels();

  /**
   * Method to apply a particular filter to this image. A new image is returned, preserving the
   * original.
   *
   * @param filter Filter object, the filter to apply to this image.
   * @return Image, a new image with the specified filter applied.
   */
  Image filter(Filter filter);

  /**
   * Method to apply a particular color transformation to this image. A new image is returned,
   * preserving the original.
   *
   * @param transform ColorTransform object, the color transformation to apply to this image.
   * @return Image, a new image with the specified color transformation applied.
   */
  Image colorTransform(ColorTransform transform);

  /**
   * Method to generate an image with a particular pattern. This method may be called on any Image
   * object: a new image will be created based on the height and width dimensions of the image it
   * was invoked upon. The original image will always be preserved.
   *
   * @param pattern Pattern object, the pattern to generate.
   * @return Image, an Image with the specified pattern with the specified dimensions.
   */
  Image generatePattern(Pattern pattern);

  /**
   * Method to apply a particular reduction technique to this image. A new image is returned,
   * preserving the original.
   *
   * @param reduction Reduce object, the reduction technique to apply to this image.
   * @return Image, an Image with the specified reduction applied.
   */
  Image reduce(Reduce reduction);

  /**
   * Method to write this image to a file. Uses the image's own height and width.
   *
   * @param fileName name of the new file to be written.
   * @throws IOException When there was a problem writing the image (must have "res" folder).
   */
  void write(String fileName) throws IOException;

  /**
   * Method to create a blurred version of this image.
   *
   * @return Image, a new copy of the original image that has been blurred.
   */
  Image blur();

  /**
   * Method to create a sharpened version of this image.
   *
   * @return Image, a new copy of the original image that has been sharpened.
   */
  Image sharpen();

  /**
   * Method to create a sepia version of this image.
   *
   * @return Image, a new copy of the original image with a sepia tone.
   */
  Image sepia();

  /**
   * Method to create a greyscale version of this image.
   *
   * @return Image, a new copy of the original image in greyscale.
   */
  Image greyscale();

  /**
   * Method to generate a horizontal rainbow. This method uses the dimensions of the image it was
   * invoked upon to set the dimensions of the new image with this pattern.
   *
   * @return Image, the horizontal rainbow pattern with dimensions set by original image.
   */
  Image horizontalRainbow();

  /**
   * Method to generate a vertical rainbow. This method uses the dimensions of the image it was
   * invoked upon to set the dimensions of the new image with this pattern.
   *
   * @return Image, the vertical rainbow pattern with dimensions set by original image.
   */
  Image verticalRainbow();

  /**
   * Method to generate a checkerboard. This method uses the dimensions of the image it was invoked
   * upon to set the dimensions of the new image with this pattern.
   *
   * @param size Integer, the size of the checkerboard squares.
   * @return Image, the checkerboard pattern with dimensions set by original image.
   */
  Image checkerboard(int size);

  /**
   * Method to generate the flag of france. This method uses the dimensions of the image it was
   * invoked upon to set the dimensions of the new image with this pattern. The flag of france must
   * be in a 2:3 ratio - if it is not, the dimensions are reset according to the shorter side.
   *
   * @return Image, the flag of france pattern with dimensions set by original image.
   */
  Image france();

  /**
   * Method to generate the flag of greece. This method uses the dimensions of the image it was
   * invoked upon to set the dimensions of the new image with this pattern. The flag of greece must
   * be in a 2:3 ratio - if it is not, the dimensions are reset according to the shorter side.
   *
   * @return Image, the flag of greece pattern with dimensions set by original image.
   */
  Image greece();

  /**
   * Method to generate the flag of switzerland. This method uses the dimensions of the image it was
   * invoked upon to set the dimensions of the new image with this pattern. The flag of switzerland
   * must be in a 1:1 ratio - if it is not, the dimensions are reset according to the shorter side.
   *
   * @return Image, the flag of switzerland pattern with dimensions set by original image.
   */
  Image switzerland();

  /**
   * Method to create a dithered, black and white version of this image.
   *
   * @return Image, a new copy of the original image dithered in black and white.
   */
  Image dither();

  /**
   * Method to create a mosaic version of this image.
   *
   * @param n number of intended seeds
   * @return Image, a new copy of the original image with mosaic applied.
   */
  Image mosaic(int n) throws IllegalArgumentException;
}

