import java.util.*;
public class Switch{
	
	public static void main(String[]args){
		Scanner console = new Scanner(System.in);
		
		//game(console.nextInt(), console.nextInt());
		game2(RPS.SCISSORS, RPS.PAPER);
		System.out.println(RPS.SCISSORS.toString());
		
		printIsACSDay2(Day.FRI);
		printIsACSDay2(Day.SUN);
		printIsACSDay2(Day.TUE);
	}
	
	public static void printIsACSDay2(Day day){
		switch(day){
			case MON:case WED:case FRI:
				System.out.println(day.toString() + " is a CS1 day");
				break;
			case TUE:case THUR:
				System.out.println(day.toString() + " is a CS2 day");
				break;
			default:
				System.out.println(day.toString() + " is not a CS day");
		}
		//System.out.println("hi there");
	}
	
	public static void printIsACSDay(Day day){
		if(day == Day.MON || day == Day.WED || day == Day.FRI){
			System.out.println(day.toString() + " is a CS1 day");
		}else if(day == Day.TUE || day ==  Day.THUR){
			System.out.println(day.toString() + " is a CS2 day");
		}else{
			System.out.println(day.toString() + " is not a CS day");
		}
	}
	
	public static void game2(RPS p1, RPS p2){
		if(p1 == null || p2 == null){
			System.out.println("I'm sorry, I didn't think enums could be null");
			return;
		}
		if(p1 == p2){
			System.out.println("P1 and P2 both lose  :(");
		}
		else if((p1 == RPS.ROCK && p2 == RPS.PAPER) || 
				(p1 == RPS.PAPER && p2 == RPS.SCISSORS) || 
				(p1 == RPS.SCISSORS && p2 == RPS.ROCK)){
			System.out.println("P2 wins!");
		}else{
			System.out.println("P1 wins!");
		}
	}
	
	// 1: Rock, 2: Paper, 3: Scissors
	public static void game(int p1, int p2){
		if(p1 < 1 || p1 > 3 || p2 < 1 || p2 > 3){
			System.out.println("Bad input");
			return;
		}
		
		if(p1 == p2){
			System.out.println("P1 and P2 both lose  :(");
		}
		else if((p1 == 1 && p2 == 2) || (p1 == 2 && p2 == 3) || (p1 == 3 && p2 == 1)){
			System.out.println("P2 wins!");
		}else{
			System.out.println("P1 wins!");
		}
	}
}
