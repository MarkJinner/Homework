package com.gmail.list;

import java.util.Comparator;

public interface ListFunctions<T> {
	public void addFirst(T val);

	public void addLast(T val);

	public void addByIndex(T val, long index) throws OutOfSizeException;

	public void set(T val, long index) throws OutOfSizeException;
	
	public void removeFirst();
	
	public void removeLast();
	
	public T getByIndex(long index) throws OutOfSizeException;
	
	public long size();
	
	public void sort(Comparator<T> comp) throws OutOfSizeException;
	
	

}
