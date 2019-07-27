/**
 * A class to represent the sepia color transformation. The grey-scale color transformation gives
 * images a sepia tone by applying a matrix multiplication of constant values to every pixel.
 */
public class Sepia extends AbstractColorTransform {

  /**
   * Constructs a Sepia ColorTransform object. Pass this object into the applyColorTransform()
   * method in Image to create a new image with the color transformation applied.
   */
  public Sepia() {
    super(new float[][]{
            {0.393f, 0.769f, 0.189f},
            {0.349f, 0.686f, 0.168f},
            {0.272f, 0.534f, 0.131f}});
  }
}
