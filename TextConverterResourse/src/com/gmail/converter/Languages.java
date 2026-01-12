package com.gmail.converter;

import java.util.Arrays;

public enum Languages {
	Ru("ru"), Eng("eng"), Uk("uk");
	
	
	
	String value;
	
	Languages(String value){
		this.value = value;
	}
	

	
	
	public static void main(String [] args) {
		Languages lang = Languages.Eng;
		String str = "ru/main";
		Arrays.stream(Languages.values()).filter(s->str.contains(s.value)).forEach(s->System.out.println(s));
		
		
	}
	
}
