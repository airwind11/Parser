import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.BodyDeclaration;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.type.PrimitiveType;
import japa.parser.ast.type.ReferenceType;
import japa.parser.ast.type.Type;


public class Parser {

    private HashMap<String, CompilationUnit> compilationsUnits;
    private PackageStructure packageStructure;

    public Parser() {
        compilationsUnits = new HashMap<String, CompilationUnit>();
    }

    public PackageStructure parsePackage(File folder) {
        packageStructure = new PackageStructure();
        packageStructure.setPackageName(folder.getName());
        List<File> javaFiles = FileHandler.getAllFilesInDirectory(folder);
        for (File file : javaFiles) {
            parseFile(file);
        }
        checkSetterGetters();
        removeImplementedMethods(compilationsUnits, javaFiles);
        for (File file : javaFiles) {
            createEdges(compilationsUnits.get(file.getName()));
        }

        return packageStructure;
    }

    }