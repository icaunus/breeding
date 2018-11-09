package breeding;

import java.io.*;

public class Playground {
  public static void main(String[] args) {
	FileInputStream fis = null;
	FileOutputStream fos = null;
	String[] lines = null;
	Human mother = null;
	Human father = null;
	Human[] humans = null;
	Human[] couple = null;
	String eyeColor = "";
 	  
	try {
	  fis = new FileInputStream(FileManager.FILE_NAME);
	  lines = FileManager.read(fis);
	  fis.close();
	} 
	catch (IOException ioe) {
	  ioe.printStackTrace(System.err);
	}
	
	humans = BreedManager.makeHumans(lines);
	couple = BreedManager.selectCouple(humans);
    eyeColor = BreedManager.defineEyeColor(couple, humans);
    
    System.out.println("mother: " + couple[0].getName());
    System.out.println("father: " + couple[1].getName());
    System.out.println("child's eye color: " + eyeColor);
    
    try {
      lines = new String[humans.length];
      
      for (int i = 0; i < humans.length; i++) {
    	String human2line = "";
    	
		if (humans[i].getEyeColor().equals("x")) {
		  mother = BreedManager.findParent(humans[i].getParentNames()[0], humans);
		  father = BreedManager.findParent(humans[i].getParentNames()[1], humans);
		  couple = new Human[2];
		  couple[0] = mother;
		  couple[1] = father;
		  eyeColor = BreedManager.defineEyeColor(couple, humans);
		  humans[i].setEyeColor(eyeColor);
		}
		
		human2line += humans[i].getName() + FileManager.COLUMN_DELIMITER + humans[i].getEyeColor() + FileManager.COLUMN_DELIMITER + humans[i].getAge() + FileManager.COLUMN_DELIMITER + humans[i].getGender()
			            + FileManager.COLUMN_DELIMITER + humans[i].getParentNames()[0] + FileManager.COLUMN_DELIMITER + humans[i].getParentNames()[1];
		lines[i] = human2line;
	  }
      
      fos = new FileOutputStream(FileManager.FILE_NAME);
      FileManager.write(fos, lines);
      fos.close();
	} 
    catch (Exception fnfe) {
	  fnfe.printStackTrace(System.err);
	}
  }
}
