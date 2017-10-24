import static org.junit.Assert.*;

import org.junit.Test;

public class InspectorTest {

	@Test
	//tests class name
	public void testClassInfo() throws Exception {
		ClassB tester = new ClassB();
		Class classB = tester.getClass();
		Inspector inspector = new Inspector();
		assertEquals("ClassB" , inspector.classInfo(classB));
		
	}

	@Test
	
	//tests number of methods
	public void testMethodInfo() throws Exception {
		ClassB tester = new ClassB();
		Class classB = tester.getClass();
		Inspector inspector = new Inspector();
		assertEquals(3 ,  inspector.methodInfo(classB));
	}

	@Test
	//tests number of constructors
	public void testConstructorInfo() throws Exception {
		ClassB tester = new ClassB();
		Class classB = tester.getClass();
		Inspector inspector = new Inspector();
		assertEquals(1 ,  inspector.constructorInfo(classB));
	}

	@Test
	//tests number of fields
	public void testFieldInfo() throws Exception {
		ClassB tester = new ClassB();
		Class classB = tester.getClass();
		Inspector inspector = new Inspector();
		assertEquals(3 ,  inspector.fieldInfo(classB, tester, false));
	}

}
