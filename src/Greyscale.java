/**
 * A class to represent the grey-scale color transformation. The grey-scale color transformation
 * gives images a "black and white" appearance by applying a matrix multiplication of constant
 * values to every pixel.
 */
public class Greyscale extends AbstractColorTransform {

  /**
   * Constructs a Greyscale ColorTransform object. Pass this object into the applyColorTransform()
   * method in Image to create a new image with the color transformation applied.
   */
  public Greyscale() {
    super(new float[][]{
            {0.2126f, 0.7152f, 0.0722f},
            {0.2126f, 0.7152f, 0.0722f},
            {0.2126f, 0.7152f, 0.0722f}});
  }
}
