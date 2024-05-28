package com.gmail.oi;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			runApp();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchSymbolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void runApp() throws IOException, ClassNotFoundException, NoSuchSymbolException {
		TextConverter tx = new TextConverter();
//		tx.getStorage().addSymbol();
//		tx.getStorage().editSymbol();
//		tx.getStorage().displayKeys();
		tx.convertWord();
//		tx.convertText("How you doing?");
	}

}
