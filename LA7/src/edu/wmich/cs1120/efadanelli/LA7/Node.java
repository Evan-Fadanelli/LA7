package edu.wmich.cs1120.efadanelli.LA7;

public class Node<E> implements INode{

	E data;//the data inside the node
	Node<E> next;//next pointer
	
	Node(E dataValue){
		data = dataValue;	//data inside the node
	}
	
	Node(E dataValue, Node<E> nextNode){
		data = dataValue;//what inside the node
		next = nextNode;//what the node points to next
	}
	
	@Override
	public E getData() {
		return data;//return data
	}

	@Override
	public Node<E> getNext() {
		
		return next; //return next
	}

	@Override
	public void setNext(Node next) {
		
		this.next = next; // this.next points to the next node "next"
	}
}
