package cmpe202;

import java.util.ArrayList;
import java.util.HashMap;

public class Output {
	
	private HashMap<String,Classcode> allclasses = new HashMap();
	private HashMap<String,Interfacecode> allinterfaces = new HashMap();
	
	
	public HashMap<String,Classcode> getAllclasses() {
		return allclasses;
	}
	
	
	public void setAllclasses(HashMap<String,Classcode> allclasses) {
		this.allclasses = allclasses;
	}
	
	public void setAllclasses(String className,Classcode classfound) {
		this.allclasses.put(className, classfound);
	}
	
	public HashMap<String,Interfacecode> getAllinterfaces() {
		return allinterfaces;
	}
	
	public void setAllinterfaces(HashMap<String,Interfacecode> allinterfaces) {
		this.allinterfaces = allinterfaces;
	}
	
	public void setAllinterfaces(String interfacename,Interfacecode interfacefound) {
		this.allinterfaces.put(interfacename, interfacefound);
	}

}
