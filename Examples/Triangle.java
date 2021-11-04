import java.util.*;

public class Triangle {
	
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		triangleLength(console);
	}
	public static void triangleLength(Scanner scan){
		
		boolean equilateral = false;
		boolean isosceles = false;
		boolean scalene = false;
		
		System.out.print("Side 1: ");
		int a = scan.nextInt();
		System.out.print("Side 2: ");
		int b = scan.nextInt();
		System.out.print("Side 3: ");
		int c = scan.nextInt();
		
		// Positive number test
		if (a <= 0 || b <= 0 || c <= 0){
			throw new IllegalArgumentException();	
		}
	
		// Valid triangle test (a + b > c and vice versa)
		if ((a + b) <= c || (b + c) <= a || (a + c) <= b){
			throw new IllegalArgumentException();	
		}
		
		// Scalene test
		if (a != b && b != c && a!=c){
			System.out.println("Scalene");
			scalene = true;
			return;
		}
		
		// Equilateral test
		if (a == b && b == c){
			System.out.println("Equilateral");
			equilateral = true;
			return;
		}
		
		// Isosceles test
		if (a == b || b == c || a == c){
			System.out.println("Isosceles");
			isosceles = true;
			return;
		}
	}
}
