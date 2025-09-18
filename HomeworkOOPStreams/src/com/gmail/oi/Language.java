package com.gmail.oi;

public class Language {
	private String name;
	private LEVEL lvl;

	public Language(String name, LEVEL lvl) {
		this.name = name;
		this.lvl = lvl;
		
	}

	public Language() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LEVEL getLvl() {
		return lvl;
	}

	public void setLvl(LEVEL lvl) {
		this.lvl = lvl;
	}

	enum LEVEL {
		Easy(), Normal(), Hard();

		LEVEL() {

		}

	}

	@Override
	public String toString() {
		return this.name + " " + this.lvl;
	}

}
