package com.imbuka.algorithms;

import java.util.NoSuchElementException;

/*
 * In Circular linked list we keep track of the lastNode instead of head 
 */
public class CircularSinglyLinkedList {
	
	private ListNode last;
	private int length;
	
	 private class ListNode {
		 private ListNode next;
		 private int data;
		 
		 public ListNode(int data) {
			 this.data = data;
		 }
	 }
	 
	 public CircularSinglyLinkedList() {
		 last = null;
		 length = 0;
	 }
	 
	 public int length() {
		 return length;
	 }
	 
	 public boolean isEmpty() {
		 return length ==0; 
	 }
	 
	 public void createCircularLinkedList() {
		 ListNode first = new ListNode(1);
		 ListNode second = new ListNode(2);
		 ListNode third = new ListNode(3);
		 ListNode fourth = new ListNode(4);
		 
		 first.next = second;
		 second.next = third;
		 third.next = fourth;
		 fourth.next = first;
		 
		 last = fourth;
	 }
	 
	 //method to traverse and print a circular linked list
	 public void displayCircularList() {
		 if (last == null) {
			 return;
		 }
		 
		 ListNode first = last.next;
		 while(first != last) {
			 System.out.print(first.data + " --> ");
			 first = first.next;
		 }
		 System.out.print(first.data + " --> ");
	 }
	 
	 //method to insert node at the start of a circular Singly linked list
	 public void insertFirst(int val) {
		 ListNode temp = new ListNode(val); 
			 if(last == null) {
				 last = temp;
			 } else {
				 temp.next = last.next;
			 }
			 last.next = temp;
			 length++;
	 }
	 
	 //method to insert node at the end of a circular linked list
	 public void insertLast(int val) {
		 ListNode temp = new ListNode(val);
		 if (last == null) {
			 last = temp;
			 last.next = last;
		 } else {
			 temp.next = last.next;
			 last.next = temp;
			 last = temp;
		 }
		length++;	 
	 }
	 
	 //method to remove first node from a circular linked list
	 public ListNode removeFirstNode() {
		 if(isEmpty()) {
			 throw new NoSuchElementException();
		 }
		 
		 ListNode temp = last.next;
		 if(last.next == last) {
			 last = null;
		 } else {
			 last.next = temp.next;
		 }
		 temp.next = null;
		 length--;
		 return temp;
	 }
	
	public static void main(String [] args) {
		CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
//		csll.createCircularLinkedList();
		
		csll.insertFirst(5);
		csll.insertFirst(7);
		csll.insertFirst(9);
		csll.insertFirst(10);
		
//		csll.insertLast(5);
//		csll.insertLast(7);
//		csll.insertLast(9);
//		csll.insertLast(10);
		
		csll.removeFirstNode();
		
		csll.displayCircularList();
		 
	}

}
