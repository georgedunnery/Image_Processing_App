/**
 * An interface to represent a filter. A filter object applies a kernel to each pixel of an image to
 * create a particular effect. For example, blurring and sharpening an image are types of filters.
 */
public interface Filter {

  /**
   * Method to apply this filter's kernel to the image.
   *
   * @param pixels 3D integer array, representing the pixels of an image.
   * @return 3D integer array, new pixels with values changed according to the filter.
   */
  int[][][] applyFilter(int[][][] pixels);
}
