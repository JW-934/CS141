/**
 * Tester for Chapter 01: Introduction
 * 
 */
import java.io.*;
import java.nio.file.*;
import java.lang.reflect.*;
@SuppressWarnings("unchecked")
public class Ch01Test{
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
		
		try{
			testOutput("Spikey");
			testOutput("WellFormed");
			testOutput("MuchBetter");
			testOutput("StarFigures");

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println();

		String className = "TwelveDays";
		try{
			Class temp = Class.forName(className);
			try{
				testOutput(className);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}catch(ClassNotFoundException cnfe){
			System.out.println("Could not find optional class "+className);
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
	public static void testOutput(String className){
		try{
			ch = Class.forName(className);
			Method main = ch.getMethod("main", String[].class);
			Path path = Path.of("output/"+className+".txt");
			String expected = Files.readString(path);
			start();
			Object[]params = new Object[1];
			params[0] = new String[0];
			main.invoke(null,params);
			String actual = stop();
			assertEquals(expected, actual);
			
		}catch(ClassNotFoundException cnfe){
			testsFailed++;
			System.out.println("Could not find class " + className);
			return;
		}catch(AssertionError ae){
			testsFailed++;
			System.out.println(ae.getMessage());
			System.out.println(className + " test failed");
			return;
		}
		catch(Exception e){
			testsFailed++;
			System.out.println(e.getMessage());
			System.out.println(className + " test failed");
			return;
		}
		System.out.println(className + " test passed");
	}
}
