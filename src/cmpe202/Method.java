package cmpe202;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;

import com.github.javaparser.ast.Modifier;

public class Method {
	
	private String methodName;
	private String returnType;
	private String methodSignature;
	private EnumSet<Modifier> methodModifier;
	private Boolean staticYN = false;
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

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getMethodSignature() {
		return methodSignature;
	}

	public void setMethodSignature(String methodSignature) {
		this.methodSignature = methodSignature;
	}

	public EnumSet<Modifier> getMethodModifier() {
		return methodModifier;
	}

	public void setMethodModifier(EnumSet<Modifier> methodModifier) {
		this.methodModifier = methodModifier;
	}

	public Boolean getStaticYN() {
		return staticYN;
	}

	public void setStaticYN(Boolean staticYN) {
		this.staticYN = staticYN;
	}

	
	
}
