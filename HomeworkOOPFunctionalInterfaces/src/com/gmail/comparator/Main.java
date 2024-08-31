package com.gmail.comparator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.gmail.comparator.Animal.Type;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try {
//			testApp();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalArgumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchMethodException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		List<Integer> numbers = new ArrayList(List.of(1,27, 98, -67, 7, 56, -56,-1, -98, -7, 7, 2,-2));
//		List<Integer> numbers = new ArrayList(List.of(100, 27, 2, 91, 77, 90, 78, 101, 102, 98, 71, 110,101,5,10,7));
		IntegerMax max = new IntegerMax();
//		

//		List<Integer> numbers2 = new ArrayList(List.of(2, 3,3,4,6,8,91, 9,5,7,10,11, 12,13, 24,67, 68, 70));
		List<Integer> numbers2 = new ArrayList(List.of(72, 73,74,101,102,103, 107,108, 41,43,37, 2,39,37, 3, 4,2, 6,8, 10, 24,11, 12, 31, 36, 37, 31, 41, 43,41,42, 44, 46, 44, 43,41, 88, 79));
//		System.out.println(max.findMax(numbers2));
//		max.findSimpleNumbers(numbers2);
//		max.ifSimple(numbers2);
		max.defineMax(numbers2);

//		try {
//			sortFiles();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		
////		List<Integer> numbers = new ArrayList<>();
////		for(int i = 0; i<20;i++) {
////			numbers.add(i, -10+(int)(Math.random()*20));
////		}
//
//		System.out.println(numbers);
//		IntegerComparator comp = new IntegerComparator();
//		comp.sortArrayBySum(numbers);
//		
//		ABSComparator <Integer> comp = new ABSComparator<>();
//		comp.findModules(numbers);
////		System.out.println(comp.findModules(numbers));
//		System.out.println(numbers);

	}

	public static void testApp() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Cat[] cats = (Cat[]) getAnimalArray(new Cat(), 10);
		cats[3] = null;

		class NullFriendly implements NullFriendlyComparator {
			public NullFriendly() {

			}
		}
		;

		NullFriendly nf = new NullFriendly();
		Comparator<Cat> comp2 = (one, two) -> one.getAge() - two.getAge();
//		NullFr <Cat>fr = new NullFr<>();
		NullFriendlyComparator<Cat> nullfr = new NullFriendly();

		System.out.println(Arrays.toString(cats));
		sortArray(cats, NullFriendlyComparator.rangeNulls(comp2));
		System.out.println(Arrays.toString(cats));

//		
//		Comparator<Cat> comp = (one, two) -> one.getName().length() - two.getName().length();
//		
//
//		Comparator<Cat> comp3 = comp.thenComparing(comp2);
//		System.out.println(Arrays.toString(cats));

	}

	public static <T> void sortArray(T[] array, Comparator<T> comp)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {

		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if (j == 0 || comp.compare(array[j], array[j - 1]) < 0) {
					T temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

	private static Animal[] getAnimalArray(Animal animal, int length)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		String[] names = { "Vas'ka", "Petkas", "Feka", "Lus'ka", "Svetka", "Fox" };
		Animal[] animals = (Animal[]) Array.newInstance(animal.getClass(), length);
		for (int i = 0; i < animals.length; i++) {
			animals[i] = animal.getClass().getDeclaredConstructor().newInstance();
			if (animal.getClass().equals(Cat.class)) {
				Cat other = (Cat) animals[i];
				other.setAge(getRandom(20));
				other.setName(names[getRandom(names.length - 1)]);
				other.setType(Type.Home);
			}
		}

		return animals;

	}

	private static int getRandom(int max) {
		return 1 + (int) (Math.random() * max);
	}

	private static class IntegerComparator {
		private List<? extends Number> numbers;

		public IntegerComparator(List<? extends Number> numbers) {
			this.numbers = numbers;
		}

		public IntegerComparator() {

		}

		public List<? extends Number> getNumbers() {
			return numbers;
		}

		public void setNumbers(List<? extends Number> numbers) {
			this.numbers = numbers;
		}

		public static <T extends Number> void sortArrayBySum(List<Integer> numbers) {
			Comparator<Integer> cmp = (one, two) -> {
				if (one == null || two == null) {
					throw new NullPointerException();
				} else if (summarize(one) > summarize(two)) {
					return 1;
				} else if (summarize(one) < summarize(two)) {
					return -1;
				}

				return 0;
			};

			for (int i = 0; i < numbers.size(); i++) {
				for (int j = 1; j < numbers.size(); j++) {
					if (cmp.compare(numbers.get(j), numbers.get(j - 1)) < 0) {
						T temp = (T) numbers.get(j);
						numbers.remove(j);
						numbers.add(j, numbers.get(j - 1));
						numbers.remove(j - 1);
						numbers.add(j - 1, (Integer) temp);

					}
				}
			}
			System.out.println(numbers);
		}

		private static <T extends Number> int summarize(T nmb) {
			char[] array = nmb.toString().toCharArray();
//			System.out.println(Arrays.toString(array));
			int total = 0;
			for (char i : array) {
				total = total + Integer.parseInt(String.valueOf(i));
			}
			return total;
		}
	}

	private static class NullFr<T> implements NullFriendlyComparator<T> {
		public NullFr() {

		}
	}

	private static void sortFiles() throws FileNotFoundException, IOException {
		File one = new File("one");
		
		File two = new File("two");
		File three = new File("three");
		File four = new File("four");
		File five = new File("five");
		
			one.createNewFile();
			two.createNewFile();
			three.createNewFile();
			four.createNewFile();
			five.createNewFile();
		
		saveTextInFile(one, "!?");
		saveTextInFile(two, "!???????????");
		saveTextInFile(three, "!???");
		saveTextInFile(four, "!????");
		saveTextInFile(five, "!??");
		
		List<File> files = new ArrayList<>(List.of(one,two, three, four, five));
		System.out.println(files);
		FileSorter fs = new FileSorter();
		
		fs.sortFiles(files);
		
		System.out.println(files);
	}

	private static void saveTextInFile(File file, String text) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.print(text);
		}
	}

}
