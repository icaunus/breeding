package breeding;

import java.io.*;

public class Playground {
  public static void main(String[] args) {
	FileInputStream fis = null;
	FileOutputStream fos = null;
	String[] lines = null;
	Human[] humans = null, couple = null;
	String eyeColor = "";
 	  
	try {
	  fis = new FileInputStream(FileManager.FILE_NAME);
	  lines = FileManager.read(fis);
	} 
	catch (FileNotFoundException fnfe) {
	  fnfe.printStackTrace(System.err);
	}
	
	humans = BreedManager.makeHumans(lines);
	
	  for (int i = 0; i < humans.length; i++) {
		System.out.println(humans[i].getName() + ", " + humans[i].getParentNames()[0] + ", " + humans[i].getParentNames()[1]);
	  }
	
    couple = BreedManager.selectCouple(humans);
    eyeColor = BreedManager.defineEyeColor(humans[0], couple, humans);
    System.out.println("Eye color: " + eyeColor);
  }
}
