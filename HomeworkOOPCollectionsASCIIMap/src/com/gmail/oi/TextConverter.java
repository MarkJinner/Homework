package com.gmail.oi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextConverter implements Converter {
	private SymbolsStorage storage;
	private StringBuilder sb;

	public TextConverter() throws IOException, ClassNotFoundException {
		storage = new SymbolsStorage();
		sb = new StringBuilder();
	}

	public SymbolsStorage getStorage() {
		return storage;
	}

	public void setStorage(SymbolsStorage storage) {
		this.storage = storage;
	}

	@Override
	public void convertWord() throws NoSuchSymbolException {
		System.out.println("Input text you'd like to convert");
		Scanner sc = new Scanner(System.in);
		String txt = sc.nextLine();
		List<String>[] lines = getLines(txt);

		joinLines(lines);

	}

	@Override
	public void convertText(String text) throws NoSuchSymbolException {
		
		List<String>[]  sentence = getLines(text);	
		joinLines(sentence);
		
	}
	

	private void joinLines(List<String>[] lines) {
		StringBuilder sb = new StringBuilder();
	
		if (lines[0] != null) {
			for (int i = 0; i < lines[0].size(); i++) {
				for (int j = 0; j < lines.length; j++) {
					sb.append(lines[j].get(i)+addSpaces(findMax(lines[j]), lines[j].get(i))+" ");
				}
				sb.append(System.lineSeparator());
			}
		}
		System.out.println(sb.toString());
	}

	private List<String>[] getLines(String txt) throws NoSuchSymbolException {
		List<String>[] lines = new ArrayList[txt.toCharArray().length];

		for (int i = 0; i < txt.toCharArray().length; i++) {
			if (storage.getStorage().containsKey(String.valueOf(txt.toCharArray()[i]).toUpperCase())) {
				lines[i] = storage.getStorage().get(String.valueOf(txt.toCharArray()[i]).toUpperCase());
			} else {
				throw new NoSuchSymbolException(
						"No symbol " + String.valueOf(txt.toCharArray()[i]).toUpperCase() + " in storage");
			}
		}
		return lines;
	}

	private int findMax(List<String> line) {
		int max = line.get(0).length();
		for (int i = 1; i < line.size(); i++) {
			if (max < line.get(i).length()) {
				max = line.get(i).length();
			}

		}
		return max;
	}
	
	private String addSpaces(int max, String line) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< max-line.length();i++) {
			sb.append(" ");
		}
		
		return sb.toString();
	}

}
