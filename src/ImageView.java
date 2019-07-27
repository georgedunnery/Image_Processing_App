import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.NoSuchElementException;

/**
 * Class to represent a GUI for the image editing application.
 * Contains both radio buttons and menu items for various operations on the image model.
 * The view is constructed with private fields for buttons, text areas, and menus,
 * organized hierarchically by category of operations and/or the GUI layout.
 */
public class ImageView extends JFrame implements View {
  private JPanel mainPanel;

  private JButton loadButton;
  private JButton saveButton;
  private JButton undoButton;
  private JButton redoButton;
  private JButton generateButton;

  private JButton executeScriptButton;
  private JTextArea scriptTextArea;

  private JButton blurButton;
  private JButton sharpenButton;
  private JButton greyscaleButton;
  private JButton sepiaButton;
  private JButton ditherButton;
  private JButton mosaicButton;

  private JLabel imageLabel;

  private JMenuItem loadMenu;
  private JMenuItem saveMenu;
  private JMenuItem executeScriptMenu;

  private JMenuItem undoMenu;
  private JMenuItem redoMenu;
  private JMenuItem greyscaleMenu;
  private JMenuItem sepiaMenu;
  private JMenuItem blurMenu;
  private JMenuItem sharpenMenu;
  private JMenuItem ditherMenu;
  private JMenuItem mosaicMenu;
  private JMenu generateMenu;
  private JMenuItem horizonalRainbowMenu;
  private JMenuItem verticalRainbowMenu;
  private JMenuItem franceMenu;
  private JMenuItem greeceMenu;
  private JMenuItem switzerlandMenu;
  private JMenuItem checkerboardMenu;

