package com.gmail.SequesntialCopier;

import java.io.File;

public class Buffer {
	private File file;
	private byte[] buffer;
	private int mark;
	private long fileSize;
	private long newFileSize;
	
	public Buffer() {
		
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public synchronized byte[] getBuffer() {
		this.notifyAll();
		return buffer;
	}

	public synchronized void setBuffer(byte[] buffer, int mark) {
		this.buffer = buffer;
		this.mark = mark;
		
		this.notifyAll();
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public long getNewFileSize() {
		return newFileSize;
	}

	public void setNewFileSize(long newFileSize) {
		this.newFileSize = newFileSize;
	}
	
	public synchronized long getBufferLength() {
		return this.buffer.length;
	}
	
	public void displayProgress() {
		double result = (double)this.newFileSize/this.fileSize*100;
		
		System.out.println(String.format("%2.2f", result));
	}
	
	
}
