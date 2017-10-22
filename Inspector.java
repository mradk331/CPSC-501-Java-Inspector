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

	
}	
	
}
