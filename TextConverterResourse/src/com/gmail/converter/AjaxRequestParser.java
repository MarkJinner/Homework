package com.gmail.converter;

public class AjaxRequestParser implements RequestParserService{
	
	
	public static void main(String [] args) {
		String reqExample = "POST /ajaxSample.html HTTP/1.1\n"
				+ "Host: localhost:8089\n"
				+ "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:143.0) Gecko/20100101 Firefox/143.0\n"
				+ "Accept: */*\n"
				+ "Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.5,en;q=0.3\n"
				+ "Accept-Encoding: gzip, deflate, br, zstd\n"
				+ "Referer: http://localhost:8089/toUpperCaseTransformer.html\n"
				+ "Content-Type: multipart/form-data; boundary=----geckoformboundaryf4e5ecf220521132a927986cb3f394dd\n"
				+ "Content-Length: 180\n"
				+ "Origin: http://localhost:8089\n"
				+ "Connection: keep-alive\n"
				+ "Sec-Fetch-Dest: empty\n"
				+ "Sec-Fetch-Mode: cors\n"
				+ "Sec-Fetch-Site: same-origin\n"
				+ "Priority: u=0\n"
				+ "\n"
				+ "------geckoformboundaryf4e5ecf220521132a927986cb3f394dd\n"
				+ "Content-Disposition: form-data; name=\"transformedText\"\n"
				+ "\n"
				+ "REQ3\n"
				+ "------geckoformboundaryf4e5ecf220521132a927986cb3f394dd--\n";
		AjaxRequestParser arp = new AjaxRequestParser();
		System.out.println(arp.parseRequest(reqExample));
		System.out.println(arp.ifAjax(reqExample));
		
	}

	@Override
	public String parseRequest(String request) {
		return request.split(System.lineSeparator())[requestLength(request)-2];
	}
	
	public String parseTextConverterName(String request) {
		String line = new RequestParser().parseRequestReferer(request);
		return line.substring(line.lastIndexOf("/"), line.lastIndexOf("."));
	}
	
	public String getJoinedConverterNameRequestContent(String request) {
		return parseTextConverterName(request)+" "+parseRequest(request);
	}
	
	private int requestLength(String request) {
		return request.split(System.lineSeparator()).length;
	}
	
	public boolean ifAjax(String request) {
		System.out.println("requestLength = "+requestLength(request));
		if(request.length()>=7) {
			return request.split(System.lineSeparator())[7].contains("form-data");
		}		
		return false;
	}
}
