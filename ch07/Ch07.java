/**
 * This class contains my methods for chapter 7.
 * 
 * @author Jesse Watson
 */

import java.util.*;
import java.io.*;

public class Ch07{
	public static void main(String[]args){
		int[]modeAry = {27, 15, 15, 11,27};
		mode(modeAry);
		int[]medAry = {5, 2, 4, 17, 55, 4, 3, 26, 18, 2, 17};
		median(medAry);
		
		int[]list1 = {2, 4, 6};
		int[]list2 = {1, 2, 3, 4, 5};
		append(list1, list2);
		append(list2, list1);
		
		//I'm sure there is a better way to fill these but I am currently a bit shaky on multidimensional arrays,
		//this is the exact thing that I've been trying to figure out for my final project.
		int[][]mat1 = new int [2][2];
		mat1[0][0] = 1;
		mat1[0][1] = 2;
		mat1[1][0] = 3;
		mat1[1][1] = 4;
		int[][]mat2 = new int [2][2];
		mat2[0][0] = 5;
		mat2[0][1] = 6;
		mat2[1][0] = 7;
		mat2[1][1] = 8;		
	}

	//Takes an array of integers and returns the most common element within it.
	public static int mode(int []modeAry){
		int[]count = new int[100];
		int i = 0;
		int mostAmt = 0;
		int mostNum = 0;
		for (i = 0; i < modeAry.length; i++){
			int next = modeAry[i];
			count[next]++;
			if (count[next] > mostAmt){
				mostAmt = count[next];
				mostNum = next;
			}
		}
		System.out.println(mostNum);
		return mostNum;
	}

	//Takes an array of integers and returns its median.
	public static int median(int []medAry){
		Arrays.sort(medAry);
		int median = medAry[medAry.length / 2];
		System.out.println(median);
		return median;
	}

	//Creates a new array containing two given arrays put together. 
	public static int[] append(int []list1, int []list2){
		int i = 0;
		int[] list3 = new int[list1.length + list2.length];
		for (i = 0; i < list1.length; i++){
			list3[i] = list1[i];
		}
		for (i = 0; i < list2.length; i++){
			list3[list1.length + i] = list2[i];
		}
		System.out.println(Arrays.toString(list3));
		return list3;
	}

	//Creates a new array containing the sum of two given matrices.
	public static int[][] matrixAdd(int mat1[][], int mat2[][]){
		int[][] mat3 = new int[mat1.length][mat1[0].length];
        for (int i = 0; i < mat3.length; i++) {
            for (int j = 0; j < mat3[0].length; j++) {
                mat3[i][j] = mat1[i][j] + mat2[i][j];
			}
		}
		return mat3;
	}
}
