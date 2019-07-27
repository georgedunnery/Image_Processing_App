/**
 * This interface represents all of the operations to be supported by the view of the project.
 * In the context of MVC, the view is a graphical user interface allowing the user to edit images.
 */
public interface View {

  /**
   * When implemented, this method adds action listeners to each clickable item in the GUI,
   * setting their result to specific operations.
   *
   * @param f the controller used by this GUI
   */
  void setFeatures(Features f);

  /**
   * Redraws the image view panel on the GUI to reflect the changes.
   *
   * @param f the controller used by this GUI
   */
  void updateImageOutput(Features f);

  /**
   * Helper method to send a notification to the user.
   *
   * @param msg String, the error message.
   */
  void notification(String msg);
}
