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

	
	
	
	System.out.println("METHODS IN CLASS");
	Method[] Methods = sentClass.getDeclaredMethods();
	
	for(int i = 0; i < (Methods.length); i++)
	{
		System.out.print("NAME: " + Methods[i].getName() + " THROWS: ");
		
		
		
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
	 
	
	System.out.println();
	
	
	
	System.out.println("CONSTRUCTORS DECLARED BY CLASS: ");
	Constructor[] constructors = sentClass.getDeclaredConstructors();
	
	
	for(int i = 0; i< constructors.length; i++)
	{
		System.out.print("NAME: " + constructors[i].getName());
		Class[] conparams = constructors[i].getParameterTypes();
		
		System.out.print(" PARAMETERS: (");
		
		for (int j = 0; j < conparams.length; j++)
		System.out.print( conparams[j].getSimpleName() + ",");
		
		System.out.print(") ");
		
		System.out.print("MODIFIER NUMBER: " + constructors[i].getModifiers());
		System.out.print(" MODIFIER: " + Modifier.toString(constructors[i].getModifiers()));
		
		System.out.println('\n');
	}
	
	
	
	
	
	
	
	
	
	
	System.out.println("FIELDS DECLARED BY CLASS:");
	Field []fields = sentClass.getDeclaredFields();
	
	
	for(int i = 0; i< fields.length; i++)
	{
		
		fields[i].setAccessible(true); //otherwise will break
		
		
		System.out.print("NAME: " + fields[i].getName());
		
		if(!fields[i].getType().isPrimitive())  //not primitive
		{
			if(fields[i].getType().isArray())
			{
				
				System.out.print(" ARRAY: ");
				int arraylength = Array.getLength(fields[i].get(obj));
				System.out.print("ARRAY LENGTH: " + arraylength);
				
				
				for(int j = 0; j < arraylength; j++)
				{
					System.out.print(" VALUE AT INDEX: [" + j + "] is " + Array.get(fields[i].get(obj), j));
					
				}
				
			}
				
			else{
				System.out.print(" NON PRIMITIVE VALUE: " + fields[i].get(obj));
			}
			
			
			
		}
		
		
		
		
		System.out.print(" TYPE: " + fields[i].getType().getSimpleName());
		System.out.print(" " + "MODIFIER NUMBER: " + fields[i].getModifiers());
	    System.out.println(" MODIFIER: " + Modifier.toString(fields[i].getModifiers()));
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
}	
	
}
