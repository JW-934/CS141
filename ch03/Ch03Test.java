
/**
 * Tester for Chapter 03: Parameters and Objects
 * 
 */
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.lang.reflect.*;
@SuppressWarnings("unchecked")
public class Ch03Test{
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
		String className = "Ch03";
		try{
			ch = Class.forName(className);
		}catch(ClassNotFoundException cnfe){
			System.out.println("Could not find class "+className);
			System.exit(-1);
		}
		try{
			testPrintPowersOfN();
			testArea();
			testSphereVolume();
			testInputBirthday();

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println();
		String optional = "savingsTable";
		try{
			Method method = ch.getMethod(optional);
			method.invoke(null);
		}catch(NoSuchMethodException nsme){
			System.out.println("Could not find optional method "+optional);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		if(testsFailed == 0){
			System.out.println("All tests passed");
		}else{
			System.out.println(testsFailed+ " test(s) failed");
			System.exit(-1);
		}
	}
	public static void assertEquals(String expected, String actual){
		expected = expected.replaceAll("\\r", "").trim();
		actual = actual.replaceAll("\\r", "").trim();
		assert expected.equals(actual) : "Expected\n" + expected.toString() + "\nbut was \n" + actual.toString();
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
	
	public static void testPrintPowersOfN(){
		String methodName = "printPowersOfN";
		try{
			Method method = ch.getMethod(methodName, int.class, int.class);
			Object[]params = new Object[2];
			String expected = "1 4 16 64";
			params[0] = 4;params[1] = 3;
			start();
			method.invoke(null, params);
			String actual = stop();
			assertEquals(expected, actual);
			
			expected = "1 5 25 125 625 3125 15625";
			params[0] = 5;params[1] = 6;
			start();
			method.invoke(null, params);
			actual = stop();
			assertEquals(expected, actual);
			
			expected = "1 -2 4 -8 16 -32 64 -128 256";
			params[0] = -2;params[1] = 8;
			start();
			method.invoke(null, params);
			actual = stop();
			assertEquals(expected, actual);
			
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(int,int)");
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
	
	public static void testArea(){
		String methodName = "area";
		try{
			Method method = ch.getMethod(methodName, double.class);
			Object[]params = new Object[1];
			String expected = "12.566370614359172";
			params[0] = 2.0;
			String actual = "" + (double)method.invoke(null, params);
			assertEquals(expected, actual);
			
			expected = "" + Math.PI;
			params[0] = 1.0;
			actual = "" + (double)method.invoke(null, params);
			assertEquals(expected, actual);
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(double)");
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
	
	public static void testSphereVolume(){
		String methodName = "sphereVolume";
		try{
			Method method = ch.getMethod(methodName, double.class);
			Object[]params = new Object[1];
			String expected = "33.510321638291124";
			params[0] = 2.0;
			String actual = "" + (double)method.invoke(null, params);
			assertEquals(expected, actual);
			
			expected = "0.0";
			params[0] = 0.0;
			actual = "" + (double)method.invoke(null, params);
			assertEquals(expected, actual);
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(double)");
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
	public static void testInputBirthday(){
		String methodName = "inputBirthday";
		try{
			Method method = ch.getMethod(methodName, Scanner.class);
			Object[]params = new Object[1];
			String expected = """
			On what day of the month were you born? 
			What is the name of the month in which you were born? 
			During what year were you born? 
			You were born on May 8, 1981. You're mighty old!
			""";
			String input = """
			8
			May
			1981
			""";
			expected = expected.replaceAll("\r|\n", " ");
			Scanner scan = new Scanner(input);
			params[0] = scan;
			start();
			method.invoke(null, params);
			String actual = stop();
			assertEquals(expected, actual);
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName +"(Scanner)");
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
