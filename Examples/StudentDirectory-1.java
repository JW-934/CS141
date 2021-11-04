import java.io.*;
import java.util.*;
public class StudentDirectory{
	public static void main(String[]args){
		try{
			// count number of students
			File students = new File("students.txt");
			Scanner scan = new Scanner(students);
			PrintStream out = System.out;
			int numStudents = 0;
			while(scan.hasNext()){
				numStudents++;
				scan.nextLine();
			}
			
			// build the directory
			Student[] directory = new Student[numStudents];
			scan = new Scanner(students); // reset the scanner
			for(int i =0;i< numStudents;i++){
				Scanner parseLine = new Scanner(scan.nextLine());
				String given = parseLine.next();
				String family = parseLine.next();
				int year = parseLine.nextInt();
				String[]grades = parseLine.nextLine().trim().split(" ");
				Student temp = new Student(given, family, year, grades);
				directory[i] = temp;
			}
			
			Arrays.sort(directory);
			System.out.println(Arrays.toString(directory));
			
			System.out.println(directory[0].getGiven());
			System.out.println(directory[0].getFamily());
			System.out.println(directory[0].getYear());
			
			// try and fail to tamper with grades
			String[] newGrades = directory[0].getGrades();
			newGrades[0] = "100";newGrades[1] = "100";newGrades[2] = "100";newGrades[3] = "100";
			
			System.out.println(Arrays.toString(directory[0].getGrades()));
			
			
		}catch(FileNotFoundException fnfe){
			System.out.println(fnfe.getCause());
			System.out.println(fnfe.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
