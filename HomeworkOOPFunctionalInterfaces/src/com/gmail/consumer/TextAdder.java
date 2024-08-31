package com.gmail.consumer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.BiConsumer;

public class TextAdder {
	private String text;
	private File file;

	public TextAdder(File file, String txt) {
		this.file = file;
		this.text = txt;
	}

	public TextAdder() {

	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void addText(String txt, File file) {
		BiConsumer <String, File> bi = ( t,f)->{
			try {
				writeText(t,f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		bi.accept(txt, file);
	}

	private void writeText(String txt, File file) throws IOException {
		try (PrintWriter pw = new PrintWriter(new FileWriter(file, true))) {
			pw.write(txt+System.lineSeparator());
		}
	}
}
