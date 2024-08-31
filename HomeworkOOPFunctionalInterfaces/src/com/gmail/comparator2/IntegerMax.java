package com.gmail.comparator2;

import java.util.Comparator;
import java.util.List;

public class IntegerMax {
	private List <Integer> numbers;
	
	
	public IntegerMax(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public IntegerMax() {
		
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
	
	public int getMax(List<Integer> numbers) {
		int max = numbers.get(0);
		Comparator<Integer> comp1 = this.getSimple(); 
		Comparator<Integer> comp2 = this.getMax();
		Comparator <Integer> fin = comp1.thenComparing(comp2);
		
		for(Integer i: numbers) {
			
			 if (fin.compare(i, max)>0) {
				 max = i;
			 }else if(max==numbers.get(0)) {
				 for(int j = 0; j< numbers.size();j++) {
					 Comparator<Integer> min = this.getMin();
					 	if(min.compare(max,numbers.get(j))<0) {
					 		max = numbers.get(j);
			
				 }		 
				 }
			
			 }
		}
		
		System.out.println(max);
		return max;
	}
	
	private Comparator<Integer> getSimple(){
		Comparator<Integer> comp = (one, two)->{
			for(int i = 2; i<= one;i++) {
				if(i< one) {
					if(i%1==0 && one%i==0) {
						return -1;
					}
				}
			}
			return 0;
			
		};
		
		return comp;
	}
	
	public Comparator<Integer> getMax(){
		Comparator<Integer> max = (one, two)->{
			if(one>two) {
				return 1; 
			}
			
			return 0;
		};
			
		return max;
	}
	
	public Comparator<Integer> getMin(){
		Comparator<Integer> min = (one, two)->{
			if(one>two) {
				return -1; 
			}
			
			return 0;
		};
			
		return min;
	}
	
	
	
	
}
