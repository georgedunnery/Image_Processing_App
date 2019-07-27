/**
 * An interface to represent a pattern. Patterns are used to generate an image by following a
 * specific algorithm. Some examples of patterns include a checkerboard and flags.
 */
public interface Pattern {

  /**
   * Method to generate a new 3D int array of the pattern with user specific dimensions.
   *
   * @param pixels pixels of original image
   * @return array corresponding to the new generated pixels
   */
  int[][][] generate(int[][][] pixels);
}
