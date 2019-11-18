package com.pra.java.datastruct.stack;

public class BaseStack<E> implements Stack<E> {

	private E queueArray[] ;
	private int lastIndex= 0; 
	private int capacity ;
	@Override
	public void push(E e) {
		  if(lastIndex>=queueArray.length) {
			  System.out.printf("\n stack is full cannot add \n");
			  return;
		  }
		queueArray[lastIndex++]=e;
	}
	
	public BaseStack(int size) {
		 queueArray = (E[]) new Object[size];
		 capacity=size;
	}

	@Override
	public E pop() {
		if(!isEmpty()) {
		E e =queueArray[lastIndex] ;
		queueArray[lastIndex] =null;
		lastIndex--;
		return e;
		}else {
			return null;
		}
	}


	@Override
	public int size() {
		return lastIndex;
	}

	@Override
	public boolean isEmpty() {
		if(lastIndex==0)
		return true;
		else
		return false;
	}
	
	@Override
	public boolean isFull() {
		if(queueArray.length==lastIndex)
		return true;
		else
		return false;
	}
	
	@Override
	public void printDataStructure() {
		for (int i = lastIndex-1; i >0; i--) {
			if(i==lastIndex-1) {
				System.out.printf("\n  \n      ^^^^Stack Top^^^^^ ");
			}
			
			System.out.printf("\n      <==== " + queueArray[i] +" ====>");
				
		}
		System.out.printf(" \n ========= stack bottom ==========  \n");
	}
//	public abstract E [] reCreate();
	
	@SuppressWarnings("unchecked")
	void init() 
	{
		queueArray =(E[]) new Object[10];
	}
	/*
	 * void resize() { System.arraycopy(queueArray,fisrtIndex,reCreate(),0,size());
	 * }
	 */

}
