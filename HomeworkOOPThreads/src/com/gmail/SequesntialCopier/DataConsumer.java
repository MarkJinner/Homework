package com.gmail.SequesntialCopier;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataConsumer implements Runnable {
	private Buffer buffer;
	private File file;
	private Thread t;

	public DataConsumer(Buffer buffer, File file) {
		this.buffer = buffer;
		this.file = new File(file.getName());
		t = new Thread(this);
		t.start();
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Thread getT() {
		return t;
	}

	public void setT(Thread t) {
		this.t = t;
	}

	public void consumeData() throws IOException, InterruptedException {

		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
			while (this.buffer.getBufferLength() > 0) {
				synchronized (buffer) {
					bos.write(buffer.getBuffer(), 0, buffer.getMark());
					buffer.setNewFileSize(file.length());	
					buffer.wait();
					
				}
				
				
			}

		}
	}

	@Override
	public void run() {
		try {
			consumeData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Data consumed");

	}

}
