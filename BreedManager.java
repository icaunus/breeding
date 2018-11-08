package breeding;

public class BreedManager {
  public Parent[] selectParents(Parent[] breeders) {
	return null;
  }
  
  public Object getField(String className, String fieldName) {
	Class clss = null;
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
}
