package com.gmail.comparator;

import java.util.Objects;

public class Cat extends Animal {
	private String name;
	private Type type;

	public Cat(int age, String name) {
		super(age);
		this.name = name;
		this.type = type.Home;
	}

	public Cat() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name, type);
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
		Cat other = (Cat) obj;
		return Objects.equals(name, other.name) && type == other.type;
	}

	@Override
	public String toString() {
		return "Cat " + this.name + " " + this.getAge();
	}

	@Override
	public int compareTo(Animal animal) {//Perfect!!!!!! 
		Cat other = (Cat) animal;
		if (other == null) {
			throw new NullPointerException();
		} else if (this.name.length() > other.name.length()) {
			return 1;
		} else if (this.name.length() < other.name.length()) {
			return -1;
		} else if (this.name.length() == other.name.length()) {
			this.type.compareTo(other.type);
		}
		return super.compareTo(other);
	}

}
