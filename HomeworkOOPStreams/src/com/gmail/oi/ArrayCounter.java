package com.gmail.oi;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ArrayCounter<T extends Number> implements Runnable {
	private T[] array;
	private T[][] array2;
	private T result;
	private int start;
	private int finish;

	public ArrayCounter(T[] array) {
		this.array = array;
	}

	public ArrayCounter(T[] array, int start, int finish) {
		this.array = array;
		this.start = start;
		this.finish = finish;
	}

	public ArrayCounter(T[][] array) {
		this.array2 = array;
	}
	
	public ArrayCounter() {
		
	}
	
	

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public Optional<? extends Number> countArray(T[] array, int start, int finish) {
		Optional<? extends Number> result;
		T[] arr = Arrays.copyOfRange(array, start, finish);
		Stream<T> str = Stream.of(arr);
		BinaryOperator<? extends Number> biOp = (one, two) -> one.doubleValue() + two.doubleValue();
		result = str.reduce((BinaryOperator<T>) biOp);
		this.result = (T) result.get();
		return result;
	}

	@Override
	public void run() {
		countArray(array, start, finish);

	}
}
