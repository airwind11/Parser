package cmpe202;

import java.util.ArrayList;

public class Classcode {
	
	private String className;
	private ArrayList<Attribute> classAttribute;
	private ArrayList<Method> classMethod;
	private String classModifier;
	
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	
	public ArrayList<Attribute> getClassAttribute() {
		return classAttribute;
	}
	
	
	public void setClassAttribute(ArrayList<Attribute> classAttribute) {
		this.classAttribute = classAttribute;
	}
	
	public void setClassAttribute(Attribute classAttribute) {
		
		this.classAttribute.add(classAttribute);
	}
	
		public void setClassAttribute() {
		
	
	}
	
	
	public ArrayList<Method> getClassMethod() {
		return classMethod;
	}
	public void setClassMethod(ArrayList<Method> classMethod) {
		this.classMethod = classMethod;
	}
	public String getClassModifier() {
		return classModifier;
	}
	public void setClassModifier(String classModifier) {
		this.classModifier = classModifier;
	}
	

}
