package cmpe202;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Classcode {
	
	private String className;
	private ArrayList<Attribute> classAttribute = new ArrayList();
	private ArrayList<Method> classMethod = new ArrayList();
	private ArrayList<Constructor> classConstructor = new ArrayList();
	private HashMap<String,String> associationwithclassorinterface = new HashMap();
	private String classModifier="";
	private String extendsclass ="";
	private ArrayList<String> implementsclass = new ArrayList();
	private HashSet<String> dependancy = new HashSet() ;
	
	
	
	
	
	public HashSet<String> getDependancy() {
		return dependancy;
	}

	public void setDependancy(HashSet<String> dependancy) {
		this.dependancy = dependancy;
	}

	public ArrayList<Constructor> getClassConstructor() {
		return classConstructor;
	}

	public void setClassConstructor(ArrayList<Constructor> classConstructor) {
		this.classConstructor = classConstructor;
	}
	
	public void setClassConstructor(Constructor classConstructor) {
		this.classConstructor.add(classConstructor);
	}
	
	

	public void setDependancy(String dependancy) {
		this.dependancy.add(dependancy);
	}
	

	public HashMap<String,String> getAssociationwithclassorinterface() {
		return associationwithclassorinterface;
	}

	public void setAssociationwithclassorinterface(HashMap<String,String> associationwithclassorinterface) {
		this.associationwithclassorinterface = associationwithclassorinterface;
	}
	
	public void setAssociationwithclassorinterface(String association,String multiplicity) {
		this.associationwithclassorinterface.put(association, multiplicity);
	}
	
	public void lookforgetterSetter()
	{
		
	}
	
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
