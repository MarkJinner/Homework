package com.gmail.oi;

public class Runner {
	private int number;
	private ThreadCounter count;
	private Thread [] ts;
	private Table table;
	
	public Runner(int number) {
		table  = new Table(number);
		this.number = number;
		ts = new Thread[number];
		count = new ThreadCounter();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ThreadCounter getCount() {
		return count;
	}

	public void setCount(ThreadCounter count) {
		this.count = count;
	}

	public Thread[] getTs() {
		return ts;
	}

	public void setTs(Thread[] ts) {
		this.ts = ts;
	}
	
	public void runPhilosophers() {
		for(int i = 0; i< ts.length;i++) {
			ts[i] = new Thread(new Philosopher(table, i));
			ts[i].start();
		}
	}
	
	
}
