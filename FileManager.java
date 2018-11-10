package breeding;

import java.io.*;

public class FileManager implements Persistable {
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

  static boolean write(FileOutputStream fos, String[] humans) {
	String tmp = "";
	boolean output = false;
	
	for (int i = 0; i < humans.length; i++) {
	  tmp += humans[i] + FileManager.ROW_DELIMITER;
	}
	
	try {
	  fos.write(tmp.getBytes());
	  output = true;
	} 
	catch(IOException ioe) {
	  ioe.printStackTrace(System.err);
	  output = false;
	}
	
	return output;
  }
}
