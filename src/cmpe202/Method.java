package cmpe202;

import java.util.HashMap;

public class Method {
	
	private String methodName;
	private String returnType;
	private HashMap<String,String> methodSignature;
	private String methodModifier;
	private Boolean staticYN = false;
	
	
	public String getMethodName() {
		return methodName;
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

	public HashMap<String, String> getMethodSignature() {
		return methodSignature;
	}

	public void setMethodSignature(HashMap<String, String> methodSignature) {
		this.methodSignature = methodSignature;
	}

	public String getMethodModifier() {
		return methodModifier;
	}

	public void setMethodModifier(String methodModifier) {
		this.methodModifier = methodModifier;
	}

	public Boolean getStaticYN() {
		return staticYN;
	}

	public void setStaticYN(Boolean staticYN) {
		this.staticYN = staticYN;
	}

	
	
}
