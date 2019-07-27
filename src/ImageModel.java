import java.io.IOException;

/**
 * Class to represent an Image. This image has a 3D array with 3 8-bit color channels. The each
 * channel (R,G,B) can have a value between 0 and 255.
 */
public class ImageModel implements Image {

  private int[][][] pixels;
  private int height;
  private int width;

  /**
   * Constructs an image from a file. Place the file in the "res" folder of the project - filepath
   * is automatically so files can be referred to by name.
   *
   * @param fileName String, name of the file.
   * @throws IOException When the file is not found (verify file is in the correct directory).
   */
  public ImageModel(String fileName) throws IOException {
    // Take in an image file
    // Convert to array, set as this.pixels
    this.pixels = ImageUtil.readImage(fileName);
    this.height = ImageUtil.getHeight(fileName);
    this.width = ImageUtil.getWidth(fileName);

  }

  /**
   * Constructs an image with the dimensions 600 x 400. Note that none of the color channels are set
   * by this operation.
   */
  public ImageModel() {
    this.height = 400;
    this.width = 600;
    this.pixels = new int[this.height][this.width][3];
  }

  /**
   * Constructs an image with the chosen dimensions. Note that none of the color channels are set by
   * this operation.
   *
   * @param width  Integer, width of the image in pixels.
   * @param height Integer, height of the image in pixels.
   */
  public ImageModel(int width, int height) {
    this.width = width;
    this.height = height;
    this.pixels = new int[this.height][this.width][3];
  }

  /**
   * Construct an image from a 3D pixel array.
   *
   * @param pixels 3D array of integers, representing an image.
   */
  public ImageModel(int[][][] pixels) {
    this.height = pixels.length;
    this.width = pixels[0].length;
    this.pixels = pixels;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public final int[][][] getPixels() {
    // FINAL METHOD:
    //   - Critical method which is public and called by other public methods
    //   - Extending classes explicitly prohibited from overriding to protect deep copy integrity
    int[][][] deepCopy = new int[this.height][this.width][3];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        for (int k = 0; k < 3; k++) {
          deepCopy[i][j][k] = this.pixels[i][j][k];
        }
      }
    }
    // Deep copy to prevent tampering with the private int[][][] representing the actual image
    return deepCopy;
  }

  @Override
  public void write(String fileName) throws IOException {
    ImageUtil.writeImage(this.getPixels(), this.width, this.height, fileName);
  }

  @Override
  public Image filter(Filter filter) {
    // Pass a deep copy to preserve the original
    int[][][] newPixels = filter.applyFilter(this.getPixels());
    return new ImageModel(newPixels);
  }

  @Override
  public Image colorTransform(ColorTransform transform) {
    // Pass a deep copy to preserve the original
    int[][][] newPixels = transform.applyColorTransform(this.getPixels());
    return new ImageModel(newPixels);
  }

  @Override
  public Image generatePattern(Pattern pattern) {
    // Pass a deep copy to preserve the original
    int[][][] patternArray = pattern.generate(this.getPixels());
    return new ImageModel(patternArray);
  }

  @Override
  public Image reduce(Reduce reduction) {
    // Pass a deep copy to preserve the original
    int[][][] newPixels = reduction.applyReduce(this.getPixels());
    return new ImageModel(newPixels);
  }

  @Override
  public Image blur() {
    return this.filter(new Blur());
  }

  @Override
  public Image sharpen() {
    return this.filter(new Sharpen());
  }

  @Override
  public Image sepia() {
    return this.colorTransform(new Sepia());
  }

  @Override
  public Image greyscale() {
    return this.colorTransform(new Greyscale());
  }

  @Override
  public Image horizontalRainbow() {
    return this.generatePattern(new HorizontalRainbow());
  }

  @Override
  public Image verticalRainbow() {
    return this.generatePattern(new VerticalRainbow());
  }

  @Override
  public Image checkerboard(int size) {
    return this.generatePattern(new Checkerboard(size));
  }

  @Override
  public Image france() {
    return this.generatePattern(new France());
  }

  @Override
  public Image greece() {
    return this.generatePattern(new Greece());
  }

  @Override
  public Image switzerland() {
    return this.generatePattern(new Switzerland());
  }

  @Override
  public Image dither() {
    return this.reduce(new Dither());
  }

  @Override
  public Image mosaic(int n) throws IllegalArgumentException {
    if (n <= 0) {
      throw new IllegalArgumentException("Mosaic must take 1 or more seeds");
    }
    return this.reduce(new Mosaic(n));
  }
}