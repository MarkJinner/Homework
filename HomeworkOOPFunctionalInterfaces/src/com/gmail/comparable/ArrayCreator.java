package com.gmail.comparable;

@FunctionalInterface
public interface ArrayCreator<T> {

	public T[] getArray(int length);
}
