package com.gmail.oi;

public class ThreadCounter {
	private int count = 0;

	public ThreadCounter() {

	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public synchronized void addCount() {
		this.count = count+1;
	}
	
	public synchronized void takeCount() {
		this.count = count-1;
	}
}
