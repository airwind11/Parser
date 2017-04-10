package cmpe202;

import java.util.ArrayList;

public class Interfacecode {
	
	
	private String interfaceName;
	private ArrayList<Attribute> interfaceAttribute;
	private ArrayList<Method> interfaceMethod;
	private ArrayList<String> implementsInterface;
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
	public ArrayList<Method> getInterfaceMethod() {
		return interfaceMethod;
	}
	public void setInterfaceMethod(ArrayList<Method> interfaceMethod) {
		this.interfaceMethod = interfaceMethod;
	}
	public ArrayList<String> getImplementsInterface() {
		return implementsInterface;
	}
	public void setImplementsInterface(ArrayList<String> implementsInterface) {
		this.implementsInterface = implementsInterface;
	}
	
	
}