  /**
   * Method to create the graphical user interface for the Image Editor program. The constructor
   * builds all the Panels, Menus and Buttons required. Always call setFeatures on the ImageView
   * from the controller to set the action listeners that drive the functionality fo the program.
   */
  public ImageView() {
    super();
    setTitle("Image Editor");
    setSize(900, 900);


    mainPanel = new JPanel();
    //for elements to be arranged vertically within this panel
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
    //scroll bars around this main panel
    JScrollPane mainScrollPane = new JScrollPane(mainPanel);
    add(mainScrollPane);




    // Menu bar and main menus
    JMenuBar menuBar = new JMenuBar();
    mainPanel.add(menuBar);
    JMenu fileMenu = new JMenu("File");
    menuBar.add(fileMenu);
    JMenu editMenu = new JMenu("Edit");
    menuBar.add(editMenu);
    generateMenu = new JMenu("Generate");
    menuBar.add(generateMenu);


    // File menu items
    loadMenu = new JMenuItem("Load Image");
    fileMenu.add(loadMenu);
    saveMenu = new JMenuItem("Save Image");
    fileMenu.add(saveMenu);
    executeScriptMenu = new JMenuItem("Execute Script");
    fileMenu.add(executeScriptMenu);


    // Undo and redo menu items
    undoMenu = new JMenuItem("Undo");
    editMenu.add(undoMenu);
    redoMenu = new JMenuItem("Redo");
    editMenu.add(redoMenu);
    // Edit submenus
    JMenu filterMenu = new JMenu("Filter");
    editMenu.add(filterMenu);
    JMenu colorTransformMenu = new JMenu("ColorTransform");
    editMenu.add(colorTransformMenu);
    JMenu reductionMenu = new JMenu("Reduction");
    editMenu.add(reductionMenu);
    // Filter menu items
    blurMenu = new JMenuItem("Blur");
    filterMenu.add(blurMenu);
    sharpenMenu = new JMenuItem("Sharpen");
    filterMenu.add(sharpenMenu);
    // ColorTransform menu items
    greyscaleMenu = new JMenuItem("Greyscale");
    colorTransformMenu.add(greyscaleMenu);
    sepiaMenu = new JMenuItem("Sepia");
    colorTransformMenu.add(sepiaMenu);
    // Reduction menu items
    ditherMenu = new JMenuItem("Dither");
    reductionMenu.add(ditherMenu);
    mosaicMenu = new JMenuItem("Mosaic");
    reductionMenu.add(mosaicMenu);


    // Generate menu items
    horizonalRainbowMenu = new JMenuItem("Horizontal Rainbow");
    generateMenu.add(horizonalRainbowMenu);
    verticalRainbowMenu = new JMenuItem("Vertical Rainbow");
    generateMenu.add(verticalRainbowMenu);
    franceMenu = new JMenuItem("France");
    generateMenu.add(franceMenu);
    greeceMenu = new JMenuItem("Greece");
    generateMenu.add(greeceMenu);
    switzerlandMenu = new JMenuItem("Switzerland");
    generateMenu.add(switzerlandMenu);
    checkerboardMenu = new JMenuItem("Checkerboard");
    generateMenu.add(checkerboardMenu);



    //show an image with a scrollbar
    JPanel imagePanel = new JPanel();
    //a border around the panel with a caption
    imagePanel.setBorder(BorderFactory.createTitledBorder("Current Image"));
    imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.PAGE_AXIS));
    mainPanel.add(imagePanel);


    // image panel for current image, generate, and load/save buttons
    imageLabel = new JLabel();
    JScrollPane imageScrollPane = new JScrollPane(imageLabel);


    imageScrollPane.setPreferredSize(new Dimension(300, 300));
    imagePanel.add(imageScrollPane);

    // load and save buttons
    JPanel loadSavePanel = new JPanel();
    imagePanel.add(loadSavePanel);
    loadButton = new JButton("Load");
    loadSavePanel.add(loadButton);
    saveButton = new JButton("Save");
    loadSavePanel.add(saveButton);

    // generate blank image button with width and height fields
    JPanel generatePanel = new JPanel();
    imagePanel.add(generatePanel);
    generateButton = new JButton("Generate blank image");
    generatePanel.add(generateButton);

    // panel to host all image editing options
    JPanel optionsPanel = new JPanel();
    mainPanel.add(optionsPanel);

    // blur and sharpen buttons organized as filters
    JPanel filtersPanel = new JPanel();
    optionsPanel.add(filtersPanel);
    filtersPanel.setLayout(new BoxLayout(filtersPanel, BoxLayout.PAGE_AXIS));
    JLabel filtersLabel = new JLabel("Filters");
    filtersPanel.add(filtersLabel);
    blurButton = new JButton("Blur");
    filtersPanel.add(blurButton);
    sharpenButton = new JButton("Sharpen");
    filtersPanel.add(sharpenButton);

    // greyscale and sepia buttons organized as color transformations
    JPanel colorTransformationsPanel = new JPanel();
    optionsPanel.add(colorTransformationsPanel);
    colorTransformationsPanel.setLayout(new BoxLayout(colorTransformationsPanel,
            BoxLayout.PAGE_AXIS));
    JLabel colorTransformationsLabel = new JLabel("Color Transformations");
    colorTransformationsPanel.add(colorTransformationsLabel);
    greyscaleButton = new JButton("Greyscale");
    colorTransformationsPanel.add(greyscaleButton);
    sepiaButton = new JButton("Sepia");
    colorTransformationsPanel.add(sepiaButton);

    // dither and mosaic buttons organized as reductions
    JPanel reductionsPanel = new JPanel();
    optionsPanel.add(reductionsPanel);
    reductionsPanel.setLayout(new BoxLayout(reductionsPanel, BoxLayout.PAGE_AXIS));
    JLabel reductionsLabel = new JLabel("Reductions");
    reductionsPanel.add(reductionsLabel);
    ditherButton = new JButton("Dither");
    reductionsPanel.add(ditherButton);

    mosaicButton = new JButton("Mosaic");
    reductionsPanel.add(mosaicButton);

    // Undo and Redo buttons
    JPanel undoRedoPanel = new JPanel();
    mainPanel.add(undoRedoPanel);
    undoButton = new JButton("Undo");
    undoRedoPanel.add(undoButton);
    redoButton = new JButton("Redo");
    undoRedoPanel.add(redoButton);

    // script panel for text area and execute/save buttons
    JPanel scriptPanel = new JPanel();
    scriptPanel.setLayout(new BoxLayout(scriptPanel, BoxLayout.PAGE_AXIS));
    mainPanel.add(scriptPanel);

    // batch script text area
    scriptTextArea = new JTextArea(5, 10);
    scriptTextArea.setLineWrap(true);
    scriptTextArea.setBorder(BorderFactory.createTitledBorder("Enter batch script"));
    scriptPanel.add(scriptTextArea);

    // execute script buttons
    JPanel scriptOptionsPanel = new JPanel();
    executeScriptButton = new JButton("Execute script");
    scriptOptionsPanel.add(executeScriptButton);
    scriptPanel.add(scriptOptionsPanel);


    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  @Override
  public void updateImageOutput(Features f) {
    int[][][] pixels = f.getImage();
    int height = pixels.length;
    int width = pixels[0].length;
    BufferedImage buff = ImageUtil.getBufferedImage(pixels, width, height);
    imageLabel.setIcon(new ImageIcon(buff));
  }

  @Override
  public void setFeatures(Features f) {
    // Display the initial blank image
    updateImageOutput(f);

    // Buttons
    executeScriptButton.addActionListener(l -> executeScriptAL(f));
    loadButton.addActionListener(l -> loadAL(f));
    saveButton.addActionListener(l -> saveAL(f));
    undoButton.addActionListener(l -> undoAL(f));
    redoButton.addActionListener(l -> redoAL(f));
    generateButton.addActionListener(l -> generateAL(f));
    greyscaleButton.addActionListener(l -> greyscaleAL(f));
    sepiaButton.addActionListener(l -> sepiaAL(f));
    blurButton.addActionListener(l -> blurAL(f));
    sharpenButton.addActionListener(l -> sharpenAL(f));
    ditherButton.addActionListener(l -> ditherAL(f));
    mosaicButton.addActionListener(l -> mosaicAL(f));

    // Menus
    executeScriptMenu.addActionListener(l -> executeScriptAL(f));
    loadMenu.addActionListener(l -> loadAL(f));
    saveMenu.addActionListener(l -> saveAL(f));
    undoMenu.addActionListener(l -> undoAL(f));
    redoMenu.addActionListener(l -> redoAL(f));
    generateMenu.addActionListener(l -> generateAL(f));
    greyscaleMenu.addActionListener(l -> greyscaleAL(f));
    sepiaMenu.addActionListener(l -> sepiaAL(f));
    blurMenu.addActionListener(l -> blurAL(f));
    sharpenMenu.addActionListener(l -> sharpenAL(f));
    ditherMenu.addActionListener(l -> ditherAL(f));
    mosaicMenu.addActionListener(l -> mosaicAL(f));
    horizonalRainbowMenu.addActionListener(l -> horizontalRainbowAL(f));
    verticalRainbowMenu.addActionListener(l -> verticalRainbowAL(f));
    franceMenu.addActionListener(l -> franceAL(f));
    greeceMenu.addActionListener(l -> greeceAL(f));
    switzerlandMenu.addActionListener(l -> switzerlandAL(f));
    checkerboardMenu.addActionListener(l -> checkerboardAL(f));
  }

  /**
   * Helper method to ask the user to choose the dimensions for an image. A pop up appears with
   * three options: OK, Default, Cancel. Choosing okay will attempt to parse integers from the
   * JTextField strings - if this fails, the default 600 x 400 is used. Choosing default
   * automatically enters 600 x 400. Choosing cancel throws an exception, thus killing the process
   * to truly cancel without needing to check the return value.
   *
   * @return String[], the width and height as strings.
   * @throws IllegalStateException When the user cancels, always let the method fail.
   */
  private String[] dimensionsChooser() throws IllegalStateException {
    String[] dimensions = {"", ""};
    // Gather multiple inputs from text fields displayed in the popup window
    JTextField widthInput = new JTextField();
    JTextField heightInput = new JTextField();
    Object[] message = {"Width:", widthInput, "Height:", heightInput};
    Object[] options = {"OK", "Default", "Cancel"};
    int choice = JOptionPane.showOptionDialog(mainPanel ,message,"Choose the Dimensions",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
            options[0]);
    if (choice == 0) {
      dimensions[0] = widthInput.getText();
      dimensions[1] = heightInput.getText();
    }
    else if (choice == 1) {
      dimensions[0] = "600";
      dimensions[1] = "400";
    }
    else if (choice == 2) {
      throw new IllegalStateException("Image generation cancelled.");
    }
    return dimensions;
  }

  /**
   * Helper method to ask the user to choose a single number. Use for the number of seeds and size
   * of checkerboard squares.
   *
   * @param prompt String, prompt to display after "Enter the".
   * @return String, the number entered.
   * @throws IllegalStateException When the user cancels, always let the method fail.
   */
  private String numberChooser(String prompt) throws IllegalStateException {
    String amount = "";
    JTextField amountInput = new JTextField();
    Object[] message = {prompt, amountInput};
    Object[] options = {"OK", "Cancel"};
    int choice = JOptionPane.showOptionDialog(mainPanel ,message,"Enter the" + prompt,
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
            options[0]);
    if (choice == 0) {
      amount = amountInput.getText();
    }
    else if (choice == 1) {
      throw new IllegalStateException("Image generation cancelled.");
    }
    return amount;
  }

  @Override
  public void notification(String msg) {
    JOptionPane.showMessageDialog(mainPanel, msg);
  }

  /*
  DEV NOTE - Explanation of Private Methods with the Suffix "AL" (for "Action Listener"):

  These methods create a single, portable method call for adding action listeners in the setFeatures
  method. Redundancy in the GUI is controlled by having all sources of some operation refer to the
  same "action listener" method below, so that all sources run the exact same code.
   */


  private void executeScriptAL(Features f) {
    try {
      f.processScript(scriptTextArea.getText());
    } catch (IOException | NoSuchElementException e) {
      notification(e.getMessage());
    }
  }

  private void loadAL(Features f) {
    f.load();
    updateImageOutput(f);
  }

  private void saveAL(Features f) {
    f.save();
    updateImageOutput(f);
  }

  private void undoAL(Features f) {
    f.undo();
    updateImageOutput(f);
  }

  private void redoAL(Features f) {
    f.redo();
    updateImageOutput(f);
  }

  private void generateAL(Features f) {
    String[] dimensions = dimensionsChooser();
    try {
      int width = Integer.parseInt(dimensions[0]);
      int height = Integer.parseInt(dimensions[1]);
      if (width > 0 && height > 0) {
        f.generateBlank(width, height);
      }
      else {
        notification("Invalid dimensions: Height and width must be positive integers.");
      }
    } catch (NumberFormatException e) {
      notification("Problem parsing integers: Default dimensions 600 x 400 used.");
      f.generateBlank(600, 400);
    }
    updateImageOutput(f);
  }

  private void greyscaleAL(Features f) {
    f.greyScale();
    updateImageOutput(f);
  }

  private void sepiaAL(Features f) {
    f.sepia();
    updateImageOutput(f);
  }

  private void blurAL(Features f) {
    f.blur();
    updateImageOutput(f);
  }

  private void sharpenAL(Features f) {
    f.sharpen();
    updateImageOutput(f);
  }

  private void ditherAL(Features f) {
    f.dither();
    updateImageOutput(f);
  }

  private void mosaicAL(Features f) {
    String seedInput = numberChooser("Number of Seeds");
    try {
      int seeds = Integer.parseInt(seedInput);
      if (seeds > 0 && seeds <= 10000) {
        f.mosaic(seeds);
      }
      else if (seeds <= 0) {
        notification("The number of seeds must be at least 1.");
      }
      else {
        notification("More than 10,000 seeds will take far too long. Try a smaller number.");
      }
    } catch (NumberFormatException e) {
      notification(e.getMessage());
    }
    updateImageOutput(f);
  }

  private void horizontalRainbowAL(Features f) {
    generateAL(f);
    f.horizontalRainbow();
    updateImageOutput(f);
  }

  private void verticalRainbowAL(Features f) {
    generateAL(f);
    f.verticalRainbow();
    updateImageOutput(f);
  }

  private void franceAL(Features f) {
    notification("France flag ratio is (width, height) 3:2, " +
            "improper dimensions will be corrected based on shortest side.");
    generateAL(f);
    f.france();
    updateImageOutput(f);
  }

  private void greeceAL(Features f) {
    notification("Greece flag ratio is (width, height) 3:2, " +
            "improper dimensions will be corrected based on shortest side.");
    generateAL(f);
    f.greece();
    updateImageOutput(f);
  }

  private void switzerlandAL(Features f) {
    notification("Switzerland flag ratio is (width, height) 1:1, " +
            "improper dimensions will be corrected based on shortest side.");
    generateAL(f);
    f.switzerland();
    updateImageOutput(f);
  }

  private void checkerboardAL(Features f) {
    generateAL(f);
    String squaresInput = numberChooser("Size of Squares");
    try {
      int squares = Integer.parseInt(squaresInput);
      if (squares > 0) {
        f.checkerboard(squares);
      }
      else {
        notification("Square size must be at least 1.");
      }
    } catch (NumberFormatException e) {
      notification(e.getMessage());
    }
    updateImageOutput(f);
  }
}