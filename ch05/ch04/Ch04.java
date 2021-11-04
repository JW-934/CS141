// @Jesse Watson cs141
// This class contains my methods for Chapter 4.

import java.util.*;

public class Ch04{
    public static void main(String[]args) {
        Scanner console = new Scanner(System.in);
        // printRange test
        printRange(2, 7);
        printRange(19, 11);
        printRange(5, 5);
        // longestName test
        longestName(console, 4);
        // wordCount test
        wordCount("hello");
        wordCount("how are you?");
        wordCount("     this     string     has     wide     spaces     ");
        // quadrant test
        quadrant(-2.3, 3.5);
        quadrant(4.5, -4.5);
        quadrant(0,5);
    }
    // This method will print the sequence of numbers between x and y, increasing if x < y, and decreasing if x > y.
    public static void printRange(int x, int y){
        if (x < y) {
            for (int i = x; i <= y; i++){
                System.out.print(i + " ");
            }
        System.out.println();
        }
        if (x > y) {
            for (int i = x; i >= y; i--){
                System.out.print(i + " ");
            }
        System.out.println();
        }
        if (x == y) {
            System.out.println(x);
        }
    }
    // This method will determine and print the longest name in a series of a specified length.
    public static void longestName(Scanner scan, int n){
        // Exception in case longestName is called with a value of n < 2.
        if (n < 2) {
			throw new IllegalArgumentException();
		}
        String lname;
        String fletter;
        lname = "a";
        fletter = "b"; // fletter = first letter, this a and b are meaningless placeholders
        String next;
        for (int i = 1; i < n + 1 ; i++){
            System.out.print("name # " + i + "? ");
            next = scan.next();
            if (next.length() > lname.length()){
                lname = next;
            }  
        }
        // This solution to fix the case of the name feels cumbersome but it works.
        lname = lname.toLowerCase();
        fletter = lname.substring(0, 1).toUpperCase();
        lname = lname.substring(1, lname.length());
        System.out.println(fletter + lname + "'s name is longest");
    }
	
	
	// Exception in case longestName is called with only a scanner.
	public static void longestName(Scanner scan){
		throw new IllegalArgumentException();	
	}
	// Exception in case longestName is called with no scanner.
	public static void longestName(int n){
		throw new IllegalArgumentException();	
	}
    // Exception in case longestName is called with no parameters.
    public static void longestName(){
		throw new IllegalArgumentException();	
	}
    // Exception in case wordCount is called with no parameter.
    public static void wordCount(){
		throw new IllegalArgumentException();
	}
    
    
    
    // This method will count and return the number of words in a string.
    // This code is heavily based on Michael Yaworski's response to this post on Stack Overflow https://stackoverflow.com/questions/5864159/count-words-in-a-string-method
    public static int wordCount(String text){
        int words = 0;
        boolean word = false;
        int endOfLine = text.length() - 1;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i)) && i != endOfLine) {
                word = true;
            } else if (!Character.isLetter(text.charAt(i)) && word) {
                words++;
                word = false;
            } else if (Character.isLetter(text.charAt(i)) && i == endOfLine) {
                words++;
            }
        }
        System.out.println(words); // I was not specifically asked to print the result but it is nicer for testing.
        return words;
    }	
    // This method will determine and return which quadrant a point resides in on a graph.
    public static int quadrant(double x, double y) {
        int quad = 0;
        if (x > 0 && y > 0) {
            quad = 1;
        }
        if (x < 0 && y > 0) {
            quad = 2;
        }
        if (x < 0 && y < 0) {
            quad = 3;
        }
        if (x > 0 && y < 0) {
            quad = 4;
        }
        System.out.println(quad);  // I was not specifically asked to print the result but it is nicer for testing.
        return quad; 
	}
}
