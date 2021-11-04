/**
 * This class contains my methods for chapter 5.
 * 
 * @author Jesse Watson
 */

import java.util.*;

public class Ch05{
	public static void main(String[]args){
		printFactors(24);
		threeHeads(42);
		digitSum(29107);
		digitSum(-456);
		digitSum(0);
		isAllVowels("eIEiO");
		isAllVowels("oink");
		isAllVowels("");
		threeHeads(12345);
		threeHeads(54321);
		threeHeads(0);
	}

// Prints the factors of a positive number.
	public static void printFactors(int x){
		if (x <= 0){
			throw new IllegalArgumentException("Number must be positive");
		}
		int i;
		System.out.print("1");
		for (i = 2; i <= x; i++){
			if (x % i == 0){
				System.out.print(" and " + i);
			}
		}
		System.out.println();
	}

// Flips a coin until it gets three heads in a row.
	public static int threeHeads(int seed){
		Random rand = new Random(seed);
		int heads = 0;
		int i;
		for (i = 0;; i++){
			int x = rand.nextInt(100);
			if (heads == 3){
			System.out.println();
			System.out.println("Three heads in a row!");
			System.out.println();
			return 0;
			} if (x % 2 == 0){
				System.out.print("H ");	
				heads++;
			} if (x % 2 == 1){
				System.out.print("T ");
				heads = 0;
			}
		}
	}

// Finds the sum of a number's individual digits.
	public static int digitSum(int y){
		int remainder, sum = 0;
		// Finds absolute value if y is negative.
		if (y < 0){				
			y = Math.abs(y);
		}
		// This post on Tutorial Gateway helped me figure out the logic for this while loop: https://www.tutorialgateway.org/sum-of-digits-in-java/
		while (y > 0){
			remainder = y % 10;
			sum = sum + remainder;
			y = y / 10;
		} 
		System.out.println(sum);
		return sum;
	}

// Determines if a string consists of only vowels.
	public static boolean isAllVowels(String words) {
    int i = 0;
    // Exception if string is null
    if (words == null){
		throw new IllegalArgumentException();
	}
    for (i = 0; i < words.length(); i++) {
        char letter = words.charAt(i);
        letter = Character.toLowerCase(letter);
        if (letter != 'a' && letter != 'e' && letter != 'i' &&
           letter != 'o' && letter != 'u') {
            System.out.println("false");
            return false;
        }
    }
    System.out.println("true");
    return true;
	}
}
