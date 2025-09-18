package com.gmail.oi;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class VowelsCounter {
	private int count = 0;
	private String str;
	char[] vwls = new char[] { 'a', 'e', 'i', 'o', 'u' };

	public VowelsCounter() {

	}

	private Function<String, Integer> getCounter() {


		Function<String, Integer> fun = (l) -> {
			for (int i = 0; i < vwls.length; i++) {
				for (int j = 0; j < l.toCharArray().length; j++) {
					if (vwls[i] == l.toCharArray()[j]) {
						count++;
					}
				}
			}
			return count;
		};
		return fun;
	}

	public List<String> sortString(String str) {
		String[] words = new String[str.split(" ").length];
		for (int i = 0; i < words.length; i++) {
			words[i] = str.split(" ")[i];
		}
		
		return Arrays.stream(words).filter(ifContains()).sorted(comp()).toList();

	}

	private Predicate<String> ifContains() {
		Predicate<String> pr = (w) -> {
			for (int i = 0; i < w.toCharArray().length; i++) {
				for (int j = 0; j < vwls.length; j++) {
					if (w.toCharArray()[i] == vwls[j]) {
						return true;
					}
				}
			}
			return false;
		};
		return pr;
	}

	private Comparator<String> comp() {
		Function<String, Integer> fun = this.getCounter();
		class Comp implements Comparator<String> {
			public Comp() {

			}

			@Override
			public int compare(String one, String two) {
				if (fun.apply(one) - fun.apply(two) > 0) {
					return 1;
				} else if (fun.apply(one) - fun.apply(two) < 0) {
					return -1;
				}
				return 0;
			}

		}
		return new Comp();
	}
	
	public static int countRaws(File file) throws IOException{
		StringBuilder sb = new StringBuilder();
		String txt = "";
		try(Scanner sc = new Scanner(file)){
		while(sc.hasNextLine()){
		sb.append(sc.nextLine());
		}
		}
		
		System.out.println(sb.toString());
		 return sb.toString().split(System.lineSeparator()).length;

		}
}
