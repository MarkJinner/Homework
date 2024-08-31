package com.gmail.comparable;

import java.util.Objects;

public class Animal implements Comparable<Animal>{
	private int age;
	
	public Animal(int age) {
		this.age = age;
	}
	
	public Animal() {
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
	public String toString() {
		return "Animal "+ this.age;
	}

	@Override
	public int compareTo(Animal o) {
		if(o==null) {
			throw new NullPointerException();
		}else if(this.age>o.age) {
			return 1;
		}else if(this.age<o.age) {
			return -1;
		}
		return 0;
	}
	
	
	
	
}
