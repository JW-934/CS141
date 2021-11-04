
/**
 * Tester for Chapter 05: Logic and Idefinite Loops
 * 
 */
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.lang.reflect.*;
@SuppressWarnings("unchecked")
public class Ch06Test{
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
		String className = "Ch06";
		try{
			ch = Class.forName(className);
		}catch(ClassNotFoundException cnfe){
			System.out.println("Could not find class "+className);
			System.exit(-1);
		}
		try{
			testCountCoins();
			testWordWrap();
			testPrintDuplicates();
			testInputStats();

		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println();
		//String optional = "pigLatin";
		//try{
			//Method method = ch.getMethod(optional);
			//System.setIn(new ByteArrayInputStream("The deepest shade of mushroom blue\n\n".getBytes()));
			//method.invoke(null);
		//}catch(NoSuchMethodException nsme){
			//System.out.println("Could not find optional method "+optional);
		//}catch(Exception e){
			//testsFailed++;
			//System.out.println(e.getCause());
			//System.out.println(e.getMessage());
			//System.out.println(optional + " test failed");
		//}
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
	
	public static void testCountCoins(){
		String methodName = "countCoins";
		try{
			Method method = ch.getMethod(methodName, Scanner.class);
			Object[]params = new Object[1];
			String expected = "Total money: $2.09";
			
			params[0] = new Scanner(new File("coins.txt"));
			start();
			method.invoke(null, params);
			String actual = stop();
			assertEquals(expected, actual);
			
			expected = "Total money: $0.00";
			params[0] = new Scanner("0 dimes");
			start();
			method.invoke(null, params);
			actual = stop();
			assertEquals(expected, actual);
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(Scanner)");
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
	
	public static void testWordWrap(){
		String methodName = "wordWrap";
		try{
			Method method = ch.getMethod(methodName, Scanner.class);
			Object[]params = new Object[1];
			String expected = """
Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cra
s id risus finibus, tincidunt tortor non, rhoncus magna. Ut\s 
a varius est. Nunc dapibus libero id felis condimentum, at t
empus mi convallis. Cras eget consectetur ante. Sed massa te
llus, accumsan malesuada diam quis, sodales placerat orci. M
orbi non libero luctus, porta magna eu, consectetur ipsum. P
hasellus eros nibh, sagittis et blandit at, dictum eget sem.
 Donec quam leo, fringilla eu metus eu, mattis lobortis lect
us. Phasellus ut mattis libero, quis gravida nibh. Ut eu ex\s 
nec est tristique condimentum. Aliquam eget libero nec urna\s 
pharetra semper nec vitae enim. Vivamus sed magna suscipit,\s 
blandit quam in, vulputate tortor.
""";
			params[0] = new Scanner(new File("words.txt"));
			start();
			method.invoke(null, params);
			String actual = stop();
			assertEqualsExact(expected, actual);
						
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(Scanner)");
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
	
	
	public static void testPrintDuplicates(){
		String methodName = "printDuplicates";
		try{
			Method method = ch.getMethod(methodName, Scanner.class);
			Object[]params = new Object[1];
			params[0] = new Scanner(new File("duplicates.txt"));
			start();
			method.invoke(null,params);
			String actual = stop();
			String expected = "how*2 you*4 \nI*3 Jack's*2 smirking*4 \nwow*2 yippee*2 yippee*2 yay*3 \n\nwakka*3 ";
			assertEquals(expected, actual);
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(Scanner)");
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
	
	public static void testInputStats(){
		String methodName = "inputStats";
		try{
			Method method = ch.getMethod(methodName, Scanner.class);
			Object[]params = new Object[1];
			params[0] = new Scanner(new File("Jabberwock.txt"));
			start();
			method.invoke(null, params);
			String actual = stop();
			String expected = "Line 1 has 5 tokens (longest = 11)\nLine 2 has 8 tokens (longest = 6)\nLine 3 has 6 tokens (longest = 6)\nLine 4 has 3 tokens (longest = 13)\nLongest line: the jaws that bite, the claws that catch,";
			assertEquals(expected,actual);
			
		}catch(NoSuchMethodException nsme){
			testsFailed++;
			System.out.println("Could not find method " + methodName+"(Scanner)");
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
