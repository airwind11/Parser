package cmpe202;

import java.util.ArrayList;

public class Classcode {
	
	private String className;
	private ArrayList<Attribute> classAttribute = new ArrayList();
	private ArrayList<Method> classMethod = new ArrayList();
	private String classModifier;
	private String extendsclass;
	private ArrayList<String> implementsclass = new ArrayList();
	
	
	public String getExtendsclass() {
		return extendsclass;
	}

	public void setExtendsclass(String extendsclass) {
		this.extendsclass = extendsclass;
	}

	public ArrayList<String> getImplementsclass() {
		return implementsclass;
	}

	public void setImplementsclass(ArrayList<String> implementsclass) {
		this.implementsclass = implementsclass;
	}
	
	public void setImplementsclass(String implementsclass) {
		this.implementsclass.add(implementsclass);
	}


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
	
			
	public ArrayList<Method> getClassMethod() {
		return classMethod;
	}
	
	
	public void setClassMethod(ArrayList<Method> classMethod) {
		this.classMethod = classMethod;
	}
	
	public void setClassMethod(Method classMethod) {
		this.classMethod.add(classMethod);
	}
	
		
	public String getClassModifier() {
		return classModifier;
	}
		
	public void setClassModifier(String classModifier) {
		this.classModifier = classModifier;
	}
			

}
