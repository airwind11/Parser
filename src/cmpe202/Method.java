package cmpe202;

import java.util.HashMap;

public class Method {
	
	private String methodName;
	private String returnType;
	private HashMap<String,String> methodSignature;
	private String methodModifier;
	private Boolean staticYN;
	
	
	private Method()
	{		
	 staticYN = false;
	}

	public static Method createMethod(Object obj)
	{
		if(obj instanceof Classcode || obj instanceof InterfaceCode)
		{
			 return new Method();
		}
		return null;
		
	}
	
	
}
