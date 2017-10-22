import java.lang.reflect.*;
import java.util.*;




public class Inspector {

	public static void main (String args[])
	{
       try {
		inspect(new ClassB(), false);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
		
	}

	
	
	
public static void inspect(Object obj, boolean recursive) throws Exception
{
	

	Class sentClass = obj.getClass();
	
	System.out.println("Class Name:");
	System.out.println(sentClass.getSimpleName() + '\n');
	System.out.println("SuperClass Name:");
	System.out.println(sentClass.getSuperclass().getSimpleName()+ '\n');
	System.out.println("Interfaces implemented:");
	
	Class[] Classes = sentClass.getInterfaces();
	
	for(int i = 0; i < (Classes.length); i++)
	{
		System.out.println(Classes[i].getSimpleName());
		
	}
	System.out.println();		

	
	
	
	System.out.println("Methods in Class:" + '\n');
	Method[] Methods = sentClass.getDeclaredMethods();
	
	for(int i = 0; i < (Methods.length); i++)
	{
		System.out.print(Methods[i].getName() + " THROWS: ");
		
		
		
		Class[] exceptions =  Methods[i].getExceptionTypes();
		
		
		for(int j = 0; j < (exceptions.length); j++)
		System.out.print(exceptions[j].getSimpleName() + ", ");
		
		
		
		
		System.out.print("PARAMETERS: (");
		Class[] parameters = Methods[i].getParameterTypes();
		
		for(int j = 0; j < (parameters.length); j++)
			System.out.print(parameters[j].getSimpleName() + ", ");
		
		System.out.print(") ");
		
		
		
		System.out.print( "RETURNS: " + Methods[i].getReturnType().getSimpleName());
		
		
		
	
		int modifier = Methods[i].getModifiers();
		System.out.print(" MODIFIER NUMBER: " + modifier + " ");
		
		System.out.print( "MODIFIER: " + Modifier.toString(modifier));
		
		
		
		System.out.println();
		
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	System.out.println("FIELDS DECLARED by Class:");
	Field []fields = sentClass.getDeclaredFields();
	
	
	for(int i = 0; i< fields.length; i++)
	{
		
		System.out.print("NAME: " + fields[i].getName());
		System.out.print(" TYPE: " + fields[i].getType().toString());
		System.out.print(" " + "MODIFIER NUMBER: " + fields[i].getModifiers());
	    System.out.println(" MODIFIER: " + Modifier.toString(fields[i].getModifiers()));
	}
	
	
	
}	
	
}
