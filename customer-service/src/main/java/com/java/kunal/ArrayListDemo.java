package com.java.kunal;

import java.util.Arrays;

public class ArrayListDemo {

	public static void main(String[] args) {

		//reverse array
		int[] arr = {1,2,3,4,5};
		
		int start=0;
		int end=arr.length-1;
		System.out.println("END ::"+end);
		while(start<end) {
			
			swap(arr,start,end);
			start++;
			end--;
			
		}
		System.out.println(Arrays.toString(arr));
		
		//Max array
		
		int maxNum=arr[0];
		
		for(int i=0;i<arr.length;i++) {
			
			if(arr.length==0) {
				return;
			}
			
			if(arr[i]>maxNum) {
				maxNum=arr[i];
			}
		}
		System.out.println("maxNum ::"+maxNum);
		
		int max=arr[0];
		
		for(int n:arr) {
			if(n>max) {
				max=n;
			}
		}
		System.out.println(max);
		
		int maxN = Arrays.stream(arr).max().getAsInt();
		
		
		
		
	}

	private static void swap(int[] arr, int start, int end) {
		int temp=arr[start];
		arr[start]=arr[end];
		arr[end]=temp;
	}
}
