package com.gmail.unaryoperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.UnaryOperator;

public class Main {
	public static void main(String[] args) {
		testApp();
	}

	public static void testApp() {
		List<Integer> nbs = new ArrayList(List.of(1, 2, 3, 4, 5, 6, 7));
		replaceUneven(nbs);
		cutOffLetters("1this is my world456?");
		List<String> words = new ArrayList<>(List.of("one", "fifteen", "three", "twetyone"));
		getStringsList(words);
	}

	public static void replaceUneven(List<Integer> numbers) {
		UnaryOperator<Integer> un = (nmb) -> {

			if (nmb % 2 != 0) {
				System.out.println(nmb);
				return 0;
			}
			return nmb;
		};

		Iterator<Integer> iter = numbers.iterator();
		for (int i = 0; i < numbers.size(); i++) {
			if (un.apply(numbers.get(i)) == 0) {
				numbers.set(i, 0);
			}
		}

		System.out.println(numbers);
	}

	public static void cutOffLetters(String str) {
		char[] letters = new char[26];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = (char) ((char) i + 97);
		}

		UnaryOperator<String> uOP = (txt) -> {
			char[] strs = txt.toCharArray();
			StringBuilder sb = new StringBuilder();
			int x = 0;
			for (int i = 0; i < strs.length; i++) {
				for (int j = 0; j < letters.length; j++) {
					if (strs[i] == letters[j]) {
						x = 1;
					}
					if (j == letters.length - 1 && x == 0) {
						sb.append(strs[i]);
					}

				}
				x = 0;
			}
			return sb.toString().strip();
		};
		System.out.println(Arrays.toString(uOP.apply(str).toCharArray()));
	}
	
	public static List<String> getStringsList(List<String> list){
		
		
		UnaryOperator<List<String>> uOp = (words)->{
			List<String> cutted = new ArrayList<>();
			Iterator<String> iter = list.iterator();
			
			while(iter.hasNext()) {
				String str  = iter.next();
				if(str.length()>5) {
					cutted.add(str);
				}
			}
			
			return cutted;
		};
		
		System.out.println(uOp.apply(list));
		return uOp.apply(list);
	}
}
