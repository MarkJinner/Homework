package com.gmail.list;

import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testList();
		} catch (OutOfSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testList() throws OutOfSizeException {
		List<Integer> list = new List<>();
		
		list.addFirst(1);
		list.addFirst(2);
		System.out.println(list);
		System.out.println(list.size());
		list.addLast(77);
		list.addLast(99);
		System.out.println(list);
		list.addByIndex(1, 3);
		System.out.println(list);
		System.out.println(list.size());
//		Iterator<Integer> iter = list.iterator();
//		
//		while(iter.hasNext()) {
//			if(iter.next()>10) {
//				iter.remove();
//			}
//		}
//		
		Comparator <Integer> cmp = (one, two) ->(one-two);
		list.sort(cmp);
		System.out.println(list);
		System.out.println(list.size());
		
//		System.out.println(list);
//		list.removeFirst();
//		System.out.println(list);
//		list.removeLast();
//		System.out.println(list);
//		System.out.println(list.size());
//		System.out.println(list.getByIndex(1));
//		System.out.println(list.getByIndex(0));
//		
	}

}
