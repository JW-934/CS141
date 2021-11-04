
/**
 * Tester for Chapter 02: Primitive Data Types and Definite Loops
 * 
 */
import java.io.*;
import java.nio.file.*;
import java.lang.reflect.*;
@SuppressWarnings("unchecked")
public class Ch02Test{
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
		String className = "Ch02";
		try{
			ch = Class.forName(className);
		}catch(ClassNotFoundException cnfe){
			System.out.println("Could not find class "+className);
			System.exit(-1);
		}
		try{
			testOutput("fibonacci");
			testOutput("triangleNum");
			testOutput("triangleNumMirror");
			testOutput("printDesign");

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println();
		String optional = "hourglass";
		try{
			Method method = ch.getMethod(optional);
			testOutput(optional);
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
	public static void testOutput(String methodName){
		try{
			Method method = ch.getMethod(methodName);
			Path path = Path.of("output/"+methodName+".txt");
			String expected = Files.readString(path);
			start();
			method.invoke(null);
			String actual = stop();
			assertEquals(expected, actual);
			
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName);
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
