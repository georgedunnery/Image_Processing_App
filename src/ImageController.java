import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class to represent the controller for an Image. Commands from the user are received and the model
 * is instructed on what to do to fulfill the commands.
 */
public class ImageController implements Controller {
  private Image current;

  /**
   * Constructs a controller that will direct a model and process commands from a batch script.
   * Not to be confused with GUIController, which processes commands from the view.
   *
   * @param model Image, the model this control should be directing.
   */
  public ImageController(Image model) {
    // Assign the model
    this.current = model;
    // Batch controller does not need a view
  }

  @Override
  public void run(String filename) throws IOException, IllegalArgumentException {
    read(new Scanner(new File(filename)));
  }

  @Override
  public final void read(Scanner script) throws IOException, IllegalArgumentException {
    // Execute until the quit command is received, or if the end of the file is reached
    // Included now to plan for potentially receiving "live" input from a terminal-like application
    boolean keepExecuting = true;
    while (keepExecuting) {
      String command = script.nextLine();
      String[] multiple = command.split(" ");
      multiple[0] = multiple[0].toLowerCase();
      keepExecuting = executeCommand(multiple);
      // Quit when the end of the file is reached
      if (!script.hasNextLine()) {
        break;
      }
    }
  }

  /**
   * Method to execute each individual script command. Exceptions are thrown for missing files
   *
   * @param multiple String[], one line containing a command split by spaces.
   * @return Boolean, continue looping unless the user has chosen to quit.
   * @throws IOException              When a script or image file is not found, or cannot be
   *                                  written.
   * @throws IllegalArgumentException When a command has invalid structure (ex. too few args).
   */
  private boolean executeCommand(String[] multiple) throws IOException, IllegalArgumentException {
    // Use the number of arguments to avoid array out of bounds exceptions
    int arguments = multiple.length;
    // Match according to the first argument, which should be a command
    switch (multiple[0]) {
      // Allow the use of empty lines in a script for readability
      case "":
        break;
      case "dimensions":
        if (arguments > 2) {
          this.current = new ImageModel(Integer.parseInt(multiple[1]),
                  Integer.parseInt(multiple[2]));
        } else {
          throw new IllegalArgumentException("Specify width and height.");
        }
        break;
      case "load":
        if (arguments > 1) {
          this.current = new ImageModel(multiple[1]);
        } else {
          System.out.println("Loading blank image to default dimensions 600 x 400.");
          this.current = new ImageModel();
        }
        break;
      case "save":
        if (arguments > 1) {
          this.current.write( multiple[1]);
        }
        break;
      case "blur":
        this.current = this.current.blur();
        break;
      case "sharpen":
        this.current = this.current.sharpen();
        break;
      case "sepia":
        this.current = this.current.sepia();
        break;
      case "greyscale":
        this.current = this.current.greyscale();
        break;
      case "dither":
        this.current = this.current.dither();
        break;
      case "mosaic":
        if (arguments > 1) {
          this.current = this.current.mosaic(Integer.parseInt(multiple[1]));
        } else {
          throw new IllegalArgumentException("Must specify number of mosaic seeds.");
        }
        break;
      case "horizontalrainbow":
        this.current = this.current.horizontalRainbow();
        break;
      case "verticalrainbow":
        this.current = this.current.verticalRainbow();
        break;
      case "checkerboard":
        if (arguments > 1) {
          this.current = this.current.checkerboard(Integer.parseInt(multiple[1]));
        } else {
          throw new IllegalArgumentException("Must define size of checkerboard squares.");
        }
        break;
      case "france":
        this.current = this.current.france();
        break;
      case "greece":
        this.current = this.current.greece();
        break;
      case "switzerland":
        this.current = this.current.switzerland();
        break;
      case "quit":
        return false;
      default:
        throw new IllegalArgumentException("Command not recognized:" + multiple[0]);
    }
    return true;
  }
}
