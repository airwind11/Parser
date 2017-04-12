package cmpe202;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.management.relation.RelationType;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ParserEngine  {
			
			
	public static void readfile(CompilationUnit cu,Output listofclassesandinterfaces)
	{	
		//try {
           new VoidVisitorAdapter<Object>() {
           
        	@Override
               public void visit(ClassOrInterfaceDeclaration n, Object arg) {
        		if(n.isInterface())
        			{
        			Interfacecode interfacefound = new Interfacecode();
        			interfacefound.setInterfaceName(n.getNameAsString());
        			//System.out.println(" * " + interfacefound.getInterfaceName());
        			
        			List<ClassOrInterfaceType> extendList = n.getExtendedTypes();
       	         
       	         for (ClassOrInterfaceType d : extendList)
       	        	interfacefound.setextendsInterface(d.getNameAsString());;
       	        
       	         for (String m : interfacefound.getextendsInterface())
       	        	 //System.out.println(" * " + m);
       	         
       	         ((Output) arg).setAllinterfaces(n.getNameAsString(),interfacefound);
       	 
       	  		      	  		
       	  		
   			    super.visit(n, interfacefound);
        		}
        		
        		else
        			
        		{
        			Classcode classfound = new Classcode();
        			classfound.setClassName(n.getNameAsString());
        			 //System.out.println(" * " + classfound.getClassName());
        			classfound.setClassModifier(n.getModifiers().toString());
        			//System.out.println(" * " + classfound.getClassModifier());
        			
        			
        			List<ClassOrInterfaceType> extendList = n.getExtendedTypes();
        	        
        			for (ClassOrInterfaceType c : extendList) 
        			   classfound.setExtendsclass(c.getNameAsString());
        	             
        			//System.out.println(" * " + classfound.getExtendsclass());
        	            
        	         List<ClassOrInterfaceType> implementList = n.getImplementedTypes();
        	         
        	         for (ClassOrInterfaceType d : implementList)
        	          classfound.setImplementsclass(d.getNameAsString()); 
        	         
        	         for (String m : classfound.getImplementsclass())
        	        	 //System.out.println(" * " + m);
           	          
        	        
        			((Output) arg).setAllclasses(n.getNameAsString(),classfound);
        	
        			 super.visit(n, classfound);     		        			         			
        		}
        	}
                   
           @Override
                public void visit(MethodDeclaration n, Object arg) 
           {
        	     Method methodfound = new Method();
        	     methodfound.setMethodName(n.getName().toString());
        	     System.out.println(methodfound.getMethodName());
        	     
        	     if(methodfound.getMethodName().startsWith("get"))
        	     {
        	    	 methodfound.setHasget(true);
        	    	 methodfound.setShortName(methodfound.getMethodName().substring(3));
        	    	 //System.out.println(methodfound.getHasget());
        	    	   }
        	     else if(methodfound.getMethodName().startsWith("set"))
        	     {
        	    	 methodfound.setHasset(true);
        	    	 methodfound.setShortName(methodfound.getMethodName().substring(3));
        	    	 //System.out.println(methodfound.getHasset());
        	     }
        	     //System.out.println(methodfound.getShortName());
        	     
        	     
        	     methodfound.setMethodModifier(n.getModifiers());
        	    // System.out.println(methodfound.getMethodModifier());
        	     
        	     
        	     methodfound.setReturnType(n.getDeclarationAsString(false, false, false).split(" ")[0]);
        	     //System.out.println(methodfound.getReturnType());
        	     
        	     //System.out.println();
 
        	    // System.out.println(n);
        	 //  System.out.println(" * " + n.getName());        
        	     super.visit(n, arg);
           }
            
                       
            @Override
                 public void visit(FieldDeclaration n, Object arg) 
            {
            	Attribute attributefound = new Attribute();
            	attributefound.setAttributeType(n.getElementType().toString());
            	//System.out.println(attributefound.getAttributeType());
            	EnumSet<Modifier> modifierList = n.getModifiers();
        		attributefound.setAttributeModifier(modifierList);
        		 
        		 for (Modifier g : attributefound.getAttributeModifier())
            	 {
        			//System.out.println(g.asString());
            		
            	 }
            	
            	if((n.getElementType().getMetaModel().toString()=="ClassOrInterfaceType") && (!attributefound.getAttributeType().equals("String")))
            	{
            		attributefound.setPrimitiveType(false);
            	}
            	
            	//System.out.println(attributefound.getPrimitiveType());
            	
            	if(!attributefound.getPrimitiveType())
            	{
            		
            		List<Node> po = n.getElementType().getChildNodes();
            		
            		if(po.size()>1)
            		{
            			//System.out.println(po.get(1));
            			if(arg instanceof Classcode)
            				 	{
            						((Classcode) arg).setAssociationwithclassorinterface(po.get(1).toString(),"multiple");
            						System.out.println(((Classcode) arg).getAssociationwithclassorinterface());
            				 	}
            					else
            					{
            						((Interfacecode) arg).setAssociationwithclassorinterface(po.get(1).toString(),"multiple");
            						System.out.println(((Interfacecode) arg).getAssociationwithclassorinterface());
            					}           				
            				}
            			
            		
            		else
            		{
            			if(arg instanceof Classcode)
       				 		{
            					((Classcode) arg).setAssociationwithclassorinterface(po.get(0).toString(),"single");
            					System.out.println(((Classcode) arg).getAssociationwithclassorinterface());
       				 		}
            			else
       						{
       							((Interfacecode) arg).setAssociationwithclassorinterface(po.get(0).toString(),"single");
       							System.out.println(((Interfacecode) arg).getAssociationwithclassorinterface());
       				       	}
            		}
            	}
            		
            		//System.out.println(attributefound.getAssociationwithclassorinterface());
            		//System.out.println(attributefound.getMultiplicity());
            		
            	/*	
            	 for(Node w:n.getChildNodes())
            	{
            		//System.out.println(w);
            		 System.out.println(n.getElementType().getChildNodes());
            		System.out.println(w.getChildNodes());
            		//System.out.println(w.get);
            	     //System.out.println(w.getMetaModel());
            		
            	}
           
            	 for(Node w:n.getElementType().getChildNodes())
             	{
             		 //System.out.println(w);
             		 //System.out.println(n.getElementType().getChildNodes());
             		//System.out.println(w.getChildNodes());
             		//System.out.println(w.get);
             	     //System.out.println(w.getMetaModel());
             		
             	}
             	*/
             	 
            	 
            	
            	
        		 for (VariableDeclarator v : n.getVariables())
            	 	{
        			 attributefound.setAttributeName(v.getNameAsString());
        			
        			//System.out.println(attributefound.getAttributeName());
            	 	}
        		 
            	 if(arg instanceof Classcode)
          	   	{            		 
            		((Classcode) arg).setClassAttribute(attributefound);
            		
            		for(Attribute y: ((Classcode) arg).getClassAttribute())
					{
            			//System.out.println(y.getAttributeName());
					}
            		
          	   }
          	   
          	   else
          	   {
          		 ((Interfacecode) arg).setInterfaceAttribute(attributefound);
          		 
          		 	for(Attribute y: ((Interfacecode) arg).getInterfaceAttribute())
          		 			{
          		 				//System.out.println(y.getAttributeName());
          		 			}
        		
          	   }
       
            	super.visit(n, arg);
            }
            
             @Override
                  public void visit(ConstructorDeclaration n, Object arg) {
                   System.out.println(" # " + n.toString());
                   super.visit(n, arg);
             	}
           }.visit(cu, listofclassesandinterfaces);
           
          System.out.println(); // empty line
     // } 
	//catch ( Exception e) {
    //     new RuntimeException(e);
    //  }
       
	}
}
