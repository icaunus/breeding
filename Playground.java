package breeding;

import java.io.*;

public class Playground {
  public static void main(String[] args) {
	FileInputStream fis = null;
	FileOutputStream fos = null;
	String[] lines = null;
 	  
	try {
	  fis = new FileInputStream(FileManager.FILE_NAME);
	  lines = FileManager.read(fis);
		
	  for (int i = 0; i < lines.length; i++) {
		System.out.println(lines[i]);
	  }
	} 
	catch (FileNotFoundException fnfe) {
	  fnfe.printStackTrace(System.err);
	}
	  
    try {
      fos = new FileOutputStream(FileManager.FILE_NAME);
      FileManager.write(fos, lines);
    }
    catch(FileNotFoundException fnfe) {
      fnfe.printStackTrace(System.err);
    }
  }
}
