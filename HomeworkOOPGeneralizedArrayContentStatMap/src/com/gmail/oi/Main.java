package com.gmail.oi;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		displayMapSample(String.class, 20);
	}

	public static <T> void displayMapSample(Class<T> cl, int length) {
		T[] array = (T[]) new ArrayConstructor().constructArray(cl, length);
		System.out.println(Arrays.toString(array));

		new MapSample().analyzeArray(array);

	}

}
