/**
 * This class contains my methods for chapter 6. 
 * 
 * @author Jesse Watson
 */

import java.util.*;
import java.io.*;

public class Ch06{
	public static void main (String[]args) throws FileNotFoundException{
		Scanner coinScan = new Scanner(new File("coins.txt"));
		countCoins(coinScan);
		System.out.println();
		Scanner wordScan = new Scanner(new File("words.txt"));
		wordWrap(wordScan);
		System.out.println();
		Scanner dupScan = new Scanner(new File("duplicates.txt"));
		printDuplicates(dupScan);
		System.out.println();
		Scanner statScan = new Scanner(new File("Jabberwock.txt"));
		inputStats(statScan);
	}
		
	
	//Takes a list of amounts of different coins and calculates the total
	//This answer by Peter Lawrey helped me write my printf line: https://stackoverflow.com/a/13791451
	public static void countCoins(Scanner coinScan){
		double total = 0;
		
		while (coinScan.hasNext()){
			int amount = coinScan.nextInt();
			String ctype = coinScan.next().toLowerCase();
			if (ctype.equals("pennies")){
				total += amount * 1;
			} else if (ctype.equals("nickels")) {
				total += amount * 5;
			} else if (ctype.equals("dimes")) {
				total += amount * 10;
			} else {
				total += amount * 25;
			}
		}
		System.out.printf("Total money: $%.2f%n", total / 100);	
	}
	
	
	//Wraps all lines in words.txt that are longer than 60 characters
	public static void wordWrap(Scanner wordScan){
		while (wordScan.hasNextLine()){
			String line = wordScan.nextLine();
			int length = line.length();
			int start = 0;
			int end = 60;
			while (length > 60){
				System.out.println(line.substring(start, end));
				//Variables adjust so it moves to next section
				start += 60;
				end += 60;
				length -= 60;
			}
			System.out.println(line.substring(start, line.length()));
		}
	}

	
	//Prints duplicate words and the number of repetitions on each line
	public static void printDuplicates(Scanner dupScan){
		while(dupScan.hasNextLine()){
			Scanner line = new Scanner(dupScan.nextLine());
			String current = "";
			int count = 0;
			//Adds up the occurences of the current word
			while(line.hasNext()) {
            String next = line.next();
				if(next.equals(current)) {
					count++;
				} else {
					if(count > 1)
						System.out.print(current + "*" + count + " ");
						current = next;
						count = 1;
				}
			}
			//This was (admittedly unnecessary) fenceposting for the last word but the tester didn't like it so it has been changed. It seems somewhat redundant though so I think it could be made more efficient.
			if(count > 1){
				System.out.println(current + "*" + count + " ");
			}else {
				System.out.println();
			}
		}
	}
	
	
	//Takes a file and reports the number of lines, the longest line, the number of tokens on each line, and the length of the longest token on each line
	public static void inputStats(Scanner statScan){
		int lineNum = 0;
		int longestLine = 0;
		String longestString = "";
		while (statScan.hasNextLine()) {
			lineNum++;
			int token = 0;
			int longestWord = 0;
			String line = statScan.nextLine();
			if (line.length() > longestLine){
				longestLine = line.length();
				longestString = line;
			}
			Scanner lineScan = new Scanner(line);
			while (lineScan.hasNext()){
				token++;
				String word = lineScan.next();
				if (word.length() > longestWord){
					longestWord = word.length();
				}
			}	
			System.out.printf("Line %d has %d tokens (longest = %d)\n", lineNum, token, longestWord);		
		}
		System.out.println("Longest line: " + longestString);	
	}
}
