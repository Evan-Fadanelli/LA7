package edu.wmich.cs1120.efadanelli.LA7;

import java.util.NoSuchElementException;

public class PriorityQueue<E> {
	
	Node<E> head = null;
	Node<E> rear = null;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void enqueue(E data) {
		Node<E> newNode = new Node(data, null);
		if(isEmpty()) {
			head = newNode;
		}else {
			rear.next = newNode;
		}
		
	}
	
	public E dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		E item = head.data;
		if(rear == head) {
			rear = null;
		}
			head = head.next;
			return item;
	}
	
	public void Qprint() {
		Node<E> curr = head;
		do
			System.out.println(curr.data);
		while(!(curr == rear));
	}
}
