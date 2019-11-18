package com.pra.java.datastruct.queue;

public class ResizableBaseQueue<E> implements Queue<E> {

	private E queueArray[] ;
	private int lastIndex= 0; 
	private int fisrtIndex=0;
	private int capacity ;
	@Override
	public void add(E e) {
		
		  if(lastIndex>=queueArray.length) {
			  E newqueueArray [] = (E[]) new Object[capacity*2];
				for (int i = fisrtIndex; i <lastIndex; i++) {
					newqueueArray[i] = queueArray[i];
				}
				queueArray=newqueueArray;
				 System.out.printf("\nQueue was full and is grown by 2 times \n"); 
		  }
		queueArray[lastIndex++]=e;
	}
	
	public ResizableBaseQueue(int size) {
		 queueArray = (E[]) new Object[size];
		 capacity=size;
	}

	@Override
	public E remove() {
		 if (lastIndex == fisrtIndex) { 
	            System.out.printf("\nQueue is empty\n"); 
	            return null; 
	        } 
		E e= queueArray[fisrtIndex++];
		E newqueueArray [] = (E[]) new Object[capacity];
		for (int i = fisrtIndex; i <lastIndex; i++) {
			newqueueArray[i-1] = queueArray[i];
		}
		queueArray=newqueueArray;
		fisrtIndex=0;
		lastIndex--;
		return e;
	}

	@Override
	public E findFirst() {
		return queueArray[fisrtIndex];
	}

	@Override
	public E findLast() {
		return queueArray[lastIndex];
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
	
	void printDataStructure() {
		for (int i = fisrtIndex; i <lastIndex; i++) {
			if(i==fisrtIndex) {
				System.out.printf(" Queue start ");
			}
			
			System.out.printf(" <==== " + queueArray[i]);
				
		}
		System.out.printf(" <=== Queue ends ");
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
