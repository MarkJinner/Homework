package com.gmail.oi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;

public interface StringToMapConverter {
	DataReader dr = new DataReader();
	
	public default Map<String, String> convertToMap(File eng, File ru){
		Map<String, String> map = new TreeMap<>();
		
		int min = 0;
		String[] ruR = null;
		String[] engR = null;
		try {
			ruR = dr.readFile(ru).split(System.lineSeparator());
			engR  = dr.readFile(eng).split(System.lineSeparator()); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		if(ruR.length<engR.length) {
			min = ruR.length;
		}else {
			min = engR.length;
		}
		
		for(int i = 0; i< min; i++) {
			map.put(engR[i], ruR[i]);
		}
		return map;
	}
}
