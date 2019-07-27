import java.io.IOException;
import java.util.Scanner;

/**
 * Interface to represent a controller for an Image. The controller should coordinate the view and
 * the model.
 */
public interface Controller {

  /**
   * Method to run the application. Please refer to the readme for details on the syntax of the
   * script commands.
   *
   * @param filename String, script containing the commands to run.
   * @throws IOException              When a script or image file is not found, or cannot be
   *                                  written.
   * @throws IllegalArgumentException When a command is invalid (e.g. too few arguments).
   */
  void run(String filename) throws IOException, IllegalArgumentException;

  /**
   * Method to process and execute a batch script. Uses a scanner to read each line,
   * parse accordinly, and execute individual commands.
   *
   * @param script the batch script to read.
   * @throws IOException when a script or image file is not found, or cannot be written.
   * @throws IllegalArgumentException when a command is invalid (e.g. too few arguments).
   */
  void read(Scanner script) throws IOException, IllegalArgumentException;
}
