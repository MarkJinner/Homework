package com.gmail.consumer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			testApp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void testApp() throws IOException {
		List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
//		listEven(numbers);
		String str = "This is 9. And this is is nine as well 10. ";
//		addStrings(str);
		String[] txt = str.split("\\. ");
		System.out.println(Arrays.toString(txt));
		File file = null;
	
		addText("one");
		addText("two");
		file = addText("three");
		
//		for (int i = 0; i < txt.length; i++) {
//			file = addText(System.lineSeparator()+txt[i] + ". ");
//			
//		}
		
		System.out.println(readFile(file));
		

	}

	public static void listEven(List<Integer> numbers) {

		Consumer<Integer> cons = (a) -> {
			if (a % 2 == 0) {
				System.out.println(a + " is even");
			}
		};

		for (Integer i : numbers) {
			cons.accept(i);
		}

	}

	public static void addStrings(String str) {
		StringAnalyzer sn = new StringAnalyzer();
		sn.getNumbersStrings(str);
	}

	public static File addText(String txt) throws IOException {
		TextAdder ta = new TextAdder();
		File file = new File("log");
		file.createNewFile();
		ta.addText(txt, file);

		return file;
	}

	private static String readFile(File file) throws FileNotFoundException {
		StringBuilder sb = new StringBuilder();
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				sb.append(sc.nextLine());
			}
		}
		return sb.toString();
	}

}
