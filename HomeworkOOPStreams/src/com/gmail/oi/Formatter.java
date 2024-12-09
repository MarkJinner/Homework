package com.gmail.oi;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Formatter {
	private String txt;
	public Formatter(String txt) {
		this.txt = txt;
	}
	
	public Formatter() {
		
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}
	
	public List<String> [] transform(String txt){
		Function<String, String[]> fun = (t)->t.split("\\. |\\.");
		
		Function<String[], List<String>[]> fun2 = (str)->{
			List<String> []list = new ArrayList[str.length];
			for(int i = 0; i< str.length;i++) {
				list[i] = new ArrayList<>();
				for(int j = 0; j< str[i].split("\\, |\\ |\\,").length;j++) {
					list[i].add(str[i].split("\\, |\\ |\\,")[j]);
				}
			}
			return list;
		};
		
		return fun.andThen(fun2).apply(txt);
		
	}
	
}
