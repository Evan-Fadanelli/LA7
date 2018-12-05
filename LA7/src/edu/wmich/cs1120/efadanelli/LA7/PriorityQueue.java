package edu.wmich.cs1120.efadanelli.LA7;

public class PriorityQueue<E extends Comparable<E>> {
	
	Node<E> head = null;
	Node<E> rear = null;
	
	public boolean isEmpty() {
		return head == null;
	}
	/*
	 * This method enqueue a node into the Priority Queue.
	 * The most prioritized node is the head and the less prioritized node is the tail.
	 */
	public void enqueue(E data) {
		Node<E> newNode = new Node<E>(data, null);
		if(isEmpty()) {//Queue empty the head and tail will become the data node
			head = newNode;
			rear = newNode;
		}else {
			if(data.compareTo(head.data) == 1) {//If the data is more prioritized than the head then
				newNode.next = head;			//The new node becomes the new head
				head = newNode;				
			}else {
				Node<E> curr = head.next;//Looks at the node it is comparing to
				Node<E> prev = head;	// The node behind curr to point at new node in the correct position
				do {
					if(data.compareTo(curr.data) == 1) {//Do-while loop to run the whole node chain 
						newNode.next = curr;			//If the data is more prioritized than the current data it is comparing
						prev.next = newNode;			//Then the previous node points to new node and new node points to curr
						break;//Break out of the loop once inserted 
					}else {
						prev = curr;
						curr = curr.next;
					}
				}while(curr != rear);
				if(curr == rear) {//If newNode is the lest prioritized than newNode will become the new tail
					rear.next = newNode;
					rear = newNode;
				}
			}
		}
	}
	/*
	 * This method takes the most prioritized node out of the queue and returns that node
	 */
	public E dequeue() {
		E item = head.data;//Data of the most prioritized node
		if(isEmpty()) {
			System.out.println("The queue is empty");//Prints out to USER
		}else {
			 item = head.data;//Data of the most prioritized node
			if(rear == head)
				rear = null;
			head = head.next;//The new head is the next prioritized node in the queue
		}
		return item;//return the most prioritized node in the queue
	}
	/*
	 * This method prints out all of the data in the queue
	 */
	public void Qprint() {
		Node<E> curr = head;
		System.out.println("<<<<<<<<<<<< Beginning of Queue Contents >>>>>>>>>>>>>>>>>");//Print out to user & for formating the output
		if(isEmpty())
			System.out.println("The queue is empty");//Print out to User
		else {
			do {
				System.out.println(curr.data);//Print out to User
				curr = curr.next;
			}while(!(curr == rear));
			System.out.println(rear.data);
		}
		System.out.println("<<<<<<<<<<<< End of Queue Contents >>>>>>>>>>>>>>>>>\n");//Print out to user & for formating the output
	}
}
