
/**
 * Tester for Chapter 07: Objects
 * 
 */
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.lang.reflect.*;
@SuppressWarnings("unchecked")
public class Ch08Test{
	public static int testsFailed = 0;
	public static Class ch;
	public static ByteArrayOutputStream baos;
	public static PrintStream original = System.out, record;
	
	public static void main(String[]args){
		try{
			assert false;
			throw new Exception("Asserts not enabled");
		}catch(AssertionError ae){
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		String className = "TimeSpan",fullName ="", methodName = "", paramsStr ="";
		try{
			ch = Class.forName(className);
		}catch(ClassNotFoundException cnfe){
			System.out.println("Could not find class "+className);
			System.exit(-1);
		}
		try{
			Class params[] = new Class[2];params[0]=int.class;params[1]=int.class;
			methodName="TimeSpan";
			paramsStr="int,int";
			fullName = className+"."+methodName+"("+paramsStr+")";
			Constructor con = ch.getDeclaredConstructor(params);
			Object zero = ch.cast(con.newInstance(0,0));
			try{
				Object illegal = ch.cast(con.newInstance(-1,0));
				throw new Exception("Constructor called with negative parameters should have errored");
			}catch(InvocationTargetException ite){
				if(ite.getTargetException().getClass()!=IllegalArgumentException.class)
					throw new Exception("Constructor called with negative parameters should have errored");
			}
			try{
				Object illegal = ch.cast(con.newInstance(0,-1));
				throw new Exception("Constructor called with negative parameters should have errored");
			}catch(InvocationTargetException ite){
				if(ite.getTargetException().getClass()!=IllegalArgumentException.class)
					throw new Exception("Constructor called with negative parameters should have errored");
			}
			System.out.println("constructor test passed");
			
			// check field access
			Field[] fields = ch.getDeclaredFields();
			for(Field f:fields){
				if(Modifier.isPublic(f.getModifiers())){
					throw new IllegalAccessError(className+"."+f.getName()+"is public");
				}
			}
			System.out.println("access test passed");
			
			testAdd(con);
			testSubtract(con);
			testScale(con);
		}catch(NoSuchMethodException nsme){
			System.out.println("Could not find method "+fullName);
			testsFailed++;
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
			testsFailed++;
		}
		System.out.println();
		className = "RationalNumber";
		try{
			ch = Class.forName(className);
			System.out.println("Optional class exists. Reviewer, please review.");
		}catch(ClassNotFoundException cnfe){
			System.out.println("Could not find optional class "+className);
		}catch(Exception e){
			testsFailed++;
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			System.out.println(className + " test failed");
		}
		if(testsFailed == 0){
			System.out.println("All tests passed");
		}else{
			System.out.println(testsFailed+ " test(s) failed");
			System.exit(-1);
		}
	}
	public static void assertEqualsExact(String expected, String actual){
		expected = expected.replaceAll("\\r", "").trim();
		expected = expected.replaceAll("\r", "").trim();
		actual = actual.replaceAll("\\r", "").trim();
		actual = actual.replaceAll("\r", "").trim();
		assert expected.equals(actual) : "Expected\n" + expected.toString() + "\nbut was \n" + actual.toString();
	}
	public static void assertEquals(String expected, String actual){
		expected = expected.replaceAll("\r\n", "\n").trim();
		expected = expected.replaceAll("\n", "").trim();
		actual = actual.replaceAll("\r\n", "\n").trim();
		actual = actual.replaceAll("\n", "").trim();
		assert expected.equals(actual) : "Expected\n" + expected.toString() + "\nbut was \n" + actual.toString();
	}
	public static void assertThrows2(Method method, String type, Object obj, Object[]params) throws Exception{
		try{
			method.invoke(obj, params);
			throw new Exception("No "+type+" thrown");
		}catch(InvocationTargetException ite){
			String cause = ite.getCause().getClass().getSimpleName();
			if(!cause.equals(type)){
				assert false : "Expected "+type+" but was " + cause;
			}
		}
	}
	public static void assertThrows(Method method, String type, Object[]params) throws Exception{
		try{
			method.invoke(null, params);
			throw new Exception("No "+type+" thrown");
		}catch(InvocationTargetException ite){
			String cause = ite.getCause().getClass().getSimpleName();
			if(!cause.equals(type)){
				assert false : "Expected "+type+" but was " + cause;
			}
		}
	}
	public static void assertThrows(Method method, String type, Object param) throws Exception{
		Object[]params = new Object[1];
		params[0] = param;
		assertThrows(method, type, params);
	}
	public static void start(){
		baos = new ByteArrayOutputStream();
		record = new PrintStream(baos);
		System.setOut(record);
	}
	public static String stop(){
		record.flush();
		String actual = baos.toString();
		record.close();
		System.setOut(original);
		return actual;
	}
	
	public static void testAdd(Constructor con){
		String methodName = "add";
		try{
			Method method = ch.getMethod(methodName, ch);
			Object[]params = new Object[1];
			Object twoThirty = ch.cast(con.newInstance(2,30));
			Object zero = ch.cast(con.newInstance(0,0));
			String expected = "2h 30m";
			params[0] = zero;
			method.invoke(twoThirty, params);
			assertEqualsExact(expected, twoThirty.toString());
			
			params[0] = twoThirty;
			method.invoke(zero, params);
			assertEquals(expected, zero.toString());
			
			expected = "5h 0m";
			method.invoke(zero, params);
			assertEquals(expected, zero.toString());
			
			params[0] = null;
			assertThrows2(method, "IllegalArgumentException", zero, params);
			
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(TimeSpan)");
			return;
		}catch(AssertionError ae){
			testsFailed++;
			System.out.println(ae.getMessage());
			System.out.println(methodName + " test failed");
			return;
		}
		catch(Exception e){
			testsFailed++;
			System.out.println(e.getMessage());
			System.out.println(methodName + " test failed");
			return;
		}
		System.out.println(methodName + " test passed");
	}
	
	public static void testSubtract(Constructor con){
		String methodName = "subtract";
		try{
			Method method = ch.getMethod(methodName, ch);
			Object[]params = new Object[1];
			Object twoThirty = ch.cast(con.newInstance(2,30));
			Object zero = ch.cast(con.newInstance(0,0));
			String expected = "2h 30m";
			params[0] = zero;
			method.invoke(twoThirty, params);
			assertEqualsExact(expected, twoThirty.toString());
			
			params[0] = twoThirty;
			try{
				method.invoke(zero, params);
				throw new AssertionError("Time cannot be negative");
			}catch(InvocationTargetException ite){
			}
			
			params[0] = null;
			assertThrows2(method, "IllegalArgumentException", zero, params);
			
			Object fourFive = ch.cast(con.newInstance(0,45));
			expected = "1h 45m";
			params[0] = fourFive;
			method.invoke(twoThirty, params);
			assertEqualsExact(expected, twoThirty.toString());
			
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(TimeSpan)");
			return;
		}catch(AssertionError ae){
			testsFailed++;
			System.out.println(ae.getMessage());
			System.out.println(methodName + " test failed");
			return;
		}
		catch(Exception e){
			testsFailed++;
			System.out.println(e.getMessage());
			System.out.println(methodName + " test failed");
			return;
		}
		System.out.println(methodName + " test passed");
	}
	public static void testScale(Constructor con){
		String methodName = "scale";
		try{
			Method method = ch.getMethod(methodName, int.class);
			Object[]params = new Object[1];
			Object twoThirty = ch.cast(con.newInstance(2,30));
			String expected = "2h 30m";
			params[0] = 1;
			method.invoke(twoThirty, params);
			assertEqualsExact(expected, twoThirty.toString());
			
			params[0] = 2;
			expected = "5h 0m";
			method.invoke(twoThirty, params);
			assertEqualsExact(expected, twoThirty.toString());
			
			params[0] = 0;
			expected = "0h 0m";
			method.invoke(twoThirty, params);
			assertEqualsExact(expected, twoThirty.toString());
			
			params[0] = -1;
			assertThrows2(method, "IllegalArgumentException", twoThirty, params);
			
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(int)");
			return;
		}catch(AssertionError ae){
			testsFailed++;
			System.out.println(ae.getMessage());
			System.out.println(methodName + " test failed");
			return;
		}
		catch(Exception e){
			testsFailed++;
			System.out.println(e.getMessage());
			System.out.println(methodName + " test failed");
			return;
		}
		System.out.println(methodName + " test passed");
	}

}
