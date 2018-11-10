package breeding;

import java.io.*;

public class FileManager implements Persistable { // /home/human/Eclipse/neon/workspace/breeding/src/breeding/
  static final String SOURCE_FILE_NAME = "source.csv";
  static final String OUTPUT_FILE_NAME = "output.csv";
  static final String UNKNOWN_VALUE = "x";
  static final String COLUMN_DELIMITER = ",";
  static final String ROW_DELIMITER = "\n";

  static String[] read(FileInputStream fis) {
	int avaialableBytes = -1;
	byte[] buffer = null;
	
    try {
      avaialableBytes = fis.available();
	  buffer = new byte[avaialableBytes];
	  fis.read(buffer);
	} 
    catch (IOException ioe) {
	  ioe.printStackTrace(System.err);
	}
    
    return new String(buffer).split(FileManager.ROW_DELIMITER);
  }

  static void write(FileOutputStream fos, String[] humans) {
	String tmp = "";
	
	for (int i = 0; i < humans.length; i++) {
	  tmp += humans[i] + FileManager.ROW_DELIMITER;
	}
	
	try {
	  fos.write(tmp.getBytes());
	} 
	catch(FileNotFoundException fnfe) {
	  fnfe.printStackTrace(System.err);
	} 
	catch (IOException ioe) {
	  ioe.printStackTrace(System.err);
	}
  }
}
