package breeding;

import java.io.*;

public class FileManager implements Persistable {
  static final String FILE_NAME = "/home/human/Eclipse/neon/workspace/breeding/src/breeding/data.csv";
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
