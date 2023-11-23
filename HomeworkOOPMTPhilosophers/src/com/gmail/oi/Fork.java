package com.gmail.oi;

public class Fork {
	private int number;
	private boolean isFree;
	
	public Fork(int number) {
		this.number = number;
		isFree = true;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public synchronized boolean isFree() {
		return isFree;
	}
	public synchronized void setFree(boolean isFree) {
		this.isFree = isFree;
	}
	
	@Override
	public String toString() {
		return "fork "+ (this.number+1);
	}
	
	
	
	
}
