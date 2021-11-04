// @author Jesse Watson CS&141 S21
// This program prints hourglass-like figures to the screen that consist of asterisks.
public class StarFigures {
	public static void main(String[] args) {
		drawPartialHourglass();
		System.out.println("");
		drawFullHourglass();
		System.out.println("");
		System.out.println("  *  ");
		System.out.println("  *  ");
		System.out.println("  *  ");
		drawPartialHourglass();
	}
	public static void drawPartialHourglass() {
		System.out.println("*****");
		System.out.println("*****");
		System.out.println(" * * ");
		System.out.println("  *  ");
		System.out.println(" * * ");
	}
	public static void drawFullHourglass() {
		System.out.println("*****");
		System.out.println("*****");
		System.out.println(" * * ");
		System.out.println("  *  ");
		System.out.println(" * * ");
		System.out.println("*****");
		System.out.println("*****");
	}
}
