import java.io.*;
import java.util.*;
public class StudentDirectory{
	public static void main(String[]args){
		try{// ask forgiveness
			File students = new File("students.txt");
			Scanner scan = new Scanner(students);
			PrintStream out = System.out;
			
			//Student adrian = new Student("adrian", "veliz", 42, 9000.1);
			//adrian.given = "Adrian";
			//adrian.family = "doe";
			//Student question = new Student();
			
			//out.println(adrian.toString());
			//out.println(question.toString());
			
			int numStudents = 0;
			while(scan.hasNext()){
				numStudents++;
				scan.nextLine();
			}
			
			//String[] givens = new String[numStudents];
			//String[] families = new String[numStudents];
			//int[] years = new int[numStudents];
			//double[] avgs = new double[numStudents];
			Student[] directory = new Student[numStudents];
			
			scan = new Scanner(students);
			for(int i =0;i< numStudents;i++){
				Scanner parseLine = new Scanner(scan.nextLine());
				Student temp = new Student(parseLine.next(), parseLine.next(), parseLine.nextInt(), avg(parseLine.nextLine()));
				directory[i] = temp;
			}
			
			Arrays.sort(directory);
			System.out.println(Arrays.toString(directory));
			
			//Arrays.sort(givens);
			//Arrays.sort(families);
			//Arrays.sort(years);
			//Arrays.sort(avgs);
			//out.println(Arrays.toString(givens));
			//out.println(Arrays.toString(families));
			//out.println(Arrays.toString(years));
			//out.println(Arrays.toString(avgs));
				//out.println("given: \t" + parseLine.next());
				//out.println("family: " + parseLine.next());
				//out.println("year: \t" + parseLine.next());
				//out.println("avg: \t" + avg(parseLine.nextLine())+"\n");
				// given family year grades.....
		}catch(FileNotFoundException fnfe){
			System.out.println(fnfe.getCause());
			System.out.println(fnfe.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
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
