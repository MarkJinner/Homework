package com.gmail.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import com.gmail.exceptions.PageNotFoundException;

public class PageLoader {
	private File file;
	private String pathToFiles = "/Users/olegivanov/eclipse-workspace/TextConverterResourse/src/pages/";
	private StringBuilder sb = new StringBuilder();
	private PageTextReplacer replacer = new PageTextReplacer(sb);
	private String address;
	
	public PageLoader(File file) {
		this.file = file;
		
	}

	public PageLoader(String address) {
		this.address = address;
	}
	
	public PageLoader() {
		
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, PageNotFoundException {
		PageLoader pLoader = new PageLoader();

//		Page testPage = pLoader.loadPage("dir").get();

//		System.out.println(testPage);
		System.out.println(pLoader.loadPage("default", "NEW REPLACED TEXT"));
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Optional<Page> loadPage(String pageName) throws FileNotFoundException, IOException, PageNotFoundException {
		sb.delete(0, sb.length());
		String line = "";
		if (Arrays.stream(new File(pathToFiles).listFiles()).anyMatch(s -> s.getName().equals(pageName + ".html"))) {
			try (BufferedReader br = new BufferedReader(new FileReader(new File(pathToFiles + pageName + ".html")))) {
				while ((line = br.readLine()) != null) {
					if(!line.contains("address")) {
						sb.append(line + System.lineSeparator());
					}else {
						sb.append(replacer.replaceAddress(line, address)+System.lineSeparator());
					}
					
				}

			}
			return Optional.ofNullable(new Page(sb.toString()));
		}
		throw new PageNotFoundException("Requested page not found");
	}

	public Optional<Page> loadPage(String pageName, String newText)
			throws FileNotFoundException, IOException, PageNotFoundException {

		sb.delete(0, sb.length());
		String line = "";

		if (Arrays.stream(new File(pathToFiles).listFiles()).anyMatch(s -> s.getName().equals(pageName + ".html"))) {
			try (BufferedReader br = new BufferedReader(new FileReader(new File(pathToFiles + pageName + ".html")))) {
				while ((line = br.readLine()) != null) {
					if (!line.contains("<div class = \"text\">")) {
						sb.append(line + System.lineSeparator());
					} else {
						sb.append(line);
					}
				}
				replacer.replaceDeafaultPageText(newText);
			}
			return Optional.ofNullable(new Page(sb.toString()));
		}
		throw new PageNotFoundException("Requested page not found");
	}



}
