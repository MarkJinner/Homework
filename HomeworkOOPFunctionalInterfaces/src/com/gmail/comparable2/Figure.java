package com.gmail.comparable2;

import java.util.Objects;

public class Figure implements Comparable<Figure> {
	private int length;

	public Figure(int length) {
		this.length = length;
	}
	
	public Figure() {
		
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
		Figure other = (Figure) obj;
		return length == other.length;
	}

	@Override
	public int compareTo(Figure other) {
		if (other == null) {
			throw new NullPointerException();
		} else if (this.length > other.length) {
			return 1;
		} else if (this.length < other.length) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Figure " + this.length;
	}

}
