package cmpe202;

import java.util.ArrayList;

public class Output {
	
	private ArrayList<Classcode> allclasses = new ArrayList();
	private ArrayList<Interfacecode> allinterfaces = new ArrayList();
	
	public ArrayList<Classcode> getAllclasses() {
		return allclasses;
	}
	
	
	public void setAllclasses(ArrayList<Classcode> allclasses) {
		this.allclasses = allclasses;
	}
	
	public void setAllclasses(Classcode classfound) {
		this.allclasses.add(classfound);
	}
	
	public ArrayList<Interfacecode> getAllinterfaces() {
		return allinterfaces;
	}
	
	public void setAllinterfaces(ArrayList<Interfacecode> allinterfaces) {
		this.allinterfaces = allinterfaces;
	}
	
	public void setAllinterfaces(Interfacecode interfacefound) {
		this.allinterfaces.add(interfacefound);
	}
	

}
