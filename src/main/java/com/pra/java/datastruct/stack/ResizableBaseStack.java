package com.pra.java.datastruct.stack;

public class ResizableBaseStack<E> implements Stack<E> {

	private E queueArray[] ;
	private int lastIndex= 0;
	private int fisrtIndex=0;
	private int capacity;
	
	@Override
	public void push(E e) {
		  if(lastIndex>=queueArray.length) {
			  capacity=capacity*2;
			  E newqueueArray [] = (E[]) new Object[capacity];
				for (int i = fisrtIndex; i <lastIndex; i++) {
					newqueueArray[i] = queueArray[i];
				}
				queueArray=newqueueArray;
				System.out.printf("\n Stack was full and is grown by 2 times \n"); 
		  }
		queueArray[lastIndex++]=e;
	}
	
	public ResizableBaseStack(int size) {
		 queueArray = (E[]) new Object[size];
		 capacity=size;
	}

	@Override
	public E pop() {
		if(!isEmpty()) {
		E e =queueArray[lastIndex] ;
		queueArray[lastIndex] =null;
		lastIndex--;
		int reducedSize = capacity; 
		if (queueArray.length >= capacity && queueArray.length  < (reducedSize + (reducedSize << 1))) {
			 E newqueueArray [] = (E[]) new Object[queueArray.length];
				for (int i = fisrtIndex; i <lastIndex; i++) {
					newqueueArray[i] = queueArray[i];
				}
				System.out.printf("\n Stack size was shrinked \n"); 
		}

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
		if(fisrtIndex==lastIndex)
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
		for (int i = lastIndex-1; i >=0; i--) {
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

}
