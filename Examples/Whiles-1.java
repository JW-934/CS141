/**
 * @author cs141 20134
 */
import java.util.*;
public class Whiles{
	public static void main(String[]args){
		Scanner console = new Scanner(System.in);
		//printAvgGrades3(console);
		printRange(0, 10);
		fence(10);
		Random rand = new Random();
		//mystery(rand.nextInt(100));
		for(int i =0; i < 10;i++){
			System.out.println(rand.nextInt(10));
		}
	}
	
	public static void mystery(int mystery){
		Scanner console = new Scanner(System.in);
		System.out.println("Enter a guess");
		int guess = console.nextInt();
		while(guess != mystery){
			if(guess < mystery){
				System.out.println("Guess higher");
			}else{
				System.out.println("Guess lower");
			}
			guess = console.nextInt();
		}
		System.out.println("Congrats! you found the mystery number");
	}
	
	
	// fenceposting is doing an iteration of the loop, outside the loop
	public static void fence(int x){
		// not fenceposting
		//for(int i =0;i<=x;i++){
			//if(i == x)
				//System.out.print("|");
			//else
				//System.out.print("|-");
		//}
		//System.out.println("|");
		System.out.print("|");
		for(int i =0;i<x;i++){
			System.out.print("-|");
		}
		System.out.println();
		
		//for(int i =0;i<x;i++){
			//System.out.print("|-");
		//}
		//System.out.println("|");
	}
	
	public static void printRange(int start, int end){
		for(int i =start;i< end-1;i++){
			System.out.print(i + ", ");
		}
		System.out.println(end-1);
	}
	
	
	public static int count7s(int start, int end){
		if(!(start < end)){
			throw new IllegalArgumentException("start must be less than end");
		}
		
		int count = 0;
		for(int i = start; i<= end;i++){
			if(i %7 == 0){ // i is divisible by 7
				count++;
			}
		}
		
		return 0;
	}
	
	
	public static void printAvgGrades3(Scanner scan){
		if(scan == null){
			throw new IllegalArgumentException();
		}
		
		System.out.println("Give us all the grades, good, bad, and ugly (\"stop\" to stop)");
		double sum =0; 
		int numGrades = 0;
		double nextGrade = 0;
		while(scan.hasNextDouble()){
			nextGrade = scan.nextDouble();
			sum += nextGrade;
			numGrades++;
			System.out.println("looped");
		}
		double avg = sum / numGrades;
		if(avg >= 85){
			System.out.println("You did great in this class!!!!");
		}else{
			System.out.println("There's room for improvement!");
		}	
		System.out.println(avg);
	}
	
	public static void printAvgGrades2(Scanner scan){
		System.out.println("Give us all the grades, good, bad, and ugly (-1 to stop)");
		double sum =1; // start at 1 to account for the addition of "-1"
		int numGrades = -1;// start at -1 to account for the extra iteration of the loop
		int nextGrade = 0;
		while(nextGrade != -1){
			nextGrade = scan.nextInt();
			sum += nextGrade;
			numGrades++;
		}
		double avg = sum / numGrades;
		if(avg >= 85){
			System.out.println("You did great in this class!!!!");
		}else{
			System.out.println("There's room for improvement!");
		}	
		System.out.println(avg);
	}
	
	public static void printAvgGrades(Scanner scan){
		System.out.println("Give us all the grades, good, bad, and ugly (-1 to stop)");
		double sum =0;
		int numGrades = 0;
		for(;;){
			int nextGrade = scan.nextInt();
			if(nextGrade == -1){
				break; // this will exit the for loop
			}
			sum += nextGrade;
			numGrades++;
		}
		double avg = sum / numGrades;
		if(avg >= 85){
			System.out.println("You did great in this class!!!!");
		}else{
			System.out.println("There's room for improvement!");
		}	
		System.out.println(avg);
	}
}
