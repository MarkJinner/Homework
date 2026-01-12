package com.gmail.converter;

import java.util.Arrays;

public class RequestParser implements RequestParserService{
	private String request;

	public RequestParser(String request) {
		this.request = request;
	}

	public RequestParser() {

	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public static void main(String[] args) {
		String requestExample = "GET /underConstruction.html HTTP/1.1\n" + "Host: localhost:8085\n"
				+ "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:143.0) Gecko/20100101 Firefox/143.0\n"
				+ "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n"
				+ "Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3\n"
				+ "Accept-Encoding: gzip, deflate, br, zstd\n" + "Connection: keep-alive\n"
				+ "Referer: http://localhost:8085/\n" + "Upgrade-Insecure-Requests: 1\n" + "Sec-Fetch-Dest: document\n"
				+ "Sec-Fetch-Mode: navigate\n" + "Sec-Fetch-Site: same-origin\n" + "Sec-Fetch-User: ?1\n"
				+ "Priority: u=0, i";
		RequestParser rp = new RequestParser();

//		System.out.println(rp.parseTextFromPOST(requestExample));
//		System.out.println(rp.parseRequest(requestExample));
//		String res = rp.parseStaticPageRequest("GET /main.html HTTP/1.1");

//		String slash = "default.html/ ";
//		System.out.println(rp.removeSlash(slash));
		System.out.println(rp.parseRequestReferer(requestExample));

	}

	@Override
	public String parseRequest(String request) {
		String requestLine = request.split(System.lineSeparator())[0];
		String response = "";
		String finalResponse = "";
		response = parseStaticPageRequest(requestLine);
		finalResponse = response;
		return checkHTML(finalResponse);
	}
	
	public String parseRequestReferer(String request) {
		String result  = "";
		if(request.length()>0) {
			result = Arrays.stream(request.split(System.lineSeparator())).filter(s->s.contains("Referer:")).reduce("", (a,b)->a+b);
			if(result.contains("Referer:")) {
				return result.substring(8, result.length()).strip();
			}
		}
		return "";
	}

	private String parseStaticPageRequest(String requestLine) {
//		System.out.println(requestLine);
		if (requestLine.contains("GET")) {
			return requestLine.substring(requestLine.indexOf("GET /") + "GET /".length(),
					requestLine.indexOf(" HTTP/1.1"));
		} else {
			return requestLine.substring(requestLine.indexOf("POST /") + "POST /".length(),
					requestLine.indexOf(" HTTP/1.1"));
		}

	}
	
	private String checkHTML(String request) {
		if(request.contains(".html")) {
			return request.substring(0, request.indexOf("."));
		}
		return request;
	}

	private String removeSlash(String line) {
		return line.substring(0, line.indexOf("/"));
	}

	public String parseTextFromPOST(String request) {
		return request.split(System.lineSeparator())[getRequestLength(request) - 1];
	}

	private int getRequestLength(String request) {
		return request.split(System.lineSeparator()).length;
	}

}
