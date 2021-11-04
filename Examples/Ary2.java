import java.util.*;

public class Ary2{
	public static void main(String[]args){
		int[] nums = new int[10];
		nums = new int[10];
		int[] num2 = {0,1,2,3,4,5,6,7,8};
		for(int i =0; i < nums.length;i++){
			nums[i] = i;
		}
		System.out.println(Arrays.toString(nums));
		shuffle(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println(maximum3(nums));
		System.out.println(Arrays.toString(nums));
		int[][][] matrix = new int[4][5][6];
		System.out.println(Arrays.deepToString(matrix));
		//for(int[][] element: matrix){
			//System.out.println("grid"+Arrays.toString(element));
			//for(int[] e2: element){
				//System.out.println("\trow" +e2);
				//for(int e3: e2){
					//System.out.println("\t\tcol"+e3);
				//}
			//}
		//}
	}
	
	public static int maximum3(int[] ary){
		int[] copy = Arrays.copyOf(ary, ary.length);
		Arrays.sort(copy);
		return copy[copy.length-1];
	}
	
	public static int maximum2(int[] ary){
		int maximum = ary[0];
		for(int element : ary){
			if(element > maximum){
				maximum = element;
			}
		}
		return maximum;
	}
	
	public static int maximum(int[] ary){
		int maximum = ary[0];
		for(int i =0; i< ary.length;i++){
			int element = ary[i];
			if(element > maximum){
				maximum = element;
			}
		}
		return maximum;
	}
	
	
	public static void shuffle(int[] ary){
		Random rand = new Random();
		for(int i =0; i < ary.length;i++){
			int temp = ary[i];
			int j = rand.nextInt(ary.length);
			ary[i] = ary[j];
			ary[j] = temp;
		}
	}
}
