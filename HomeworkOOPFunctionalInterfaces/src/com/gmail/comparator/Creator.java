package com.gmail.comparator;


@FunctionalInterface
public interface Creator {
	
	public<T> T [] getArray(T ex, int length);
}
