package breeding;

import java.util.*;

public class BreedManager {
  public static int MIN_AGE = 16;
  public static final String REGEX = ",";
  
  private static int calculateIndex(int maxLimit) {
	return new Random().nextInt(maxLimit);
  }

  public static String defineEyeColor(Human[] parents, Human[] humans) {
	Human mother = parents[0];
	Human father = parents[1];
	Human fatherInLaw = BreedManager.findParent(mother.getParentNames()[1], humans);
	boolean areParentsBluеEyed = mother.getEyeColor().equals(EyeColors.BLUE) && father.getEyeColor().equals(EyeColors.BLUE);
	boolean areFatherAndFatherInLawBluеEyed = father.getEyeColor().equals(EyeColors.BLUE) && fatherInLaw.getEyeColor().equals(EyeColors.BLUE);
	
	if (areParentsBluеEyed || areFatherAndFatherInLawBluеEyed) {
	  return EyeColors.BLUE;
	}

	return EyeColors.BROWN;
  }
  
  static Human findParent(String parentName, Human[] humans) {
	int i = 0;
	Human parent = new Human();
	
	for (; i < humans.length; i++) {
	  if (humans[i].getName().equals(parentName)) {
		parent = humans[i];
	    break;
	  }
	}
	
	return parent;
  }

  public static Human[] makeHumans(String[] lines) {
	Human newHuman = null;
	Human[] humans = new Human[(int) lines.length];
	
	for (int i = 0; i < lines.length; i++) {
	  String[] tmp = lines[i].split(BreedManager.REGEX);
	  String[] parentNames = new String[2];
	  
	  newHuman = new Human();
	  newHuman.setName(tmp[0]);
	  
	  if (tmp[1].equals(EyeColors.BLUE) || tmp[1].equals(EyeColors.BROWN)) {
		newHuman.setEyeColor(tmp[1]);
	  }
	  else {
		newHuman.setEyeColor("x");
	  }
	  
	  newHuman.setAge(Integer.parseInt(tmp[2]));
	  
	  if (tmp[3].equals(Genders.MALE)) {
		newHuman.setGender(tmp[3]);
	  }
	  else {
		newHuman.setGender(Genders.FEMALE);
	  }
	  
	  parentNames[0] = tmp[4];
      parentNames[1] = tmp[5];
	  newHuman.setParentNames(parentNames);
	  
	  humans[i] = newHuman;
	}
	
	return humans;
  }
  
  public static Human[] selectCouple(Human[] parents) {
	int index = -1;
	Human[] couple = new Human[2];
	
	while (true) {
	  index = BreedManager.calculateIndex(parents.length);
	  
	  if (parents[index].getGender().equals(Genders.FEMALE) && parents[index].getAge() >= BreedManager.MIN_AGE) {
	    break;
	  }
	};
	couple[0] = parents[index];
	
	while (true) {
	  index = BreedManager.calculateIndex(parents.length);
	  
	  if (parents[index].getGender().equals(Genders.MALE) && parents[index].getAge() >= BreedManager.MIN_AGE) {
	    break;
	  }
	};
	couple[1] = parents[index];
	
	return couple;
  }
}
