package edu.wmich.cs1120.efadanelli.LA7;

public class LinkedList<E> {
	// Determine if the LinkedList is empty.
	
	Node<E> head;
	Node<E> rear;
	
	public boolean isEmpty() {
		if(head == null)
			return true;
		else
			return false;
	}
	// Add object received to the linked list if he/she has the priority.
	public void add(E item) {
		if(head == null) {
			head = new Node(item);
			rear = head;
		}else{
			rear.next = new Node(item);
			rear = rear.next;
		}
	}
	// get the object in specific position in the LinkedList used to print the enrolled student contents inside the Course class and return the name
	public E get(int position) {
		Node<E> curr = head;
		for(int i=0;i<position;i++) {
			try {
				curr = curr.next;
			}catch(NullPointerException e) {
				System.err.println("Given index is out of bounds");
			}
		}
		return curr.getData();
	}
	// Return number of elements in the list.
	public int size() {
		int count = 1;
		Node<E> curr = head;
		if(head == null)
			return 1;
		else {
			while(!(curr == rear)) {
				count++;
				curr = curr.next;
			}
			return count;
		}
	}

}
