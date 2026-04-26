package com.java.kunal;

import java.util.Arrays;

public class Arrays_2 {

	public static void main(String[] args) {
		int[] arr1 = { 55, 77, 33, 44, 99 };

		int largest = Integer.MIN_VALUE;
		int secLargest = Integer.MIN_VALUE;

		for (int n : arr1) {
			if (n > largest) {
				secLargest = largest;
				largest = n;
			}else if (n>secLargest && secLargest!=largest) {
				secLargest=n;
			}
		}
		System.out.println(largest+" :"+secLargest);

		
		
		
		
		
		
		
		//Practive sec largest
		int[] arr2= {2,3,4,5,6,7};
		
		int max=Integer.MIN_VALUE;
		int secMax=Integer.MIN_VALUE;
		

		for(int n:arr2) {
			
			if(n>max) {
				secMax=max;
				max=n;
			}else if(max!=secMax && n>secMax) {
				secMax=n;
				
			}
		}
		System.out.println(secMax);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
