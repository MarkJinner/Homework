package com.gmail.foldercopier;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copier implements Runnable {
	private File in;

	public Copier(File in) {
		this.in = in;
	}

	public File getIn() {
		return in;
	}

	public void setIn(File in) {
		this.in = in;
	}

	private void copy() throws FileNotFoundException, IOException {
		byte[] buffer = new byte[512 * 512];
		int byteRead = 0;
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(in));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(in.getName())))) {
			while ((byteRead = bis.read(buffer)) > 0) {
				bos.write(buffer, 0, byteRead);
			}
		}
		System.out.println("File " + in.getName() + " copied");
	}

	@Override
	public void run() {
		try {
			copy();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
