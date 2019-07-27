/**
 * A class to represent a sharpening filter. The sharpen filter gives images a more defined
 * appearance by applying a kernel to every pixel.
 */
public class Sharpen extends AbstractFilter {

  /**
   * Constructs a sharpen object. Pass this object to the generatePattern() method in Image to
   * create a sharpened version of the image.
   */
  public Sharpen() {
    super(new float[][]{
            {-0.125f, -0.125f, -0.125f, -0.125f, -0.125f},
            {-0.125f, 0.25f, 0.25f, 0.25f, -0.125f},
            {-0.125f, 0.25f, 1f, 0.25f, -0.125f},
            {-0.125f, 0.25f, 0.25f, 0.25f, -0.125f},
            {-0.125f, -0.125f, -0.125f, -0.125f, -0.125f}});
  }
}