package com.gmail.oi;

import java.util.Date;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

public class MultyArrayCounter<T extends Number> {
	private T[][] array;

	public MultyArrayCounter(T[][] array) {
		this.array = array;
	}

	public MultyArrayCounter() {

	}

	public T[][] getArray() {
		return array;
	}

	public void setArray(T[][] array) {
		this.array = array;
	}

	public <T extends Number> int countArray(T[][] array) {
		Date d = new Date();
		long s = d.getTime();
		int result = 0;
		BinaryOperator<? extends Number> bi = (one, two) -> one.intValue() + two.intValue();
		Function<T[], T> fun = (v) -> Stream.of(v).reduce((BinaryOperator<T>) bi).get();
		Stream<T[]> str = Stream.of(array);
		result = (int) str.map(fun).reduce((BinaryOperator<T>) bi).get();
		System.out.println("Time spent on multy: " + (new Date().getTime() - s));
		return result;
	}

	public <T extends Number> int countArrayOrd(T[][] array) {
		Date d = new Date();
		long s = d.getTime();
		int result = 0;

		for (T[] i : array) {
			for (T j : i) {
				result = j.intValue() + result;
			}
		}
		System.out.println("Time spent on ordinary: " + (new Date().getTime() - s));
		return result;
	}

}
