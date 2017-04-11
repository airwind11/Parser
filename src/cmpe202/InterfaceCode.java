package cmpe202;

import java.util.ArrayList;

public class Interfacecode {
	
	
	private String interfaceName;
	private ArrayList<Attribute> interfaceAttribute = new ArrayList();
	private ArrayList<Method> interfaceMethod = new ArrayList();
	private ArrayList<String> extendsInterface = new ArrayList();
	
	
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
