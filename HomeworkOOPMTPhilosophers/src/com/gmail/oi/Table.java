package com.gmail.oi;

public class Table {
	private int number;
	private ThreadCounter count;
	private Fork[] forks;
	private int countP = 0;

	public Table(int number) {
		this.number = number;
		forks = new Fork[number];
		for (int i = 0; i < number; i++) {
			forks[i] = new Fork(i);
		}
		count = new ThreadCounter();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	

	public synchronized Fork[] getForks() {
		return forks;
	}

	public synchronized void setForks(Fork[] forks) {
		this.forks = forks;
	}

	public ThreadCounter getCount() {
		return count;
	}

	public void setCount(ThreadCounter count) {
		this.count = count;
	}

	public int getCountP() {
		return countP;
	}

	public void setCountP(int countP) {
		this.countP = countP;
	}

	public void putAllForks() {
//		if (this.getCountP() == this.number) {
			
		for (int i = 0; i < this.forks.length; i++) {
				forks[i].setFree(true);
				
				if (i == this.forks.length - 1) {
					System.out.println("All the philosophers put their forks");
					System.out.println();
					this.countP = 0;
					break;
				}
			}
//			for(Fork i: forks) {
//				System.out.println(i.isFree());
//			}
			
//		}
		

	}

}
