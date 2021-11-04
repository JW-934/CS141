// @Jesse Watson cs141
// This class contains my methods for Chapter 3.

import java.util.*;

public class Ch03{
	public static void main(String[]args) {
		Scanner console = new Scanner(System.in);
		printPowersOfN(4, 3);
		printPowersOfN(5, 6);
		printPowersOfN(-2, 8);
		area(2.0);
		sphereVolume(2.0);
		inputBirthday(console);
	}
	
	public static void printPowersOfN(int x, int y) {
	// This method will print all the powers of x up to y.
		for (int i = 0; i <= y; i++ ) {
			System.out.print((int)Math.pow(x, i) + " ");
		}
		System.out.println();
	}
	
	public static double area(double radius) {
	// This method will determine then print and return a circle's area from its radius.
		double area = Math.pow(radius, 2) * Math.PI;
		System.out.println(area);
		return(area); 
	}
	
	public static double sphereVolume(double radius) {
	// This method will determine then print and return a sphere's volume from its radius.
		double volume = (double)4/3 * (Math.PI * Math.pow(radius, 3));
		System.out.println(volume);
		return(volume);
	}
	
	public static void inputBirthday(Scanner scan) {
	// This method will ask for then present the user's birthday.
		
		String month;
		
		// Ask for birthdate
		System.out.print("On what day of the month were you born? ");
		int day = scan.nextInt();
		System.out.print("What is the name of the month in which you were born? ");
		month = scan.next();
		System.out.print("During what year were you born? ");
		int year = scan.nextInt();
		
		// Display birthdate
		System.out.print("You were born on ");
		System.out.print(month + " " + day + ", " + year);	
		System.out.print(". You're mighty old!");
	}
}
