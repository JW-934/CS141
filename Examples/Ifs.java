import java.util.*;
public class Ifs{
	public static void main(String[]args){
		System.out.println(letterGrade2(100));
		System.out.println(letterGrade2(90));
		System.out.println(letterGrade2(80));
		System.out.println(letterGrade2(70));
		System.out.println(letterGrade2(60));
		System.out.println(letterGrade2(59));
		
		Scanner console = new Scanner(System.in);
		//int max = maxInt(console);
		//System.out.println(max);
		//letterGrade2(max);
		Exception x = example(0);
	}
	// example
	public static IllegalArgumentException example(int x){
		if(x > 0){
			throw new IllegalArgumentException("something was thrown not returned");
		}
		return new IllegalArgumentException("hello!");
	}
	
	/*
	 * returns the maximum of user inputed numbers, prompt using the 
	 * given scanner for the number of numbers
	 */
	public static int maxInt(Scanner console){
		int max = Integer.MIN_VALUE; // anything is bigger than is (in theory)
		System.out.print("Enter the number of numbers: ");
		int numbers = console.nextInt();
		if(numbers <= 0){
			throw new IllegalArgumentException("Number must be positive");
		}
		for(int i =0; i< numbers;i++){
			int next = console.nextInt();
			//if(i == 0){  // first value we is see is max
				//max = next;
			//}
			if(next > max){
				max = next;
			}
		}
		return max;
	}
	
	/*
	 * return the appropriate letter grade given a number
	 */
	public static char letterGrade2(int grade){
		if(grade < 60){
			return 'F';
		}
		if(grade < 70){
			return 'D';
		}
		if(grade < 80){
			return 'C';
		}
		if(grade < 90){
			return 'B';
		}
		return 'A';
	}
	public static char letterGrade(int grade){
		char letter = 0;
		if(grade < 60){
			letter = 'F';
		}else if(grade < 70){
			letter = 'D';
		}else if(grade < 80){
			letter = 'C';
		}else if(grade < 90){
			letter = 'B';
		}else{
			letter = 'A';
		}
		return letter;
	}
}
