package com.imbuka.algorithms;

public class ArrayUtil {
	
	public void printArray(int[] arr) {
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
	}
	
	public void arrayDemo() {
		int[] myArray = {9,5,6,7,8};
//		myArray[0] = 9;
//		myArray[1] = 8;
//		myArray[2] = 7;
//		myArray[3] = 6;
//		myArray[4] = 5;
//		myArray[5] = 9;
		
		printArray(myArray);
		System.out.println(myArray.length);
		System.out.println(myArray[myArray.length -5]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayUtil arrUtil = new ArrayUtil();
		arrUtil.arrayDemo();

	}

}
