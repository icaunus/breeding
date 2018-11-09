package breeding;

import java.util.Random;

public class BreedManager {
  public static final String REGEX = ", ";
  
  public static long calculateIndex(long maxLimit) {
	Random generator = new Random();
	long index = -1;
	
	index = generator.nextLong();
	
	return index;
  }
  
  public static Object findFieldValue(String className, String fieldName) {
	Class<?> clss = null;
	Object fieldValue = null;
	
	try {
	  clss = Class.forName(className);
	} 
	catch (ClassNotFoundException cnfe) {
	  cnfe.printStackTrace(System.err);
	  return null;
	}
	
	try {
	  fieldValue = clss.getField(fieldName);
	} 
	catch (NoSuchFieldException | SecurityException e) {
	  e.printStackTrace(System.err);
	}
	
	return fieldValue;
  }
  
  public static Parent[] makeParents(String[] lines) {
	String[] tmp = null;
	Parent newParent = null;
	Parent[] parents = new Parent[(int) lines.length];
	
	for (int i = 0; i < parents.length; i++) {
	  tmp = lines[i].split(BreedManager.REGEX);
	  newParent = new Parent();
	  newParent.setName(tmp[0]);
	  
	  if (tmp[1].equals(EyeColors.BLUE)) {
	    newParent.setEyeColor(tmp[1]);
	  }
	  else {
		newParent.setEyeColor(EyeColors.BROWN);
	  }
	  
	  newParent.setAge(Integer.parseInt(tmp[2]));
	  
	  if (tmp[3].equals(Genders.MALE)) {
	    newParent.setGender(tmp[3]);
	  }
	  else {
		newParent.setGender(Genders.FEMALE);
	  }
	  
	  parents[i] = newParent;
	}
	
	return parents;
  }
  
  public static Parent[] selectParents(Parent[] parents) {
	long index0 = BreedManager.calculateIndex(maxLimit);
	long index1 = -1;
	Parent father = null, mother = null;
	
	while () {
	  
	}
	
	try {
	  /*
	  if (parents[0].getGender() != Genders.MALE) {
		throw new IllegalArgumentException("First parent fas to be male.");
	  }
	  
	  if (parents[1].getGender() != Genders.FEMALE) {
		throw new IllegalArgumentException("First parent fas to be male.");
	  }
	  */
	  
	}
	catch(IllegalArgumentException iae) {
	  iae.printStackTrace(System.err);
	}
	
	return null;
  }
}
