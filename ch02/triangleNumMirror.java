// @author Jesse Watson CS&141 S21
// This program prints a similar figure as triangleNum.java but mirrored.
public class triangleNumMirror {
	
	public static void main(String[] args) {
		
		for (int line = 1; line <= 5; line++) {
// Lines 7 and 8 determine how many spaces to print before the numbers
			for (int i= 1; i <= (5 - line); i++) 
				System.out.print(" ");
// Lines 11 and 12 print the line numbers
			for (int i = 1; i <= (line); i++) 
				System.out.print(line);
			System.out.println();
		}
	}
}
