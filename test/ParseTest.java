import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertArrayEquals;

/**
 * JUnit test class for the various operations involved in batch script processing and execution.
 */
public class ParseTest {
  private Controller controller;

  @Before
  public void setup() {
    Image model = new ImageModel();
    controller = new ImageController(model);
  }

  /**
   * Allow blank lines in the script for readability. No errors should occur.
   */
  @Test
  public void testReadability() {
    Scanner scan = new Scanner("\n");
    try {
      controller.read(scan);
    } catch (IOException | IllegalArgumentException e) {
      fail("Blank lines are allowed.");
    }
  }

  @Test
  public void testUnknown() {
    Scanner scan = new Scanner("badCommand");
    try {
      controller.read(scan);
      fail("An illegal argument exception should be thrown.");
    } catch (IllegalArgumentException e) {
      // Pass the test
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testCheckerboardException() {
    Scanner scan = new Scanner("load\ncheckerboard\n");
    try {
      controller.read(scan);
      fail("Checkerboard requires an argument, exception should have been thrown.");
    } catch (IllegalArgumentException e) {
      // Pass the test
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testMosaicException() {
    Scanner scan = new Scanner("load res/giraffe.jpg\nmosaic\n");
    try {
      controller.read(scan);
      fail("Mosaic requires an argument, exception should have been thrown.");
    } catch (IllegalArgumentException e) {
      // Pass the test
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testDimensions() {
    Scanner scan = new Scanner("dimensions 100 100\nsave res/Test-dimensions.jpg");
    try {
      controller.read(scan);
      Image output = new ImageModel("res/Test-dimensions.jpg");
      Image expected = new ImageModel(100, 100);
      assertArrayEquals(expected.getPixels(), output.getPixels());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testBlur() {
    Scanner scan = new Scanner("load res/giraffe.jpg\nblur\nsave res/Test-blur.jpg");
    try {
      controller.read(scan);
      Image out = new ImageModel("res/Test-blur.jpg");
      Image expected = new ImageModel("res/blurredGiraffe.jpg");
      assertArrayEquals(expected.getPixels(), out.getPixels());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testSharpen() {
    Scanner scan = new Scanner("load res/giraffe.jpg\nsharpen\nsave res/Test-sharp.jpg");
    try {
      controller.read(scan);
      Image out = new ImageModel("res/Test-sharp.jpg");
      Image expected = new ImageModel("res/sharpenedGiraffe.jpg");
      assertArrayEquals(expected.getPixels(), out.getPixels());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testSepia() {
    Scanner scan = new Scanner("load res/giraffe.jpg\nsepia\nsave res/Test-sepia.jpg");
    try {
      controller.read(scan);
      Image out = new ImageModel("res/Test-sepia.jpg");
      Image expected = new ImageModel("res/sepiaGiraffe.jpg");
      assertArrayEquals(expected.getPixels(), out.getPixels());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testGreyscale() {
    Scanner scan = new Scanner("load res/giraffe.jpg\ngreyscale\nsave res/Test-grey.jpg");
    try {
      controller.read(scan);
      Image out = new ImageModel("res/Test-grey.jpg");
      Image expected = new ImageModel("res/greyscaleGiraffe.jpg");
      assertArrayEquals(expected.getPixels(), out.getPixels());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testDither() {
    Scanner scan = new Scanner("load res/giraffe.jpg\ndither\nsave res/Test-dither.jpg");
    try {
      controller.read(scan);
      Image out = new ImageModel("res/Test-dither.jpg");
      Image expected = new ImageModel("res/ditheredGiraffe.jpg");
      assertArrayEquals(expected.getPixels(), out.getPixels());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testHorizontalRainbow() {
    Scanner scan = new Scanner("load\nhorizontalrainbow\nsave res/Test-hRain.jpg");
    try {
      controller.read(scan);
      Image out = new ImageModel("res/Test-hRain.jpg");
      Image expected = new ImageModel("res/horizontalRainbow.jpg");
      assertArrayEquals(expected.getPixels(), out.getPixels());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testVerticalRainbow() {
    Scanner scan = new Scanner("load\nverticalrainbow\nsave res/Test-vRain.jpg");
    try {
      controller.read(scan);
      Image out = new ImageModel("res/Test-vRain.jpg");
      Image expected = new ImageModel("res/verticalRainbow.jpg");
      assertArrayEquals(expected.getPixels(), out.getPixels());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testCheckerboard() {
    Scanner scan = new Scanner("load\ncheckerboard 50\nsave res/Test-check.jpg");
    try {
      controller.read(scan);
      Image out = new ImageModel("res/Test-check.jpg");
      Image expected = new ImageModel("res/checkerboard.jpg");
      assertArrayEquals(expected.getPixels(), out.getPixels());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testFrance() {
    Scanner scan = new Scanner("dimensions 1200 800\nfrance\nsave res/Test-france.jpg");
    try {
      controller.read(scan);
      Image out = new ImageModel("res/Test-france.jpg");
      Image expected = new ImageModel("res/france.jpg");
      assertArrayEquals(expected.getPixels(), out.getPixels());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testGreece() {
    Scanner scan = new Scanner("dimensions 1200 800\ngreece\nsave res/Test-greece.jpg");
    try {
      controller.read(scan);
      Image out = new ImageModel("res/Test-greece.jpg");
      Image expected = new ImageModel("res/greece.jpg");
      assertArrayEquals(expected.getPixels(), out.getPixels());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void testSwitzerland() {
    Scanner scan = new Scanner("dimensions 500 500\nswitzerland\nsave res/Test-swiss.jpg");
    try {
      controller.read(scan);
      Image out = new ImageModel("res/Test-swiss.jpg");
      Image expected = new ImageModel("res/switzerland.jpg");
      assertArrayEquals(expected.getPixels(), out.getPixels());
    } catch (IOException e) {
      fail(e.getMessage());
    }
  }
}
