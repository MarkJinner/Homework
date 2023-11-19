package com.gmail.oi;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		try {
			runApp();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void runApp() throws FileNotFoundException, IOException {
		Runner runner = new Runner();

		runner.runApp();
	}

}
