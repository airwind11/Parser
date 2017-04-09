package cmpe202;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.management.relation.RelationType;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import cmpe202.ParserEngine;

public class Parser {

	public static void main(String[] args) throws FileNotFoundException {
	
		CompilationUnit cu = JavaParser.parse(new FileInputStream("C:/Parser/TestFiles/classb.java"));
		System.out.println(cu.toString());
		
		try {
	           new VoidVisitorAdapter<Object>() {
	               @Override
	               public void visit(ClassOrInterfaceDeclaration n, Object arg) {
	                   super.visit(n, arg);
	                   System.out.println(" * " + n.getName());
	               }
	           }.visit(cu, null);
	           System.out.println(); // empty line
	       } 
		catch ( Exception e) {
	           new RuntimeException(e);
	       }
		
		try {
	           new VoidVisitorAdapter<Object>() {
	               @Override
	               public void visit(MethodDeclaration n, Object arg) {
	                   super.visit(n, arg);
	                   System.out.println(" * " + n.getName());
	               }
	           }.visit(cu, null);
	           System.out.println(); // empty line
	       } 
		catch ( Exception e) {
	           new RuntimeException(e);
	       }
	   
	}

	
}
