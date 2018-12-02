package edu.wmich.cs1120.efadanelli.LA7;

public class PriorityQueue<E> {
	
	Node<E> head;
	Node<E> rear;
	
	public boolean isEmpty() {
		if(head == null)
			return true;
		else
			return false;
	}
	
	public void enqueue(E data) {
		if(head == null) {
			head = new Node(data);
			rear = head;
		}else {
			
		}
	}
	
	public E dequeue() {
		
		return null;
	}
}
