// @author Jesse Watson CS&141 S21
// This program prints a triangle of numbers surrounded by dashes.
public class printDesign {
	
	public static void main(String[] args) {
// Prints dashes before the numbers and increases line variable by 2 to keep the numbers all odd
		for (int line = 1; line <= 9; line += 2) {
			for (int i = 0; i < (11 - line) / 2; i++) 
				System.out.print("-");	
// Prints line values
			for (int i = 0; i < line; i++) 
				System.out.print(line);
// Prints dashes after the numbers
			for (int i = 0; i < (11 - line) /2; i++) 
				System.out.print("-");
// Moves to a new line
			System.out.println();
			}
		}
}
