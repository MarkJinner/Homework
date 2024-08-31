package com.gmail.comparable;

import java.util.Objects;

public class BoxDemo extends Box{
	private int heigth;
	
	public BoxDemo(int length, int heigth) {
		super(length);
		this.heigth = heigth;
	}
	
	public BoxDemo() {
		
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
		BoxDemo other = (BoxDemo) obj;
		return heigth == other.heigth;
	}
	
	@Override
	public String toString() {
		return "Box "+this.getHeigth()+" "+this.getLength();
	}
	
	
	
	@Override
	public int compareTo(Box other) {
		BoxDemo demo = (BoxDemo) other;
		if(demo == null) {
			throw new NullPointerException();
		}else if(this.heigth>demo.heigth) {
			return 1;
		}else if(this.heigth<demo.heigth) {
			return -1;
		}
		return super.compareTo(demo);
	}
	
}
