package cmpe202;

import java.util.EnumSet;
import java.util.HashMap;

import com.github.javaparser.ast.Modifier;

public class Attribute {

	private String attributeName;
	private String attributeType;
	private EnumSet<Modifier> attributeModifier;
	private Boolean primitiveType = true;
	private Boolean staticYN = false;
	private Boolean ordered = false;
	private String multiplicity = "Single";
	
	//private String associationwithclassorinterface;	
	/*
	public String getAssociationwithclassorinterface() {
		return associationwithclassorinterface;
	}
	public void setAssociationwithclassorinterface(String associationwithclassorinterface) {
		this.associationwithclassorinterface = associationwithclassorinterface;
	}
	*/
	
	public Boolean getPrimitiveType() {
		return primitiveType;
	}
	public void setPrimitiveType(Boolean primitiveType) {
		this.primitiveType = primitiveType;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}


	public String getAttributeType() {
		return attributeType;
	}
	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}
	public Boolean getOrdered() {
		return ordered;
	}
	public void setOrdered(Boolean ordered) {
		this.ordered = ordered;
	}
	public String getMultiplicity() {
		return multiplicity;
	}
	public void setMultiplicity(String multiplicity) {
		this.multiplicity = multiplicity;
	}
	public EnumSet<Modifier> getAttributeModifier() {
		return attributeModifier;
	}
	public void setAttributeModifier(EnumSet<Modifier> attributeModifier) {
		this.attributeModifier = attributeModifier;
	}
	public Boolean getStaticYN() {
		return staticYN;
	}
	public void setStaticYN(Boolean staticYN) {
		this.staticYN = staticYN;
	}
	
		
}
