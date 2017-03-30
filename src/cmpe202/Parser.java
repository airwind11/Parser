package cmpe202;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class Parser {
	
	private static final String FILE_PATH = null;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		CompilationUnit cu = JavaParser.parse(new FileInputStream("C:/Parser/TestFiles/classb.java"));
		
	System.out.println(cu.toString());
		
		new MethodVisitor().visit(cu, null);
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




}
