import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

/**
 * JUnit test class for operations on the view interface.
 */
public class ViewTest {
  private Features guiController;
  private Image model;

  @Before
  public void setUp() throws IOException {
    // View is required by the GUIController constructor, but the test should not show a view
    // Create a bogus view here to keep the controller satisfied
    View mockView = new View() {
      @Override
      public void setFeatures(Features f) {
        // Mock View does nothing
      }

      @Override
      public void updateImageOutput(Features f) {
        // Mock View does nothing
      }

      @Override
      public void notification(String msg) {
        // Mock View does nothing
      }
    };
    // Pass in a default blank image with the bogus view, now we can call controller methods
    guiController = new GUIController(new ImageModel("res/giraffe.jpg"), mockView);
    model = new ImageModel("res/giraffe.jpg");
  }

  @Test
  public void testGetImage() {
    assertArrayEquals(model.getPixels(), guiController.getImage());

  }

  @Test
  public void testGenerateBlank() {
    Image blankImage = new ImageModel(100, 100);
    guiController.generateBlank(100, 100);
    assertArrayEquals(blankImage.getPixels(), guiController.getImage());
  }

  @Test
  public void testGreyscale() {
    model = model.greyscale();
    guiController.greyScale();
    assertArrayEquals(model.getPixels(), guiController.getImage());
  }

  @Test
  public void testSepia() {
    model = model.sepia();
    guiController.sepia();
    assertArrayEquals(model.getPixels(), guiController.getImage());
  }


  @Test
  public void testBlur() {
    model = model.blur();
    guiController.blur();
    assertArrayEquals(model.getPixels(), guiController.getImage());
  }


  @Test
  public void testSharpen() {
    model = model.sharpen();
    guiController.sharpen();
    assertArrayEquals(model.getPixels(), guiController.getImage());
  }


  @Test
  public void testDither() {
    model = model.dither();
    guiController.dither();
    assertArrayEquals(model.getPixels(), guiController.getImage());
  }


  @Test
  public void testHorizontalRainbow() {
    model = model.horizontalRainbow();
    guiController.horizontalRainbow();
    assertArrayEquals(model.getPixels(), guiController.getImage());
  }


  @Test
  public void testVerticalRainbow() {
    model = model.verticalRainbow();
    guiController.verticalRainbow();
    assertArrayEquals(model.getPixels(), guiController.getImage());
  }


  @Test
  public void testFrance() {
    model = model.france();
    guiController.france();
    assertArrayEquals(model.getPixels(), guiController.getImage());
  }

  @Test
  public void testGreece() {
    model = model.greece();
    guiController.greece();
    assertArrayEquals(model.getPixels(), guiController.getImage());
  }


  @Test
  public void testSwitzerland() {
    model = model.switzerland();
    guiController.switzerland();
    assertArrayEquals(model.getPixels(), guiController.getImage());
  }


  @Test
  public void testCheckerboard() {
    model = model.checkerboard(10);
    guiController.checkerboard(10);
    assertArrayEquals(model.getPixels(), guiController.getImage());
  }


}
