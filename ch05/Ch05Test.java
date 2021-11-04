
/**
 * Tester for Chapter 05: Logic and Idefinite Loops
 * 
 */
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.lang.reflect.*;
@SuppressWarnings("unchecked")
public class Ch05Test{
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
		String className = "Ch05";
		try{
			ch = Class.forName(className);
		}catch(ClassNotFoundException cnfe){
			System.out.println("Could not find class "+className);
			System.exit(-1);
		}
		try{
			testPrintFactors();
			testThreeHeads();
			testDigitSum();
			testIsAllVowels();

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println();
		String optional = "pigLatin";
		try{
			Method method = ch.getMethod(optional);
			System.setIn(new ByteArrayInputStream("The deepest shade of mushroom blue\n\n".getBytes()));
			method.invoke(null);
		}catch(NoSuchMethodException nsme){
			System.out.println("Could not find optional method "+optional);
		}catch(Exception e){
			testsFailed++;
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			System.out.println(optional + " test failed");
		}
		if(testsFailed == 0){
			System.out.println("All tests passed");
		}else{
			System.out.println(testsFailed+ " test(s) failed");
			System.exit(-1);
		}
	}
	public static void assertEquals(String expected, String actual){
		expected = expected.replaceAll("\r\n", "\n").trim();
		expected = expected.replaceAll("\n", "").trim();
		actual = actual.replaceAll("\r\n", "\n").trim();
		actual = actual.replaceAll("\n", "").trim();
		assert expected.equals(actual) : "Expected\n" + expected.toString() + "\nbut was \n" + actual.toString();
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
	
	public static void testPrintFactors(){
		String methodName = "printFactors";
		try{
			Method method = ch.getMethod(methodName, int.class);
			Object[]params = new Object[1];
			String expected = "1 and 2 and 3 and 4 and 6 and 8 and 12 and 24";
			params[0] = 24;
			start();
			method.invoke(null, params);
			String actual = stop();
			assertEquals(expected, actual);
			
			expected = "1 and 5 and 25";
			params[0] = 25;
			start();
			method.invoke(null, params);
			actual = stop();
			assertEquals(expected, actual);
			
			params[0] = -1;
			assertThrows(method, "IllegalArgumentException", params);
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
	
	public static void testThreeHeads(){
		String methodName = "threeHeads";
		try{
			Method method = ch.getMethod(methodName, int.class);
			Object[]params = new Object[1];
			String expected = "T H H H \nThree heads in a row!";
			params[0] = 12345;
			start();
			method.invoke(null, params);
			String actual = stop();
			assertEquals(expected, actual);
			
			expected = "H T H H H \nThree heads in a row!";
			params[0] = 54321;
			start();
			method.invoke(null, params);
			actual = stop();
			assertEquals(expected, actual);
			
			expected = "H H T H H T H T H H T T T H H H \nThree heads in a row!";
			params[0] = 0;
			start();
			method.invoke(null, params);
			actual = stop();
			assertEquals(expected, actual);
			
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(int)");
			System.out.println("For testing purposes, your pseudorandom number generator needs to take a seed parameter.");
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
	
	
	public static void testDigitSum(){
		String methodName = "digitSum";
		try{
			Method method = ch.getMethod(methodName, int.class);
			Object[]params = new Object[1];
			params[0] = 29107;
			String actual = "" + (int)method.invoke(null,params);
			String expected = "19";
			assertEquals(expected, actual);
			
			params[0] = -456;
			actual = "" + (int)method.invoke(null,params);
			expected = "15";
			assertEquals(expected, actual);
			
			params[0] = 0;
			actual = "" + (int)method.invoke(null,params);
			expected = "0";
			assertEquals(expected, actual);
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
	
	public static void testIsAllVowels(){
		String methodName = "isAllVowels";
		try{
			Method method = ch.getMethod(methodName, String.class);
			Object[]params = new Object[1];
			String nil = null;
			params[0] = nil;
			assertThrows(method, "IllegalArgumentException", params);
			
			String expected = "true";
			params[0] = "eIEio";
			String actual = ""+(boolean)method.invoke(null, params);
			assertEquals(expected, actual);
			
			expected = "false";
			params[0] = "oink";
			actual = ""+(boolean)method.invoke(null, params);
			assertEquals(expected, actual);
			
			expected = "true";
			params[0] = "";
			actual = ""+(boolean)method.invoke(null, params);
			assertEquals(expected, actual);
			
			expected = "true";
			params[0] = "aeiouAEIOU";
			actual = ""+(boolean)method.invoke(null,params);
			assertEquals(expected, actual);
			
			
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(String)");
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
