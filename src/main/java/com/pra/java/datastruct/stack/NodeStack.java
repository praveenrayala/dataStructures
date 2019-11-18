package com.pra.java.datastruct.stack;

public class NodeStack<E> implements Stack<E> {

	private Node<E> lastNode;
	
	private Node<E> firstNode;
	
	private int size;
	
	@Override
	public void push(E e) {
		Node<E> node = new Node<E>(e);
		if(lastNode==null) {
			lastNode=node;
			firstNode=node;
		}else if(lastNode==firstNode){
			firstNode.setNextNode(lastNode);
			lastNode.setNextNode(node);
			node.setPrevNode(lastNode);
			lastNode=node;
		}else {
			lastNode.setNextNode(node);
			node.setPrevNode(lastNode);
			lastNode=node;
		}
		size++;
	}

	@Override
	public E pop() {
		Node<E> oldlastNode;
		if(!isEmpty()) {
			if(lastNode.getPrevNode()==null) {
				oldlastNode= lastNode;
				lastNode=null;
				firstNode=null;
				size--;
				return (E) oldlastNode.getE();
			}
		 oldlastNode= lastNode;
		Node<E> newLastNode =lastNode.getPrevNode();
		newLastNode.setNextNode(null);
		lastNode=newLastNode;
		size--;
		if(firstNode==null) {
			lastNode=null;
			return null;
		}
		return (E) oldlastNode.getE();
		}
		return null;
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
	
	public void printDataStructure() {
		Node<E> element=lastNode;
		System.out.printf("\n  \n  ^^^^Stack Top^^^^^ ");
		while(element!=null) {
			System.out.printf("\n <==== " + element.getE() +" ====>");
			element=element.getPrevNode();
		}
		System.out.printf(" \n ========= stack bottom ==========  \n");
	}
}


class Node<E> {
	
	private Node<E> nextNode;
	
	private Node<E> prevNode;
	
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

	public Node<E> getPrevNode() {
		return prevNode;
	}

	public void setPrevNode(Node<E> prevNode) {
		this.prevNode = prevNode;
	}
}
