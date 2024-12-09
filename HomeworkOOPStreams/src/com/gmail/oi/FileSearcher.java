package com.gmail.oi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FileSearcher {
	private String ext;
	private List<File> result;
	private int count = 0;
	private boolean copied = false;

	public FileSearcher(String ext) {
		this.ext = ext;
	}

	public FileSearcher() {

	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public List<File> scanFolder(File[] folder, String ext) throws IOException {
		Predicate<File> pr = (f) -> getExtention(f).equals(ext);
		int max = 1;
		Thread[] ts = new Thread[max];
		Stream<File> str = Stream.of(folder);

		return str.filter(pr).peek((f) -> {

			if (count < max) {
				ts[count++] = new Thread(new Copier(f));

			} else {
				System.out.println("File not copied");
			}
			if (count == max) {
				for (int i = 0; i < ts.length; i++) {
					try {
						ts[i].join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					count--;

				}
			}

		}).toList();
	}

	private String getExtention(File file) {
		return file.getName().substring(file.getName().lastIndexOf(".") + 1, file.getName().length());
	}

	private class Copier implements Runnable {
		private Thread ts;
		private File in;

		public Copier(File in) {
			this.in = in;
			ts = new Thread(this);
			ts.start();
		}

		private void copyFile(File in) throws FileNotFoundException, IOException {
			int byteRead = 0;
			byte[] buffer = new byte[512 * 512];
			try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(in));
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(in.getName())))) {
				while ((byteRead = bis.read(buffer)) > 0) {
					bos.write(buffer, 0, byteRead);
				}
			}
			System.out.println(Thread.currentThread().getName() + " File " + in.getName() + " copied");
			copied = true;
		}

		@Override
		public void run() {
			try {
				copyFile(in);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
