package breeding;

import java.io.*;

public class Playground {
  public static void main(String[] args) {
	FileInputStream fis = null;
	FileOutputStream fos = null;
	String[] lines = null;
	Human[] humans = null;
	Human child = null;
	String[] couple = new String[2];
	String eyeColor = "";
 	  
	try {
	  fis = new FileInputStream(FileManager.FILE_NAME);
	  lines = FileManager.read(fis);
	} 
	catch (FileNotFoundException fnfe) {
	  fnfe.printStackTrace(System.err);
	}
	
	humans = BreedManager.makeHumans(lines);
	child = humans[1];
    couple[0] = humans[1].getParentNames()[0]; // BreedManager.selectCouple(humans);
    couple[1] = humans[1].getParentNames()[1];
    System.out.println("child: " + humans[1].getName());
    System.out.println("mother: " + couple[0]);
    System.out.println("father: " + couple[1]);
    eyeColor = BreedManager.defineEyeColor(child, humans);
    System.out.println("eye color: " + eyeColor);
  }
}
