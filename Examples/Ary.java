import java.util.*;
public class Ary{
	public static void main(String[]args){
		Scanner scan = new Scanner("100 200 300 400 42");
		while(scan.hasNext()){
			System.out.println(scan.nextInt());
		}
		int num1 = 100, num2 =200, num3 = 300, num4 = 400, num5 = 42;
		System.out.println(num3);
		System.out.println(num1);
		System.out.println(num5);
		System.out.println(num4);
		System.out.println(num2);
		
		int[] nums = {100, 200, 300, 400, 42};
		for(int i =0;i < nums.length;i++){
			System.out.println(nums[i]);
		}
		
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(args));
		
		Random rand;
		if(args.length > 0){
			rand = new Random(Integer.parseInt(args[0]));
		}else{
			rand = new Random();
		}
		System.out.println(rand.nextBoolean());
		System.out.println(rand.nextBoolean());
		System.out.println(rand.nextBoolean());
		System.out.println(rand.nextBoolean());
		
		String[] words = null;
		System.out.println(Arrays.toString(words));
		words = new String[10];
		System.out.println(Arrays.toString(words));
		boolean[] questions = new boolean[5];
		System.out.println(Arrays.toString(questions));
		int[]numbers =new int[100];
		System.out.println(Arrays.toString(numbers));
		int[]number2 = numbers;
		number2[0] = 9000;
		System.out.println(Arrays.toString(numbers));
		char[] hello = {'h','e','l','l','o'};
		System.out.println(Arrays.toString(hello));
		
		String[][] mindBlown= {{"hello", "there"},{"my", "name", "is"},{"adrian"}};
		for(int i = 0;i<mindBlown.length;i++){
			System.out.println(Arrays.toString(mindBlown[i]));
		}
		
		for(int i = 0;i<mindBlown.length;i++){
			for(int j= 0;j<mindBlown[i].length;j++){
				System.out.println(mindBlown[i][j]);
			}
			System.out.println();
		}
	}
}
