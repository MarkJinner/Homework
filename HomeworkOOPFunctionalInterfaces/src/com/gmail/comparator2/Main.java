package com.gmail.comparator2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testApp();
	}
	
	public static void testApp() {
		List<Integer> numbers = new ArrayList(List.of(72, 73,74,101,102,103,105,108, 107, 41,43,37, 2,39,37, 3, 4,2, 6,8, 10, 24,11, 12, 31, 36, 37, 31, 41, 43,41,42, 44, 46, 44, 43,41, 88, 79));
		List<Integer> numbers3 = new ArrayList<>(List.of(6,4,12,88, 12, 8, 6, 4, 44,3,2, 5));
		IntegerMax iMax = new IntegerMax();
//		iMax.getMax(numbers);
//		Comparator<Integer> comp = iMax.getMax();
		int max = numbers3.get(0);
//		for(Integer i: numbers) {
//			if(comp.compare(i, max)>0) {
//				max = i;
//			}
//		}
		iMax.getMax(numbers3);
//		System.out.println(max);
	}

}
