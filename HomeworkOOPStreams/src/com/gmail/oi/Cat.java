package com.gmail.oi;

import java.util.Objects;

public class Cat implements Comparable<Cat>{
	private String name;
	private int age;
	private int weigth;
	
	public Cat(String name, int age, int weigth) {
		this.name = name;
		this.age = age;
		this.weigth = weigth;
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

	public int getWeigth() {
		return weigth;
	}

	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, weigth);
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
		return age == other.age && Objects.equals(name, other.name) && weigth == other.weigth;
	}

	@Override
	public int compareTo(Cat other) {
		if(other==null) {
			throw new NullPointerException();
		}else if(this.name.length()-other.name.length()>0) {
			return 1;
		}else if(this.name.length()-other.name.length()<0) {
			return -1;
		}else if(this.name.length()-other.name.length()==0) {
			return this.age-other.age;
		}
		return this.weigth-other.weigth;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + ", weigth=" + weigth + "]";
	}
	
	
	
	
	
	
	
}
