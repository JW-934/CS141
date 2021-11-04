// @author Jesse Watson CS&141 S21
// This program contains my programs for Chapter 2.
public class Ch02 {
	
	public static void main(String[] args) {
		fibonacci();
		System.out.println();
		triangleNum();
		triangleNumMirror();
		printDesign();
	}

// Prints the first 12 Fibonacci numbers
// This YouTube video by Simple Snippets helped me write the fibonacci method (https://youtu.be/tNCBGSh0qOE), the section at 5:42 really helped me understand the process.
// The "definition of each kth Fibonacci number" in the book made this seem much more complex than it needed to be, I really have no clue what their "intended" code would look like for this.

	public static void fibonacci() {
		
		int a = 1;
		int b = 1;
		int c;
		
		for (int i = 0; i < 12; i++) {
			System.out.print(a + " ");
			c = a + b;
			a = b;
			b = c;	
		}
	}

// Prints a triangle consisting of numbers
	
	public static void triangleNum() {
		
		for (int line = 1; line <= 7; line++) {
			for (int i = 1; i <= (line); i++) 
				System.out.print(line);
				System.out.println();
			}
		}

// Prints a similar figure as triangleNum.java but mirrored
	
	public static void triangleNumMirror() {
	
		for (int line = 1; line <= 5; line++) {
			for (int i= 1; i <= (5 - line); i++) 
				System.out.print(" ");
			for (int i = 1; i <= (line); i++) 
				System.out.print(line);
			System.out.println();
		}
	}
	
// Prints a triangle of numbers surrounded by dashes
	
	public static void printDesign() {
		for (int line = 1; line <= 9; line += 2) {
			for (int i = 0; i < (11 - line) / 2; i++) 
				System.out.print("-");	
			for (int i = 0; i < line; i++) 
				System.out.print(line);
			for (int i = 0; i < (11 - line) /2; i++) 
				System.out.print("-");
				System.out.println();
			}	
	}
}
