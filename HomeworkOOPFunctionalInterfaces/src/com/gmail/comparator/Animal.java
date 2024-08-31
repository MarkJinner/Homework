package com.gmail.comparator;

import java.util.Objects;


public class Animal implements Comparable<Animal>{
	private int age;
	
	public Animal(int age) {
		this.age = age;
	}
	
	public Animal() {
		
	}
	
	protected enum Type{
		Home(1), Wild(2);
		
		private int val;
		
		Type(int val) {
			this.val = val;
		}
		
		Type(){
			
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}
	}
	
	public int getAge() {
		int temp = age;
		return temp;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Animal "+this.age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return age == other.age;
	}

	@Override
	public int compareTo(Animal other) {
		if(other==null) {
			throw new NullPointerException();
		}else if(this.age>other.age) {
			return 1;
		}else if(this.age<other.age) {
			return -1;
		}
		return 0;
	}
	
	
}
