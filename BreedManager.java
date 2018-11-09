package breeding;

import java.util.Random;

public class BreedManager {
  public static final String REGEX = ", ";
  
  public static Human breed(Human[] parents) {
	Human child = new Human();
	
	
	
	return child;
  }
  
  public static int calculateIndex(int maxLimit) {
	Random generator = new Random();
	int index = -1;
	
	while (index > maxLimit) {
	  index = generator.nextInt();
	}
	
	return index;
  }
  /*
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
  */
  public static Human[] makeParents(String[] lines) {
	String[] tmp = null;
	Human newParent = null;
	Human[] parents = new Human[(int) lines.length];
	
	for (int i = 0; i < parents.length; i++) {
	  tmp = lines[i].split(BreedManager.REGEX);
	  newParent = new Human();
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
  
  public static Human[] selectCouple(Human[] parents) {
	int index = -1;
	Human[] couple = new Human[2];
	
	while (parents[index].getGender() == Genders.FEMALE) {
	  index = BreedManager.calculateIndex(parents.length);
	}
	couple[0] = parents[index];
	
	while (parents[index].getGender() == Genders.MALE) {
	  index = BreedManager.calculateIndex(parents.length);
	}
	couple[1] = parents[index];
	
	return couple;
  }
}
