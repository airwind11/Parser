package cmpe202;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.umlgraph.doclet.UmlGraph;
import org.umlgraph.doclet.UmlGraphDoc;

import com.github.javaparser.ast.Modifier;
import com.github.javaparser.utils.Pair;

public class IntermediateUML  {
	
	
	
	public static final String filename = "IntermediateforUMLGraph.java";
	
	public static File intermediatefilecreator(String path,Output listofclassesandinterfaces)
	{
		
		String as = path+File.separator +filename;
		//System.out.println(as);
		File file = new File(as);
		try {
			file.getParentFile().mkdirs();
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BufferedWriter out = null;
		
		
		try  
		{
		    FileWriter fstream = new FileWriter(file, true);
		    out = new BufferedWriter(fstream);
		    out.write("import java.util.*;\n\n");
		    
			for(Classcode d :listofclassesandinterfaces.getAllclasses().values())
			{
									
			out.write(d.getClassModifier().substring(1, (d.getClassModifier().length()-1)).toLowerCase()+" "+
						"class"+" "+d.getClassName()+" ");
			
					
			if(!d.getExtendsclass().equals(""))
			{
				out.write(" "+"extends"+" "+d.getExtendsclass()+" ");
			}
					
			
				if(d.getImplementsclass().size()!=0)
					{
					out.write("implements"+" ");
						int c = 1;
							for(String asd :d.getImplementsclass())
							{
								out.write(asd);
							      if(c<d.getImplementsclass().size())
										{
							    	  		out.write(",");
										}
										c=c+1;
									}
								}
								
				out.write(" "+ "{"+"\n");
		
		for(Attribute ad :d.getClassAttribute())
			{
				String modifierwithoutstatic = ""; 
					for (Modifier sd : ad.getAttributeModifier())
						{
							if(!sd.asString().equalsIgnoreCase("static"))
								{
									modifierwithoutstatic = sd.asString().toLowerCase();
								}
						}
							out.write(modifierwithoutstatic+" "+ad.getAttributeType());
							if(ad.getPrimitiveType())
							{
								if(ad.getMultiplicity().equalsIgnoreCase("multiple"))
								{
									out.write("[]");
								}
							}
							
							out.write(" "+ad.getAttributeName()+" "+";"+"\n\n");
						}
				
		
		
		for(Method ad :d.getClassMethod())
		{
			if(ad.getIncludedinUML())
			{
				String modifierwithoutstatic = ""; 
					for (Modifier sd : ad.getMethodModifier())
						{
							if(!sd.asString().equalsIgnoreCase("static"))
								{
									modifierwithoutstatic = sd.asString().toLowerCase();
									}
						}
					out.write(modifierwithoutstatic+" "+" "+ad.getReturnType()
					+" "+ad.getMethodName()+"(");
					int k =1;
					for(Pair<String, String> sdf :ad.getMethodSignature())
					{
						out.write(sdf.a+" "+sdf.b);
						if(k<ad.getMethodSignature().size())
						{
			    	  		out.write(",");
						}
						k=k+1;
					}
					out.write(");\n\n");
					
			}

		}
		
		for(Constructor ad :d.getClassConstructor())
		{
			
				String modifierwithoutstatic = ""; 
					for (Modifier sd : ad.getConstModifier())
						{
							if(!sd.asString().equalsIgnoreCase("static"))
								{
									modifierwithoutstatic = sd.asString().toLowerCase();
									}
						}
					out.write(modifierwithoutstatic+" "+" "
					+" "+ad.getConstName()+"(");
					int k =1;
					for(Pair<String, String> sdf :ad.getConstSignature())
					{
						out.write(sdf.a+" "+sdf.b);
						if(k<ad.getConstSignature().size())
						{
			    	  		out.write(",");
						}
						k=k+1;
					}
					out.write(");\n\n");
					
			

		}
		out.write("}"+"\n\n");
		
		
			}
			
			
			for(Interfacecode d :listofclassesandinterfaces.getAllinterfaces().values())
			{	
			
				 out.write("interface"+" "+d.getInterfaceName()+" " +"{");
				 
				  for(Attribute ad :d.getInterfaceAttribute())
		            {
		                String modifierwithoutstatic = "";
		                    for (Modifier sd : ad.getAttributeModifier())
		                        {
		                            if(!sd.asString().equalsIgnoreCase("static"))
		                                {
		                                    modifierwithoutstatic = sd.asString().toLowerCase();
		                                }
		                        }
		                            out.write(modifierwithoutstatic+" "+ad.getAttributeType());
		                            if(ad.getPrimitiveType())
		                            {
		                                if(ad.getMultiplicity().equalsIgnoreCase("multiple"))
		                                {
		                                    out.write("[]");
		                                }
		                            }

		                            out.write(" "+ad.getAttributeName()+" "+";"+"\n\n");
		                        }
				  
				     for(Method ad :d.getInterfaceMethod())
				        {
				            if(ad.getIncludedinUML())
				            {
				                String modifierwithoutstatic = "";
				                    for (Modifier sd : ad.getMethodModifier())
				                        {
				                            if(!sd.asString().equalsIgnoreCase("static"))
				                                {
				                                    modifierwithoutstatic = sd.asString().toLowerCase();
				                                    }
				                        }
				                    out.write(modifierwithoutstatic+" "+" "+ad.getReturnType()
				                    +" "+ad.getMethodName()+"(");
				                    int k =1;
				                    for(Pair<String, String> sdf :ad.getMethodSignature())
				                    {
				                        out.write(sdf.a+" "+sdf.b);
				                        if(k<ad.getMethodSignature().size())
				                        {
				                            out.write(",");
				                        }
				                        k=k+1;
				                    }
				                    out.write(");\n\n");

				            }

				        }
				 
			

              out.write(" "+ "}"+"\n\n");
				
			}
			
			
			 out.close();
		  
		}
		catch (IOException e)
		{
		    System.err.println("Error: " + e.getMessage());
		}
		
		
		
//	UmlGraph.buildGraph(as, null, path);
		
		
		return null;
		
	}
	
	

}
