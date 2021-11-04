// @author Jesse Watson CS&141 S21
// This program prints the first 12 Fibonacci numbers.
public class fibonacci {
	
	public static void main(String[] args) {
		
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
}
// This YouTube video by Simple Snippets helped me write this program (https://youtu.be/tNCBGSh0qOE), the section at 5:42 really helped me understand the process.
// The "definition of each kth Fibonacci number" in the book made this seem much more complex than it needed to be, I really have no clue what their "intended" code would look like for this.
