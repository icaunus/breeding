package breeding;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class BreedManagerTest {
  FileInputStream fis = null;
  String[] lines = null;
  Human mother = null;
  Human father = null;
  Human[] humans = null;
  Human[] couple = null;
  
  public BreedManagerTest() {
	try {
	  fis = new FileInputStream(FileManager.SOURCE_FILE_NAME);
	  lines = FileManager.read(fis);
	  fis.close();
	} 
	catch (IOException ioe) {
	  ioe.printStackTrace(System.err);
	}
	
	humans = BreedManager.makeHumans(lines);
	couple = BreedManager.selectCouple(humans);
  }
  
  @Test
  public void testDefineEyeColor() {
	Human[] parents = {humans[5], humans[7]};
	
	assertEquals("кафяв", BreedManager.defineEyeColor(parents, humans));
  }

  @Test
  public void testFindParent() {
	assertEquals(humans[4].getParentNames()[1], BreedManager.findParent("Румен", humans).getName());
  }

  @Test
  public void testMakeHumans() {
	assertEquals(8, humans.length);
  }

  @Test
  public void testSelectCoupleMother() {
	assertEquals("жена", couple[0].getGender());
  }

  @Test
  public void testSelectCoupleFather() {
	assertEquals("мъж", couple[1].getGender());
  }
}
