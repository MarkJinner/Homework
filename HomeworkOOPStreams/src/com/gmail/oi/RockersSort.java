package com.gmail.oi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RockersSort {
	private Rocker[] rockers;
	
	public RockersSort(Rocker[] rockers) {
		this.rockers = rockers;
	} 
	
	public RockersSort() {
		
	}

	public Rocker[] getRockers() {
		return rockers;
	}

	public void setRockers(Rocker[] rockers) {
		this.rockers = rockers;
	}
	
	public List<String> sortRockers(Rocker... rockers){
		Comparator<String> comp = (str1, str2)-> str1.compareTo(str2);
		
		List<String> rockersSongs = Arrays.stream(rockers).flatMap((r)->r.getSongs().stream()).sorted(comp).limit(3).toList();
		
		
		return rockersSongs;
	}
	
	
}
