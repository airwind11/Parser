package cmpe202;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

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
		    
		    for(Interfacecode d :listofclassesandinterfaces.getAllinterfaces().values())
			{	
		    	
		    	out.write("/**\n*/\n\n");
		    	
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
		    HashSet<String> alreadychecked = new HashSet();
			for(Classcode d :listofclassesandinterfaces.getAllclasses().values())
			{
			alreadychecked.add(d.getClassName());
				
				out.write("/**\n");
				if(d.getDependancy().size()>0)
				{
					
					
					for(String retq:d.getDependancy())
					{
						if(listofclassesandinterfaces.getAllinterfaces().containsKey(retq))
						{
						out.write("* @depend - - - "+retq+"\n");
						}
					}
					
					
				}
				
if(d.getAssociationwithclassorinterface().size()>0)
	{
	
		for(String asd : d.getAssociationwithclassorinterface().keySet())
			{
			
			if(!alreadychecked.contains(asd))
			{
				alreadychecked.add(asd);
				out.write("* @assoc ");
			if(listofclassesandinterfaces.getAllclasses().containsKey(asd))
			{
				
				for(String asdf:listofclassesandinterfaces.getAllclasses().get(asd).getAssociationwithclassorinterface().keySet())
				{
					if(asdf.equals(d.getClassName()))
					{
						if(listofclassesandinterfaces.getAllclasses().get(asd).getAssociationwithclassorinterface().get(asdf).equalsIgnoreCase("single"))
						out.write("0..1 - ");
						else
						out.write("* - ");	
					}
				}			
			}
			else if(listofclassesandinterfaces.getAllinterfaces().containsKey(asd))
			{
				System.out.println("here");
				for(String asdf:listofclassesandinterfaces.getAllinterfaces().get(asd).getAssociationwithclassorinterface().keySet())
				{
					if(asdf.equals(d.getClassName()))
					{
						if(listofclassesandinterfaces.getAllinterfaces().get(asd).getAssociationwithclassorinterface().get(asdf).equalsIgnoreCase("single"))
						{
						out.write("0..1 - ");
						}
						else
						{
						out.write("* - ");
						}
					}
				}		
			}
			else
			{
				System.out.println("here");
				out.write("- - ");
			}
			if(d.getAssociationwithclassorinterface().get(asd).equalsIgnoreCase("single"))
			{
			out.write("  0..1 "+asd+"\n");
			}
			else
			{
				out.write(" * "+asd+"\n");
			}
			}
			
			}
		
		
					
	}
				
				out.write("*/\n\n");
				
				
									
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
			
			
			
			
			
			 out.close();
		  
		}
		catch (IOException e)
		{
		    System.err.println("Error: " + e.getMessage());
		}
		
		
		
		
		return null;
		
	}
	
	

}
