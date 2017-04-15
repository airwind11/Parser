package cmpe202;

import java.util.ArrayList;
import java.util.HashMap;

public class Interfacecode {
	
	
	private String interfaceName;
	private HashMap<String,String> associationwithclassorinterface = new HashMap();
	private ArrayList<Attribute> interfaceAttribute = new ArrayList();
	private ArrayList<Method> interfaceMethod = new ArrayList();
	private ArrayList<String> extendsInterface = new ArrayList();
	private ArrayList<String> dependancy = new ArrayList() ;
	
	public ArrayList<String> getDependancy() {
		return dependancy;
	}

	public void setDependancy(ArrayList<String> dependancy) {
		this.dependancy = dependancy;
	}
	
	public void setDependancy(String dependancy) {
		this.dependancy.add(dependancy);
	}

	public HashMap<String, String> getAssociationwithclassorinterface() {
		return associationwithclassorinterface;
	}

	public void setAssociationwithclassorinterface(HashMap<String, String> associationwithclassorinterface) {
		this.associationwithclassorinterface = associationwithclassorinterface;
	}
	
	public void setAssociationwithclassorinterface(String association,String multiplicity) {
		this.associationwithclassorinterface.put(association, multiplicity);
	}

	public ArrayList<String> getExtendsInterface() {
		return extendsInterface;
	}

	public void setExtendsInterface(ArrayList<String> extendsInterface) {
		this.extendsInterface = extendsInterface;
	}
	
	public String getInterfaceName() {
		return interfaceName;
	}
	
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}
	
	public ArrayList<Attribute> getInterfaceAttribute() {
		return interfaceAttribute;
	}
	
	public void setInterfaceAttribute(ArrayList<Attribute> interfaceAttribute) {
		this.interfaceAttribute = interfaceAttribute;
	}
	
	public void setInterfaceAttribute(Attribute interfaceAttribute) {
		this.interfaceAttribute.add(interfaceAttribute);
	}
	
	public ArrayList<Method> getInterfaceMethod() {
		return interfaceMethod;
	}
	
	public void setInterfaceMethod(ArrayList<Method> interfaceMethod) {
		this.interfaceMethod = interfaceMethod;
	}
	
	public void setInterfaceMethod(Method interfaceMethod) {
		this.interfaceMethod.add(interfaceMethod);
	}
	
	public ArrayList<String> getextendsInterface() {
		return extendsInterface;
	}
	
	public void setextendsInterface(ArrayList<String> extendsInterface) {
		this.extendsInterface = extendsInterface;
	}
	
	public void setextendsInterface(String extendsInterface) {
		this.extendsInterface.add(extendsInterface);
	}
	
}
