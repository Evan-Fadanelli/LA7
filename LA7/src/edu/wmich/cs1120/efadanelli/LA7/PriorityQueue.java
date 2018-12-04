package edu.wmich.cs1120.efadanelli.LA7;


public class PriorityQueue<E extends Comparable<E>> {
	
	Node<E> head = null;//when the class first gets set these are the
	Node<E> rear = null;//Beginning variables 
	
	/*
	 * This method looks to see if the queue is empty or not 
	 * and it will return a boolean answer.
	 */
	public boolean isEmpty() {
		return head == null;//if head == null the queue is empty
	}
	
	/*
	 *This method enqueue a node into the Priority Queue in the correct spot
	 *according to its priority.
	 */
	public void enqueue(E data) {
		Node<E> newNode = new Node<E>(data, null);//new node with data and points to nothing
		if(isEmpty()) {// if the queue is empty than the node will become both head and rear
			head = newNode;
			rear = newNode;
			
		}else {
			if(data.compareTo(head.data) == 1) {
				
				newNode.next = head;//if the new node has more priority over the head then the new node
				head = newNode;		//becomes the new head and new node points to head("the previous head")		
			}else {
				Node<E> curr = head.next;//points at the one we will compare to
				Node<E> prev = head;//points at the previous one 
				do {
					if(data.compareTo(curr.data) == 1) {// if the data has more priority than curr's data 
						
						newNode.next = curr;//new node will point at currs node
						prev.next = newNode;//the previous node will point at new node adding it in to the queue
						break;//when inserted break from the loop
					}else {//else go to the next node and loop
						prev = curr;
						curr = curr.next;
					}
				}while(curr != rear);//go while curr is not pointing at rear or break out
				if(curr == rear) {//if curr is rear and is less priority new node becomes rear
					rear.next = newNode;//rear points to new node
					rear = newNode;//rear becomes new node
				}
			}
		}
	}
	
	/*
	 * This method dequeue a node inside of the Priority Queue, and because 
	 * the Priority Queue is already sorted to the most priority node first
	 * that node will be the one returned.
	 */
	public E dequeue() {
		if(isEmpty()) {
			System.out.println("Sorry, but no more to dequeue my guy.");//prints out to USERS
			return null;//return null
		}
		E item = head.data;	  //item get head node data
		if(rear == head)	  //sees if it is the last node
			rear = null;	  //rear gets null
			head = head.next; //head gets heads next node
			return item;	  //return the previous data
	}
	
	/*
	 * This method prints everything that is in the Priority Queue already.
	 */
	public void Qprint() {
		Node<E> curr = head;//curr points at the head
		if(isEmpty())//looks to see if the queue is empty
			System.out.println("The queue is empty");//prints out to the USERS
		else {
			do {
				System.out.println(curr.data);//prints out to the USERS
				curr = curr.next;//points to next node
			}while(!(curr == rear));//loop until it gets to rear
			System.out.println(rear.data);//prints rear out to the USERS
		}
	}
}
