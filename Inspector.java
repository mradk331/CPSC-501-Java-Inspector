import java.lang.reflect.*;
import java.util.*;




public class Inspector {

	public static void main (String args[])
	{
       try {
		inspect(new ClassD(), true);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
		
	}

	
	
	
public static void inspect(Object obj, boolean recursive) throws Exception
{
	 if(obj == null )  //base case
		 return;

	 Class <?> sentClass = obj.getClass(); 
	 classInfo(sentClass);
	 methodInfo(sentClass);
	 constructorInfo(sentClass);
	 fieldInfo(sentClass, obj);
	  
	 
	 
	 
	 
	 
	 
	 


	
	
	
	if(recursive)
	{

	Class <?> superClass =  sentClass.getSuperclass();
		
	
	Class temp;
	
		while (superClass != null && superClass.getSuperclass() != null )
		{
			//System.out.println("KILLLLLLLLLLLLLLLL");
		 System.out.println("SUPERCLASS: " + superClass.getName());
		 
		 
		 classInfo(superClass);
		 methodInfo(superClass);
		 constructorInfo(superClass);
		 fieldInfo(superClass, obj);
		 
		 temp = superClass.getSuperclass();
		 superClass = temp;
		 
		 
		}
		
		
	}
	
	
}	


public static void classInfo(Class sentClass) throws Exception
{	
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

}	



public static void methodInfo(Class sentClass) throws Exception
{
	
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
	
}	


public static void constructorInfo( Class sentClass) throws Exception
{
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
	
}	
	




public static void fieldInfo (Class sentClass, Object obj) throws Exception
{
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
			System.out.print(" NON PRIMITIVE VALUE: " + fields[i].get(obj));   //should work recursively using obj please
		}
		
		
		
	}
	else 
		
		
		{
		//extremely repetitive, handles each of the primitive types
		 if(fields[i].getType().getName() == "int")		
		System.out.print(" PRIMITIVE VALUE: " + fields[i].getInt(obj));
		 
		 
		 if(fields[i].getType().getName() == "char")		
				System.out.print(" PRIMITIVE VALUE: " + fields[i].getChar(obj));
		 
		 if(fields[i].getType().getName() == "boolean")		
				System.out.print(" PRIMITIVE VALUE: " + fields[i].getBoolean(obj));
		 
		 
		 if(fields[i].getType().getName() == "byte")		
				System.out.print(" PRIMITIVE VALUE: " + fields[i].getByte(obj));
		 
		 if(fields[i].getType().getName() == "short")		
				System.out.print(" PRIMITIVE VALUE: " + fields[i].getShort(obj));
		 
		 if(fields[i].getType().getName() == "long")		
				System.out.print(" PRIMITIVE VALUE: " + fields[i].getLong(obj));
		 
		 
		 
		 if(fields[i].getType().getName() == "double")		
				System.out.print(" PRIMITIVE VALUE: " + fields[i].getDouble(obj));
		 
		 
		 if(fields[i].getType().getName() == "float")		
				System.out.print(" PRIMITIVE VALUE: " + fields[i].getFloat(obj));
		}
	
	
	
	System.out.print(" TYPE: " + fields[i].getType().getSimpleName());
	System.out.print(" " + "MODIFIER NUMBER: " + fields[i].getModifiers());
    System.out.println(" MODIFIER: " + Modifier.toString(fields[i].getModifiers()));




}
System.out.println();

}	









}
