package com.gmail.oi;

public interface Converter {
	
	public void convertWord() throws NoSuchSymbolException;
	
	public void convertText(String text) throws NoSuchSymbolException;
}
