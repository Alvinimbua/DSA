package com.imbuka.algorithms;
import java.util.Arrays;
import java.util.Stack;

public class NextGreatorElement {

	public static void main(String[] args) {
		int [] arr1 = {4,1,2};
		int [] arr2 = {1,3,4,2};
		int [] ans = nextGreaterElement3(arr1, arr2);
		for (int a : ans) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static int[] nextGreaterElement(int[] arr) {
		 Stack<Integer> stack = new Stack<>();
		 int [] result = new int[arr.length];
		 
		 for (int i = arr.length -1; i >= 0; i--) {
			 //pop all smaller elements
			 while(stack.size() > 0 && stack.peek() < arr[i]) {
				 stack.pop();
			 } 
			 //update result 
			 if(stack.size() == 0) {
				 result[i] = -1;
			 } else {
				 result[i] = stack.peek();
			 }
			 
			//add current element in the stack
			 stack.push(arr[i]);
		 }
		 
		return result;
	}
	
	public static int[] nextGreaterElement2(int[] arr) {
		Stack <Integer> stack = new Stack<>();
		int [] result = new int[arr.length];
		stack.push(0);
		
		for (int i = 1; i < arr.length; i++) {
			//pop smaller elements
			//for all the smaller elements, nge is current element
			while(stack.size() > 0 && arr[stack.peek()] < arr[i]) {
				result[stack.peek()] = arr[i];
				stack.pop();
			}
			stack.push(i);
		}
		
		while(stack.size() > 0) {
			result[stack.pop()] = -1;
		}
		
		return result;
	}
	
	// solving for a circular array
	public static int[] nextGreaterElement3(int[] arr1, int []arr2) {
		int n = arr1.length;
		int c = arr2.length;
		Stack<Integer> stack = new Stack<>();
		int [] result = new int[n];
		Arrays.fill(result, -1);
		stack.push(0);
		
		for (int i = 1; i < 2 * n; i++) {
			for(int j = 1; j < 2 * c; j++) {
				boolean ans = stack.size() > 0 && arr1[stack.peek()] < arr1[i % n] && stack.size() > 0 && arr2[stack.peek()] < arr2[j % c]; 
				while(ans) {
					result[stack.pop()] = arr1[i % n];
					result[stack.pop()] = arr2[j % c];
				}
				stack.push(i % n);
				stack.push(j % n);
				
			}
			
		}
		
		return result;
	}
}
