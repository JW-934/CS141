import java.io.*;
import java.util.*;
public class Files{
	public static void main(String[]args)throws FileNotFoundException{
		File students = new File("students.txt");
		Scanner scan = new Scanner(students);
		while(scan.hasNext()){
			Scanner parseLine = new Scanner(scan.nextLine());
			System.out.println("given: \t" + parseLine.next());
			System.out.println("family: " + parseLine.next());
			System.out.println("year: \t" + parseLine.next());
			System.out.println("avg: \t" + avg(parseLine.nextLine())+"\n");
			// given family year grades.....
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
