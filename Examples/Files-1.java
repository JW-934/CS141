import java.io.*;
import java.util.*;
public class Files{
	public static void main(String[]args)throws FileNotFoundException{
		Scanner console = new Scanner(System.in);
		//File students = new File(console.next());
		//while(!students.exists()){// asking for permission
			//System.out.println("The file doesn't exist");
			//students = new File(console.next());
		//}
		
		try{// ask forgiveness
			File students = new File(console.next());
			
			Scanner scan = new Scanner(students);
			PrintStream out;// = new PrintStream(new File("output.java"));
			out = System.out;
			while(scan.hasNext()){
				Scanner parseLine = new Scanner(scan.nextLine());
				out.println("given: \t" + parseLine.next());
				out.println("family: " + parseLine.next());
				out.println("year: \t" + parseLine.next());
				out.println("avg: \t" + avg(parseLine.nextLine())+"\n");
				// given family year grades.....
			}
			throw new Exception("This is a thrown exception");
		}catch(FileNotFoundException fnfe){
			//fnfe.printStackTrace();
			System.out.println(fnfe.getCause());
			System.out.println(fnfe.getMessage());
			//throw fnfe;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		
		//int x = Integer.parseInt("100");
		//Scanner console = new Scanner(System.in);
		//int y = 10/ console.nextInt();
		//System.out.println(y);
	}
	
	public static double avg(String grades){
		Scanner parseGrades = new Scanner(grades);
		double sum = 0;
		int num = 0;
		while(parseGrades.hasNext()){
			sum +=parseGrades.nextInt();
			num++;
		}
		return sum / num;
	}
}
