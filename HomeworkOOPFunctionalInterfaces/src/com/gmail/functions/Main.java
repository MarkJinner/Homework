package com.gmail.functions;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import com.gmail.list.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testApp();

	}

	public static void testApp() {
//		System.out.println(getSimpleNumbers(5, 6, 7, 8, 9, 10,11,12));
		String text  = "Any phrase i say. Any phrase i";
//		countConsonants(text);
//		getCodesSum(text);
//		analyzePhrases(text.split("\\.")[0], text.split("\\.")[1]);
		System.out.println(getIntFunction());

	}

	public static int getSimpleNumbers(Integer... numbers) {
		Predicate<Integer> pr = (n) -> {

			for (int i = 2; i <= n; i++) {
				if (i < n) {
					if (n % i == 0) {
						return false;
					}
				} else if (i == n) {
					if (n % i == 0) {
						return true;
					}
				}

			}

			return true;
		};

		Function<Integer[], Integer> f = (nmbs) -> {
			int count = 0;

			for (int i = 0; i < nmbs.length; i++) {
				if (pr.test(nmbs[i])) {
					count++;
				}
			}

			return count;
		};

		return f.apply(numbers);
	}
	
	public static void countConsonants(String str) {
		String []cons = "b, c, d, f, g, h, j, k, l, m, n, p, q, r, s, t, v, w, x, y, z".split(", ");
		System.out.println(Arrays.toString(cons));
		
		Predicate<String> pr = (st)->{
			for(String i: cons) {
				if(i.equals(st)) {
					return true;
				}
			}
			return false;
		};
		Function<String, Integer> fn = (st)->{
			int count = 0;
			char [] letters = str.toCharArray();
			System.out.println(Arrays.toString(letters));
			for(char i: letters) {
				if(pr.test(String.valueOf(i))) {
					count++;
				}
			}
			return count;
		};
		
		
		System.out.println(fn.apply(str));
		
	}
	
	public static Map<Character, Integer> getCodesSum(String str) {
		Function<String, Map<Character, Integer>> fn = (st)->{
			Map<Character, Integer> smbs = new TreeMap<>();
			char [] txt = str.toLowerCase().toCharArray();
			Arrays.sort(txt);
			for(int i = 0; i< txt.length;i++) {
				if(!smbs.containsKey(txt[i])) {
					smbs.put(txt[i], 1);
				}else {
					smbs.put(txt[i], smbs.get(txt[i])+1);
				}
			}
			
			smbs.forEach((key, value)->System.out.println(key+" "+(value*key)));
			return smbs;
		};
		
		return fn.apply(str);
	}
	
	public static void analyzePhrases(String str, String str2) {
		BiPredicate<String, String[]> pr = (st, txt)->{
			for(int i = 0; i< txt.length;i++) {
				if(st.equals(txt[i])) {
					return true;
				}
			}
			return false;
		};
		String [] one = str.split(" ");
		System.out.println(Arrays.toString(one));
		String [] two = str2.split(" ");
		
		List<String> list  = new List<>();
		
		for(int i = 0; i< one.length;i++) {
				if(pr.test(one[i],two)) {
					list.addFirst(one[i]);

			}
		}
		
		System.out.println(list);

	}
	
	public static int getIntFunction() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy", new Locale("EN", "ENG"));

		Calendar cl = Calendar.getInstance();

		
		ToIntFunction <Calendar>ifunc = (c)-> {
			Date date2 = cl.getTime();	
			System.out.println(sdf.format(date2));
			String sub = date2.toString().substring(date2.toString().length()-4, date2.toString().length());
			return Integer.parseInt(sub);
			
		};
		
		
		return ifunc.applyAsInt(cl);
		
	}

}
