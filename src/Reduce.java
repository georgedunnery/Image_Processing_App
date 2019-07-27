/**
 * An interface to represent a technique of reducing an image to some abstract form. Two examples of
 * reductions are dithering and converting to a mosaic.
 */
public interface Reduce {

  /**
   * Method to reduce an image by using a specified technique.
   *
   * @param pixels 3D Integer array, the pixels that represent an image.
   * @return 3D Integer array, the pixels that represent the new version of the image.
   */
  int[][][] applyReduce(int[][][] pixels);
}
