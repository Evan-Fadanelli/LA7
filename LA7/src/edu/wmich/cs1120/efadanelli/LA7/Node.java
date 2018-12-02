package edu.wmich.cs1120.efadanelli.LA7;

public class Node<E> implements INode{

	E data;
	Node<E> next;
	
	Node(E dataValue){
		data = dataValue;	
	}
	
	Node(E dataValue, Node<E> nextNode){
		data = dataValue;
		next = nextNode;
	}
	
	@Override
	public E getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public Node<E> getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	@Override
	public void setNext(Node next) {
		// TODO Auto-generated method stub
		this.next = next;
	}
}
