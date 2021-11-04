/**
 * This is my final project for CS 141, it will ask for the user's hourly wage and take a file called hours.txt containing their work hours for each 
 * day of the week and the amount of each (weekly) paycheck. It will then generate a file called output.txt containing the number of hours, the amount 
 * they made in all each week, how much of it was removed for taxes/fees, the average weekly fees, and which week had the highest fees (indicating union dues etc.).
 * 
 * 
 * @author Jesse Watson
 */
// Testing wage is $13.79

import java.util.*;
import java.io.*;

public class TimesheetCalc{
	
	static File file = new File("hours.txt");
	static String wageString;
	static int weeks;
	static int mostFees;
	static double wage = 0;
	static double avgFees;
	static double[]weekHours;
	static double[]weekPay;
	static double[]weekEarnings;
	static double[]weekFees;
	static double[]feePerc;
	
	public static void main (String[]args) throws FileNotFoundException{
		int i = 0;
		
		PrintStream out = new PrintStream(new File("output.txt"));
		
		//Performs all calculations and populates arrays and variables.
		countWeeks();
		getWage();
		hourAry();
		payAry();
		calcFees();
		calcFeeAvg();
		calcFeePerc();
		findMostFees();
		
		//Creates/populates output.txt with the calculated values
		
		for(i = 0; i < weeks; i++){
			out.println("Week: " + (i + 1)); //i + 1 because i starts at 0 to traverse the arrays
			out.println("Hours Worked: " + weekHours[i]);
			out.printf("Full Earnings: $%.2f%n" , weekEarnings[i]);
			out.println("Taxed Earnings: $" + weekPay[i]);
			out.printf("Fees: $%.2f%n" , weekFees[i]);
			out.printf("Percentage of Earnings Removed: %.2f" , feePerc[i]);
			out.println("%");
			out.println();
			out.println("*************************************************************************");
			out.println();
		}
		
		out.println("Week With The Highest Fee Percentage: Week " + mostFees);
		out.printf("Average Weekly Fees: $%.2f" , avgFees);
		
		System.out.println();
		System.out.println("output.txt has been created.");
		
		
		//For Testing
		//System.out.println(weeks);
		//System.out.println(Arrays.toString(weekHours));
		//System.out.println(Arrays.toString(weekPay));
		//System.out.println(wage);
		//System.out.println(Arrays.toString(weekEarnings));
		//System.out.println(Arrays.toString(weekFees));
		//System.out.println(avgFees);
		//System.out.println(Arrays.toString(feePerc));
	}

	
	//Counts the number of weeks in the file.
	public static void countWeeks() throws FileNotFoundException{
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()){
			sc.nextLine();
			weeks++;
		} 
		weekHours = new double[weeks];
		weekPay = new double[weeks];
		weekEarnings = new double[weeks];
		weekFees = new double[weeks];
		feePerc = new double [weeks];
	}
	
	
	//Populates weekhours[] with the amount of hours worked per week.
	public static void hourAry() throws FileNotFoundException{
		Scanner hours = new Scanner(file);		
		double wkhours = 0;
		double nextDay = 0;		
		int i = 0;		
		int j = 0;
		//double[]weekHours = new double[weeks]; previous solution
		
		for(i = 0; i < weeks; i++){
			for(j = 0; j < 7; j++){ //Counts hours per week
				if(hours.hasNextDouble()){
					nextDay = hours.nextDouble();
					wkhours += nextDay;
				}
			}
			hours.nextLine();
			weekHours[i] = wkhours;
			wkhours = 0;
		}
	}

	
	//Populates weekpay[] with the amount of each weekly paycheck.
	public static void payAry() throws FileNotFoundException{
		Scanner pay = new Scanner(file);
		double wkpay = 0;
		int i = 0;
		int j = 0;
		
		for (i = 0; i < weeks; i++){
			for (j = 0; j < 8; j++){
				wkpay = pay.nextDouble();
			}
			weekPay[i] = wkpay;
		}
	}
		
		
	//Prompts the user for their hourly wage (must be a number, reprompts if necessary).
	public static void getWage(){		
		Scanner input = new Scanner(System.in);
		try {
			while (wage == 0){
				System.out.print("Enter your hourly wage: $");
				wageString = input.nextLine();
				
				//Reprompt if nothing entered.
				if (wageString.equals("")){
				}
				wage = Double.parseDouble(wageString);
			}
		
		//Reprompt if non-number value entered.
		}catch(Exception e) {
			System.out.println("Wage must be a number, try again.");
			getWage();
		
		}
	}


	//Calculates earnings without fees (hours * wage) then populates weekEarnings[]. Then calculates the weekly fees and populates weekFees.
	public static void calcFees(){
		int i = 0;
		
		for (i = 0; i < weeks; i++){
			weekEarnings[i] = weekHours[i] * wage;
			weekFees[i] = weekEarnings[i] - weekPay[i];
		}
	}


	//Calculates the average weekly fees (average of weekFees[]).
	public static void calcFeeAvg(){
		int i = 0;
		double nextFees = 0;
		double feeSum = 0;
		
		for (i = 0; i < weeks; i++){
			nextFees = weekFees[i];
			feeSum += nextFees;
		}
		avgFees = feeSum / weeks;
	}


	//Calculates the percentage of each paycheck that is taken out for fees.
	public static void calcFeePerc(){
		int i = 0;
		
		for (i = 0; i < weeks; i++){
			feePerc[i] = (weekFees[i] / weekEarnings[i]) * 100;
		}
	}


	//Determines which paycheck had the highest percentage of fees removed.
	public static void findMostFees(){
		int i = 0;
		double max = 0;
		double nextFeePerc;
		
		for (i = 0; i < weeks; i++){
			nextFeePerc = feePerc[i];
			if (nextFeePerc > max){
				max = nextFeePerc;
				mostFees = (i + 1);
			}
		}
		
	}
}
//https://www.programiz.com/java-programming/examples/count-lines-in-file
//https://www.w3schools.com/java/java_try_catch.asp
//https://stackoverflow.com/a/3899796
//https://www.geeksforgeeks.org/convert-string-to-double-in-java/
//https://www.daniweb.com/posts/jump/916667
