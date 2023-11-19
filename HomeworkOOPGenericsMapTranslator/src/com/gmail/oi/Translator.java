package com.gmail.oi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Translator {
	private Scanner sc = new Scanner(System.in);
	private Vocabular voc;
	private List<String> unTrans;

	public Translator(Vocabular voc) {
		this.voc = voc;
		unTrans = new ArrayList<>();
	}

	public Vocabular getVoc() {
		return voc;
	}

	public void setVoc(Vocabular voc) {
		this.voc = voc;
	}

	public void runTranslation() throws IOException {
		List<List<String>> texts = splitText(inputText());
		System.out.println(texts);
		searchWordsinVoc(texts);
		wantToFixMethod();
	}

	private String inputText() {
		System.out.println("Input text in english and press 'Enter'");
		return sc.nextLine();
	}

	private List<List<String>> splitText(String text) {
		List<List<String>> texts = new ArrayList<>();
		String[] txt = text.split("\\.|\\? |\\!|\\?|\\. ");
		initLists(texts, txt);
		fillLists(texts, txt, addSymbols(text, txt));
		return texts;
	}

	private void fillLists(List<List<String>> texts, String[] txt, char[] syms) {
		for (int i = 0; i < txt.length; i++) {
			for (int j = 0; j < txt[i].split(" |,").length; j++) {
				if (!txt[i].split(" |,")[j].equals(",")) {
					texts.get(i).add(j, txt[i].split(" |,")[j]);

				}
				if (j == txt[i].split(" |,").length - 1) {
					texts.get(i).add(syms[i] + "");
				}

			}

		}
	}

	private void initLists(List<List<String>> texts, String[] txt) {
		for (int i = 0; i < txt.length; i++) {
			texts.add(new ArrayList<>());
		}
	}

	private char[] addSymbols(String text, String[] txt) {
		char[] syms = new char[txt.length];

		int count = 0;
		for (int i = 0; i < syms.length; i++) {
			for (int j = count; j < text.length(); j++) {
				count++;
				if (text.toCharArray()[j] == '?' || text.toCharArray()[j] == '!' || text.toCharArray()[j] == '.') {
					syms[i] = text.toCharArray()[j];
					break;
				}
			}

		}
		return syms;
	}

	private String searchWordsinVoc(List<List<String>> texts) throws IOException {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < texts.size(); i++) {
			for (int j = 0; j < texts.get(i).size(); j++) {
				String wrd = this.voc.searchWordInVoc(texts.get(i).get(j));
				if (!wrd.equals("null")) {
					if (j < texts.get(i).size() - 2) {
						if (j == 0) {
							sb.append(upFirstLetter(wrd) + " ");
						} else {
							if (!wrd.equals(" ")) {
								sb.append(wrd + " ");
							}
						}
					} else {
						if (!wrd.equals(" ")) {
							sb.append(wrd);
						}
					}
				} else {
					unTrans.add(texts.get(i).get(j));
				}

			}
			sb.append(" ");
		}
		searchUntranslated(texts, sb);
		System.out.println(unTrans);
		System.out.println(sb.toString());
		
		return sb.toString();
	}

	private void searchUntranslated(List<List<String>> texts, StringBuilder sb) throws IOException {
		if (unTrans.size() > 0) {
			String[] arr = new String[unTrans.toArray().length];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = unTrans.toArray()[i].toString().toLowerCase();
			}
			unTrans.clear();
			this.voc.addWords(arr);
			sb.delete(0, sb.length());
			if (unTrans.size() == 0) {
				searchWordsinVoc(texts);
			}
		}
	}

	private String upFirstLetter(String wrd) {
		StringBuilder sb = new StringBuilder();
		char[] one = wrd.toCharArray();
		char[] two = wrd.toUpperCase().toCharArray();

		for (int i = 0; i < wrd.toCharArray().length; i++) {
			if (i == 0) {
				sb.append(two[0]);
			} else {
				sb.append(one[i]);
			}

		}

		return sb.toString();

	}

	private void wantToFixMethod() throws IOException {
		System.out.println("Do you want to update any translation? 1 for yes, 2 - for quit the app");
		if (sc.nextInt() == 1) {
			this.voc.editTranslation();
		}else {
			System.out.println("Good bye!");
		}
	}

}
