package com.gmail.Factorial;

public class ThreadCounter {
	private int trds = 0;
	public ThreadCounter() {
		
	}
	public int getTrds() {
		return trds;
	}
	public void setTrds(int trds) {
		this.trds = trds;
	}
	
	public synchronized  void addCount() {
		this.trds = trds+1;
	}
	public synchronized void takeOffCount() {
		this.trds = trds-1;
	}
}
