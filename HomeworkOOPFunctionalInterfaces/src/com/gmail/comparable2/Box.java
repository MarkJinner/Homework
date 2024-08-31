package com.gmail.comparable2;

import java.util.Objects;

public class Box extends Figure{
	private int heigth;
	
	public Box(int length, int heigth) {
		super(length);
		this.heigth = heigth;
	}
	
	public Box() {
		
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(heigth);
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
		Box other = (Box) obj;
		return heigth == other.heigth && this.getLength()==other.getLength();
	}
	
//	public int compareTo(Box other) {
//		
//		if(other==null) {
//			throw new NullPointerException();
//		}else if(this.heigth>other.heigth) {
//			return 1;
//		}else if(this.heigth<other.heigth) {
//			return -1;
//		}
//		return super.compareTo(other);
//	}
	
	@Override
	public int compareTo(Figure figure) {
		
		Box other =(Box) figure;
		if(figure ==null) {
			throw new NullPointerException();
		}
		
		else if(this.heigth>other.heigth) {
			return 1;
		}else if(this.heigth>other.heigth) {
			return -1;
		}
		return super.compareTo(other);
	}
	
	@Override
	public String toString() {
		return "Box "+ super.getLength()+" "+this.heigth;
	}
	
	
	
	
}
