package com.gmail.logger;

public interface StackTraceConverter {
	
	abstract <T extends Exception> String convert(Exception e);
}
