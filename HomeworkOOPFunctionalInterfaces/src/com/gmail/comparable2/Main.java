package com.gmail.comparable2;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub

		Figure one = new Figure(10);
		Figure two = new Figure(11);
		
		System.out.println(one.compareTo(two));
		System.out.println(one.equals(two));
		
		Box b1 = new Box(10,10);
		Box b2 = new Box(10,20);
		
		System.out.println( b1.compareTo(b2));
		System.out.println( b1.equals(b2));

		Figure [] figures = getArray(one, 10);
		System.out.println(Arrays.toString(figures));
		Box [] boxes = getArray(b1, 10);
		System.out.println(Arrays.toString(boxes));
	}
	
	public static <T extends Comparable<T>>void sortArray(T [] array) {
		for(int i = 0; i< array.length;i++) {
			for(int j = 1; j< array.length;j++) {
				if(j==0 || array[j].compareTo(array[j-1])>0) {
					T temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
	}
	
	private static <T extends Figure>T[] getArray(T figure, int length) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		T [] array = (T[]) Array.newInstance(figure.getClass(), length);
		
		for(int i = 0; i< array.length;i++) {
			array[i] = (T) figure.getClass().getDeclaredConstructor().newInstance();
			array[i].setLength(i);
			
		}
			return array;	
	}

}
