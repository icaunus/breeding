package breeding;

public class Parent {
  private String name;
  private String gender;
  private int age;
  private String eyeColor;
  private String[] parentNames;

  public Parent() {
  }
  
  public Parent(String name, String gender, int age, String eyeColor, String[] parentNames) {
	this.name = name;
	this.gender = gender;
	this.age = age;
	this.eyeColor = eyeColor;
	this.parentNames = parentNames;
  }

  /**
  * @return the name
  */
  public String getName() {
	return name;
  }

  /**
  * @param name the name to set
  */
  public void setName(String name) {
	this.name = name;
  }

  /**
  * @return the gender
  */
  public String getGender() {
	return gender;
  }

  /**
  * @param gender the gender to set
  */
  public void setGender(String gender) {
	this.gender = gender;
  }

  /**
  * @return the age
  */
  public int getAge() {
	return age;
  }

  /**
  * @param age the age to set
  */
  public void setAge(int age) {
	this.age = age;
  }

  /**
  * @return the color
  */
  public String getEyeColor() {
	return eyeColor;
  }

  /**
  * @param color the color to set
  */
  public void setEyeColor(String eyeColor) {
	this.eyeColor = eyeColor;
  }

  /**
  * @return the parent names
  */
  public String[] getParentNames() {
	return parentNames;
  }

  /**
  * @param parents the parents to set
  */
  public void setParentNames(String[] parentNames) {
	this.parentNames = parentNames;
  }
}
