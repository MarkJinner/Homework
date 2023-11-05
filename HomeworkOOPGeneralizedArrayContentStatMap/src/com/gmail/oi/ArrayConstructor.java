package com.gmail.oi;

import java.lang.reflect.Array;

public class ArrayConstructor<T> {
	private String[] str = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M" };

	public ArrayConstructor() {

	}

	private int getRandomizer(int length) {
		return (int) (Math.random() * length);
	}

	public T[] constructArray(Class<T> cl, int length) {
		T[] array = (T[]) Array.newInstance(cl, length);
		for (int i = 0; i < length; i++) {
			if (cl.equals(Integer.class)) {
				array[i] = cl.cast(this.getRandomizer(10));
			} else if (cl.equals(String.class)) {
				array[i] = cl.cast(str[getRandomizer(str.length)]);
			}
		}
		return array;
	}
}
