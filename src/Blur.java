/**
 * A class to represent a blurring filter. The blur filter gives images a less defined appearance by
 * applying a kernel to every pixel.
 */
public class Blur extends AbstractFilter {

  /**
   * Constructs a blur object. Pass this object to the generatePattern() method in Image to create a
   * blurred version of the image.
   */
  public Blur() {
    super(new float[][]{
            {0.0625f, 0.125f, 0.0625f},
            {0.125f, 0.25f, 0.125f},
            {0.0625f, 0.125f, 0.0625f}});
  }
}
