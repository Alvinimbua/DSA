package com.imbuka.algorithms;

import java.util.EmptyStackException;

public class Stack {
	
	private ListNode top;
	private int length; //it will store the size of the stack
	
	private class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	//once we initialize a stack, top pints to null and length = 0
	public Stack() {
		top = null;
		length = 0;
	}
	
	public int length() {
		return length;
	}
	
	//method that will return if stack is empty or not
	public boolean isEmpty() {
		return length == 0;
	}
	
	public void displayStack() {
		if (top == null) {
			return;
		}
		ListNode temp = top;
		while(temp != null) {
			System.out.print(temp.data + " --> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	//push method 
	public void push(int data) {
		ListNode temp = new ListNode(data);
		temp.next = top;
		top = temp;
		length++;
	}
	
	//pop method
	public int pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		int result = top.data;
		top = top.next;
		length --;
		return result;
	}
	
	//peek method (returns the value which top holds)
	 public int peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		 }
		
		return top.data;
		 
	 }
	public static void main(String[] args) {
		Stack stk = new Stack();
		stk.push(12);
		stk.push(23);
		stk.push(45);
		
		stk.displayStack();
		
		stk.pop();
		
		stk.displayStack();
		
		System.out.println(stk.peek());
	}

}
