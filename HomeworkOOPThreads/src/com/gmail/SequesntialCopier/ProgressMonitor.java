package com.gmail.SequesntialCopier;

public class ProgressMonitor {
	private Buffer buffer;
	private Thread t;
	
	public ProgressMonitor(Buffer buffer) {
		this.buffer = buffer;
//		t = new Thread(this);
//		t.start();
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void monitorProgress() throws InterruptedException {
		
		
			while((buffer.getBufferLength())>0) {
				synchronized(buffer) {
				this.buffer.displayProgress();
				this.buffer.wait();

			}
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
	}

//	@Override
//	public void run() {
//		try {
//			monitorProgress();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
}
