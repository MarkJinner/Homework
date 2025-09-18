package com.gmail.oi;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LettersCounter {
	private String str;

	public LettersCounter(String str) {
		this.str = str;
	}

	public LettersCounter() {

	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Optional<Integer> getLettersSum(String str) {
		Predicate<String> pr = (s) -> s.length() > 4;
		Stream<String> stream = Stream.of(str.split(" "));
		Optional<Integer> opt = (stream.filter(pr).map((s) -> s.length()).reduce((a, b) -> a + b));
		return opt.isPresent() ? opt : Optional.empty();
	}

}
