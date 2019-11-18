package com.pra.java.datastruct.queue;

public class NodeQueue<E> implements Queue<E> {

	private Node<E> lastNode;
	
	private Node<E> firstNode;
	
	private int size;
	
	@Override
	public void add(E e) {
		Node<E> node = new Node(e);
		if(lastNode==null) {
			lastNode=node;
			firstNode=node;
		}else {
			lastNode.setNextNode(node);
			lastNode=node;
		}
		size++;
		
	}

	@Override
	public E remove() {
		if(!isEmpty()) {
		Node newfirstNode= firstNode.getNextNode();
		Node oldFirstNode =firstNode;
		firstNode=newfirstNode;
		size--;
		if(firstNode==null) {
			lastNode=null;
			return null;
		}
		return (E) oldFirstNode.getE();
		}
		return null;
	}

	@Override
	public E findFirst() {
		return firstNode.getE();
	}

	@Override
	public E findLast() {
		return lastNode.getE();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if(lastNode==null)
		return true;
		else
		return false;
	}

	@Override
	public boolean isFull() {
		return false;
	}
	
	void printDataStructure() {
		Node element=firstNode;
		System.out.printf("\n  \n Queue start ");
		while(element!=null) {
			System.out.printf(" <==== " + element.getE());
			element=element.getNextNode();
		}
		System.out.printf(" <=== Queue ends \n \n");
	}
	

}


class Node<E> {
	
	private Node<E> nextNode;
	
	E e;
	
	public Node(E e) {
		this.e=e;
	}

	public Node<E> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<E> nextNode) {
		this.nextNode = nextNode;
	}

	public E getE() {
		return e;
	}
	
	
	
	
	
}
