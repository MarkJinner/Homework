package com.gmail.oi;

import java.io.IOException;

public abstract class Storage {

	public Storage() {
		
	}
	
	public abstract void addSymbol() throws IOException;
	
	public abstract void editSymbol() throws IOException, NoSuchSymbolException;
	
	public abstract void editSymbol(String symbol) throws NoSuchSymbolException, IOException;
	
	public abstract void removeSymbol() throws NoSuchSymbolException, IOException;
	
	public abstract String displaySymbol(String symbol) throws NoSuchSymbolException;
	
	public abstract String displaySymbols();
	
}
