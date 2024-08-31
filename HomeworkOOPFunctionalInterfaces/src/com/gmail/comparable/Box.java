package com.gmail.comparable;

import java.util.Objects;

public class Box implements Comparable<Box>{
	private int length;
	
	public Box(int length) {
		this.length = length;
	}
	
	public Box() {
		
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(length);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Box other = (Box) obj;
		return length == other.length;
	}
	
	

	@Override
	public String toString() {
		return "Figure "+this.length;
	}

	@Override
	public int compareTo(Box o) {
		if(o==null) {
			throw new NullPointerException();
		}else if(this.length>o.length) {
			return 1;
		}else if(this.length<o.length) {
			return -1;
		}
		return 0;
	}
}
