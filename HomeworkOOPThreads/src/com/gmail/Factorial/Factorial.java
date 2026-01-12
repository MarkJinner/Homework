package com.gmail.Factorial;

import java.math.BigInteger;

public class Factorial implements Runnable {
	private int number;
	private ThreadCounter count;

	public Factorial(int number, ThreadCounter count) {
		this.number = number;
		this.count = count;
	}

	public Factorial() {

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

	public BigInteger calculateFactorial(int nmb) {
		BigInteger x = new BigInteger("1");

		if (nmb == 1) {
			return x;
		} else {
			return this.calculateFactorial(nmb - 1).multiply(new BigInteger(nmb + ""));
		}
	}

	public void runCalculations() {
		String tName = Thread.currentThread().getName();
		int trd = Integer.parseInt(tName.substring(tName.lastIndexOf("-") + 1, tName.length()));

		if (trd == 1) {
			System.out.println(tName + " " + this.calculateFactorial(1));
		} else {
			while (count.getTrds() < number - 1) {
				synchronized (count) {
					for (int i = 0; i < number; i++) {
						if (i == number - 1 || trd == 1) {
							this.count.addCount();
							if (trd - 1 == count.getTrds() || trd == 1) {
								System.out.println(tName + " " + this.calculateFactorial(i + 1));
							} else {
								count.takeOffCount();
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void run() {
		runCalculations();

	}

}
