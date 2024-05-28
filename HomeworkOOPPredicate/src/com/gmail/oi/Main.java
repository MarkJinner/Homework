package com.gmail.oi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.gmail.ownlist.List;
import com.gmail.ownlist.ListIsEmptyException;
import com.gmail.ownlist.OutOfSizeException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			displayPredicates();
		} catch (OutOfSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ListIsEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void displayPredicates() throws OutOfSizeException, ListIsEmptyException {
		List<String> strList = new List<>("zero", "one", "two", "three", "four", "five", "six", "seven", "eigth",
				"nine");
//		removeStartsWithLetter(strList, "o");
		char[] symbols = new char[] { 't', 'f', 's' };

//		removeStartsWithLetters(strList, symbols);

		System.out.println(strList);
		List<Cat> cats = new List<>(new Cat(5, "Kuzia"), new Cat(4, "Vaska"), new Cat(7, "Seryi"), new Cat(12, "Dymka"),
				new Cat(7, "Plyushka"));
		removeCats(cats, 5, "d");
		System.out.println(cats);
	
		Map<Integer, String> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			map.put(i, strList.getByIndex(i));
		}

		filterMap(map);
		
		System.out.println(checkIfEven(103));

	}

	public static void removeStartsWithLetter(List<String> list, String letter)
			throws OutOfSizeException, ListIsEmptyException {
		list.removeIf((f) -> f.startsWith(letter));
	}

	public static void removeStartsWithLetters(List<String> list, char[] symbols)
			throws OutOfSizeException, ListIsEmptyException {
		for (int i = 0; i < symbols.length; i++) {
			removeStartsWithLetter(list, String.valueOf(symbols[i]));
		}
	}

	public static void removeCats(List<Cat> cats, int age, String letter)
			throws OutOfSizeException, ListIsEmptyException {

		Predicate<Cat> one = (a) -> a.getAge() > age;
		Predicate<Cat> two = (l) -> String.valueOf(l.getName().charAt(0)).toLowerCase().compareTo(letter) > 0;

		for (int i = 0; i < cats.getSize(); i++) {
			cats.removeIf(one.and(two));
		}

	}

	public static void filterMap(Map<Integer, String> map ) {
		BiPredicate <Integer, String> pr = (i, s) ->(i!=s.length());
		

		Iterator<Entry<Integer, String>> iter = map.entrySet().iterator();
	
		while(iter.hasNext()) {
			Integer el = iter.next().getKey();
			if(pr.test(el, map.get(el))) {
				iter.remove();
			}
			
		}
		map.forEach((key, value) -> System.out.println(key + " " + value));
		
	}
	
	public static boolean checkIfEven(int number) {
		IntPredicate iPr = (n) ->{
			int sum = 0;
			for(int i = 0; i< String.valueOf(n).toCharArray().length;i++) {
			 sum = 	String.valueOf(n).toCharArray()[i]+ sum;
			}
			if(sum%2==0) {
				return true;
			}
			return false;
		};
		
		return iPr.test(number);

	}

}
