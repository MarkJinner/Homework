package com.gmail.comparable;

import java.util.Objects;

public class FinBox extends BoxDemo{
	private int volume;
	
	public FinBox(int length, int heigth) {
		super(length, heigth);
		this.volume = length*heigth;
	}
	
	public FinBox() {
		
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(volume);
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
		FinBox other = (FinBox) obj;
		return volume == other.volume;
	}
	
	@Override
	public String toString() {
		return "FinBox "+this.volume;
	}
	
	@Override
	public int compareTo(Box box) {
		FinBox other = (FinBox) box;
		if(other==null) {
			throw new NullPointerException();
		}else if(this.volume>other.volume) {
			return 1;
		}else if(this.volume<other.volume) {
			return -1;
		}
		System.out.println("l: "+super.getLength()+" h:"+super.getHeigth()+" vol:"+this.getVolume());
		return super.compareTo(other);
	} 
	
}
