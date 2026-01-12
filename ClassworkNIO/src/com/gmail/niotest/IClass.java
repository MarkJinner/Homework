package com.gmail.niotest;

public class IClass {
	private String message = "outer";
	
	public IClass() {
		
	}
	
	
	class InnerClass{
		private String message = "inner";
		public InnerClass() {
			
		}
		
		
		@Override
		public String toString() {
			return this.message+IClass.this.message;
		}	
		
	}
	
	@Override
	public String toString() {
		return this.message;
	}
}
