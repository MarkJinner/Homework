package com.gmail.comparator;

import java.util.Comparator;
import java.util.List;


public class ABSComparator<T extends Number> {
	private List<T> numbers;
	private Comparator<T> comp;

	public ABSComparator(List<T> numbers, Comparator<T> comp) {
		this.numbers = numbers;
		this.comp = comp;
	}

	public ABSComparator() {

	}

	public List<T> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<T> numbers) {
		this.numbers = numbers;
	}

	public Comparator<T> getComp() {
		return comp;
	}

	public void setComp(Comparator<T> comp) {
		this.comp = comp;
	}

	public <Integer> int  findModules(List <Integer> numbers) {
		Comparator<Integer> comp1 = (one, two) -> (Math.abs((int) one)-Math.abs((int) two));
		
		Comparator<Integer> comp2 = (one, two)-> {
			if(Math.abs((int) one)==Math.abs((int) two)) {
				if(one.hashCode()<0) {
					return 1;
				}else return -1;
			}
			return 0;
		};
		Comparator <Integer> comp3 = comp1.thenComparing(comp2);
				
		Integer min = numbers.get(0);
		
		for(Integer i: numbers) {
			if(comp3.compare(i, min)<0) {
				min = i;
			}
		}
		System.out.println(min);
		return (int)min;
	}
}
