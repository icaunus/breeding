package breeding;

public class Parent {
  private String name;
  private Genders gender;
  private int age;
  private EyeColors color;
  private String[] parents;

  public Parent() {
  }
  
  public Parent(String name, Genders gender, int age, EyeColors color, String[] parents) {
	this.name = name;
	this.gender = gender;
	this.age = age;
	this.color = color;
	this.parents = parents;
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
  public Genders getGender() {
	return gender;
  }

  /**
  * @param gender the gender to set
  */
  public void setGender(Genders gender) {
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
  public EyeColors getColor() {
	return color;
  }

  /**
  * @param color the color to set
  */
  public void setColor(EyeColors color) {
	this.color = color;
  }

  /**
  * @return the parents
  */
  public String[] getParents() {
	return parents;
  }

  /**
  * @param parents the parents to set
  */
  public void setParents(String[] parents) {
	this.parents = parents;
  }
}
