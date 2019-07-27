import java.io.IOException;

/**
 * Class to run the program. Use this class to create the jar file.
 */
public class ProgramRunner {

  /**
   * Method to run the program. Accepts a script file with commands as input to perform various
   * operations on Images. Refer to the readme for details on how to write a script.
   *
   * @param args String array, the first element must be the name of the file.
   */
  public static void main(String[] args) {
    Image model = new ImageModel();
    if (args[0].equals("-interactive")) {
      ImageView view = new ImageView();
      Features controller = new GUIController(model, view);
    }
    else if (args[0].equals("-script")) {
      Controller controller = new ImageController(model);
      try {
        controller.run(args[1]);
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }
    else {
      System.out.println("Invalid Argument, try -script or -interactive.");
    }
  }
}
