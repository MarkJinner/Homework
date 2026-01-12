package com.gmail.SequesntialCopier;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProvider implements Runnable {
	private File file;
	private Buffer buffer;
	private int bufferSize;
	private byte[] buff;
	private Thread t;

	public DataProvider(Buffer buffer, File file, int bufferSize) {
		this.buffer = buffer;
		this.file = file;
		buff = new byte[bufferSize];
		t = new Thread(this);
		t.start();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

	public byte[] getBuff() {
		return buff;
	}

	public void setBuff(byte[] buff) {
		this.buff = buff;
	}

	public Thread getT() {
		return t;
	}

	public void setT(Thread t) {
		this.t = t;
	}

	public void provideData() throws FileNotFoundException, IOException, InterruptedException {
		this.buffer.setFileSize(file.length());

		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
			synchronized (buffer) {
				int byteRead = 0;
				while ((byteRead = bis.read(buff)) > 0) {
					buffer.setBuffer(buff, byteRead);
					this.buffer.wait();
				}
				buffer.setBuffer(new byte[0], 0);
			}

		}
	}

	@Override
	public void run() {
		try {
			provideData();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Data provided");

	}

}
