package com.imbuka.algorithms;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
	
	private ListNode head;
	private ListNode tail;
	private int length; // length of the doubly linked list
	
	//inner class 
	private class ListNode {
		private int data;
		private ListNode next; //pointer to next node 
		private ListNode previous; //pointer to previous node 
		
		public ListNode(int data) {
			this.data = data;
		}
	}
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public boolean isEmpty() {
		return length == 0; //i.e head == null
	}
	
	public int length() {
		return length;
	}
	
	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		newNode.previous = tail;
		tail = newNode;
		length++;
	}
	
	//print the list in forward direction
	public void displayForward() {
		if (head == null) {
			return;
		}
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.data + " --> ");
			temp = temp.next;
		}
		System.out.println("null");
	}
	
	//print in backward direction
	public void displayBackward() {
		if (tail == null) {
			return;
		}
		ListNode temp = tail;
		while(temp != null) {
			System.out.print(temp.data + " --> ");
			temp = temp.previous;
		}
		System.out.print("null");
	}
	
	//insert node at the beginning of a doubly linked list
	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		if(isEmpty()) {
			tail = newNode;
		} else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;
	}
	
	//delete first node in a doubly linked list
	public ListNode deleteFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		
		ListNode temp = head;
		if(head == tail) {
			tail = null;
		} else {
			head.next.previous = null;
		}
		head = head.next;
		temp.next = null;
		length--;
		return temp;
		
		
	}
	
	//delete last node in a doubly linked list
		public ListNode deleteLast() {
			if(isEmpty()) {
				throw new NoSuchElementException();
			}
			ListNode temp = tail;
			if(tail == head) {
				tail = null;
			} else {
				tail.previous.next = null;
			}
			tail = tail.previous;
			temp.next = null;
			length--;
			return temp;	
		}
	
	public static void main (String [] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.insertLast(1);
		dll.insertLast(10);
		dll.insertLast(15);
		dll.insertLast(25);
// 
//		dll.insertFirst(2);
//		dll.insertFirst(4);
//		dll.insertFirst(3);
//		dll.insertFirst(5);
		
		dll.displayForward();
		
		dll.deleteLast();
		
		dll.displayForward();
		
		dll.deleteFirst();
		
		dll.displayForward();
 
	}

}
