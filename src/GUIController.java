import java.io.File;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * This class represents a controller that operates on a model and reflects changes in the GUI.
 */
public class GUIController implements Features {
  private Image model;
  private View view;
  private Deque<Image> undoStack;
  private Deque<Image> redoStack;

  /**
   * Constructs a GUI controller.
   *
   * @param model the image model that will update based on the commands it receives.
   * @param view the GUI that the user sees.
   */
  public GUIController(Image model, View view) {
    this.model = model;
    this.view = view;
    // Create the undo and redo stacks
    this.undoStack = new LinkedList<>();
    this.redoStack = new LinkedList<>();
    // Let the view know this controller exists so it can use callbacks!
    view.setFeatures(this);
  }

  @Override
  public void processScript(String input) {
    Controller batchHandler = new ImageController(new ImageModel());
    try {
      batchHandler.read(new Scanner(input));
      view.notification("Batch Script ran successfully.\nCheck your directory for output.");
    } catch (IOException e) {
      view.notification(e.getMessage());
    }
  }

  @Override
  public int[][][] getImage() {
    return this.model.getPixels();
  }

  @Override
  public void load() {
    String filename = "";
    final JFileChooser choose = new JFileChooser(".");
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Images", "jpg", "png", "bmp");
    choose.setFileFilter(filter);
    int choice = choose.showOpenDialog(null);
    if (choice == JFileChooser.APPROVE_OPTION) {
      File file = choose.getSelectedFile();
      try {
        this.model = new ImageModel(file.getAbsolutePath());
        resetStacks();
      } catch (IOException e) {
        view.notification(e.getMessage());
      }
    }
    // Do nothing if the user presses cancel
  }

  @Override
  public void save() {
    final JFileChooser choose = new JFileChooser(".");
    int choice = choose.showSaveDialog(null);
    if (choice == JFileChooser.APPROVE_OPTION) {
      File file = choose.getSelectedFile();
      try {
        String name = file.getCanonicalPath();
        this.model.write(name);
      } catch (IOException e) {
        view.notification(e.getMessage());
      }
    }
    // Do nothing if the user presses cancel
  }

  @Override
  public void undo() {
    if (!this.undoStack.isEmpty()) {
      // Add current image to the redo stack
      this.redoStack.push(this.model);
      // Pop out the previous version from the undo stack
      this.model = this.undoStack.pop();
    }
  }

  @Override
  public void redo() {
    if (!this.redoStack.isEmpty()) {
      // Add current image to the undo stack
      this.undoStack.push(this.model);
      // Pop out the next version from the redo stack
      this.model = this.redoStack.pop();
    }
  }

  @Override
  public void generateBlank(int width, int height) {
    resetStacks();
    this.model = new ImageModel(width, height);
  }

  /**
   * Private method to reset the undo and redo stacks. Undo and Redo stacks should be cleared when
   * a new image is loaded or generated.
   */
  private void resetStacks() {
    // Fresh stacks are assigned for the new image
    this.undoStack = new LinkedList<>();
    this.redoStack = new LinkedList<>();
  }

  // FOR ALL OPERATIONS:
  //  - Push current image to the undo stack
  //  - Perform operation & reassign current image

  @Override
  public void greyScale() {
    undoStack.push(this.model);
    this.model = this.model.greyscale();
  }

  @Override
  public void sepia() {
    undoStack.push(this.model);
    this.model = this.model.sepia();
  }

  @Override
  public void blur() {
    undoStack.push(this.model);
    this.model = this.model.blur();
  }

  @Override
  public void sharpen() {
    undoStack.push(this.model);
    this.model = this.model.sharpen();
  }

  @Override
  public void dither() {
    undoStack.push(this.model);
    this.model = this.model.dither();
  }

  @Override
  public void mosaic(int n) {
    undoStack.push(this.model);
    this.model = this.model.mosaic(n);
  }

  @Override
  public void horizontalRainbow() {
    undoStack.push(this.model);
    this.model = this.model.horizontalRainbow();

  }

  @Override
  public void verticalRainbow() {
    undoStack.push(this.model);
    this.model = this.model.verticalRainbow();
  }

  @Override
  public void france() {
    undoStack.push(this.model);
    this.model = this.model.france();
  }

  @Override
  public void greece() {
    undoStack.push(this.model);
    this.model = this.model.greece();
  }

  @Override
  public void switzerland() {
    undoStack.push(this.model);
    this.model = this.model.switzerland();
  }

  @Override
  public void checkerboard(int n) {
    undoStack.push(this.model);
    this.model = this.model.checkerboard(n);
  }
}
