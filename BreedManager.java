package breeding;

import java.util.*;
import java.util.stream.*;

public class BreedManager {
  public static int MIN_AGE = 16;
  public static final String REGEX = ", ";
  
  public static String defineEyeColor(Human child, Human[] parents, Human[] humans) {
	String eyeColor = EyeColors.BROWN;
	String nameOfFatherInLaw = BreedManager.findParentName(child, humans, true);
	boolean areParentsBluеEyed = parents[0].getEyeColor().equals(EyeColors.BLUE) && parents[0].getEyeColor().equals(EyeColors.BLUE);
	boolean areFatherAndFatherInLawBluеEyed = parents[0].getEyeColor().equals(EyeColors.BLUE) && parents[1].getParentNames()[0].equals(nameOfFatherInLaw);
	
	if (areParentsBluеEyed || areFatherAndFatherInLawBluеEyed) {
	  return EyeColors.BLUE;
	}
	
	return eyeColor;
  }
  
  public static int calculateIndex(int maxLimit) {
	Random generator = new Random();
	int index = -1;
	
	do {
	  index = generator.nextInt();
	} while (index > maxLimit);
	
	return index;
  }
  
  public static String findParentName(Human human, Human[] parents, boolean isParentAFather) {
	List<String> parentalNames = new ArrayList<String>();
	int i = 0;
	List<String> result = null;
	String parent = null;
	
	if (isParentAFather) {
	  for (; i < parents.length; i++) {
		parentalNames.add(parents[0].getName());
	  }
	  
	  final String PARENT_NAME = human.getParentNames()[0];
	  result = parentalNames.stream().filter(currentName -> PARENT_NAME.equals(currentName)).collect(Collectors.toList());
	} 
	else {
	  for (; i < parents.length; i++) {
		parentalNames.add(parents[1].getName());
	  }
	  
	  final String PARENT_NAME = human.getParentNames()[1];
	  result = parentalNames.stream().filter(currentName -> PARENT_NAME.equals(currentName)).collect(Collectors.toList());
	}
	
	parent = result.get(0);
	
	return parent;
  }
  
  public static Human[] makeHumans(String[] lines) {
	String[] tmp = null;
	Human newHuman = null;
	Human[] humans = new Human[(int) lines.length];
	
	for (int i = 0; i < humans.length; i++) {
	  tmp = lines[i].split(BreedManager.REGEX);
	  newHuman = new Human();
	  newHuman.setName(tmp[0]);
	  
	  if (tmp[1].equals(EyeColors.BLUE) || tmp[1].equals(EyeColors.BROWN)) {
		newHuman.setEyeColor(tmp[1]);
	  }
	  else {
		newHuman.setEyeColor("");
	  }
	  
	  newHuman.setAge(Integer.parseInt(tmp[2]));
	  
	  if (tmp[3].equals(Genders.MALE)) {
		newHuman.setGender(tmp[3]);
	  }
	  else {
		newHuman.setGender(Genders.FEMALE);
	  }
	  
	  humans[i] = newHuman;
	}
	
	return humans;
  }
  
  public static Human[] selectCouple(Human[] parents) {
	int index = -1;
	Human[] couple = new Human[2];
	
	while (parents[index].getGender() == Genders.FEMALE && parents[index].getAge() < BreedManager.MIN_AGE) {
	  index = BreedManager.calculateIndex(parents.length);
	}
	couple[0] = parents[index];
	
	while (parents[index].getGender() == Genders.MALE && parents[index].getAge() < BreedManager.MIN_AGE) {
	  index = BreedManager.calculateIndex(parents.length);
	}
	couple[1] = parents[index];
	
	return couple;
  }
}
