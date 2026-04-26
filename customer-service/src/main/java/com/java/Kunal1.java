package com.java;

import java.util.Arrays;
import java.util.Scanner;

public class Kunal1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[][] arr = new int[3][2];

		System.out.println(arr.length);

		for (int row = 0; row < arr.length; row++) {

			for (int col = 0; col < arr[row].length; col++) {
				arr[row][col] = scanner.nextInt();
			}
		}
		System.out.println("Output:");

//		for (int row = 0; row < arr.length; row++) {
//		    for (int col = 0; col < arr[row].length; col++) {
//		        System.out.print(arr[row][col] + " ");
//		    }
//		    System.out.println();
//		}
		for(int[] singleArr: arr) {
			System.out.println(Arrays.toString(singleArr));
		}

	}

}
