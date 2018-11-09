package breeding;

import java.util.*;

public class BreedManager {
  private static String EMTPTY_STRING = "";
  public static int MIN_AGE = 16;
  public static final String REGEX = ",";
  
  private static int calculateIndex(int maxLimit) {
	return new Random().nextInt(maxLimit);
  }
  
  public static String defineEyeColor(Human child, Human[] parents, Human[] humans) {
	String eyeColor = EyeColors.BROWN;
	String nameOfFatherInLaw = BreedManager.findParentName(child, humans, true);
	boolean areParentsBluеEyed = parents[0].getEyeColor().equals(EyeColors.BLUE) && parents[1].getEyeColor().equals(EyeColors.BLUE);
	boolean areFatherAndFatherInLawBluеEyed = parents[0].getEyeColor().equals(EyeColors.BLUE) && parents[1].getParentNames()[1].equals(nameOfFatherInLaw);
	
	if (areParentsBluеEyed || areFatherAndFatherInLawBluеEyed) {
	  return EyeColors.BLUE;
	}
	
	return eyeColor;
  }
  
  private static String findParentName(Human human, Human[] parents, boolean isParentAFather) {
	int i = 0;
	String parentName = null;
	
	if (isParentAFather) {
	  for (; i < parents.length; i++) {
		if (human.getParentNames()[1].equals(parents[i].getName())) {
		  parentName = parents[i].getName();
		  break;
		}
	  }
	} 
	else {
	  for (; i < parents.length; i++) {
		if (human.getParentNames()[0].equals(parents[i].getName())) {
		  parentName = parents[i].getName();
		  break;
		}
	  }
	}
	
	return parentName;
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
		newHuman.setEyeColor("err");
	  }
	  
	  newHuman.setAge(Integer.parseInt(tmp[2]));
	  
	  if (tmp[3].equals(Genders.MALE)) {
		newHuman.setGender(tmp[3]);
	  }
	  else {
		newHuman.setGender(Genders.FEMALE);
	  }
	  
	  if (tmp[4].equals(BreedManager.EMTPTY_STRING)) {
		parentNames[1] = "UNKNOWN"; 
	  }
	  else {
		parentNames[0] = tmp[4];
	  }
	  
	  if (tmp[5].equals(BreedManager.EMTPTY_STRING)) {
		parentNames[0] = "UNKNOWN"; 
	  }
	  else {
		parentNames[1] = tmp[5];
	  }
	  
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
	  
	  if (parents[index].getGender().equals(Genders.MALE) && parents[index].getAge() >= BreedManager.MIN_AGE) {
	    break;
	  }
	};
	couple[1] = parents[index];
	
	while (true) {
	  index = BreedManager.calculateIndex(parents.length);
	  
	  if (parents[index].getGender().equals(Genders.FEMALE) && parents[index].getAge() >= BreedManager.MIN_AGE) {
	    break;
	  }
	};
	couple[0] = parents[index];
	
	return couple;
  }
}
