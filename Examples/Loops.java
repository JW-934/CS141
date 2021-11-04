// @author cs141 20314
public class Loops{
	public static int SIZE = 10; // this is a global variable
	public static void main(String[]args){
		printBox3();
		printTriangle();
	}
	// |, \, _
	public static void printTriangle(){
		System.out.print(" ");
		for(int i = 0;i< SIZE + 1;i++){
			System.out.print("_");
		}
		System.out.println();
		for(int i = SIZE; i > 0;i--){
			System.out.print("|");
			for(int j = 0; j< i; j++){
				System.out.print(" ");
			}
			System.out.println("/");
		}
	}
	
	public static void printBox3(){
		for(int k = 0; k < SIZE;k++){
			System.out.print("-");
		}
		System.out.println();
		for(int i = 0; i< (SIZE-1)/2;i++){
			System.out.print("|");
			for(int j = 0;j < SIZE -2;j++){
				System.out.print(" ");
			}
			System.out.println("|");
		}
		for(int l = 0; l < SIZE;l++){
			System.out.print("-");
		}
		System.out.println();
	}
	
	public static void printBox2(){
		printDashes();
		for(int i = 0; i< (SIZE-1)/2;i++){
			System.out.print("|");
			for(int j = 0;j < SIZE -2;j++){
				System.out.print(" ");
			}
			System.out.println("|");
		}
		printDashes();
	}
	
	public static void printBox(){
		printDashes();
		for(int i = 0; i< (SIZE-1)/2;i++){
			printPipes();
		}
		printDashes();
	}
	
	// |
	public static void printPipes(){
		System.out.print("|");
		for(int j = 0;j < SIZE -2;j++){
			System.out.print(" ");
		}
		System.out.println("|");
	}
	// prints a line of dashes
	public static void printDashes(){
		for(int k = 0; k < SIZE;k++){
			System.out.print("-");
		}
		System.out.println();
	}
	
	public static void dullBoy2(){
		dullBoy();
		dullBoy();
		dullBoy();
		dullBoy();
	}
	
	public static void dullBoy(){
		System.out.println("All work and no play makes Homer do something something");
	}
}
