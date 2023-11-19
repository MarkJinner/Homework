package com.gmail.oi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Vocabular {
	private Map<String, String> map;
	private Scanner sc = new Scanner(System.in);
	private DataSaver ds = new DataSaver();
	private File eng;
	private File ru;

	public Vocabular(Map<String, String> map, File eng, File ru) {
		this.map = map;
		this.eng = eng;
		this.ru = ru;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public File getEng() {
		return eng;
	}

	public void setEng(File eng) {
		this.eng = eng;
	}

	public File getRu() {
		return ru;
	}

	public void setRu(File ru) {
		this.ru = ru;
	}

	public void addWord() throws FileNotFoundException, IOException {
		System.out.println("Write word in English and press 'Enter'");
		String engW = sc.nextLine().toLowerCase();

		if (!map.containsKey(engW)) {
			System.out.println("Write translation for the word " + engW+" and press 'Enter'");

			String ruW = sc.nextLine();
			if (ruW.length() > 0) {
				map.put(engW.toLowerCase(), ruW.toLowerCase());
				ds.saveWord(eng, engW.toLowerCase());
				ds.saveWord(ru, ruW.toLowerCase());
			} else {
				map.put(engW.toLowerCase(), "null");
				ds.saveWord(eng, engW.toLowerCase());
				ds.saveWord(ru, "null");
			}

			System.out.println("Translation saved");
		} else {
			wordFound(engW.toLowerCase());
		}

	}

	private void wordFound(String engW) {
		System.out.println("Word " + engW + " found in vocabular: " + map.get(engW));
	}

	public void addWords(String... words) throws IOException {
		for (int i = 0; i < words.length; i++) {
			if (!map.containsKey(words[i].toLowerCase())) {
				System.out.println("Input translation for " + words[i]+" and press 'Enter'");
				String ruW = sc.nextLine();
				if (ruW.length() > 0) {
					map.put(words[i].toLowerCase(), ruW.toLowerCase());
					ds.saveWord(eng, words[i].toLowerCase());
					ds.saveWord(ru, ruW.toLowerCase());
					System.out.println("Translation saved");
				} else {
					map.put(words[i], "null");
					ds.saveWord(eng, words[i].toLowerCase());
					ds.saveWord(ru, "null");
				}

			} else {
				wordFound(words[i].toLowerCase());
			}
		}

	}

	public void editTranslation() throws IOException {
		System.out.println("Write word in English and press 'Enter'");
		String engW = sc.nextLine();

		if (map.containsKey(engW.toLowerCase())) {
			System.out.println("Write new translation and press 'Enter'");
			String ruW = sc.nextLine();
			map.replace(engW.toLowerCase(),ruW.toLowerCase());
			System.out.println("Translation renewed");
			replaceEng(map);
			replaceRu(map);

		}else {
			System.out.println("No such word in vocabular");
		}

	}

	private void replaceEng(Map<String, String> map) throws IOException {
		eng.delete();
		File fileNew = new File(eng.getName());
		fileNew.createNewFile();
		Set<Entry<String, String>> set = map.entrySet();

		for (Entry i : set) {
			ds.saveWord(fileNew, i.getKey().toString());
		}
	}

	private void replaceRu(Map<String, String> map) throws IOException {
		ru.delete();
		File fileNew = new File(ru.getName());
		fileNew.createNewFile();
		Set<Entry<String, String>> set = map.entrySet();

		for (Entry i : set) {
			ds.saveWord(fileNew, i.getValue().toString());
		}
	}

	public void showVocabularL() {
		map.forEach((key, value) -> System.out.println(String.format(("%-"+defineBigger(map)+"s" + " " +value), key)));
	}

	public int defineBigger(Map<String, String> map) {
		int max = 0;

		Set<String> set = map.keySet();
		
		for (String i : set) {
			if (max < i.toString().length()) {
				max = i.toString().length();
			}
		}

		return max*2;

	}

	public void showVocabular() {
		Set<Entry<String, String>> set = map.entrySet();
		Iterator<Entry<String, String>> iter = set.iterator();
//		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}

	}
	
//	public void updateEngWord() {
//		System.out.println("Input engword for update");
//	}
	
	public String searchWordInVoc(String word) {
		String wrd = map.getOrDefault(word.toLowerCase(), "null");
		return wrd;
	}

	@Override
	public String toString() {
		return "Vocabular [map=" + map + ", sc=" + sc + ", ds=" + ds + ", eng=" + eng + ", ru=" + ru + "]";
	}

}
