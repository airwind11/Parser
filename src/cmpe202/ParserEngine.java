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
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.type.ArrayType;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.utils.Pair;

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
       	         {
       	        	 //System.out.println(" * " + m);
       	         }
       	         
       	         ((Output) arg).setAllinterfaces(n.getNameAsString(),interfacefound);
       	 
       	  		      	  		
       	  		
   			    super.visit(n, interfacefound);
        		}
        		
        		else
        			
        		{
        			Classcode classfound = new Classcode();
        			classfound.setClassName(n.getNameAsString());
        			// System.out.println(" * " + classfound.getClassName());
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
        	         {
        	        	 //System.out.println(" * " + m);
        	         }
           	          
        	        	//System.out.println(n.getNameAsString());
        			((Output) arg).setAllclasses(n.getNameAsString(),classfound);
        	       
        	         
        	        //System.out.println(((Output) arg).getAllclasses());
        	
        			 super.visit(n, classfound);     		        			         			
        		}
        	}
                   
           @Override
                public void visit(MethodDeclaration n, Object arg) 
           {
        	     Method methodfound = new Method();
        	     methodfound.setMethodName(n.getName().toString());
        	     //System.out.println(methodfound.getMethodName());
        	     
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
        	     
        	    // System.out.println(n.getDeclarationAsString(false, false, false));
        	     if(!n.getParameters().isEmpty())
        	     {
        	    	 
        	    	 for (Parameter i : n.getParameters())
        	    	
        	    	 {
        	    		 String[] parametersplitinparts = i.toString().split(" ");
        	    		methodfound.setMethodSignature(parametersplitinparts[0], parametersplitinparts[1]);
        	    		 if(arg instanceof Classcode)
        	    		 {
        	    			 
        	    			 ((Classcode) arg).setDependancy(parametersplitinparts[0]);
        	    			 
        	    			// System.out.println(((Classcode) arg).getDependancy());
        	    			
        	    		 }
        	    		 else
        	    		 {
        	    			 ((Interfacecode) arg).setDependancy(parametersplitinparts[0]);
        	    			 //System.out.println(((Interfacecode) arg).getDependancy());
        	    			
        	    		 }
        	    	 }
        	    	 for(Pair<String, String> i:methodfound.getMethodSignature())
        	    	 {
        	    	 //System.out.println(i.a+"*"+i.b);
        	    	 }
        	     }
        	     
        	     if(arg instanceof Classcode)
	    		 {
        	    	 ((Classcode) arg).setClassMethod(methodfound);
	    		 }
	    		 else
	    		 {
	    			 ((Interfacecode) arg).setInterfaceMethod(methodfound);
	    		 }
        	     
        	  
        	     
        	     
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
            	
            	if((n.getElementType().getMetaModel().toString().equals("ClassOrInterfaceType")) && (!attributefound.getAttributeType().equals("String")))
            	{
            		attributefound.setPrimitiveType(false);
                        	}
            	//
            	//System.out.println(n.getCommonType() instanceof ArrayType);
            	if(n.getCommonType() instanceof ArrayType) 
            	{
            		
            		
            		attributefound.setMultiplicity("multiple");
            	}
            	//System.out.println(attributefound.getPrimitiveType());
            	
            	
            	if(!attributefound.getPrimitiveType())
            	{
            		
            		List<Node> po = n.getElementType().getChildNodes();
            		
            		if(po.size()>1)
            		{
            			//System.out.println(po.get(1));
            			//System.out.println(po.get(1) instanceof PrimitiveType);
            			if(arg instanceof Classcode)
            				 	{
            				//if(!((po.get(1) instanceof PrimitiveType) || po.get(1).toString().equalsIgnoreCase("string")))
            				//{
            						((Classcode) arg).setAssociationwithclassorinterface(po.get(1).toString(),"multiple");
            						attributefound.setMultiplicity("multiple");
            						//System.out.println(((Classcode) arg).getAssociationwithclassorinterface());
            				 //	}
            				 	}
                		
            					else
            					{
            						//if(!((po.get(1) instanceof PrimitiveType) || po.get(1).toString().equalsIgnoreCase("string")))
            						((Interfacecode) arg).setAssociationwithclassorinterface(po.get(1).toString(),"multiple");
            						attributefound.setMultiplicity("multiple");
            						//System.out.println(((Interfacecode) arg).getAssociationwithclassorinterface());
            					}           				
            		}
            		
            		else
            		{
            			if(arg instanceof Classcode)
       				 		{
            				
            					((Classcode) arg).setAssociationwithclassorinterface(po.get(0).toString(),"single");
            					//System.out.println(((Classcode) arg).getAssociationwithclassorinterface());
       				 		}
            			else
       						{
            				
       							((Interfacecode) arg).setAssociationwithclassorinterface(po.get(0).toString(),"single");
       							
       							//System.out.println(((Interfacecode) arg).getAssociationwithclassorinterface());
       				       	}
            		}
            		}
            	
            	//System.out.println(attributefound.getMultiplicity());
            		
            		//System.out.println(attributefound.getAssociationwithclassorinterface());
            		//System.out.println(attributefound.getMultiplicity());
            		
            
             	 
            	 
            	
            	
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
            	 	Constructor constfound = new Constructor();
            	 	constfound.setConstName(n.getNameAsString());
            	 	//System.out.println(constfound.getConstName());
            	
            	constfound.setConstModifier(n.getModifiers());
            	//System.out.println(constfound.getConstModifier());
            	 
            	
            	 
                   //System.out.println(" # " + n.getDeclarationAsString(false, false, false));
            		
            			 if(!n.getParameters().isEmpty())
                	     {
                	    	 
                	    	 for (Parameter i : n.getParameters())
                	    	
                	    	 {
                	    		 String[] parametersplitinparts = i.toString().split(" ");
                	    		 constfound.setConstSignature(parametersplitinparts[0], parametersplitinparts[1]);
                	    		     ((Classcode) arg).setDependancy(parametersplitinparts[0]);
                	    			// System.out.println(((Classcode) arg).getDependancy());
                	    			 
                	    		 }
                	     }
                	    		
                	    	 for(Pair<String, String> i:constfound.getConstSignature())
                	    	 {
                	    	 //System.out.println(i.a+"*"+i.b);
                	    	 }              	    	 
                	    	                   	    		 
                       	   ((Classcode) arg).setClassConstructor(constfound);
               	    		
                       	  for(Constructor i :((Classcode) arg).getClassConstructor() )
                  	     {
                  	    	 //System.out.println(i.getConstName());
                  	     }
                       	    
                       	     
                	    	 
                   super.visit(n, arg);
             	}                   
           
             
             
           }.visit(cu, listofclassesandinterfaces);
           
           modifybasedonGetterandSetter(listofclassesandinterfaces);
           
          //System.out.println(); // empty line
     // } 
	//catch ( Exception e) {
    //     new RuntimeException(e);
    //  }
       
	}
	
	public static void modifybasedonGetterandSetter(Output listofclassesandinterfaces){
			
		for(Classcode classobjects : listofclassesandinterfaces.getAllclasses().values())
		{
			
			for (Method sd :classobjects.getClassMethod())
			{
								
				if(sd.getHasget())
				{
					for(Method sd1 :classobjects.getClassMethod())
					{						
						if(sd1.getHasset())
						{
							if(sd.getShortName().equalsIgnoreCase(sd1.getShortName()))
							{
																
								for(Attribute df :classobjects.getClassAttribute())
								{
									
									if(df.getAttributeName().equalsIgnoreCase(sd.getShortName()))
									{
										EnumSet<Modifier> newmod =EnumSet.noneOf(Modifier.class);
																		
										for(Modifier mod:df.getAttributeModifier())
										{
																												
											if(mod.toString().equalsIgnoreCase("private"))
											{
												newmod.add(Modifier.PUBLIC);
											}
											else 
											{
												newmod.add(mod);
											}
											
										}
										sd.setIncludedinUML(false);
										sd1.setIncludedinUML(false);
										df.setAttributeModifier(newmod);
										System.out.println(df.getAttributeModifier());
										
									}
								}
							}
							
							
						}
						
					}
				}
				
			}
		}
		
	}
	
	
}
