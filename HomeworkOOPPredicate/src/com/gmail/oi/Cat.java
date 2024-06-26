package com.gmail.oi;

import java.util.Objects;

public class Cat {
	private int age;
	private String name;
	
	public Cat(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public Cat() {
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public String toString() {
		return "Cat [age=" + age + ", name=" + name + "]";
	}
	
	
	
	
}
