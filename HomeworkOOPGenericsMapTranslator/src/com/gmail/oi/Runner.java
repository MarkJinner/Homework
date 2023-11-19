package com.gmail.oi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Runner implements StringToMapConverter{
	private Vocabular voc;
	private Translator trans;
	private Map<String, String> map;
	private File eng;
	private File ru;
	
	public Runner() {
		eng  = new File("eng");
		ru = new File("ru");
		
		
		try {
			eng.createNewFile();
			ru.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		map = this.convertToMap(eng, ru);
		voc = new Vocabular(map, eng, ru);
		trans = new Translator(voc);
	}
	
	

	public Translator getTrans() {
		return trans;
	}



	public void setTrans(Translator trans) {
		this.trans = trans;
	}



	public Vocabular getVoc() {
		return voc;
	}

	public void setVoc(Vocabular voc) {
		this.voc = voc;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public File getEng() {
		return eng;
	}

	public void setEng(File eng) {
		this.eng = eng;
	}

	public File getRu() {
		return ru;
	}

	public void setRu(File ru) {
		this.ru = ru;
	}
	
	public void runApp() throws FileNotFoundException, IOException {
//		voc.addWord();
//		voc.editTranslation();
//		voc.addWords("four", "pig");
//		voc.showVocabularL();
//		voc.addWords("you", "I");
//		voc.addWords("!", "?",".");
		trans.runTranslation();
//		voc.addWords("this", "that");
	}
	
	
}
