package com.gmail.comparable;

import java.util.Objects;

public class Dog extends Animal{
	private String name;
	
	public Dog(int age, String name) {
		super(age);
		this.name = name;
	}
	
	public Dog() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return Objects.equals(name, other.name);
	}
	
	@Override
	public String toString() {
		return "Dog "+this.getAge()+" "+this.name;
	}
	
	@Override
	public int compareTo(Animal animal) {
		Dog other = (Dog) animal;
		if(other == null) {
			throw new NullPointerException();
		}else if(this.name.length()>other.name.length()) {
			return 1;
		}else if(this.name.length()<other.name.length()) {
			return -1;
		}
		
		System.out.println("Dog "+this.name+ "'s age is different: "+ this.getAge());
		return super.compareTo(other);
	}

}
