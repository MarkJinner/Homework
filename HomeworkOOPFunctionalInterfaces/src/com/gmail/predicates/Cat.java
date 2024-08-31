package com.gmail.predicates;

import java.util.Objects;

public class Cat implements Comparable<Cat> {
	
	private String name;
	private int age;
	
	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Cat() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Cat "+this.name+" "+this.age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(Cat o) {
		if(o==null) {
			throw new NullPointerException("Comparable cat is null");
		}else if(this.age>o.age) {
			return 1;
		}else if(this.age<o.age) {
			return -1;
		}
		return this.name.compareTo(o.name);
	}
	
	
	
	
}
