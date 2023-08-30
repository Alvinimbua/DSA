package com.imbuka.algorithms;

public class SinglyLinkedList {
	
	//create an instance variable of type ListNode by name head
	
	private ListNode head;
	
	//a static inner class
	private static class ListNode {
		//it takes 2 properties
		//@SuppressWarnings("unused")
		private int data;
		//@SuppressWarnings("unused")
		private ListNode next;
		
		//a constructor of the ListNode Class
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void display( ) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public void printLinkedList() {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	//method to insert at the beginning of the linked list
	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}
	
	//method to insert a node at a given position
	public void insert(int position, int value) {
		ListNode node = new ListNode(value);
		//check if is in position 1 --> if it is 1 we will insert the node at the beginning of the list
		if(position == 1) {
			node.next = head;
			head = node;
		} else {
			ListNode previous = head;
			int count = 1;
			
			while(count < position - 1) {
				previous = previous.next;
				count ++;
			}
			ListNode current = previous.next;
			node.next = current;
			previous.next = node;
		}
	}
	
	//method to insert at the end of the linked list
	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		//we check if the list is empty-->if head == null we know the list is empty and there are no node.
		if(head == null) {
			//assign the value of newNode to head
			head = newNode;
			return;
		}
		//here the singly list is not empty
		//create a temporary node by name current and assign value head to it.
		ListNode current = head;
		while(null != current.next) {
			//iterate current
			current = current.next;	
		}
		/*here it will have current.next == null which means it is the end of the singly linked list
		since the last node of a singly linked list points to null
		it will the assign newNode to current.next.*/
		//
		current.next = newNode;
	}
	
	//method to delete first node of a linked list
	public ListNode deleteFirst() {
		if(head == null) {
			return null;
		} else {
			ListNode temp = head;
			head = head.next;
			temp.next = null;
			return temp;
		}
	}
	
	//method to delete last node of linked list
	public ListNode deleteLast() {
		if(head == null || head.next == null) {
			return head;
		}
		/*
		 * To delete the last node we will have to traverse current to the last node
		 * and previous to the second last node
		 */
		ListNode current = head;
		ListNode previous = null;
		while (current.next != null) {
			previous = current;
			current = current.next;	
		}
		previous.next = null;
		return current;
		
	}
	
	//method to delete a node at a given position 
	public void delete(int position) {
		if (position == 1) {
			head = head.next;
		} else {
			ListNode previous = head;
			int count = 1;
			while (count < position -1) {
				previous = previous.next;
				count++;
			}
			ListNode current = previous.next;
			previous.next = current.next;
		}
	}
	
	//search an element in a singly linked list
	public boolean find(ListNode head, int searchKey) {
		if (head == null) {
			return false;
		}
		//assign current to head
		ListNode current = head;
		while(current != null) {
			//check if the data in the current is equals to the search key(element to search)
			if (current.data == searchKey) {
				return true;
			}
			current = current.next;
		}
		return false;
	}
	
