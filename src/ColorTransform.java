/**
 * An interface to represent a color transformation. A color transformation applies a multiplication
 * matrix of constant values to the color channels of each pixel. For example, gray-scale and sepia
 * are color transformations.
 */
public interface ColorTransform {

  /**
   * Method to apply a given color transformation to an image.
   *
   * @param pixels 3D integer array, the pixels of an image to transform.
   * @return 3D integer array, new pixels with adjusted values according to color transformation.
   */
  int[][][] applyColorTransform(int[][][] pixels);
}
