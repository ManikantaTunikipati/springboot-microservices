package com.java.kunal;

import java.util.Arrays;

public class Arrays_DuplicateArray {

	
	
	public static void main(String[] args) {
		
		  int[] arr={1,2,3,4,55,55,66,88,77,88};
	        
		  Arrays.sort(arr);
	        for(int i=0;i<arr.length-1;i++){
	            
	            if(arr[i]==arr[i+1]){
	                System.out.println(arr[i]);
	            }
	        }
	}
}
