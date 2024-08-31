package com.gmail.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StringAnalyzer {
	private String txt;
	
	public StringAnalyzer(String txt) {
		this.txt = txt;
	}
	
	public StringAnalyzer() {
	
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}
	
	public List<String> getNumbersStrings(String txt){
		String [] str = txt.split("\\?|\\!|\\.");
		System.out.println(Arrays.toString(str));
		char[] smbs = new char [] {'0','1','2','3','4','5','6','7','8','9'};
		List<String> strs = new ArrayList<>();
		
		Consumer <String> con = (a)->{
			for(int i = 0; i< smbs.length;i++) {
				for(int j = 0; j< a.toCharArray().length;j++) {
					if(smbs[i]==a.toCharArray()[j]) {
						strs.add(a);
						return;
					}
					
				}
			}
		};
		
		for(String i: str) {
			con.accept(i);
		}
		System.out.println(strs);
		
		return strs;
		
	}
	
	
}
