package com.gmail.Factorial;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testFactorial(10);
	}
	
	public static void testFactorial(int max) {
		Thread [] ts = new Thread[max];
		ThreadCounter count = new ThreadCounter();
		
		for(int i = 0; i< max;i++) {
			ts[i] = new Thread(new Factorial(i, count));
			ts[i].start();
		}
	}

}
