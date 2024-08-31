package com.gmail.predicates;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.gmail.list.List;
import com.gmail.list.OutOfSizeException;

public class Main {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		try {
//			testPredicates();
//		} catch (OutOfSizeException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ifEven(104);
		
		System.out.println();
		
	}

	public static void testPredicates() throws OutOfSizeException {
		List<String> strs = new List<String>("one", "two", "three", "four");
//		System.out.println(strs);
//		removeFromList(strs, "t");
//		multiplyRemovalFromList(strs, "t", "f","o");
//		System.out.println(strs);
		List<Cat> cats = new List<>(new Cat("Luska", 12), new Cat("Fedka", 4), new Cat("Vaska", 7), new Cat("Anka", 4), new Cat("Chizhik", 7), new Cat("Miron",2),new Cat("Lusska", 4));
		System.out.println(cats);
//		removeFromCatsList(cats, "a", 10);
//		System.out.println(cats.size());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i<cats.size();i++) {
			Cat cat = cats.getByIndex(i);
			map.put(cat.getName(), cat.getAge());
//			System.out.println(cats.getByIndex(i));
		
		}
		
		map.forEach((key, value)->System.out.println(key+" "+value));
		removeFromTheMap(map);

	}

	public static void removeFromList(List<String> list, String letter) {
		Predicate<String> pr = str -> (str.startsWith(letter));
		Iterator<String> iter = list.iterator();

		while (iter.hasNext()) {
			if (pr.test(iter.next())) {
				iter.remove();
			}
		}

	}

	public static void multiplyRemovalFromList(List<String> list, String... letters) {
		for (int i = 0; i < letters.length; i++) {
			removeFromList(list, letters[i]);
		}
	}

	public static void removeFromCatsList(List<Cat> cats, String letter, int age) {
		Predicate<Cat> one = cat -> {

			if ((cat.getName().charAt(0)) > letter.toUpperCase().hashCode()) {
				return true;
			}
			return false;
		};
		Predicate<Cat> two = cat -> {
			if (cat.getAge() < age) {
				return true;
			}
			return false;
		};

		Predicate<Cat> result = one.and(two);
		cats.removeIf(result);
	}

	public static void removeFromTheMap(Map<String, Integer> map) {
		map.forEach((key, value)->System.out.println(key+" "+value));
		BiPredicate<String, Integer> bi = ( s,i) -> {
			if (i == s.toString().length()) {
				return true;
			} 
			return false;
		};

		Set<Entry<String, Integer>> entry = map.entrySet();

		Iterator<Entry< String, Integer>> iter = entry.iterator();

		while (iter.hasNext()) {
			Entry<String, Integer> ent =  iter.next();
			if (bi.test(ent.getKey(), ent.getValue())) {
//				System.out.println(iter.next());
				iter.remove();
			}
		}
		
		System.out.println("Remained: " );
				
		map.forEach((key, value)->System.out.println(key+" "+value));
	}
	
	public static void ifEven(int number) {
		IntPredicate pr = (n)->{
			char [] nmbs = String.valueOf(number).toCharArray();
			int result = 0;
			for(char i:nmbs) {
				result = i+result;
			}
			if(result%2==0) {
				return true;
			}
			return false;
		};
	System.out.println(pr.test(number));
	}
	

}
