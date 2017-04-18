package cmpe202;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.utils.Pair;

public class Method {
	
	private String methodName;
	private String returnType;
	private ArrayList<Pair<String,String>> methodSignature = new ArrayList();
	private EnumSet<Modifier> methodModifier;
	private Boolean hasget = false;
	private Boolean hasset = false;
	private Boolean includedinUML = true;
	private String shortName ;
	


	public String getMethodName() {
		return methodName;
	}

	public Boolean getHasget() {
		return hasget;
	}

	public Boolean getIncludedinUML() {
		return includedinUML;
	}

	public void setIncludedinUML(Boolean includedinUML) {
		this.includedinUML = includedinUML;
	}

	public void setHasget(Boolean hasget) {
		this.hasget = hasget;
	}

	public Boolean getHasset() {
		return hasset;
	}

	public void setHasset(Boolean hasset) {
		this.hasset = hasset;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getReturnType() {
		return returnType;
	}

	public ArrayList<Pair<String, String>> getMethodSignature() {
		return methodSignature;
	}

	public void setMethodSignature(ArrayList<Pair<String, String>> methodSignature) {
		this.methodSignature = methodSignature;
	}
	
	public void setMethodSignature(String parameterType, String variableName) {
		Pair<String,String> signatureparts = new Pair(parameterType,variableName);
		methodSignature.add(signatureparts);
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}



	public EnumSet<Modifier> getMethodModifier() {
		return methodModifier;
	}

	public void setMethodModifier(EnumSet<Modifier> methodModifier) {
		this.methodModifier = methodModifier;
	}

	

	
	
}
