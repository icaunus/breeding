package breeding;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class FileManagerTest {
  
  @Test
  public void testRead() {
	FileInputStream fis = null;
	String[] lines = new String[8];
	
	try {
	  fis = new FileInputStream(FileManager.SOURCE_FILE_NAME);
	  lines = FileManager.read(fis);
	  fis.close();
	} 
	catch (IOException ioe) {
	  ioe.printStackTrace(System.err);
	}
	
	assertEquals(8, lines.length);
  }

  @Test
  public void testWrite() {
	FileOutputStream fos = null;
	String[] lines = {"Alf", "Betty", "Charlie", "Delta"};
	boolean wasSuccess = false;
	
	try {
	  fos = new FileOutputStream("/tmp/test_output.csv");
	  wasSuccess = FileManager.write(fos, lines);
	  fos.close();
	  assertEquals(true, wasSuccess);
	  
	} 
	catch (IOException ioe) {
	  ioe.printStackTrace(System.err);
	}
  }
}
