package cmpe202;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.management.relation.RelationType;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ParserEngine  {
			
			
	public static void readfile(CompilationUnit cu,Output listofclassesandinterfaces)
	{	
		try {
           new VoidVisitorAdapter<Object>() {
           
        	@Override
               public void visit(ClassOrInterfaceDeclaration n, Object arg) {
        		if(n.isInterface())
        			{
        			Interfacecode interfacefound = new Interfacecode();
        			interfacefound.setInterfaceName(n.getNameAsString());
        			System.out.println(" * " + interfacefound.getInterfaceName());
        			
        			List<ClassOrInterfaceType> extendList = n.getExtendedTypes();
       	         
       	         for (ClassOrInterfaceType d : extendList)
       	        	interfacefound.setextendsInterface(d.getNameAsString());;
       	        
       	         for (String m : interfacefound.getextendsInterface())
       	        	 System.out.println(" * " + m);
       	         
       	  	((Output) arg).setAllinterfaces(interfacefound);
       	 
   		 List<Interfacecode> tAllcla = ((Output) arg).getAllinterfaces();
   			 
   			 for (Interfacecode e : tAllcla) 
	         	{
	        	
	        	 System.out.println(" * " + e.getInterfaceName());
	            } 
        			       	
        			}
        		else
        		{
        			Classcode classfound = new Classcode();
        			classfound.setClassName(n.getNameAsString());
        			 System.out.println(" * " + classfound.getClassName());
        			classfound.setClassModifier(n.getModifiers().toString());
        			System.out.println(" * " + classfound.getClassModifier());
        			
        			
        			List<ClassOrInterfaceType> extendList = n.getExtendedTypes();
        	        
        			for (ClassOrInterfaceType c : extendList) 
        			   classfound.setExtendsclass(c.getNameAsString());
        	             
        			System.out.println(" * " + classfound.getExtendsclass());
        	            
        	         List<ClassOrInterfaceType> implementList = n.getImplementedTypes();
        	         
        	         for (ClassOrInterfaceType d : implementList)
        	          classfound.setImplementsclass(d.getNameAsString()); 
        	         
        	         for (String m : classfound.getImplementsclass())
        	        	 System.out.println(" * " + m);
           	          
        	        
        			((Output) arg).setAllclasses(classfound);
        			
        		 List<Classcode> tAllcla = ((Output) arg).getAllclasses();
        			 
        			 for (Classcode e : tAllcla) 
     	         	{
     	        	
     	        	 System.out.println(" * " + e.getClassName());
     	            } 
        			        		        			         			
        		}
        		       		 
        		super.visit(n, arg);
               
        	}
                   
           @Override
                public void visit(MethodDeclaration n, Object arg) {
        	   System.out.println(" * " + n.getName());        
        	   super.visit(n, arg);
                          
           }
            
                       
            @Override
                 public void visit(FieldDeclaration n, Object arg) {
            	System.out.println(" * " + n.toString());  
            	super.visit(n, arg);
                  
            }
             @Override
                  public void visit(ConstructorDeclaration n, Object arg) {
                    System.out.println(" * " + n.toString());
                    super.visit(n, arg);
             	}
           }.visit(cu, listofclassesandinterfaces);
           
          System.out.println(); // empty line
      } 
	catch ( Exception e) {
         new RuntimeException(e);
      }
       
	}
}
