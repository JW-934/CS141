// @author Adrian Veliz

import java.lang.reflect.*;
import java.io.*;
@SuppressWarnings("unchecked")
public class HelloWorldTest{
	public static void main(String[]args){
		boolean pass = false;
		String className = "HelloWorld", methodName = "main", params = "String[]", errorMsg = "";
		String fullName = className+"."+methodName+"("+params+")";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream original = System.out, record = new PrintStream(baos);
		System.setOut(record);
		try{
			Class helloWorld = Class.forName(className);
			Method main = helloWorld.getMethod(methodName, String[].class);
			Object[] args2 = new Object[1];
			args2[0] = new String[0];
			main.invoke(null,args2);
			record.flush();
			String expected = "Hello World!", actual = baos.toString().trim();
			assert actual.equals(expected) : "Expected <" + expected + "> but was <"+actual+">";
			pass = true;
		}catch(ClassNotFoundException cnfe){
			errorMsg = "Could not find class \""+className+"\"";
		}catch(NoSuchMethodException nsme){
			errorMsg = "Cout not find method "+fullName;
		}catch(IllegalArgumentException iae){
			errorMsg = "Illegal argument(s) for method "+fullName;
		}catch(IllegalAccessException iae){
			errorMsg = "Could not access method "+fullName;
		}catch(InvocationTargetException ite){
			errorMsg = "Method "+fullName+" threw an exception: " + ite.getCause();
		}catch(AssertionError ae){
			errorMsg = ae.getMessage();
		}finally{
			record.close();
			System.setOut(original);
		}
		if(!pass){
			System.out.println("Test failed: "+errorMsg);
			System.exit(-1);
		}
		System.out.println("Test passed: "+fullName);
	}
}
