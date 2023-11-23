package com.gmail.oi;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runApp(5);
	}
	
	public static void runApp(int number) {
		Runner runner = new Runner(number);
		
		runner.runPhilosophers();
	}

}
