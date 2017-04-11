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
        			
        			
        			}
        		else
        		{
        			Classcode classfound = new Classcode();
        			classfound.setClassName(n.getNameAsString());
        			classfound.setClassModifier(n.getModifiers().toString());
        			classfound.setExtendsclass(n.getExtendedTypes().toString());
        			
        			List<ClassOrInterfaceType> extendList = n.getExtendedTypes();
        	        
        			for (ClassOrInterfaceType c : extendList) 
        				{
        	          // classfound.setExtendsclass(c.getName().toString());
        	             System.out.println(" * " + c.getName());
        	            }
        	            
        	         List<ClassOrInterfaceType> implementList = n.getImplementedTypes();
        	         
        	         for (ClassOrInterfaceType c : implementList) 
        	         	{
        	        	 //classfound.setImplementsclass(c.getName().toString());;
        	        	 System.out.println(" * " + c.getName());
        	            } 
        	            
        			System.out.println(" * " + n.getModifiers());
        			//((Output) arg).setAllclasses(classfound);
        			         			
        		}
        		
        		 super.visit(n, arg);
            
               }
                   
           @Override
                public void visit(MethodDeclaration n, Object arg) {
                       super.visit(n, arg);
                       System.out.println(" * " + n.getName());   
           }
            
                       
            @Override
                 public void visit(FieldDeclaration n, Object arg) {
                  super.visit(n, arg);
                  System.out.println(" * " + n.toString());
            }
             @Override
                  public void visit(ConstructorDeclaration n, Object arg) {
                  super.visit(n, arg);
                  System.out.println(" * " + n.toString());
             	}
           }.visit(cu, listofclassesandinterfaces);
           
           System.out.println(); // empty line
       } 
	catch ( Exception e) {
           new RuntimeException(e);
       }
	}
}