	//finding the length of the list
	public int length() {
		if(head == null) {
			return 0;
		}
		int count = 0;
		ListNode current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
	
	//method to reverse Singly Linked list
	public ListNode reverse(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
	
	/*
	 * method to find middle of a linked list (even or odd)
	 * the idea is to have 2 pointers, making one node traverse one node at a time
	 * while the second node is traversing 2 nodes at a time.
	 */
	public ListNode getMiddle() {
		//check if the node is null
		if (head == null) {
			return null;
		}
		
		ListNode slowPtr = head;
		ListNode fastPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		
		return slowPtr;
	}
	
	//how to get nth node from the end of a linked list
	public ListNode getNthNodeFromEnd(int n) {
		if(head == null) {
			return null;
		}
		
		if(n <= 0) {
			throw new IllegalArgumentException("Invalid value: n = " + n);
		}
		
		ListNode mainPtr = head;
		ListNode refPtr = head;
		int count = 0;
		while (count < n) {
			if(refPtr == null) {
				throw new IllegalArgumentException(n + " is greater than the number of node in the list");
			}
			refPtr = refPtr.next;
			count++;
		}
		
		while(refPtr != null) {
			refPtr = refPtr.next;
			mainPtr = mainPtr.next;
		}
		
		return mainPtr;
		
	}
	
	public ListNode deleteNthNodeFromEnd(ListNode head, int n) {
		
	  //checking if head and head.next == null
    if(head == null || head.next== null) {
			return head;
		}
    ListNode mainPtr = head;
    ListNode refPtr = head;
    ListNode previous = null;

    int count = 0;
    while(count < n -1) {
        refPtr = refPtr.next;
        count ++;
    }
    while(refPtr != null) {
        refPtr = refPtr.next;
        mainPtr = mainPtr.next;
        previous = mainPtr.next;
    }
    previous.next = null;
        return mainPtr;
    }
	
	//method to remove duplicate from a singly linked list
	public void removeDuplicates() {
		if (head == null) {
			return;
		}
		ListNode current = head;
		while(current != null && current.next != null) {
			if(current.data == current.next.data) {
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
	}
	
	//method to insert into a sorted linked list
	public ListNode insertInSortedList(int value) {
		ListNode newNode = new ListNode(value);
		if(head == null || head.next == null ) {
			return head;
		}
		
		ListNode current = head;
		ListNode temp = null;
		
		while(current != null && current.data < newNode.data) {
			temp = current;
			current = current .next;
		}
		
		newNode.next = current;
		temp.next = newNode;
		return head;
	}
	
	//method to remove a key from a sorted linked list
	public void removeKeyFromSortedList(int key) {
		ListNode current = head;
		ListNode temp = null;
		
		while(current != null && current.data == key) {
			head = current.next;
			return;
		}
		
		while(current != null && current.data != key) {
			temp = current;
			current = current.next;
		}
		
	//key is not found
			if(current == null)
				 return;
			temp.next = current.next;
			 
		}
	
	//method to detect a loop in a singly linked list
	public boolean containsLoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		
		if (fastPtr == slowPtr) {
			return true;
		}
		}
		return false;
	}
	
	//method to find a start of a loop in a singly linked list
		public ListNode  startNodeInALoop() {
			ListNode fastPtr = head;
			ListNode slowPtr = head;
			
			while(fastPtr != null && fastPtr.next != null) {
				fastPtr = fastPtr.next.next;
				slowPtr = slowPtr.next;
			
			if (fastPtr == slowPtr) {
				return getStartingNode(slowPtr);
			}
			}
			return null;
		}
	 
	public ListNode getStartingNode(ListNode slowPtr) {
		ListNode temp = head;
		while (slowPtr != temp) {
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		return temp;
	}
	
	//method to remove a loop in a singly linked list
			public void removeLoopInANode() {
				ListNode fastPtr = head;
				ListNode slowPtr = head;
				
				while(fastPtr != null && fastPtr.next != null) {
			 		fastPtr = fastPtr.next.next;
					slowPtr = slowPtr.next;
				
				if (fastPtr == slowPtr) {
					removeLoop(slowPtr);
					return;
			}
		}				 
   }

	private void removeLoop(ListNode slowPtr) {
		ListNode temp = head;
		while(temp.next != slowPtr.next) {
			temp = temp.next;
			slowPtr = slowPtr.next;
		} 
		slowPtr.next = null;
	}

	//create a method that will create a loop in a linked list
	public void createALoopInLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		
		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = third;
	}
	
	public static ListNode merge(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		
		while(a != null && b != null) {
			if(a.data <= b.data) {
				tail.next = a;
				a = a.next;
			} else {
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;
		}
		
		if(a == null) {
			tail.next = b;
		} else {
			tail.next = a;
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList sll1 = new SinglyLinkedList();
		sll1.insertLast(1);
		sll1.insertLast(4);
		sll1.insertLast(7);
		
		SinglyLinkedList sll2 = new SinglyLinkedList();
		sll2.insertLast(3);
		sll2.insertLast(5);
		sll2.insertLast(8);
		sll2.insertLast(9);
		sll2.insertLast(14);
		sll2.insertLast(18);
		
		sll1.display();
		sll2.display();
		
		SinglyLinkedList result = new SinglyLinkedList();
		result.head = merge(sll1.head, sll2.head);
		
		result.display();
		 
		//initialize the singly linked list
		
//		sll.insert(1,3);
//		sll.insert(2,5);
//		sll.insert(1,2);
//		sll.insert(2,4);
//		sll.insert(5,7);
//		
//		sll.delete(1);
//		sll.delete(3);
//		sll.delete(3);
//		sll.display();
//		
//		ListNode head = new ListNode(10);
//		ListNode second = new ListNode(1);
//		ListNode third = new ListNode(8);
//		ListNode fourth = new ListNode(11);
  		
		//Connect them together to form a chain (Singly Linked lIst)
//		head.next = second; //10 --> 1
//		second.next = third; // 10--> 1 --> 8
//		third.next = fourth; //10--> 1 --> 8 --> 11 --> null	
		 
//		SinglyLinkedList sll = new SinglyLinkedList();
//		sll.createALoopInLinkedList();
//		System.out.println(sll.containsLoop());
//		System.out.println(sll.startNodeInALoop().data);  
//		sll.removeLoopInANode();
//		sll.display(); 
		
//		 sll.insertFirst(16);
//		 sll.insertFirst(11);
//		 sll.insertFirst(10);
//		 sll.insertFirst(8);
//		 sll.insertFirst(1);
 		 
		// sll.insertInSortedList(2);
//		 sll.printLinkedList();
		 
		 //sll.removeKeyFromSortedList(2);
//		 sll.insertInSortedList(2);
//		 
//		 sll.printLinkedList();
		 
		 
		// sll.removeDuplicates();
		 
				
//		ListNode middleNode = sll.getMiddle();
//		System.out.println("MIddle node is => " + middleNode.data);
		
//		ListNode nthNode = sll.getNthNodeFromEnd(5);
//		System.out.println("Nth node is => " + nthNode.data);
//		
 
		//System.out.println(sll.deleteNthNodeFromEnd(head, 2).data);
		
		//sll.reverse(head);
	 
//		if(sll.find(head, 13)) {
//			System.out.println("Search Key found !!");
//		} else {
//			System.out.println("Search Key Not found !!");
//		}
//		
		
//		sll.delete(2);
//System.out.println(sll.length());		 
// 
//		sll.insertLast(8);
//		sll.insertLast(4);
//		sll.insertLast(6);
//		sll.insertLast(7);		
//		sll.display();		
//		System.out.println(sll.deleteFirst().data);		
//		sll.display();		
//		System.out.println(sll.deleteLast().data);
//sll.display();
		
	}

}
