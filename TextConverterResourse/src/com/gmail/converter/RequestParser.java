package com.gmail.converter;

public class RequestParser {
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
		String requestExample = "GET /underConstruction.html HTTP/1.1\n"
				+ "Host: localhost:8085\n"
				+ "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:143.0) Gecko/20100101 Firefox/143.0\n"
				+ "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n"
				+ "Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3\n"
				+ "Accept-Encoding: gzip, deflate, br, zstd\n"
				+ "Connection: keep-alive\n"
				+ "Referer: http://localhost:8085/\n"
				+ "Upgrade-Insecure-Requests: 1\n"
				+ "Sec-Fetch-Dest: document\n"
				+ "Sec-Fetch-Mode: navigate\n"
				+ "Sec-Fetch-Site: same-origin\n"
				+ "Sec-Fetch-User: ?1\n"
				+ "Priority: u=0, i";
		RequestParser rp = new RequestParser();
		System.out.println(rp.parseRequest(requestExample));

	}
	public String parseRequest(String request) {
		String requestLine = request.split(System.lineSeparator())[0];

		if(requestLine.length()>0) {
			if(requestLine.contains("html")) {
				return parseStaticPageRequest(requestLine);
			}
			
		}
		return "";
	}
	
	private String parseStaticPageRequest(String requestLine) {
		return requestLine.substring(requestLine.indexOf("GET /") + "GET /".length(), requestLine.indexOf(" HTTP/1.1"));
	}

}
