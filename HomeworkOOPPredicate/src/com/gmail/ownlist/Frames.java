package com.gmail.ownlist;

public interface Frames <T>{
	
	public void addFirst(T data);
	
	public void addLast(T data);
	
	public void addByIndex(long index, T data) throws ListIsEmptyException, OutOfSizeException;
	
	public void removeFirst() throws ListIsEmptyException;
	
	public void removeLast() throws ListIsEmptyException;
	
	public void removeByIndex(long index) throws ListIsEmptyException, OutOfSizeException;
	
	public T getByIndex(long index) throws OutOfSizeException, ListIsEmptyException;
	
	
	
}
