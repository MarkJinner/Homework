package com.gmail.oi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCat();
	}
	
	public static void testCat() {
		Cat one = new Cat("Vaska", 1,2);
		Cat two = new Cat("Petka", 2,3);
		Cat three = new Cat("Efim", 1,8);
		Cat four = new Cat("Seratonin", 3,4);
		Cat five = new Cat("Stepan", 5,4);
		Cat[] cats2 = new Cat[] {one,two, three, four, five};
		List<Cat> cats = new ArrayList<>(List.of(one, two, three, four, five));
		System.out.println(cats);
		System.out.println(one.compareTo(four));
		
		cats.sort((o,t)->o.getAge()-t.getAge());
		System.out.println(cats);
		Arrays.sort(cats2);
		System.out.println(Arrays.toString(cats2));
		
		
		
	}

}
