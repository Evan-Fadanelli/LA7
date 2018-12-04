package edu.wmich.cs1120.efadanelli.LA7;

import java.util.NoSuchElementException;

public class PriorityQueue<E extends Comparable<E>> {
	
	Node<E> head = null;
	Node<E> rear = null;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void enqueue(E data) {
		Node<E> newNode = new Node<E>(data, null);
		if(isEmpty()) {
			head = newNode;
			rear = newNode;
			System.out.println("QUEUEING UP FIRST");
		}else {
			if(data.compareTo(head.data) == 1) {
				System.out.println("QUEUEING UP HEAD");
				newNode.next = head;
				head = newNode;				
			}else {
				Node<E> curr = head.next;
				Node<E> prev = head;
				do {
					if(data.compareTo(curr.data) == 1) {
						System.out.println("QUEUEING UP MID");
						newNode.next = curr;
						prev.next = newNode;
						break;
					}else {
						prev = curr;
						curr = curr.next;
					}
				}while(curr != rear);
				if(curr == rear) {
					rear.next = newNode;
					rear = newNode;
					System.out.println("QUEUEING UP REAR");
				}
			}
		}
	}
	
	public E dequeue() {
		if(isEmpty()) {
			System.out.println("weffjdskwoejfdikmsljk");
		}
		E item = head.data;
		if(rear == head)
			rear = null;
			head = head.next;
			return item;
	}
	
	public void Qprint() {
		Node<E> curr = head;
		if(isEmpty())
			System.out.println("The queue is empty");
		else {
			do {
				System.out.println(curr.data);
				curr = curr.next;
			}while(!(curr == rear));
			System.out.println(rear.data);
		}
	}
}
