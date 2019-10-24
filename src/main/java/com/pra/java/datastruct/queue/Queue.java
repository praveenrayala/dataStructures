package com.pra.java.datastruct.queue;

public interface Queue<E> {

	void add(E e);
	E remove();
	E findFirst();
	E findLast();
	int size();
	boolean isEmpty();
	boolean isFull();
}
