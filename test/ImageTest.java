import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * A JUnit test class for the ImageModel. The test class largely does the same thing as the main
 * method.
 */
public class ImageTest {
  private Image empty;
  private Image base;
  private Image giraffe;
  private Image rushmore;

  @Before
  public void setUp() throws IOException {
    empty = new ImageModel();
    base = new ImageModel(1200, 800);
    giraffe = new ImageModel("res/giraffe.jpg");
    rushmore = new ImageModel("res/rushmore.jpg");
  }

  @Test
  public void getHeight() {
    assertEquals(400, empty.getHeight());
    assertEquals(800, base.getHeight());
  }

  @Test
  public void getWidth() {
    assertEquals(600, empty.getWidth());
    assertEquals(1200, base.getWidth());
  }

  @Test
  public void getPixels() {
    int[][][] expectedEmptyImagePixels = new int[400][600][3];
    assertArrayEquals(expectedEmptyImagePixels, empty.getPixels());
  }

  @Test
  public void testBlur() {
    Image blurredRushmore = rushmore.filter(new Blur());
    try {
      blurredRushmore.write("res/blurredRushmore.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }

    Image blurredGiraffe = giraffe.filter(new Blur());
    try {
      blurredGiraffe.write("res/blurredGiraffe.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }
  }

  @Test
  public void testSharpen() {
    Image sharpenedRushmore = rushmore.filter(new Sharpen());
    try {
      sharpenedRushmore.write("res/sharpenedRushmore.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }

    Image sharpenedGiraffe = giraffe.filter(new Sharpen());
    try {
      sharpenedGiraffe.write("res/sharpenedGiraffe.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }

  }

  @Test
  public void testGreyscale() {
    Image greyscaleRushmore = rushmore.colorTransform(new Greyscale());
    try {
      greyscaleRushmore.write("res/greyscaleRushmore.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }

    Image greyscaleGiraffe = giraffe.colorTransform(new Greyscale());
    try {
      greyscaleGiraffe.write("res/greyScaleGiraffe.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }
  }

  @Test
  public void testSepia() {
    Image sepiaRushmore = rushmore.colorTransform(new Sepia());
    try {
      sepiaRushmore.write("res/sepiaRushmore.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }

    Image sepiaGiraffe = giraffe.colorTransform(new Sepia());
    try {
      sepiaGiraffe.write("res/sepiaGiraffe.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }
  }

  @Test
  public void testHorizontalRainbow() {
    Image horizontalRainbow = base.generatePattern(new HorizontalRainbow());
    try {
      horizontalRainbow.write("res/horizontalRainbow.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }
  }

  @Test
  public void testVerticalRainbow() {
    Image verticalRainbow = base.generatePattern(new VerticalRainbow());
    try {
      verticalRainbow.write("res/verticalRainbow.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }
  }

  @Test
  public void testCheckerboard() {
    Image checkerboard = base.generatePattern(new Checkerboard(25));
    try {
      checkerboard.write("res/checkerboard.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }

  }

  @Test
  public void testFrance() {
    Image france = base.generatePattern(new France());
    try {
      france.write("res/france.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }
  }

  @Test
  public void testGreece() {
    Image greece = base.generatePattern(new Greece());
    try {
      greece.write("res/greece.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }
  }

  @Test
  public void testSwitzerland() {
    Image switzerland = base.generatePattern(new Switzerland());
    try {
      switzerland.write("res/switzerland.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }
  }

  @Test
  public void testMosaic() {
    Image mosaicGiraffe = giraffe.mosaic(5000);
    try {
      mosaicGiraffe.write("res/mosaicGiraffe.jpg");
    } catch (IOException e) {
      fail("Problem writing image!");
    }
  }
}

