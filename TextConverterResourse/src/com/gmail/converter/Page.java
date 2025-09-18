package com.gmail.converter;

import java.util.Arrays;
import java.util.Optional;

public class Page {
	private String basicResponse = "HTTP/1.1 200 OK\r\n" + "Server: My_Server\r\n"
			+ "Content-Type:text/html; charset=utf-8\r\nContent-Length: " + "\r\n" + "Connection: close\r\n\r\n";
	private String defaultMessage = "Page not found";
	private String message = "";
	private String pageTitle = "";
	private String pageHead = "";
	private String pagesLines;

	public Page(String pageTitle, String pageHead, String message) {
		this.pageTitle = pageTitle;
		this.pageHead = pageHead;
		this.message = message;
	}
	
	public Page(String lines) {
		this.pagesLines = lines;
	}
	public Page() {
		
	}
	
	public Optional<Page> getNewPage(String lines){
		StringBuilder sb = new StringBuilder();
		sb.append(basicResponse);
		sb.append(lines);
		return Optional.ofNullable(new Page(sb.toString()));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(basicResponse);
		Arrays.stream(pagesLines.split(System.lineSeparator())).forEach(s->sb.append(s+System.lineSeparator()));
		return sb.toString();
	}
}
