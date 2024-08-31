package com.gmail.binaryoperator;

import java.util.Comparator;
import java.util.List;

public class MinMultyFinder<T> {
	private List<? extends Comparable<T>> one;
	private List<? extends Comparable<T>> two;
	private List<? extends Comparable<T>>[] lists;

	public MinMultyFinder(List<? extends Comparable<T>> one, List<? extends Comparable<T>> two) {
		this.one = one;
		this.two = two;
	}

	public MinMultyFinder(List<? extends Comparable<T>>... lists) {
		this.lists = lists;
	}

	public MinMultyFinder() {

	}

	public List<? extends Comparable<T>> getOne() {
		return one;
	}

	public void setOne(List<? extends Comparable<T>> one) {
		this.one = one;
	}

	public List<? extends Comparable<T>> getTwo() {
		return two;
	}

	public void setTwo(List<? extends Comparable<T>> two) {
		this.two = two;
	}

	public List<? extends Comparable<T>> getListWithMinElement(List<? extends Comparable<T>>... lists)
			throws InterruptedException {

		
		Thread[] ts = new Thread[lists.length];
		Comparator<T> comp = (one, two) -> (one.hashCode() - two.hashCode());
		List<? extends Comparable<T>> mins = null;
		

		MinFinder[] finders = new MinFinder[lists.length];

		for (int i = 0; i < lists.length; i++) {
			finders[i] = new MinFinder(lists[i]);
//			System.out.println(finders[i].list);
		}

		for (int i = 0; i < ts.length; i++) {
			ts[i] = new Thread(finders[i]);
			ts[i].start();
		}

		for (int i = 0; i < ts.length; i++) {
			ts[i].join();
		}
		
		T min = (T) lists[0].get(0);
		
		for (int i = 0; i < finders.length; i++) {
			if (comp.compare(min, (T) finders[i].min)>0) {
				min = (T) finders[i].min;
				mins = finders[i].list;
			}else{
				mins = finders[0].list;
			}
		}

		return mins;
	}

	private class MinFinder<T> implements Runnable {
		private List<? extends Comparable<T>> list;
		private T min;

		public MinFinder(List<? extends Comparable<T>> list) {
			this.list = list;
		}

		public MinFinder() {

		}

		public List<? extends Comparable<T>> getList() {
			return list;
		}

		public void setList(List<? extends Comparable<T>> list) {
			this.list = list;
		}

		private T getMin(List<? extends Comparable<T>> one) {
//			System.out.println(one);
			Comparator<T> comp = (on, tw) -> on.hashCode() - tw.hashCode();
			
			this.min = (T) one.get(0);
//			System.out.println(min);
			for (Comparable<T> i : one) {
				if (comp.compare(min, (T) i) > 0) {
					min = (T) i;
//					
				}
			}
			System.out.println(min);
			return min;
		}

		@Override
		public void run() {
			getMin(list);

		}

	}

}
