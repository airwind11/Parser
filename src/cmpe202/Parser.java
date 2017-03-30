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
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class Parser {
	
	   private static HashMap<String, ClassOrInterfaceDeclaration> _typeMap;
	    private HashMap<String, List<MethodDeclaration>> _interfaceMap;
	    private ArrayList<RelationType> _relationsList;
	    
	    Parser() {
	       	        _relationsList = new ArrayList<>();
	        _interfaceMap = new HashMap<>();
	        _typeMap = new HashMap<>();
	    }
	
	private static final String FILE_PATH = null;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		CompilationUnit cu = JavaParser.parse(new FileInputStream("C:/Parser/TestFiles/classb.java"));
		
	System.out.println(cu.toString());
	new MethodVisitor().visit(cu, null);
	ClassOrInterfaceDeclaration dec = readClassOrInterfaceName(cu);
			System.out.println(dec.getName().toString());//to be changed cannot call private methods inside static method
    if (dec != null) {
        _typeMap.put(dec.getName().toString(), dec);
    }
   
		
		
		
		
	}

	private static class MethodVisitor extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodDeclaration n, Void arg) {
            /* here you can access the attributes of the method.
             this method will be called for all methods in this 
             CompilationUnit, including inner class methods */
            System.out.println(n.getName());
            super.visit(n, arg);
        }
    }
	
	public static ClassOrInterfaceDeclaration readClassOrInterfaceName(CompilationUnit unit) {
        List<Node> nodelist = unit.getChildNodes();
        for (Node node : nodelist) {
            if (node instanceof ClassOrInterfaceDeclaration) {
                return (ClassOrInterfaceDeclaration) node;
            }
        }
        return null;
    }




}
