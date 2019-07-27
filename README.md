# Images: Model, View, Controller (Version 3.0)
### Authors
George Dunnery & Jake Feinbaum

### Image Citations
The images used in our project were sourced from [Pics4Learning.com](http://www.pics4learning.com/)

*Pics4Learning is a curated image library that is safe and free for education. Teachers and students can use the copyright-friendly photos and illustrations for classroom projects, web sites, videos, portfolios, or any other projects in an educational setting.*

Links: 

- [Mt. Rushmore](https://www.pics4learning.com/details.php?img=mt.rushmore2.jpg)
- [Giraffe](https://www.pics4learning.com/details.php?img=giraffe1234567.jpg)

## Introduction
The code contained in Assignment 10 is intended to be used as a standalone application based on the MVC design pattern. The documentation of the previous versions are included below for any users who wish to continue lower-level use of this application.

## Overview of Version 3.0
The biggest change of this version is the creation of a graphical user interface (GUI). Although all of the previously documented methods are still supported, it recommended to use the Image Editor by interacting with the GUI or by running batch scripts from the terminal. An explanation of how to use this program will follow after the updates, justification of changes and important notes are presented as relevant background information.

## Updates:
- Added GUI
  - added Features interface
  - added method read() to Controller interface
- Exposed all functionality through menus in the GUI
- Offer an area to type and execute a batch script from the GUI
- Added two launch modes from the command line
  - "-script": Run batch scripts from the terminal
  - "-interactive": Open the GUI

## Justification of Changes
##### 1. Controller interface: added method read(Scanner)
This change was made as a result of supporting the ability to run batch scripts from the GUI. The Controller which handles batch script execution reads from a file with the run method. To avoid saving to a file to run the script and deleting the file afterwards, the read method was added to sit between run and the private execution method. Run still functions the same way (converting file to scanner behind the scenes). The read method simply makes the ability to pass in a Scanner public, allowing the GUI to run batch scripts using the same, reliable code that already exists while maintaining identical functionality to the run() method.
##### 2. Program Runner Modified
The main method in the program runner was further developed to support the required launch modes for the image editor, "-script" and "-interactive". It is important to note that the command line method to run a batch script has changed:
```
// Previous call
java -jar Assignment_10.jar photos.txt

// New call with specific launch mode
java -jar Assignment_10.jar -script photos.txt
```

## Important Notes:
- GUI Batch script: The final result is not displayed, please save it to a directory from the script.
- Filepaths: Loading & Saving with Batch in -script vs. -interactive
  - Jar file is in the res/ folder, so you can refer to an image there as "giraffe.jpg".
  - The GUI is in the src/ folder, so you must specify the filepath for that image from the GUI script: "res/giraffe.jpg".
- Command line invocation has changed to include -script or -interactive launch modes

## Features
- System:
  - Load an image
  - Save an image
- Filtering: 
  - Blur
  - Sharpen
- Color Transformation:
  - Greyscale
  - Sepia
- Generated Patterns:
  - Horizontal Rainbow
  - Vertical Rainbow
  - Checkerboard (Black & White)
  - Flag of France (Ratio 2:3)
  - Flag of Greece (Ratio 2:3)
  - Flag of Switzerland (Ratio 1:1)
- Reductions:
  - Dither
  - Mosaic
- Launch Modes:
  - Script: Command line argument accepts a .txt file as a batch script
  - Interactive: GUI facilitates image editing
- Interactive Mode Only:
  - Undo
  - Redo

## How to Use the Image Editor Application
To use the image editor, you must launch it from the command line. Two launch modes are offered: interactive and script.
```
// Script launch mode
java -jar Assignment_10.jar -script [name of batch script]

// Interactive launch mode (Opens the GUI)
java -jar Assignment_10.jar -interactive
```
Details on how to use each launch mode are included below.

### 1. How to Use the GUI
The GUI was designed with convention in mind. All operations are available through menus at the top of the window, as you would expect in any other program. The File menu offers saving and loading images. The Edit menu offers undo & redo, along with many operations (blur, sharpen, dither, etc.) on existing images. The Generate menu offers the creation of several patterns including the flags of certain countries. Several buttons are also provided for easier access to many of these operations. An area to type and execute a batch script is also provided, but note that the final product will only be saved to a directory - the GUI will not show the final result of your script.

### 2. How to Use Batch Scripts
Batch scripts allow the user to write a chain of commands for the program to perform. This can be done by passing in a .txt file as the name of the batch script in the command line invocation, or by writing and executing the script from within the GUI.

### Important Foreword on Filepaths
The jar file is inside the res/ foler, so images contained within the res folder can be referred to without the "res/" prefix. However, the Program Runner is in the src/ file, so the user must include the "res/" prefix to refer to the same image! This caveat is a result of the requirement to not hardcode in any filepaths to give the user more freedom.

##### Scripting Syntax
The general syntax of scripts for this program is as follows:
```
[command] [argument1] [argument2] ...
```
#### File Commands
The following commands operate on files:
- "load": Initializes an ImageModel. Load will create an ImageModel from a file, or it can be called alone to create a default 600 x 400 blank image.
```
load
load [filename.jpg]
```
- "dimensions": Initializes a blank ImageModel with specific dimensions. This command is recommended for generating images.
```
dimensions [width] [height]
```
- "save": Writes the ImageModel to a file.
```
save [filename.jpg]
```
#### Operation Commands
The commands to modify an image are named according to their operation:
- "blur"
- "sharpen"
- "sepia"
- "greyscale"
- "dither"
- "mosaic"
```
mosaic [number of seeds]
```
- "horizontalrainbow"
- "verticalrainbow"
- "checkerboard"
```
checkerboard [size of squares]
```
- "france"
- "greece"
- "switzerland"
#### Quit Command
- "quit": Exit the program. All scripts should end with this command. This will not cause the GUI to close if executing from the GUI.

### Creating a Script
Creating a script is as easy as creating a text file and filling in some commands. Note that whitespace (i.e. new lines) are allowed for script readability. The general format of scripts should be:
1. Initialize an ImageModel with the "load" command or the "dimensions" command.
2. Perform some operation on the image using the corresponding command.
3. Write out the image using the "save" command.
4. Exit the program with the "quit" command when the script is completed.

Here is an example using an existing file:
```
load myfile.jpg
sharpen
sepia
save myfile-sepia-sharpen.jpg
quit
```

Here is an example of generating an image:
```
dimensions 1200 800
greece
save greece.jpg
quit
```
Example scripts are included in the "res" folder.

### Running a Script
1. Choose a directory to work in.
2. Place the following files inside the chosen directory:
  - The program.jar file.
  - The script.txt file.
  - All image files that are to be operated upon.
  - Note: Saved images will also be written to this directory.
3. Open the terminal and navigate to this directory.
4. Enter the following command:
```
java -jar program.jar -script commands.txt
```
5. The program will then run according to the script.

## Closing
Be sure to refer to the javadocs for further details. You are now ready to use the Image Editor program based on the MVC Design pattern!

# Images: Model and Controller (Version 2.0)
## Overview of Version 2.0
The previous documentation focused on how to write Java code that called methods in the ImageModel class to perform operations on Images. All of those methods are still supported and have not been changed. Simpler methods are now offered that take no arguments to simplify Java code that uses the ImageModel. Scripting is now supported via text files filled with commands that can be run via a .jar file. The simple method calls and scripting are detailed after the updates, justification of changes, and available features are presented as relevant background information.

## Important Notes:
- Scripting operates on a single image at a time. 
- Scripts will continue to modify the "current" image until a new one is loaded or blank dimensions are initialized.
- Generated flags will automatically be resized according to the shorter side to respect the proper ratio for a particular flag.

## Updates
- Image: Added simple method calls for every operation
- Image: getPixels() is now final
- Added Image reductions: Dither, Mosaic
- Added a Controller
- Added a scripting syntax to use with the Controller via text files

## Justification of Changes
The only change that diverges from Version 1.0 is the decision to make getPixels() a final method. This method is used in nearly every Image operation behind the scenes and must reliably return a deep copy of the 3D integer array that represents the pixels of the Image. Therefore, this method was made final to maintain the integrity of the deep copy it returns in all future extending classes and thus protect pixel data from accidental mutations.

## How To Use the Program
The two main ways to use this program are through scripting with text files and the jar file, or by calling methods in the ImageModel through your own code.
## Part 1: Scripting 
(Moved to the Documentation of Version 3.0)

## Part 2: Programming
The general procedure for Image operations is as follows:
1. Initialize an ImageModel using one of the four constructors.
```
ImageModel(String file)
ImageModel(int width, int height)
ImageModel()
ImageModel(int[][][] pixels)
```
2. Perform an operation using a method (simple commands are now supported).
```
// Version 2.0: Simple method call
Image blurredPicture = picture.blur();
// Version 1.0: Method call accepts objects of a certain type
Image blurredPicture = picture.filter(new Blur());
```
3. Save the image to a file by using the write method.
```
blurredPicture.write("directory/filename.jpg");
```
#### Simple Method Calls List
Here is a list of the newly supported simple method calls for your convenience. These methods should be invoked upon an Image object. Refer to the Image javadoc for more details.
```
- Blur:               .blur()
- Sharpen:            .sharpen()
- Sepia:              .sepia()
- Greyscale:          .greyscale()
- Dither:             .dither()
- Mosaic:             .mosiac(int seeds)
- Horizontal Rainbow: .horizontalRainbow()
- Vertical Rainbow:   .verticalRainbow()
- Checkerboard:       .checkerboard(int squareSize)
- France:             .france()
- Greece:             .greece()
- Switzerland:        .switzerland()
```
## Closing
Be sure to refer to the Java docs for further details. You are now ready to use the Model and Controller!

# Images: Model (Version 1.0)
This section preserves the documentation provided with version 1.0 for those who wish to continue using this approach. All of these methods are still supported, but it is recommended to use scripting and simple method calls unless there is reason to work on a lower level.

### Abbreviated Structure
The core class ImageModel implements the Image interface, which includes one method per category of operation that takes in a corresponding object.
```
- Interface: Image < - - - - - Class: ImageModel
  - Image filter(Filter object)
  - Image colorTransform(ColorTransform object)
  - Image generatePattern(Pattern object)
```
Each category of operations has an interface. Abstract classes were created for filtering and color transformations.
```
- Interface: Filter < - - - - - - - - - Abstract Class: AbstractFilter
  - int[][][] applyFilter(int[][][] pixels)
- Interface: ColorTransform < - - - - - Abstract Class: AbstractColorTransform
  - int[][][] applyColorTransform(int[][][] pixels)
- Interface: Pattern
  - int[][][] generatePattern(int[][][] pixels)
 ```
 Individual operations of each type (Filter, ColorTransform, Pattern) were then added by implementing an interface or extending an abstract class.

## How to Use Methods that Accept Operation Objects
### Create an ImageModel: Four Constructors
1. Read from a file.
```
ImageModel(String file)
```
2. Initialize an image to specified dimensions. Note that the color channels are not set by this constructor.
```
ImageModel(int width, int height)
```
3. Initialize a default image of 600 x 400 pixels. Note that the color channels are not set by this constructor.
```
ImageModel()
```
4. Create an image from a 3D array of integers.
```
ImageModel(int[][][] pixels)
```

### Filtering
1. Initialize an image with one of the constructors (recommend reading from a file).
2. Decide which filter to apply (blur or sharpen).
3. Invoke the filter(...) method on your ImageModel. Here is an example:
```
Image myPicture = new ImageModel("myfile.jpg");
Image blurred = myPicture.filter(new Blur());
Image sharpened = myPicture.filter(new Sharpen());
```
4. After these lines have been executed, the user has 3 images (original, blurred, sharpened).

### Color Transformations
1. Initialize an image with one of the constructors (recommend reading from a file).
2. Decide which color transformation to apply (greyscale or sepia).
3. Invoke the colorTransform(...) method on your ImageModel. Here is an example:
```
Image myPicture = new ImageModel("myfile.jpg");
Image greyPicture = myPicture.colorTransform(new Greyscale());
Image sepiaPicture = myPicture.colorTransform(new Sepia());
```
4. After these lines have been executed, the user has 3 images (original, greyscale, sepia).

### Generated Patterns
Generated patterns work a little differently. The generatePattern(...) method is invoked upon an initialized ImageModel object to set the dimensions and a new image is returned. Ratios are enforced when generating flags such that an improper ratio will be reset according to the shortest side of the ImageModel. Certain pattern objects may also take a parameter to their constructor (e.g. the checkerboard).

1. Initialize an ImageModel with the desired dimensions.
2. Decide which pattern to generate.
3. Invoke the generatePattern(...) method on your ImageModel.

Here is an example of some standard patterns:
```
Image dimensions = new ImageModel(1920, 1080);
Image vertRainbow = dimensions.generatePattern(new VerticalRainbow());
Image horizRainbow = dimensions.generatePattern(new HorizontalRainbow());
Image checker = dimensions.generatePattern(new Checkerboard(100));
```
4. After these lines have been executed, the user has 4 images (blank dimensions, 2 rainbows, checkerboard).

Flags are a special case of Patterns which enforce correct proportions automatically:
```
// No change, correct ratio is provided
Image square = new ImageModel(500, 500);
Image switzerland = square.generatePattern(new Switzerland());

// Dimensions of 'switzerland' will be set to 500 x 500 to respect the ratio (1:1)!
Image notSquare = new ImageModel(500, 600);
Image switzerland = notSquare.generatePattern(new Switzerland());

// Dimensions of 'france' and 'greece' will be set to 1200 x 800 to respect the ratio (2:3)!
Image notCorrect = new Image(1000, 800);
Image france = notCorrect.generatePattern(new France());
Image greece = notCorrect.generatePattern(new Greece());
```
## How to Add Features
### Expand Existing Category of Operations
- Filter: Add a new filter by extending AbstractFilter and writing a constructor that passes a 2D array of floats representing the kernel to the super() constructor. The abstract class can apply any kernel it is given (odd dimensions of at least 3x3).
- ColorTransform: Add a new color transformation by extending AbstractColorTransform and writing a constructor that passes a 2D array of floats representing the multiplication matrix to the super() constructor. The abstract class can apply any matrix it is given (operates on 3 8-bit color channels).
- Pattern: Add a new pattern by implementing the Pattern interface, writing a constructor that takes in any necessary arguments, and overrriding the generate(...) method with the algorithm to draw the pattern.

### Add New Category of Operations
To add a new category:
1. Write the appropriate interface (and an abstract class if possible), which includes a method with an intuitive name.
2. Add a method named after the new category to the Image interface (and ImageModel class) which takes in an object of that type as an argument.
3. Write classes for that category.
4. Invoke those operations in a similar manner to filtering, color transformation, and pattern generation.

## Closing
Be sure to refer to the Java docs for further details. You are now ready to use the ImageModel!
