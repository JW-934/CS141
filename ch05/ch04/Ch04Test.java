
/**
 * Tester for Chapter 04: Conditional Execution
 * 
 */
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.lang.reflect.*;
@SuppressWarnings("unchecked")
public class Ch04Test{
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
		String className = "Ch04";
		try{
			ch = Class.forName(className);
		}catch(ClassNotFoundException cnfe){
			System.out.println("Could not find class "+className);
			System.exit(-1);
		}
		try{
			testPrintRange();
			testLongestName();
			testWordCount();
			testQuadrant();

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println();
		String optional = "caesar";
		try{
			Method method = ch.getMethod(optional);
			System.setIn(new ByteArrayInputStream("Attack zerg at dawn\n3\n".getBytes()));
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
		expected = expected.replaceAll("\\r", "").trim();
		actual = actual.replaceAll("\\r", "").trim();
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
	
	public static void testPrintRange(){
		String methodName = "printRange";
		try{
			Method method = ch.getMethod(methodName, int.class, int.class);
			Object[]params = new Object[2];
			String expected = "2 3 4 5 6 7";
			params[0] = 2;params[1] = 7;
			start();
			method.invoke(null, params);
			String actual = stop();
			assertEquals(expected, actual);
			
			expected = "19 18 17 16 15 14 13 12 11";
			params[0] = 19;params[1] = 11;
			start();
			method.invoke(null, params);
			actual = stop();
			assertEquals(expected, actual);
			
			expected = "5";
			params[0] = 5;params[1] = 5;
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
	
	
	public static void testLongestName(){
		String methodName = "longestName";
		try{
			Method method = ch.getMethod(methodName, Scanner.class, int.class);
			Object[]params = new Object[2];
			Scanner scan = null;
			params[0] = scan; params[1] = 5;
			assertThrows(method, "IllegalArgumentException", params);
			
			scan = new Scanner(""); 
			params[0] = scan; params[1] = -10;
			assertThrows(method, "IllegalArgumentException", params);
			
			scan = new Scanner("Roy DANE sTeFaNiE Mariana");
			params[0] = scan; params[1] = 4;
			start();
			method.invoke(null,params);
			String actual = stop();
			String expected = "name #1? name #2? name #3? name #4? Stefanie's name is longest";
			assertEquals(expected, actual);
			
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(Scanner,int)");
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
	
	public static void testWordCount(){
		String methodName = "wordCount";
		try{
			Method method = ch.getMethod(methodName, String.class);
			Object[]params = new Object[1];
			String nil = null;
			params[0] = nil;
			assertThrows(method, "IllegalArgumentException", params);
			
			String expected = "1";
			params[0] = "hello";
			String actual = ""+(int)method.invoke(null, params);
			assertEquals(expected, actual);
			
			expected = "3";
			params[0] = "how are you?";
			actual = ""+(int)method.invoke(null, params);
			assertEquals(expected, actual);
			
			expected = "5";
			params[0] = "   this   string   has   wide   spaces   ";
			actual = ""+(int)method.invoke(null, params);
			assertEquals(expected, actual);
			
			expected = "0";
			params[0] = " ";
			actual = ""+(int)method.invoke(null,params);
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
	public static void testQuadrant(){
		String methodName = "quadrant";
		try{
			Method method = ch.getMethod(methodName, double.class, double.class);
			Object[]params = new Object[2];
			String expected = "0";
			params[0] = 0.0; params[1] = 1.0;
			String actual = "" + (int)method.invoke(null, params);
			assertEquals(expected, actual);
			
			params[0] = 1.0; params[1] = 0.0;
			expected = "0";
			actual = "" + (int)method.invoke(null, params);
			assertEquals(expected, actual);
			
			params[0] = 1.0; params[1] = 1.0;
			expected = "1";
			actual = "" + (int)method.invoke(null, params);
			assertEquals(expected, actual);
			
			params[0] = -1.0; params[1] = 1.0;
			expected = "2";
			actual = "" + (int)method.invoke(null, params);
			assertEquals(expected, actual);
			
			params[0] = -1.0; params[1] = -1.0;
			expected = "3";
			actual = "" + (int)method.invoke(null, params);
			
			params[0] = 1.0; params[1] = -1.0;
			expected = "4";
			actual = "" + (int)method.invoke(null, params);
			assertEquals(expected, actual);
			assertEquals(expected, actual);
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName +"(double,double)");
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
