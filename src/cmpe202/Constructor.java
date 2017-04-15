package cmpe202;

import java.util.ArrayList;
import java.util.EnumSet;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.utils.Pair;

public class Constructor {
	
	private String constName;
	private ArrayList<Pair<String,String>> constSignature = new ArrayList();
	private EnumSet<Modifier> constModifier;
	
	public String getConstName() {
		return constName;
	}
	public void setConstName(String constName) {
		this.constName = constName;
	}
	public ArrayList<Pair<String, String>> getConstSignature() {
		return constSignature;
	}
	public void setConstSignature(ArrayList<Pair<String, String>> constSignature) {
		this.constSignature = constSignature;
	}
	
	public void setConstSignature(String parameterType, String variableName) {
		Pair<String,String> signatureparts = new Pair(parameterType,variableName);
		constSignature.add(signatureparts);
	}

	public EnumSet<Modifier> getConstModifier() {
		return constModifier;
	}
	public void setConstModifier(EnumSet<Modifier> constModifier) {
		this.constModifier = constModifier;
	}
	
	
	



}
