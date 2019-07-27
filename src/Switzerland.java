/**
 * A class to represent the flag of Switzerland. This class generates an image of the flag of
 * Switzerland.
 */
public class Switzerland implements Pattern {

  /**
   * Constructs a Switzerland object. Takes no parameters. Pass this object to the generatePattern()
   * in Image method to create an image of this pattern with the dimensions of the image it was
   * invoked upon. This flag expects dimensions in a 1:1 ratio. If the ratio is different, the
   * dimensions will be reset according to the shorter size.
   */
  public Switzerland() {
    // Does nothing
  }

  @Override
  public int[][][] generate(int[][][] pixels) {
    int height = pixels.length;
    int width = pixels[0].length;
    int[][] colors = {{255, 0, 0}, {255, 255, 255}};
    // Set the proportions according to the shorter side (based on factor of 32 from wikipedia)
    int prop;
    int side;
    if (height <= width) {
      prop = height / 32;
      side = height;
    } else {
      prop = width / 32;
      side = width;
    }
    int[][][] flag = new int[side][side][3];
    // Fill red background
    for (int h = 0; h < side; h++) {
      for (int w = 0; w < side; w++) {
        flag[h][w] = colors[0];
      }
    }
    // Draw vertical white rectangle
    for (int h = prop * 6; h < prop * 26; h++) {
      for (int w = prop * 13; w < prop * 19; w++) {
        flag[h][w] = colors[1];
      }
    }
    // Draw horizontal white rectangle
    for (int h = prop * 13; h < prop * 19; h++) {
      for (int w = prop * 6; w < prop * 26; w++) {
        flag[h][w] = colors[1];
      }
    }
    return flag;
  }
}
