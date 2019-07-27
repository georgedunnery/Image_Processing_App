import java.io.IOException;

/**
 * This interface represents the operations that can be called by a GUI controller.
 */
public interface Features {

  /**
   * Method to handle a batch script containing commands to be executed.
   *
   * @param input string representation of the script we want to process.
   * @throws IOException when a script or image file is not found, or cannot be written.
   * @throws IllegalArgumentException when a command has invalid structure (ex. too few args).
   */
  void processScript(String input) throws IOException, IllegalArgumentException;

  /**
   * Method to get the current image displayed by the view.
   * @return int array representation of the current image.
   */
  int[][][] getImage();

  /**
   * Method to allow a user to select and load an image file from the root directory .
   */
  void load();

  /**
   * Method to allow a user to save an image anywhere within the directory with a custom filename.
   */
  void save();

  /**
   * Method to undo the last operation performed on the GUI; opposite of redo.
   */
  void undo();

  /**
   * Method to redo the last operation performed on the GUI; opposite of undo.
   */
  void redo();

  /**
   * Method to generate a blank image onto the view with specified dimensions.
   * @param w int, the user-specified width.
   * @param h int, the user-specified height.
   */
  void generateBlank(int w, int h);

  /**
   * Method to apply a greyscale color transformation to the current image and display in the view.
   */
  void greyScale();

  /**
   * Method to apply a sepia color transformation to the current image and display in the view.
   */
  void sepia();

  /**
   * Method to apply a blur filter to the current image and display in the view.
   */
  void blur();

  /**
   * Method to apply a sharpen filter to the current image and display in the view.
   */
  void sharpen();

  /**
   * Method to apply a dither reduction to the current image and display in the view.
   */
  void dither();

  /**
   * Method to apply a mosaic reduction to the current image and display in the view.
   *
   * @param n int, number of seeds to be generated in the image.
   */
  void mosaic(int n);

  /**
   * Method to generate a horizontal rainbow image and display it in the view.
   */
  void horizontalRainbow();

  /**
   * Method to generate a vertical rainbow image and display it in the view.
   */
  void verticalRainbow();

  /**
   * Method to generate a france flag image and display it in the view.
   */
  void france();

  /**
   * Method to generate a greece flag image and display it in the view.
   */
  void greece();

  /**
   * Method to generate a switzerland flag image and display it in the view.
   */
  void switzerland();

  /**
   * Method to generate a checkerboard image and display it in the view.
   * @param n int, size of each square specified by the user.
   */
  void checkerboard(int n);
}
