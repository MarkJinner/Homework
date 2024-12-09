package com.gmail.oi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class DocParser {
	private File file;

	public DocParser(File file) {
		this.file = file;
	}

	public DocParser() {

	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public List<String> parseDoc(File file) {
		String[] strArray = convertFile(file).split(System.lineSeparator());
		String tag = "<groupid>";
		String tag2 = "</groupid>";
		Predicate<String> pr = getPredicateOne(tag, tag2);

		return Arrays.stream(strArray).filter(pr)
				.map((s) -> s.substring(s.indexOf('>') + 1, s.lastIndexOf('<'))).toList();
	}

	private Predicate<String> getPredicateOne(String tag, String tag2) {
		return (s) -> s.startsWith(tag) & s.endsWith(tag2);
	}

	private String convertFile(File file) {
		Function<File, String> fun = (f) -> {
			StringBuilder sb = new StringBuilder();
			try (Scanner sc = new Scanner(file)) {
				while (sc.hasNextLine()) {
					sb.append(sc.nextLine().trim());
					sb.append(System.lineSeparator());
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return sb.toString();

		};
		return fun.apply(file);

	}
}
