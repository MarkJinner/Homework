package com.gmail.converter;

public class DifferentLanguagePageRequestChecker {
	private LangRequestConverter langConverter = new LangRequestConverter();

	public DifferentLanguagePageRequestChecker() {
		
	}
	
	public String getOtherLanguagePage(String specified) {
		
			return  langConverter.convertLangRequest(specified);
	}
	
	public static void main(String [] args) {
		DifferentLanguagePageRequestChecker checker = new DifferentLanguagePageRequestChecker();
		String req = "ru/main";
	}
}
