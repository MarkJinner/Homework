package com.gmail.converter;

public class LangRequestConverter {
	private String specified;
	
	public LangRequestConverter() {
		
	}
	
	public static void main(String [] args) {
		String langReq = "ru/main";	
		
		LangRequestConverter lrc = new LangRequestConverter();
		
		System.out.println(lrc.convertLangRequest(langReq));
	}
	
	public String convertLangRequest(String request) {
		StringBuilder sb = new StringBuilder();
			sb.append(request.substring(request.indexOf("/")+1, request.length()));
			sb.append("_"+request.substring(0, request.indexOf("/")));
		
		return sb.toString();
	}
	
	
}
