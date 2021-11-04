
/**
 * Tester for Chapter 07: Arrays
 * 
 */
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.lang.reflect.*;
@SuppressWarnings("unchecked")
public class Ch07Test{
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
		String className = "Ch07";
		try{
			ch = Class.forName(className);
		}catch(ClassNotFoundException cnfe){
			System.out.println("Could not find class "+className);
			System.exit(-1);
		}
		try{
			testMode();
			testMedian();
			testAppend();
			testMatrixAdd();

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println();
		String optional = "integerAdd";
		try{
			Method method = ch.getMethod(optional);
			System.setIn(new ByteArrayInputStream("12345678901234567890123456789012345678901234567890 \n 12345678901234567890123456789012345678901234567890 \n".getBytes()));
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
	
	public static void testMode(){
		String methodName = "mode";
		try{
			Method method = ch.getMethod(methodName, int[].class);
			Object[]params = new Object[1];
			int expected = 15;
			int[] param = {27, 15, 15, 11, 27};
			
			params[0] = param;
			int actual =(int)method.invoke(null, params);
			assertEquals(expected+"", actual+"");
			
			expected = 0;
			int[]param2 = {0, 0, 0, 1, 1, 1};
			params[0] = param2;
			actual = (int)method.invoke(null, params);
			assertEquals(expected+"", actual+"");
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(int[])");
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
	
	public static void testMedian(){
		String methodName = "median";
		try{
			Method method = ch.getMethod(methodName, int[].class);
			Object[]params = new Object[1];
			int[] param = {5,2,4,17,55,4,3,26,18,2,17};
			int expected = 5;
			params[0] = param;
			int actual = (int)method.invoke(null, params);
			assertEqualsExact(expected+"", actual+"");
			
			int[] param2 = {42,37,1,97,1,2,7,42,3,25,89,15,10,29,27};
			expected = 25;
			params[0] = param2;
			actual = (int)method.invoke(null, params);
			assertEqualsExact(expected+"", actual+"");
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(int[])");
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
	
	public static void testAppend(){
		String methodName = "append";
		try{
			Method method = ch.getMethod(methodName, int[].class, int[].class);
			Object[]params = new Object[2];
			int[] param = {2,4,6};int[]param2 = {1,2,3,4,5};
			int[] expected = {2,4,6,1,2,3,4,5};
			params[0] = param;params[1]=param2;
			int[] actual = (int[])method.invoke(null, params);
			assertEqualsExact(Arrays.toString(expected), Arrays.toString(actual));
			
			int[] expected2 = {1,2,3,4,5,2,4,6};
			params[0] = param2;params[1]=param;
			actual = (int[])method.invoke(null, params);
			assertEqualsExact(Arrays.toString(expected2), Arrays.toString(actual));

		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(int[],int[])");
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
	
	public static void testMatrixAdd(){
		String methodName = "matrixAdd";
		try{
			Method method = ch.getMethod(methodName, int[][].class, int[][].class);
			Object[]params = new Object[2];
			int[][]param = {{1,2},{3,4}};int[][]param2={{5,6},{7,8}};
			params[0] = param;params[1] = param2;
			int[][]actual =(int[][])method.invoke(null, params);
			String expected = "[[6, 8], [10, 12]]";
			assertEquals(expected,Arrays.deepToString(actual));
			
			int[][]param3 = {{-1}};int[][]param4={{-2}};
			params[0] = param3;params[1] = param4;
			actual =(int[][])method.invoke(null, params);
			expected = "[[-3]]";
			assertEquals(expected,Arrays.deepToString(actual));
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(int[][],int[][])");
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
