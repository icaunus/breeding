package breeding;

import java.io.*;

interface Persistable {
  static String[] read(InputStream inStream) {
	return null;
  }
  
  static void write(OutputStream outStream, String[] breeders) {
  }
}
