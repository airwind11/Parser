package cmpe202;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.management.relation.RelationType;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import cmpe202.ParserEngine;

public class Parser {

	public static void main(String[] args) throws FileNotFoundException {
		
		String path = args[1];
		Output listofclassesandinterfaces = new Output() ;
		
		File dir = new File(path);
		File[] files = dir.listFiles();
		
		for(File sd :files)
		{
			if(sd.toString().endsWith("java"))
			{
				CompilationUnit cu = JavaParser.parse(new FileInputStream(sd));
				ParserEngine.readfile(cu,listofclassesandinterfaces);
			}
			
		}
		
		
		for(Classcode asd :listofclassesandinterfaces.getAllclasses().values())
		{
			//System.out.println(asd.getClassName());
		}
	
		for(Interfacecode asd :listofclassesandinterfaces.getAllinterfaces().values())
		{
			//System.out.println(asd.getInterfaceName());
		}
		
	}
}
