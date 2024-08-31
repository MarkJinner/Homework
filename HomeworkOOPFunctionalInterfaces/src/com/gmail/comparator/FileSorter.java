package com.gmail.comparator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class FileSorter {
	private File[] files;
	private List<File> filez;

	public FileSorter(File[] files) {
		this.files = files;
	}

	public FileSorter(List<File> filez) {
		this.filez = filez;
	}

	public FileSorter() {

	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public List<File> getFilez() {
		return filez;
	}

	public void setFilez(List<File> filez) {
		this.filez = filez;
	}

	public void sortFiles(List<File> files) {
		Comparator<File> comp = getFilesComparator();
		
		
		files.sort(comp);
	}

	private Comparator<File> getFilesComparator() {

		Comparator<File> comp = (one, two) -> {
			if (one == null || two == null) {
				throw new NullPointerException();
			} else if (this.getSymbols(this.readFile(one)) > this.getSymbols(this.readFile(two))) {
				return 1;
			} else if (this.getSymbols(this.readFile(one)) < this.getSymbols(this.readFile(two))) {
				return -1;
			}
			return 0;

		};
		return comp;
	}

	private String readFile(File one) {
		StringBuilder sb = new StringBuilder();
		String str = "";
		try (BufferedReader br = new BufferedReader(new FileReader(one))) {

			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

	private int getSymbols(String str) {
		char[] smbs = { ',', '.', ' ', '?', '!', '-' };
		int count = 0;
		
		for (int i = 0; i < smbs.length; i++) {
			
			for (int j = 0; j < str.toCharArray().length; j++) {
				if (smbs[i] == str.toCharArray()[j]) {
					
					count++;
				}
			}
		}

		return count;
	}
}
